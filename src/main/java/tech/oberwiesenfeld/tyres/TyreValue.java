package tech.oberwiesenfeld.tyres;

import java.math.BigDecimal;

class TyreValue {

    private BigDecimal value;
    private TyreUnits unit;

    TyreValue(BigDecimal value, TyreUnits unit) {
        this.value = value;
        this.unit = unit;
    }

    BigDecimal getValue(TyreUnits targetUnit) {
        if (targetUnit == getUnit()) {
            return value;
        }

        if (targetUnit == TyreUnits.MM && unit == TyreUnits.INCH) {
            return TyresConversions.inchToMillimeter(value);
        }

        throw new RuntimeException("conversion not implemented");
    }

    private TyreUnits getUnit() {
        return unit;
    }

}
