package com.github.jqudt.onto.units;

import com.github.jqudt.Unit;
import com.github.jqudt.onto.UnitFactory;

public class TimeUnit {

    private TimeUnit() {}

    public static Unit NANO_SECOND = UnitFactory.getInstance().getUnit("http://qudt.org/vocab/unit/NanoSEC");

    public static Unit MICRO_SECOND = UnitFactory.getInstance().getUnit("http://qudt.org/vocab/unit/MicroSEC");

    public static Unit MILLI_SECOND = UnitFactory.getInstance().getUnit("http://qudt.org/vocab/unit/MilliSEC");

    public static Unit KILO_SECOND = UnitFactory.getInstance().getUnit("http://qudt.org/vocab/unit/KiloSEC");

    public static Unit SECOND = UnitFactory.getInstance().getUnit("http://qudt.org/vocab/unit/SEC");

    public static Unit MINUTE = UnitFactory.getInstance().getUnit("http://qudt.org/vocab/unit/MIN");

    public static Unit HOUR = UnitFactory.getInstance().getUnit("http://qudt.org/vocab/unit/HR");

    public static Unit DAY = UnitFactory.getInstance().getUnit("http://qudt.org/vocab/unit/DAY");

    public static Unit WEEK = UnitFactory.getInstance().getUnit("http://qudt.org/vocab/unit/WK");

    public static Unit MONTH = UnitFactory.getInstance().getUnit("http://qudt.org/vocab/unit/MO");

    public static Unit YEAR = UnitFactory.getInstance().getUnit("http://qudt.org/vocab/unit/YR");

    public static Unit MEGA_YEAR = UnitFactory.getInstance().getUnit("http://qudt.org/vocab/unit/MegaYR");

}
