/* Copyright (C) 2013  Egon Willighagen <egonw@users.sf.net>
 *
 * License: new BSD
 */
package com.github.jqudt.onto.units;

import com.github.jqudt.Unit;
import com.github.jqudt.onto.UnitFactory;

public class LengthUnit {

	private LengthUnit() {};

	public static Unit NANO_METER = UnitFactory.getInstance().getUnit("http://qudt.org/vocab/unit/NanoM");

	public static Unit MILLI_METER = UnitFactory.getInstance().getUnit("http://qudt.org/vocab/unit/MilliM");

	public static Unit CENTI_METER = UnitFactory.getInstance().getUnit("http://qudt.org/vocab/unit/CentiM");

	public static Unit DECI_METER = UnitFactory.getInstance().getUnit("http://qudt.org/vocab/unit/DeciM");

	public static Unit METER = UnitFactory.getInstance().getUnit("http://qudt.org/vocab/unit/M");

	public static Unit KILO_METER = UnitFactory.getInstance().getUnit("http://qudt.org/vocab/unit/KiloM");
}
