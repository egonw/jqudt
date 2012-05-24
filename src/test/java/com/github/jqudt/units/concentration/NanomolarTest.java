/* Copyright (C) 2012  Egon Willighagen <egonw@users.sf.net>
 *
 * License: new BSD
 */
package com.github.jqudt.units.concentration;

import org.junit.Assert;
import org.junit.Test;

import com.github.jqudt.Quantity;
import com.github.jqudt.onto.units.ConcentrationUnit;

public class NanomolarTest {

	@Test
	public void testAbsoluteZero() throws IllegalArgumentException, IllegalAccessException {
		Quantity obs = new Quantity(0.1, ConcentrationUnit.MICROMOLAR);
		Quantity obs2 =  obs.convertTo(ConcentrationUnit.NANOMOLAR);
		Assert.assertEquals(ConcentrationUnit.NANOMOLAR, obs2.getUnit());
		Assert.assertEquals(100, obs2.getValue(), 1);
	}

}
