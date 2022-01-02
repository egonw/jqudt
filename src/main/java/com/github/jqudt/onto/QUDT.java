/* Copyright (C) 2012  Egon Willighagen <egonw@users.sf.net>
 *
 * License: new BSD
 */
package com.github.jqudt.onto;

import org.openrdf.model.URI;
import org.openrdf.model.ValueFactory;
import org.openrdf.model.impl.ValueFactoryImpl;

public class QUDT {

	private static ValueFactory factory = new ValueFactoryImpl();

	public final static String namespace = "http://qudt.org/schema/qudt/";

	private static final URI getURI(String localPart) {
		return factory.createURI(namespace, localPart);
	}

	public final static URI SYMBOL = getURI("symbol");
	public final static URI ABBREVIATION = getURI("abbreviation");
	public final static URI CONVERSION_OFFSET = getURI("conversionOffset");
	public final static URI CONVERSION_MULTIPLIER = getURI("conversionMultiplier");

	public final static URI SI_UNIT = getURI("SIUnit");
	public final static URI SI_BASE_UNIT = getURI("SIBaseUnit");
	public final static URI SI_DERIVED_UNIT = getURI("SIDerivedUnit");
	public final static URI DERIVED_UNIT = getURI("DerivedUnit");
	public final static URI NOT_USED_WITH_SI_UNIT = getURI("NotUsedWithSIUnit");
	public final static URI USED_WITH_SI_UNIT = getURI("UsedWithSIUnit");
	public final static URI IS_DELTA_QUANTITY = getURI("isDeltaQuantity");

}
