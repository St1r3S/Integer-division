package ua.foxminded.integerdivision;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {
    Calculator calculator = new Calculator();

    @Test
    void shouldVerifyDividendEqualsDivisor() {
        assertEquals("Result(dividend=15, divisor=15, quotient=1, reminder=0, subtrahendList=[15], minuendList=[15])", calculator.divide(15, 15).toString());
    }

    @Test
    void shouldVerifyDividendLessThanDivisor() {
        assertEquals("Result(dividend=15, divisor=45, quotient=0, reminder=15, subtrahendList=[], minuendList=[])", calculator.divide(15, 45).toString());
    }

    @Test
    void shouldVerifyDividendGreaterThanDivisor() {
        assertEquals("Result(dividend=7485, divisor=5, quotient=1497, reminder=0, subtrahendList=[5, 20, 45, 35], minuendList=[7, 24, 48, 35])", calculator.divide(7485, 5).toString());
    }

    @Test
    void shouldVerifyDividendGreaterThanDivisorAndReminderFilled() {
        assertEquals("Result(dividend=7485, divisor=6, quotient=1247, reminder=3, subtrahendList=[6, 12, 24, 42], minuendList=[7, 14, 28, 45])", calculator.divide(7485, 6).toString());
    }

    @Test
    void shouldVerifyDividendEqualsOneAndDivisorEqualsOneHundred() {
        assertEquals("Result(dividend=1, divisor=100, quotient=0, reminder=1, subtrahendList=[], minuendList=[])", calculator.divide(1, 100).toString());
    }

    @Test
    void shouldVerifyNegativeDividendAndPositiveDivisor() {
        assertEquals("Result(dividend=-2081, divisor=15, quotient=-138, reminder=11, subtrahendList=[15, 45, 120], minuendList=[20, 58, 131])", calculator.divide(-2081, 15).toString());
    }

    @Test
    void shouldVerifyPositiveDividendAndNegativeDivisor() {
        assertEquals("Result(dividend=2081, divisor=-15, quotient=-138, reminder=11, subtrahendList=[15, 45, 120], minuendList=[20, 58, 131])", calculator.divide(2081, -15).toString());
    }

    @ParameterizedTest
    @CsvSource({"15,5", "16,4", "24,6", "18,9", "12,2", "81,9", "9,3", "21,7"})
    void shouldVerifySeveralSimpleDivisions(int dividend, int divisor) {
        assertEquals(dividend / divisor, calculator.divide(dividend, divisor).getQuotient());
    }

    @ParameterizedTest
    @CsvSource({"156541,5", "1512136,4", "9542124,6", "1844448,901", "6661552,72", "844381,92", "235419,31", "55413221,27"})
    void shouldVerifySeveralComplicatedDivisions(int dividend, int divisor) {
        assertEquals(dividend / divisor, calculator.divide(dividend, divisor).getQuotient());
    }

    @Test
    void shouldThrowExceptionOnDivisionByZero() {
        assertThrows(IllegalArgumentException.class, () -> calculator.divide(7485, 0));
    }
}
