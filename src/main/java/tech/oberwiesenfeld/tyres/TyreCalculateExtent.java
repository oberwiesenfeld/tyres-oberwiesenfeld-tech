package tech.oberwiesenfeld.tyres;

import java.math.BigDecimal;

import static java.lang.Math.PI;
import static java.math.BigDecimal.valueOf;

public class TyreCalculateExtent {

    private static final BigDecimal TWO = valueOf(2.0);

    public BigDecimal calculateExtent(Tyre tyre, TyreUnits tyreUnit) {
        BigDecimal tyreWidth = tyre.getTyreWidth().getValue(tyreUnit);
        BigDecimal tyreHeight = tyreWidth.multiply(tyre.getTyreAspectRatio());
        BigDecimal extent = tyreHeight.multiply(TWO);

        extent = extent.add(tyre.getWheelWidth().getValue(tyreUnit));
        extent = extent.multiply(valueOf(PI));
        return extent;
    }
}
