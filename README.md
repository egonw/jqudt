Introduction
============

Java Library to deal with QUDT units and conversions between them.

QUDT is "Quantities, Units, Dimensions and Data Types in OWL and XML"

    http://www.qudt.org/

QUDT is a CC-SA-BY project by NASA Ames Research Center and TopQuadrant, Inc.

License of this Java library: new BSD

Status
======

The status of this library is alpha.

Quick demo
==========

Keep in mind, that the below conversions are purely derived from the information
defined in the QUDT ontology, taking advantage from the fact that the have the
same unit type, qudt:MolarConcentrationUnit and qudt:TemperatureUnit respectively.

Source:

    Quantity obs = new Quantity(0.1, Micromolar.getInstance());
    System.out.println(obs + " = " +  obs.convertTo(Nanomolar.getInstance()));
    
    Quantity temp = new Quantity(20, TemperatureUnit.CELSIUS);
    System.out.println(temp + " = " +  temp.convertTo(TemperatureUnit.KELVIN));

Output

    0.1 μM = 100.00000000000001 nM
    20.0 C = 293.0 K

