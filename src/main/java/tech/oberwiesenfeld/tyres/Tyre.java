package tech.oberwiesenfeld.tyres;

import java.math.BigDecimal;

import static java.math.BigDecimal.valueOf;

public class Tyre {
    private TyreValue tyreWidth;
    private TyreValue wheelWidth;
    private BigDecimal tyreAspectRatio;

    public Tyre(double tyreWidthAsDouble, double wheelWidthAsDouble, double aspectRatio, TyreUnits tyreUnit) {
        setTyreAspectRatio(valueOf(aspectRatio));
        setTyreWidth(valueOf(tyreWidthAsDouble), tyreUnit);
        setWheelWidth(valueOf(wheelWidthAsDouble), tyreUnit);
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
