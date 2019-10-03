package tech.oberwiesenfeld.tyres;

import java.math.BigDecimal;

import static java.lang.Math.PI;
import static java.math.BigDecimal.valueOf;

class TyreCalculateExtent {

    BigDecimal calculateExtent(Tyre tyre, TyreUnits tyreUnit) {
        BigDecimal tyreWidth = tyre.getTyreWidth().getValue(tyreUnit);
        BigDecimal tyreHeight = tyreWidth.multiply(tyre.getTyreAspectRatio());
        BigDecimal extent = tyreHeight.multiply(valueOf(2.0));

        extent = extent.add(tyre.getWheelWidth().getValue(tyreUnit));
        extent = extent.multiply(valueOf(PI));
        return extent;
    }
}
