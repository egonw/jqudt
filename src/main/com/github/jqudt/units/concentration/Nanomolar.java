/* Copyright (C) 2012  Egon Willighagen <egonw@users.sf.net>
 *
 * License: new BSD
 */
package com.github.jqudt.units.concentration;

import java.net.URI;
import java.net.URISyntaxException;

import com.github.jqudt.Multiplier;
import com.github.jqudt.Unit;

public class Nanomolar extends Unit {

	private static Unit instance;

	private Nanomolar() {
		setAbbreviation("nM");
		setLabel("Nanomolar");
		Multiplier multiplier = new Multiplier();
		multiplier.setMultiplier(0.000001);
		multiplier.setOffset(0.0);
		setMultiplier(multiplier);
		try {
			setResource(new URI("http://www.openphacts.org/units/Nanomolar"));
			setType(new URI("http://qudt.org/schema/qudt#MolarConcentrationUnit"));
		} catch (URISyntaxException e) { /* this exception will never happen */ } 
		setSymbol("nmol/dm^3");
	}

	public static Unit getInstance() {
		if (instance == null) instance = new Nanomolar();
		return instance;
	}

}
