/* Copyright (C) 2013  Egon Willighagen <egonw@users.sf.net>
 *
 * License: new BSD
 */
package com.github.jqudt.onto.units;

import com.github.jqudt.Unit;
import com.github.jqudt.onto.UnitFactory;

public class AreaUnit {

	private AreaUnit() {};

	public static Unit SQUARE_MM = UnitFactory.getInstance().getUnit("http://qudt.org/vocab/unit/MilliM2");
	public static Unit SQUARE_CM = UnitFactory.getInstance().getUnit("http://qudt.org/vocab/unit/CentiM2");
	public static Unit SQUARE_DM = UnitFactory.getInstance().getUnit("http://qudt.org/vocab/unit/DeciM2");
	public static Unit SQUARE_METER = UnitFactory.getInstance().getUnit("http://qudt.org/vocab/unit/M2");
	public static Unit HECTARE = UnitFactory.getInstance().getUnit("http://qudt.org/vocab/unit/HA");
	public static Unit SQUARE_ANGSTROM = UnitFactory.getInstance().getUnit("http://www.openphacts.org/units/SquareAngstrom");

}
