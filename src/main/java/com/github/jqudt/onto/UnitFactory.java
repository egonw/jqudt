/* Copyright (C) 2012  Egon Willighagen <egonw@users.sf.net>
 *
 * License: new BSD
 */
package com.github.jqudt.onto;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.openrdf.model.Statement;
import org.openrdf.model.ValueFactory;
import org.openrdf.model.vocabulary.RDF;
import org.openrdf.model.vocabulary.RDFS;
import org.openrdf.repository.Repository;
import org.openrdf.repository.RepositoryConnection;
import org.openrdf.repository.RepositoryException;
import org.openrdf.repository.RepositoryResult;
import org.openrdf.repository.sail.SailRepository;
import org.openrdf.rio.RDFParseException;
import org.openrdf.sail.memory.MemoryStore;

import com.github.jqudt.Multiplier;
import com.github.jqudt.Unit;

public class UnitFactory {
	
	private Repository repos;

	private static UnitFactory factory = null;

	private UnitFactory() throws RepositoryException, RDFParseException, IOException {
		repos = new SailRepository(new MemoryStore());
		repos.initialize();
		OntoReader.read(repos, "unit");
		OntoReader.read(repos, "qudt");
		OntoReader.read(repos, "quantity");
	}

	public static UnitFactory getInstance() throws RepositoryException, RDFParseException, IOException {
		if (factory == null) factory = new UnitFactory();
		return factory;
	}
	
	public Unit getUnit(String resource) throws RepositoryException, URISyntaxException {
		URI uri = new URI(resource);
		return getUnit(uri);
	}

	public Unit getUnit(URI resource) throws RepositoryException, URISyntaxException {
		if (resource == null) throw new IllegalArgumentException("The URI cannot be null");

		ValueFactory f = repos.getValueFactory();
		org.openrdf.model.URI uri = f.createURI(resource.toString());
		
		Unit unit = new Unit();
		unit.setResource(resource);
		Multiplier multiplier = new Multiplier();

		RepositoryConnection con = repos.getConnection();
		RepositoryResult<Statement> statements = con.getStatements(uri, null, null, true);
		for (Statement statement : statements.asList()) {
			System.out.println(statement.toString());
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
				unit.setType(new URI(statement.getObject().stringValue()));
			}
		}
		unit.setMultiplier(multiplier);

		return unit;
	}
}
