/* Copyright (C) 2012  Egon Willighagen <egonw@users.sf.net>
 *
 * License: new BSD
 */
package com.github.jqudt.units.concentration;

import org.junit.Assert;
import org.junit.Test;

import com.github.jqudt.Quantity;
import com.github.jqudt.Unit;
import com.github.jqudt.onto.UnitFactory;

public class TimeUnitTest {

	@Test
	public void test() throws IllegalArgumentException, IllegalAccessException {
		UnitFactory factory = UnitFactory.getInstance();
		Unit hour = factory.getUnit("http://qudt.org/vocab/unit#Hour");
		Unit second = factory.getUnit("http://qudt.org/vocab/unit#SecondTime");
		Quantity obs = new Quantity(1, hour);
		Quantity obs2 =  obs.convertTo(second);
		Assert.assertEquals(second, obs2.getUnit());
		Assert.assertEquals(3600, obs2.getValue(), 1);
	}

}
