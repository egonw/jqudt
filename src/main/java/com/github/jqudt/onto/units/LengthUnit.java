/* Copyright (C) 2013  Egon Willighagen <egonw@users.sf.net>
 *
 * License: new BSD
 */
package com.github.jqudt.onto.units;

import com.github.jqudt.Unit;
import com.github.jqudt.onto.UnitFactory;

public class LengthUnit {

	private LengthUnit() {};

	public static Unit NM = UnitFactory.getInstance().getUnit("http://qudt.org/vocab/unit/NanoM");

	public static Unit MM = UnitFactory.getInstance().getUnit("http://qudt.org/vocab/unit/MilliM");

	public static Unit CM = UnitFactory.getInstance().getUnit("http://qudt.org/vocab/unit/CentiM");

	public static Unit DM = UnitFactory.getInstance().getUnit("http://qudt.org/vocab/unit/DeciM");

	public static Unit M = UnitFactory.getInstance().getUnit("http://qudt.org/vocab/unit/M");

	public static Unit KM = UnitFactory.getInstance().getUnit("http://qudt.org/vocab/unit/KiloM");
}
