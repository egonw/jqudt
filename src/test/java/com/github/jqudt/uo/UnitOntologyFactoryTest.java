/* Copyright (C) 2012-2013  Egon Willighagen <egonw@users.sf.net>
 *
 * License: new BSD
 */
package com.github.jqudt.uo;

import java.net.URI;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import com.github.jqudt.Unit;
import com.github.jqudt.uo.UnitOntologyFactory;

/**
 * Tests that mappings from the Unit Ontology (UO) to QUDT are working, and
 * that units can be instantiated using the UO.
 */
public class UnitOntologyFactoryTest {

	@Test
	public void testGetInstance() throws Exception {
		UnitOntologyFactory factory = UnitOntologyFactory.getInstance();
		Assert.assertNotNull(factory);
	}

	@Test
	public void testGetUnit() throws Exception {
		UnitOntologyFactory factory = UnitOntologyFactory.getInstance();
		Unit unit = factory.getUnit("http://purl.obolibrary.org/obo/UO_0000065");
		Assert.assertNotNull(unit);
		Assert.assertEquals("Nanomolar", unit.getLabel());
		Assert.assertEquals("nmol/dm^3", unit.getSymbol());
		Assert.assertEquals("nM", unit.getAbbreviation());
		Assert.assertEquals(0.000001, unit.getMultiplier().getMultiplier(), 0.0000001);
		Assert.assertEquals(0, unit.getMultiplier().getOffset(), 0.01);
		Assert.assertEquals("http://qudt.org/schema/qudt#MolarConcentrationUnit", unit.getType().toString());
	}

	@Test
	public void testGetUOUnitsByQUDTType() throws Exception {
		UnitOntologyFactory factory = UnitOntologyFactory.getInstance();
		List<String> units = factory.getURIs(new URI("http://qudt.org/schema/qudt#MolarConcentrationUnit"));
		Assert.assertNotNull(units);
		Assert.assertNotSame(0, units.size());
	}

}
