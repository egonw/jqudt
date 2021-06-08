/* Copyright (C) 2013  Egon Willighagen <egonw@users.sf.net>
 *
 * License: new BSD
 */
package com.github.jqudt.onto.units;

import com.github.jqudt.Unit;
import com.github.jqudt.onto.UnitFactory;

public class VolumeUnit {

	private VolumeUnit() {};

	public static Unit CUBIC_MILLI_METER = UnitFactory.getInstance().getUnit("http://qudt.org/vocab/unit/MilliM3");
	public static Unit CUBIC_CENTI_METER = UnitFactory.getInstance().getUnit("http://qudt.org/vocab/unit/CentiM3");
	public static Unit CUBIC_METER = UnitFactory.getInstance().getUnit("http://qudt.org/vocab/unit/M3");
	public static Unit CUBIC_DECA_METER = UnitFactory.getInstance().getUnit("http://qudt.org/vocab/unit/DecaM3");

	// liter
	public static Unit HECTO_LITER = UnitFactory.getInstance().getUnit("http://qudt.org/vocab/unit/HectoL");
	public static Unit LITER = UnitFactory.getInstance().getUnit("http://qudt.org/vocab/unit/L");
	public static Unit MICRO_LITER = UnitFactory.getInstance().getUnit("http://qudt.org/vocab/unit/MicroL");
	public static Unit MILLI_LITER = UnitFactory.getInstance().getUnit("http://qudt.org/vocab/unit/MilliL");

}
