package ua.foxminded.integerdivision;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {
    Calculator calculator = new Calculator();

    @Test
    void shouldVerifyDividendEqualsDivisor() {
        Result result = new Result(15, 15, 1, 0, Arrays.asList(15), Arrays.asList(15));
        assertEquals(result, calculator.divide(15, 15));
    }

    @Test
    void shouldVerifyDividendLessThanDivisor() {
        Result result = new Result(15, 45, 0, 15, Arrays.asList(), Arrays.asList());
        assertEquals(result, calculator.divide(15, 45));
    }

    @Test
    void shouldVerifyDividendGreaterThanDivisor() {
        Result result = new Result(7485, 5, 1497, 0, Arrays.asList(5, 20, 45, 35), Arrays.asList(7, 24, 48, 35));
        assertEquals(result, calculator.divide(7485, 5));
    }

    @Test
    void shouldVerifyDividendGreaterThanDivisorAndReminderFilled() {
        Result result = new Result(7485, 6, 1247, 3, Arrays.asList(6, 12, 24, 42), Arrays.asList(7, 14, 28, 45));
        assertEquals(result, calculator.divide(7485, 6));
    }

    @Test
    void shouldVerifyDividendEqualsOneAndDivisorEqualsOneHundred() {
        Result result = new Result(1, 100, 0, 1, Arrays.asList(), Arrays.asList());
        assertEquals(result, calculator.divide(1, 100));
    }

    @Test
    void shouldVerifyNegativeDividendAndPositiveDivisor() {
        Result result = new Result(-2081, 15, -138, 11, Arrays.asList(15, 45, 120), Arrays.asList(20, 58, 131));
        assertEquals(result, calculator.divide(-2081, 15));
    }

    @Test
    void shouldVerifyPositiveDividendAndNegativeDivisor() {
        Result result = new Result(2081, -15, -138, 11, Arrays.asList(15, 45, 120), Arrays.asList(20, 58, 131));
        assertEquals(result, calculator.divide(2081, -15));
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
