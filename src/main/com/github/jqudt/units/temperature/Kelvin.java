/* Copyright (C) 2012  Egon Willighagen <egonw@users.sf.net>
 *
 * License: new BSD
 */
package com.github.jqudt.units.temperature;

import java.net.URI;
import java.net.URISyntaxException;

import com.github.jqudt.Multiplier;
import com.github.jqudt.Unit;

public class Kelvin extends Unit {

	private static Unit instance;

	private Kelvin() {
		setAbbreviation("K");
		setLabel("kelvin");
		Multiplier multiplier = new Multiplier();
		multiplier.setMultiplier(1.0);
		multiplier.setOffset(0.0);
		setMultiplier(multiplier);
		try {
			setResource(new URI("http://www.openphacts.org/units/Kelvin"));
			setType(new URI("http://qudt.org/schema/qudt#Kelvin"));
		} catch (URISyntaxException e) { /* this exception will never happen */ } 
		setSymbol("K");
	}

	public static Unit getInstance() {
		if (instance == null) instance = new Kelvin();
		return instance;
	}

}
