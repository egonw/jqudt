/* Copyright (C) 2013  Egon Willighagen <egonw@users.sf.net>
 *
 * License: new BSD
 */
package com.github.jqudt.units.area;

import org.junit.Assert;
import org.junit.Test;

import com.github.jqudt.Quantity;
import com.github.jqudt.onto.units.AreaUnit;

public class SquareAreaTest {

	@Test
	public void testMinusTwenty() throws IllegalArgumentException, IllegalAccessException {
		Quantity area = new Quantity(5, AreaUnit.SQUARE_CM);
		Quantity area2 = area.convertTo(AreaUnit.SQUARE_METER);
		Assert.assertEquals(0.00000000000000000005, area2.getValue(), 0.01);
	}

}
