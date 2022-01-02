/* Copyright (C) 2013  Egon Willighagen <egonw@users.sf.net>
 *
 * License: new BSD
 */
package com.github.jqudt.onto.units;

import com.github.jqudt.Unit;
import com.github.jqudt.onto.UnitFactory;

public class CountingUnit {

	private CountingUnit() {};

	public static Unit PERCENT = UnitFactory.getInstance().getUnit("http://qudt.org/vocab/unit/PERCENT");

}
