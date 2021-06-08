/* Copyright (C) 2013  Egon Willighagen <egonw@users.sf.net>
 *
 * License: new BSD
 */
package com.github.jqudt.units;

import com.github.jqudt.Unit;
import org.junit.Assert;
import org.junit.Test;

import com.github.jqudt.Quantity;
import com.github.jqudt.onto.units.LengthUnit;

public class LengthTests {

	@Test
	public void testNanometer() throws IllegalArgumentException, IllegalAccessException {
		Quantity temp = new Quantity(23.5, LengthUnit.NM);
		Assert.assertEquals("nm", temp.getUnit().getSymbol());
	}

	@Test
	public void testCentimeter() throws IllegalAccessException {
		Quantity centim = new Quantity(1, LengthUnit.CM);
		Assert.assertEquals("cm", centim.getUnit().getSymbol());
		Assert.assertEquals(0.01, centim.convertTo(LengthUnit.M).getValue(), 0);
	}

}
