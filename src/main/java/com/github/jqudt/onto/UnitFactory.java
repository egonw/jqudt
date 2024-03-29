/* Copyright (C) 2012,2019,2023  Egon Willighagen <egonw@users.sf.net>
 *
 * License: new BSD
 */
package com.github.jqudt.onto;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Model;
import org.eclipse.rdf4j.model.Statement;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.LinkedHashModel;
import org.eclipse.rdf4j.model.impl.ValidatingValueFactory;
import org.eclipse.rdf4j.model.vocabulary.RDF;
import org.eclipse.rdf4j.model.vocabulary.RDFS;
import org.eclipse.rdf4j.model.vocabulary.XSD;

import com.github.jqudt.Multiplier;
import com.github.jqudt.Unit;

public class UnitFactory {
	
	private Model repos;

	private static UnitFactory factory = null;
	private ValueFactory f = null;

	private UnitFactory() {
		this.f = new ValidatingValueFactory();
		repos = new LinkedHashModel();
		String[] ontologies = {
			"unit", "qudt", "quantity", "ops"
		};
		for (String ontology : ontologies) {
			try {
				OntoReader.read(repos, ontology);
			} catch (Exception exception) {
				throw new IllegalStateException(
					"Could not load the QUDT ontology '" + ontology + "': " + exception.getMessage(), exception
				);
			}
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

		IRI uri = f.createIRI(resource.toString());
		
		Unit unit = new Unit();
		unit.setResource(resource);
		Multiplier multiplier = new Multiplier();

		try {
			Model statements = repos.filter(uri, null, null);
			if (statements.isEmpty())
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
					if (type instanceof IRI) {
						IRI typeURI = (IRI)type;
						if (!shouldBeIgnored(typeURI)) {
							unit.setType(new URI(typeURI.stringValue()));
						}
					}
				} else {
					// System.out.println("Ignoring: " + statement);
				}
			}
			unit.setMultiplier(multiplier);
		} catch (Exception exception) {
			throw new IllegalStateException("Could not create the unit: " + exception.getMessage(), exception);
		}

		return unit;
	}

	public List<Unit> findUnits(String symbol) {
		if (symbol == null) throw new IllegalArgumentException("The symbol cannot be null");

		Model statements = repos.filter(null, QUDT.ABBREVIATION, f.createLiteral(symbol, XSD.STRING));
		if (statements.isEmpty()) return Collections.emptyList();
		List<Unit> foundUnits = new ArrayList<Unit>();
		for (Statement statement : statements) {
			Object type = statement.getSubject();
			try {
				if (type instanceof IRI) {
					IRI typeURI = (IRI)type;
					foundUnits.add(getUnit(typeURI.toString()));
				}
			} catch (Exception exception) {
				// ignore
			}
		}
		return foundUnits;
	}

	public List<String> getURIs(String type) {
		URI uri;
		try {
			uri = new URI(type);
		} catch (URISyntaxException exception) {
			throw new IllegalStateException("Invalid URI: " + type, exception);
		}
		return getURIs(uri);
	}
	
	public List<String> getURIs(URI type) {
		if (type == null) throw new IllegalArgumentException("The type cannot be null");

		IRI uri = f.createIRI(type.toString());
		
		try {
			Model statements = repos.filter(null, null, uri);
			if (statements.isEmpty())
				return Collections.emptyList();

			List<String> units = new ArrayList<String>();
			for (Statement statement : statements) {
				units.add(statement.getSubject().toString());
			}
			return units; 
		} catch (Exception exception) {
			throw new IllegalStateException("Error while getting the units: " + exception.getMessage(), exception);
		}
	}

	private boolean shouldBeIgnored(IRI typeURI) {
		// accept anything outside the QUDT namespace
		if (!typeURI.getNamespace().equals(QUDT.namespace)) return false;

		if (typeURI.equals(QUDT.SI_DERIVED_UNIT)) return true;
		if (typeURI.equals(QUDT.SI_BASE_UNIT)) return true;
		if (typeURI.equals(QUDT.SI_UNIT)) return true;
		if (typeURI.equals(QUDT.DERIVED_UNIT)) return true;
		if (typeURI.equals(QUDT.NOT_USED_WITH_SI_UNIT)) return true;
		if (typeURI.equals(QUDT.USED_WITH_SI_UNIT)) return true;

		// everything else is fine too
		return false;
	}
}
