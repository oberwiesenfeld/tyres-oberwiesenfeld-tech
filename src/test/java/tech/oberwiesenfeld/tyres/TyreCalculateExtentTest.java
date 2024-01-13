package tech.oberwiesenfeld.tyres;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static java.math.BigDecimal.valueOf;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static tech.oberwiesenfeld.tyres.TyreUnits.INCH;
import static tech.oberwiesenfeld.tyres.TyreUnits.MM;

class TyreCalculateExtentTest {

    private TyreCalculateExtent underTest;

    @BeforeEach
    void  setup() {
        underTest = new TyreCalculateExtent();
    }

    private static Stream<Arguments> createTestTyres() {
        return Stream.of(
                Arguments.of(3.25, 19, 0.8, 1931.08),
                Arguments.of(3.25, 19, 1.0, 2034.81),
                Arguments.of(3.50, 19, 0.8, 1963.00),
                Arguments.of(3.50, 19, 1.0, 2074.71)
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
