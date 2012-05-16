/* Copyright (C) 2012  Egon Willighagen <egonw@users.sf.net>
 *
 * License: new BSD
 */
package com.github.jqutd.units.concentration;

import java.net.URI;
import java.net.URISyntaxException;

import com.github.jqutd.Multiplier;
import com.github.jqutd.Unit;

public class Micromolar extends Unit {

	private static Unit instance;

	private Micromolar() {
		setAbbreviation("μM");
		setLabel("Micromolar");
		Multiplier multiplier = new Multiplier();
		multiplier.setMultiplier(0.001);
		multiplier.setOffset(0.0);
		setMultiplier(multiplier);
		try {
			setResource(new URI("http://www.openphacts.org/units/Micromolar"));
			setType(new URI("http://qudt.org/schema/qudt#MolarConcentrationUnit"));
		} catch (URISyntaxException e) { /* this exception will never happen */ } 
		setSymbol("μmol/dm^3");
	}

	public static Unit getInstance() {
		if (instance == null) instance = new Micromolar();
		return instance;
	}

}
