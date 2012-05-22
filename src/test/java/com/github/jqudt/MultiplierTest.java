/* Copyright (C) 2012  Egon Willighagen <egonw@users.sf.net>
 *
 * License: new BSD
 */
package com.github.jqudt;

import org.junit.Assert;
import org.junit.Test;

public class MultiplierTest {

	@Test
	public void testConstructorNullUnit() {
		Multiplier multiplier = new Multiplier(0.1, 0.2);
		Assert.assertEquals(0.1, multiplier.getOffset(), 0.01);
		Assert.assertEquals(0.2, multiplier.getMultiplier(), 0.01);
	}

}
