package tech.oberwiesenfeld.motorcycle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import tech.oberwiesenfeld.tyres.Tyre;
import tech.oberwiesenfeld.tyres.TyreCalculateExtent;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static java.math.BigDecimal.valueOf;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static tech.oberwiesenfeld.tyres.TyreUnits.INCH;
import static tech.oberwiesenfeld.tyres.TyreUnits.MM;

class BMW_R27 {
    private TyreCalculateExtent underTest;

    @BeforeEach
    void  setup() {
        underTest = new TyreCalculateExtent();
    }

    private static Stream<Arguments> createTestTyres() {
        // Rim, Felge 2,15 B x 18 Tiefbett
        return Stream.of(
                Arguments.of(3.25, 18, 0.8, 1851.28),
                Arguments.of(3.25, 18, 1.0, 1955.02)
        );
    }

    @ParameterizedTest
    @MethodSource("createTestTyres")
    void calcuteAndCheckExpectedExtent(double tyreWidthDouble, int wheelWidthDouble, double aspectRatio, double result) {
        assertWheel(tyreWidthDouble, wheelWidthDouble, aspectRatio, result);
    }

    private void assertWheel(double tyreWidthDouble, int wheelWidthDouble, double aspectRatio, double result) {
        Tyre tyre = new Tyre(tyreWidthDouble, wheelWidthDouble, aspectRatio, INCH);
        BigDecimal extent = underTest.calculateExtent(tyre, MM);
        assertEquals(valueOf(result).setScale(2,2), extent.setScale(2,2));
    }
}
