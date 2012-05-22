/* Copyright (C) 2012  Egon Willighagen <egonw@users.sf.net>
 *
 * License: new BSD
 */
package com.github.jqudt.units.concentration;

import java.net.URI;
import java.net.URISyntaxException;

import com.github.jqudt.Multiplier;
import com.github.jqudt.Unit;

public class Molar extends Unit {

	private static Unit instance;

	private Molar() {
		setAbbreviation("M");
		setLabel("Molar");
		Multiplier multiplier = new Multiplier();
		multiplier.setMultiplier(1000.0);
		multiplier.setOffset(0.0);
		setMultiplier(multiplier);
		try {
			setResource(new URI("http://www.openphacts.org/units/Molar"));
			setType(new URI("http://qudt.org/schema/qudt#MolarConcentrationUnit"));
		} catch (URISyntaxException e) { /* this exception will never happen */ } 
		setSymbol("mol/dm^3");
	}

	public static Unit getInstance() {
		if (instance == null) instance = new Molar();
		return instance;
	}

}
