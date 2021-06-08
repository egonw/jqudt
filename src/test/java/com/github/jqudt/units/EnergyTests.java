/* Copyright (C) 2013  Egon Willighagen <egonw@users.sf.net>
 *
 * License: new BSD
 */
package com.github.jqudt.units;

import org.junit.Assert;
import org.junit.Test;

import com.github.jqudt.Quantity;
import com.github.jqudt.onto.units.EnergyUnit;

public class EnergyTests {

	@Test
	public void testElectronVolt() throws IllegalArgumentException, IllegalAccessException {
		Quantity temp = new Quantity(-23.5, EnergyUnit.ELECTRON_VOLT);
		Assert.assertEquals("eV", temp.getUnit().getSymbol());
	}

}
