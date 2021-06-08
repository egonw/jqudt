/* Copyright (C) 2013  Egon Willighagen <egonw@users.sf.net>
 *
 * License: new BSD
 */
package com.github.jqudt.onto.units;

import com.github.jqudt.Unit;
import com.github.jqudt.onto.UnitFactory;

public class MassUnit {

	private MassUnit() {};

	public static Unit TONNE = UnitFactory.getInstance().getUnit("http://qudt.org/vocab/unit/TONNE");
	public static Unit KILO_GRAM = UnitFactory.getInstance().getUnit("http://qudt.org/vocab/unit/KiloGM");
	public static Unit GRAM = UnitFactory.getInstance().getUnit("http://qudt.org/vocab/unit/GM");
	public static Unit MILLI_GRAM = UnitFactory.getInstance().getUnit("http://qudt.org/vocab/unit/MilliGM");
	public static Unit MICRO_GRAM = UnitFactory.getInstance().getUnit("http://qudt.org/vocab/unit/MicroGM");
	public static Unit NANO_GRAM = UnitFactory.getInstance().getUnit("http://qudt.org/vocab/unit/NanoGM");
	public static Unit PICO_GRAM = UnitFactory.getInstance().getUnit("http://qudt.org/vocab/unit/PicoGM");
	public static Unit FEMTO_GRAM = UnitFactory.getInstance().getUnit("http://www.openphacts.org/units/Femtogram");

}
