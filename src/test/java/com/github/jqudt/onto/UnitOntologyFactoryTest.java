/* Copyright (C) 2012  Egon Willighagen <egonw@users.sf.net>
 *
 * License: new BSD
 */
package com.github.jqudt.onto;

import junit.framework.Assert;

import org.junit.Test;

import com.github.jqudt.Unit;

/**
 * Tests that mappings from the Unit Ontology (UO) to QUDT are working, and
 * that units can be instantiated using the UO.
 */
public class UnitOntologyFactoryTest {

	@Test
	public void testGetInstance() throws Exception {
		UnitFactory factory = UnitFactory.getInstance();
		Assert.assertNotNull(factory);
	}

	@Test
	public void testGetUnit() throws Exception {
		UnitFactory factory = UnitFactory.getInstance();
		Unit unit = factory.getUnit("http://purl.obolibrary.org/obo/UO_0000033");
		Assert.assertNotNull(unit);
	}

}
