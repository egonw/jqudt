/* Copyright (C) 2013  Egon Willighagen <egonw@users.sf.net>
 *
 * License: new BSD
 */
package com.github.jqudt.units.concentration;

import org.junit.Assert;
import org.junit.Test;

import com.github.jqudt.Quantity;
import com.github.jqudt.onto.units.ConcentrationUnit;

public class MolarTest {

	@Test
	public void testMolarConversion() throws IllegalArgumentException, IllegalAccessException {
		Quantity obs = new Quantity(0.000001, ConcentrationUnit.MOLAR);
		Quantity obs2 =  obs.convertTo(ConcentrationUnit.NANO_MOLAR);
		Assert.assertEquals(ConcentrationUnit.NANO_MOLAR, obs2.getUnit());
		Assert.assertEquals(1000, obs2.getValue(), 1);
	}

}
