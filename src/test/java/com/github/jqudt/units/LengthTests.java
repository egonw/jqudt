/* Copyright (C) 2013  Egon Willighagen <egonw@users.sf.net>
 *
 * License: new BSD
 */
package com.github.jqudt.units;

import org.junit.Assert;
import org.junit.Test;

import com.github.jqudt.Quantity;
import com.github.jqudt.onto.units.LengthUnit;

public class LengthTests {

	@Test
	public void testNanometer() throws IllegalArgumentException, IllegalAccessException {
		Quantity temp = new Quantity(23.5, LengthUnit.NM);
		Assert.assertEquals("nm", temp.getUnit().getAbbreviation());
	}

}
