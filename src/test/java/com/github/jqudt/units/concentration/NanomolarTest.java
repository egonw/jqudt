/* Copyright (C) 2012  Egon Willighagen <egonw@users.sf.net>
 *
 * License: new BSD
 */
package com.github.jqudt.units.concentration;

import org.junit.Assert;
import org.junit.Test;

import com.github.jqudt.Quantity;

public class NanomolarTest {

	@Test
	public void testAbsoluteZero() throws IllegalArgumentException, IllegalAccessException {
		Quantity obs = new Quantity(0.1, Micromolar.getInstance());
		Quantity obs2 =  obs.convertTo(Nanomolar.getInstance());
		Assert.assertEquals(Nanomolar.getInstance(), obs2.getUnit());
		Assert.assertEquals(100, obs2.getValue(), 1);
	}

}
