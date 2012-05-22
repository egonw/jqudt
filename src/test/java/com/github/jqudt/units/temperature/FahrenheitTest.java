/* Copyright (C) 2012  Egon Willighagen <egonw@users.sf.net>
 *
 * License: new BSD
 */
package com.github.jqudt.units.temperature;

import org.junit.Assert;
import org.junit.Test;

import com.github.jqudt.Quantity;

public class FahrenheitTest {

	@Test
	public void testTwentyDegrees() throws IllegalArgumentException, IllegalAccessException {
		Quantity temp = new Quantity(20, Celsius.getInstance());
		Quantity temp2 = temp.convertTo(Fahrenheit.getInstance());
		Assert.assertEquals(Fahrenheit.getInstance(), temp2.getUnit());
		Assert.assertEquals(68., temp2.getValue(), 0.1);
	}

	@Test
	public void testMinusTwenty() throws IllegalArgumentException, IllegalAccessException {
		Quantity temp = new Quantity(-20, Celsius.getInstance());
		Quantity temp2 = temp.convertTo(Fahrenheit.getInstance());
		Assert.assertEquals(Fahrenheit.getInstance(), temp2.getUnit());
		Assert.assertEquals(-4, temp2.getValue(), 0.01);
	}

}
