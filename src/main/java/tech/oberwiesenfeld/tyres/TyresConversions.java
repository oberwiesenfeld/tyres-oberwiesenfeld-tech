package tech.oberwiesenfeld.tyres;

import java.math.BigDecimal;

import static java.math.BigDecimal.*;

class TyresConversions {

    static BigDecimal inchToMillimeter(BigDecimal inches) {
        return inches.multiply(valueOf(25.4));
    }
}
