/* Copyright (C) 2012  Egon Willighagen <egonw@users.sf.net>
 *
 * License: new BSD
 */
package com.github.jqudt.onto;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import com.github.jqudt.Unit;

public class UnitFactoryTest {

	@Test
	public void testGetInstance() throws Exception {
		UnitFactory factory = UnitFactory.getInstance();
		Assert.assertNotNull(factory);
	}

	@Test
	public void testGetUnit() throws Exception {
		UnitFactory factory = UnitFactory.getInstance();
		Unit unit = factory.getUnit("http://qudt.org/vocab/unit#Kelvin");
		Assert.assertNotNull(unit);
		Assert.assertEquals("Kelvin", unit.getLabel());
		Assert.assertEquals("K", unit.getSymbol());
		Assert.assertEquals("K", unit.getAbbreviation());
		Assert.assertEquals(1, unit.getMultiplier().getMultiplier(), 0.01);
		Assert.assertEquals(0, unit.getMultiplier().getOffset(), 0.01);
		Assert.assertEquals("http://qudt.org/schema/qudt#TemperatureUnit", unit.getType().toString());
	}

	@Test
	public void testGetURIs() throws Exception {
		UnitFactory factory = UnitFactory.getInstance();
		List<String> units = factory.getURIs("http://qudt.org/schema/qudt#TemperatureUnit");
		Assert.assertNotNull(units);
		Assert.assertNotSame(0, units.size());
	}

	@Test
	public void testGetOpenPHACTSUnit() throws Exception {
		UnitFactory factory = UnitFactory.getInstance();
		Unit unit = factory.getUnit("http://www.openphacts.org/units/Nanomolar");
		Assert.assertNotNull(unit);
		Assert.assertEquals("Nanomolar", unit.getLabel());
		Assert.assertEquals("nmol/dm^3", unit.getSymbol());
		Assert.assertEquals("nM", unit.getAbbreviation());
		Assert.assertEquals(0.000001, unit.getMultiplier().getMultiplier(), 0.0000001);
		Assert.assertEquals(0, unit.getMultiplier().getOffset(), 0.01);
		Assert.assertEquals("http://qudt.org/schema/qudt#MolarConcentrationUnit", unit.getType().toString());
	}

}
