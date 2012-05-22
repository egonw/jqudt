/* Copyright (C) 2012  Egon Willighagen <egonw@users.sf.net>
 *
 * License: new BSD
 */
package com.github.jqudt;

import org.junit.Assert;
import org.junit.Test;

import com.github.jqudt.units.temperature.Celsius;

public class QuantityTest {

	@Test
	public void testConstructorNullUnit() {
		Quantity quantity = new Quantity(0.1, null);
		Assert.assertEquals(0.1, quantity.getValue(), 0.01);
		Assert.assertNull(quantity.getUnit());
	}

	@Test
	public void testConstructor() {
		Quantity quantity = new Quantity(0.1, Celsius.getInstance());
		Assert.assertEquals(0.1, quantity.getValue(), 0.01);
		Assert.assertEquals(Celsius.getInstance(), quantity.getUnit());
	}
}
