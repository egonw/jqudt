/* Copyright (C) 2012  Egon Willighagen <egonw@users.sf.net>
 *
 * License: new BSD
 */
package com.github.jqudt.units.temperature;

import java.net.URI;
import java.net.URISyntaxException;

import com.github.jqudt.Multiplier;
import com.github.jqudt.Unit;

public class Fahrenheit extends Unit {

	private static Unit instance;

	private Fahrenheit() {
		setAbbreviation("degF");
		setLabel("degree fahrenheit");
		Multiplier multiplier = new Multiplier();
		multiplier.setMultiplier(0.5555555555555555556);
		multiplier.setOffset(255.37037037037037037);
		setMultiplier(multiplier);
		try {
			setResource(new URI("http://www.openphacts.org/units/Kelvin"));
			setType(new URI("http://qudt.org/schema/qudt#Kelvin"));
		} catch (URISyntaxException e) { /* this exception will never happen */ } 
		setSymbol("K");
	}

	public static Unit getInstance() {
		if (instance == null) instance = new Fahrenheit();
		return instance;
	}

}
