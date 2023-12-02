/* Copyright (C) 2012,2023  Egon Willighagen <egonw@users.sf.net>
 *
 * License: new BSD
 */
package com.github.jqudt.onto;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.ValidatingValueFactory;

public class QUDT {

	private static ValueFactory factory = new ValidatingValueFactory();

	public final static String namespace = "http://qudt.org/schema/qudt#";

	private static final IRI getURI(String localPart) {
		return factory.createIRI(namespace, localPart);
	}

	public final static IRI SYMBOL = getURI("symbol");
	public final static IRI ABBREVIATION = getURI("abbreviation");
	public final static IRI CONVERSION_OFFSET = getURI("conversionOffset");
	public final static IRI CONVERSION_MULTIPLIER = getURI("conversionMultiplier");

	public final static IRI SI_UNIT = getURI("SIUnit");
	public final static IRI SI_BASE_UNIT = getURI("SIBaseUnit");
	public final static IRI SI_DERIVED_UNIT = getURI("SIDerivedUnit");
	public final static IRI DERIVED_UNIT = getURI("DerivedUnit");
	public final static IRI NOT_USED_WITH_SI_UNIT = getURI("NotUsedWithSIUnit");
	public final static IRI USED_WITH_SI_UNIT = getURI("UsedWithSIUnit");

}
