/* Copyright (C) 2012  Egon Willighagen <egonw@users.sf.net>
 *
 * License: new BSD
 */
package com.github.jqudt;

import java.net.URI;

import junit.framework.Assert;

import org.junit.Test;

public class UnitTest {

	@Test
	public void testResource() throws Exception {
		Unit unit = new Unit();
		URI resource = new URI("http://qudt.org/vocab/unit#Kelvin");
		Assert.assertNull(unit.getResource());
		unit.setResource(resource);
		Assert.assertNotNull(unit.getResource());
		Assert.assertEquals(resource, unit.getResource());
	}

	@Test
	public void testType() throws Exception {
		Unit unit = new Unit();
		URI resource = new URI("http://qudt.org/vocab/unit#Kelvin");
		Assert.assertNull(unit.getType());
		unit.setType(resource);
		Assert.assertNotNull(unit.getType());
		Assert.assertEquals(resource, unit.getType());
	}

	@Test
	public void testLabel() throws Exception {
		Unit unit = new Unit();
		Assert.assertNull(unit.getLabel());
		unit.setLabel("nanomolar");
		Assert.assertNotNull(unit.getLabel());
		Assert.assertEquals("nanomolar", unit.getLabel());
	}

	@Test
	public void testAbbreviation() throws Exception {
		Unit unit = new Unit();
		Assert.assertNull(unit.getAbbreviation());
		unit.setAbbreviation("nM");
		Assert.assertNotNull(unit.getAbbreviation());
		Assert.assertEquals("nM", unit.getAbbreviation());
	}

	@Test
	public void testSymbol() throws Exception {
		Unit unit = new Unit();
		Assert.assertNull(unit.getSymbol());
		unit.setSymbol("K");
		Assert.assertNotNull(unit.getSymbol());
		Assert.assertEquals("K", unit.getSymbol());
	}
}
