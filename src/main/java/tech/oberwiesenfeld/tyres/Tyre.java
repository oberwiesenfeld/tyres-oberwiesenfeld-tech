package tech.oberwiesenfeld.tyres;

import java.math.BigDecimal;

import static java.math.BigDecimal.valueOf;

public class Tyre {
    private TyreValue tyreWidth;
    private TyreValue wheelWidth;
    private BigDecimal tyreAspectRatio;

    public Tyre(double tyreWidthDouble, double wheelWidthDouble, double aspectRatio, TyreUnits unit) {
        setTyreAspectRatio(BigDecimal.valueOf(aspectRatio));
        setTyreWidth(valueOf(tyreWidthDouble), unit);
        setWheelWidth(valueOf(wheelWidthDouble), unit);
    }

    TyreValue getTyreWidth() {
        return tyreWidth;
    }

    TyreValue getWheelWidth() {
        return wheelWidth;
    }

    BigDecimal getTyreAspectRatio() {
        return tyreAspectRatio;
    }

    private void setTyreWidth(BigDecimal tyreWidth, TyreUnits measurementUnit) {
        this.tyreWidth = new TyreValue(tyreWidth, measurementUnit);
    }

    private void setWheelWidth(BigDecimal wheelWidth, TyreUnits measurementUnit) {
        this.wheelWidth = new TyreValue(wheelWidth, measurementUnit);
    }

    private void setTyreAspectRatio(BigDecimal tyreAspectRatio) {
        this.tyreAspectRatio = tyreAspectRatio;
    }

}
