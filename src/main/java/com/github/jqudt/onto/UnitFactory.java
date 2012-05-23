/* Copyright (C) 2012  Egon Willighagen <egonw@users.sf.net>
 *
 * License: new BSD
 */
package com.github.jqudt.onto;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.openrdf.model.Statement;
import org.openrdf.model.ValueFactory;
import org.openrdf.model.vocabulary.RDF;
import org.openrdf.model.vocabulary.RDFS;
import org.openrdf.repository.Repository;
import org.openrdf.repository.RepositoryConnection;
import org.openrdf.repository.sail.SailRepository;
import org.openrdf.sail.memory.MemoryStore;

import com.github.jqudt.Multiplier;
import com.github.jqudt.Unit;

public class UnitFactory {
	
	private Repository repos;

	private static UnitFactory factory = null;

	private UnitFactory() {
		repos = new SailRepository(new MemoryStore());
		try {
			repos.initialize();
			OntoReader.read(repos, "unit");
			OntoReader.read(repos, "qudt");
			OntoReader.read(repos, "quantity");
		} catch (Exception exception) {
			throw new IllegalStateException(
				"Could not load the QUDT ontologies: " + exception.getMessage(), exception
			);
		}
	}

	public static UnitFactory getInstance() {
		if (factory == null) factory = new UnitFactory();
		return factory;
	}
	
	public Unit getUnit(String resource) {
		URI uri;
		try {
			uri = new URI(resource);
		} catch (URISyntaxException exception) {
			throw new IllegalStateException("Invalid URI: " + resource, exception);
		}
		return getUnit(uri);
	}

	public Unit getUnit(URI resource) {
		if (resource == null) throw new IllegalArgumentException("The URI cannot be null");

		ValueFactory f = repos.getValueFactory();
		org.openrdf.model.URI uri = f.createURI(resource.toString());
		
		Unit unit = new Unit();
		unit.setResource(resource);
		Multiplier multiplier = new Multiplier();

		try {
			RepositoryConnection con = repos.getConnection();
			List<Statement> statements = con.getStatements(uri, null, null, true).asList();
			if (statements.size() == 0)
				throw new IllegalStateException("No ontology entry found for: " + resource.toString());

			for (Statement statement : statements) {
				if (statement.getPredicate().equals(QUDT.SYMBOL)) {
					unit.setSymbol(statement.getObject().stringValue());
				} else if (statement.getPredicate().equals(QUDT.ABBREVIATION)) {
					unit.setAbbreviation(statement.getObject().stringValue());
				} else if (statement.getPredicate().equals(QUDT.CONVERSION_OFFSET)) {
					multiplier.setOffset(Double.parseDouble(statement.getObject().stringValue()));
				} else if (statement.getPredicate().equals(QUDT.CONVERSION_MULTIPLIER)) {
					multiplier.setMultiplier(Double.parseDouble(statement.getObject().stringValue()));
				} else if (statement.getPredicate().equals(RDFS.LABEL)) {
					unit.setLabel(statement.getObject().stringValue());
				} else if (statement.getPredicate().equals(RDF.TYPE)) {
					Object type = statement.getObject();
					if (type instanceof org.openrdf.model.URI) {
						org.openrdf.model.URI typeURI = (org.openrdf.model.URI)type;
						if (!shouldBeIgnored(typeURI)) {
							unit.setType(new URI(typeURI.stringValue()));
						}
					}
				} else {
					System.out.println("Ignoring: " + statement);
				}
			}
			unit.setMultiplier(multiplier);
		} catch (Exception exception) {
			throw new IllegalStateException("Could not create the unit: " + exception.getMessage(), exception);
		}

		return unit;
	}

	private boolean shouldBeIgnored(org.openrdf.model.URI typeURI) {
		// accept anything outside the QUDT namespace
		if (!typeURI.getNamespace().equals(QUDT.namespace)) return false;

		if (typeURI.equals(QUDT.SI_BASE_UNIT)) return true;
		if (typeURI.equals(QUDT.SI_UNIT)) return true;
		if (typeURI.equals(QUDT.DERIVED_UNIT)) return true;
		if (typeURI.equals(QUDT.NOT_USED_WITH_SI_UNIT)) return true;

		// everything else is fine too
		return false;
	}
}
