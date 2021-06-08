package com.github.jqudt.onto.units;

import com.github.jqudt.Unit;
import com.github.jqudt.onto.UnitFactory;

public class KinematicUnit {

    private KinematicUnit() {}

    // speed
    // per sec
    public static Unit MM_PER_SEC = UnitFactory.getInstance().getUnit("http://qudt.org/vocab/unit/MilliM-PER-SEC");
    public static Unit CM_PER_SEC = UnitFactory.getInstance().getUnit("http://qudt.org/vocab/unit/CentiM-PER-SEC");
    public static Unit M_PER_SEC = UnitFactory.getInstance().getUnit("http://qudt.org/vocab/unit/M-PER-SEC");
    public static Unit KM_PER_SEC = UnitFactory.getInstance().getUnit("http://qudt.org/vocab/unit/KiloM-PER-SEC");

    // per minute
    public static Unit MM_PER_MIN = UnitFactory.getInstance().getUnit("http://qudt.org/vocab/unit/MilliM-PER-MIN");
    public static Unit M_PER_MIN = UnitFactory.getInstance().getUnit("http://qudt.org/vocab/unit/M-PER-MIN");

    // per hour
    public static Unit MM_PER_HOUR = UnitFactory.getInstance().getUnit("http://qudt.org/vocab/unit/MilliM-PER-HR");
    public static Unit CM_PER_HOUR = UnitFactory.getInstance().getUnit("http://qudt.org/vocab/unit/CentiM-PER-HR");
    public static Unit M_PER_HOUR = UnitFactory.getInstance().getUnit("http://qudt.org/vocab/unit/M-PER-HR");
    public static Unit KM_PER_HOUR = UnitFactory.getInstance().getUnit("http://qudt.org/vocab/unit/KiloM-PER-HR");

    // per day
    public static Unit MM_PER_DAY = UnitFactory.getInstance().getUnit("http://qudt.org/vocab/unit/MilliM-PER-DAY");
    public static Unit KM_PER_DAY = UnitFactory.getInstance().getUnit("http://qudt.org/vocab/unit/KiloM-PER-DAY");

    // period frequency
    public static Unit HERTZ = UnitFactory.getInstance().getUnit("http://qudt.org/vocab/unit/HZ");
    public static Unit KILO_HERTZ = UnitFactory.getInstance().getUnit("http://qudt.org/vocab/unit/KiloHZ");
    public static Unit MEGA_HERTZ = UnitFactory.getInstance().getUnit("http://qudt.org/vocab/unit/MegaHZ");
    public static Unit GIGA_HERTZ = UnitFactory.getInstance().getUnit("http://qudt.org/vocab/unit/GigaHZ");
    public static Unit TERA_HERTZ = UnitFactory.getInstance().getUnit("http://qudt.org/vocab/unit/TeraHZ");


    public static Unit NUM_PER_SEC = UnitFactory.getInstance().getUnit("http://qudt.org/vocab/unit/NUM-PER-SEC");
    public static Unit NUM_PER_HOUR = UnitFactory.getInstance().getUnit("http://qudt.org/vocab/unit/NUM-PER-HR");
    public static Unit NUM_PER_YEAR = UnitFactory.getInstance().getUnit("http://qudt.org/vocab/unit/NUM-PER-YR");

    // circular frequency
    public static Unit RAD_PER_SEC = UnitFactory.getInstance().getUnit("http://qudt.org/vocab/unit/RAD-PER-SEC");
    public static Unit RAD_PER_MIN = UnitFactory.getInstance().getUnit("http://qudt.org/vocab/unit/RAD-PER-MIN");
    public static Unit RAD_PER_HOUR = UnitFactory.getInstance().getUnit("http://qudt.org/vocab/unit/RAD-PER-HR");

    // angular acceleration
    public static Unit RAD_PER_SEC2 = UnitFactory.getInstance().getUnit("http://qudt.org/vocab/unit/RAD-PER-SEC2");

    public static Unit M2_PER_SEC = UnitFactory.getInstance().getUnit("http://qudt.org/vocab/unit/M2-PER-SEC");


}
