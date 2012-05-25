/* Copyright (C) 2012  Egon Willighagen <egonw@users.sf.net>
 *
 * License: new BSD
 */
package com.github.jqudt.units.concentration;

import org.junit.Assert;
import org.junit.Test;

import com.github.jqudt.Quantity;
import com.github.jqudt.onto.units.ConcentrationUnit;

public class MassPerVolumeUnitTest {

	@Test
	public void test() throws IllegalArgumentException, IllegalAccessException {
		Quantity obs = new Quantity(0.1, ConcentrationUnit.MICROGRAM_PER_MILLILITER);
		Quantity obs2 =  obs.convertTo(ConcentrationUnit.PICOGRAM_PER_MILLILITER);
		Assert.assertEquals(ConcentrationUnit.PICOGRAM_PER_MILLILITER, obs2.getUnit());
		Assert.assertEquals(100000, obs2.getValue(), 1);
	}

}
