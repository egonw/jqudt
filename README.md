[![DOI](https://zenodo.org/badge/DOI/10.5281/zenodo.3883588.svg)](https://doi.org/10.5281/zenodo.3883588)
[![Build Status](https://travis-ci.org/egonw/jqudt.svg?branch=master)](https://travis-ci.org/egonw/jqudt)
[![Maven Central](https://img.shields.io/maven-central/v/com.github.egonw/jqudt.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22com.github.egonw%22%20AND%20a:%22jqudt%22)

Introduction
============

Java Library to deal with QUDT units and conversions between them.

QUDT is "Quantities, Units, Dimensions and Data Types in OWL and XML"

    http://www.qudt.org/

QUDT is a CC-SA-BY project by NASA Ames Research Center and TopQuadrant, Inc.

License of this Java library: new BSD

Installation
============

Maven:

```xml
<dependency>
  <groupId>com.github.egonw</groupId>
  <artifactId>jqudt</artifactId>
  <version>1.4.0</version>
</dependency>
```

Groovy:

```groovy
@Grab(group='com.github.egonw', module='jqudt', version='1.4.0')
```

Quick demo
==========

Keep in mind, that the below conversions are purely derived from the information
defined in the QUDT ontology, taking advantage from the fact that the have the
same unit type, qudt:MolarConcentrationUnit and qudt:TemperatureUnit respectively.

Source:

```java
Quantity obs = new Quantity(0.1, ConcentrationUnit.MICROMOLAR);
System.out.println(obs + " = " +  obs.convertTo(ConcentrationUnit.NANOMOLAR));

Quantity temp = new Quantity(20, TemperatureUnit.CELSIUS);
System.out.println(temp + " = " +  temp.convertTo(TemperatureUnit.KELVIN));
```

Output

```
0.1 μM = 100.00000000000001 nM
20.0 C = 293.0 K
```
