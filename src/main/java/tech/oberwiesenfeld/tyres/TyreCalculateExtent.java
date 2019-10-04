package tech.oberwiesenfeld.tyres;

import java.math.BigDecimal;

import static java.math.BigDecimal.valueOf;

public class TyreCalculateExtent {

    private static final BigDecimal TWO = valueOf(2.0);
    private static final BigDecimal PI = valueOf(Math.PI);

    @SuppressWarnings("UnnecessaryLocalVariable")
    public BigDecimal calculateExtent(Tyre tyre, TyreUnits tyreUnit) {
        BigDecimal twoTimesTyreHeight = calculateTwoTimesTyreHeight(tyre, tyreUnit);
        BigDecimal wheelAndTyreDiameter = twoTimesTyreHeight.add(tyre.getWheelWidth().getValue(tyreUnit));
        BigDecimal extent = wheelAndTyreDiameter.multiply(PI);
        return extent;
    }

    private BigDecimal calculateTwoTimesTyreHeight(Tyre tyre, TyreUnits tyreUnit) {
        BigDecimal tyreWidth = tyre.getTyreWidth().getValue(tyreUnit);
        BigDecimal tyreHeight = tyreWidth.multiply(tyre.getTyreAspectRatio());
        return tyreHeight.multiply(TWO);
    }
}
