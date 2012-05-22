/* Copyright (C) 2012  Egon Willighagen <egonw@users.sf.net>
 *
 * License: new BSD
 */
package com.github.jqudt.demo;

import com.github.jqudt.Measurement;
import com.github.jqudt.units.concentration.Micromolar;
import com.github.jqudt.units.concentration.Nanomolar;
import com.github.jqudt.units.temperature.Celsius;
import com.github.jqudt.units.temperature.Fahrenheit;
import com.github.jqudt.units.temperature.Kelvin;

public class Demo {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		Measurement obs = new Measurement(0.1, Micromolar.getInstance());
		System.out.println(obs + " = " +  obs.convertTo(Nanomolar.getInstance()));

		Measurement temp = new Measurement(20, Celsius.getInstance());
		System.out.println(temp + " = " +  temp.convertTo(Kelvin.getInstance()));
		System.out.println(temp + " = " +  temp.convertTo(Fahrenheit.getInstance()));
	}

}
