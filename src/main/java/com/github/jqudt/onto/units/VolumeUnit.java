/* Copyright (C) 2013  Egon Willighagen <egonw@users.sf.net>
 *
 * License: new BSD
 */
package com.github.jqudt.onto.units;

import com.github.jqudt.Unit;
import com.github.jqudt.onto.UnitFactory;

public class VolumeUnit {

	private VolumeUnit() {};

	public static Unit HECTOLITER = UnitFactory.getInstance().getUnit("http://qudt.org/vocab/unit/HectoL");
	public static Unit LITER = UnitFactory.getInstance().getUnit("http://qudt.org/vocab/unit/L");
	public static Unit MICROLITER = UnitFactory.getInstance().getUnit("http://qudt.org/vocab/unit/MicroL");
	public static Unit MILLILITER = UnitFactory.getInstance().getUnit("http://qudt.org/vocab/unit/MilliL");

}
