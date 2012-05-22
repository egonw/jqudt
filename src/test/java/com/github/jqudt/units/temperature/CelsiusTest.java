/* Copyright (C) 2012  Egon Willighagen <egonw@users.sf.net>
 *
 * License: new BSD
 */
package com.github.jqudt.units.temperature;

import org.junit.Assert;
import org.junit.Test;

import com.github.jqudt.Quantity;

public class CelsiusTest {

	@Test
	public void testAbsoluteZero() throws IllegalArgumentException, IllegalAccessException {
		Quantity temp = new Quantity(-273.15, Celsius.getInstance());
		Quantity temp2 = temp.convertTo(Kelvin.getInstance());
		Assert.assertEquals(Kelvin.getInstance(), temp2.getUnit());
		Assert.assertEquals(0.0, temp2.getValue(), 0.01);
	}

	@Test
	public void testRoomTemperature() throws IllegalArgumentException, IllegalAccessException {
		Quantity temp = new Quantity(20, Celsius.getInstance());
		Quantity temp2 = temp.convertTo(Kelvin.getInstance());
		Assert.assertEquals(Kelvin.getInstance(), temp2.getUnit());
		Assert.assertEquals(293.15, temp2.getValue(), 0.01);
	}

}
