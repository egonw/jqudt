package com.github.jqudt.onto.units;

import com.github.jqudt.Unit;
import com.github.jqudt.onto.UnitFactory;

public class TimeUnit {

    private TimeUnit() {}

    public static Unit NANOSEC = UnitFactory.getInstance().getUnit("http://qudt.org/vocab/unit/NanoSEC");

    public static Unit MICROSEC = UnitFactory.getInstance().getUnit("http://qudt.org/vocab/unit/MicroSEC");

    public static Unit MILLISEC = UnitFactory.getInstance().getUnit("http://qudt.org/vocab/unit/MilliSEC");

    public static Unit KILOSEC = UnitFactory.getInstance().getUnit("http://qudt.org/vocab/unit/KiloSEC");

    public static Unit SEC = UnitFactory.getInstance().getUnit("http://qudt.org/vocab/unit/SEC");

    public static Unit MIN = UnitFactory.getInstance().getUnit("http://qudt.org/vocab/unit/MIN");

    public static Unit HOUR = UnitFactory.getInstance().getUnit("http://qudt.org/vocab/unit/HR");

}
