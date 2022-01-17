package ua.foxminded.integerdivision;

import java.util.LinkedList;

public class Calculator {

    public Result divide(int dividend, int divisor) {

        if (divisor == 0) {
            throw new IllegalArgumentException("Division by zero!");
        }

        int quotient = 0;
        int reminder = dividend;
        int partDividend;
        int partQuotient;
        int subtrahendCheck = quotient * divisor;
        int quotientCheck = dividend / divisor;
        int delta;

        LinkedList<Integer> subtrahendList = new LinkedList<>();
        LinkedList<Integer> minuendList = new LinkedList<>();

        if (Math.abs(dividend) >= divisor) {
            int dividendDigitQuantityMinusOne = (int) (Math.log10(Math.abs(dividend)));
            int quotientDigitQuantityMinusOne = (int) (Math.log10(Math.abs(quotientCheck)));

            while (quotient != (quotientCheck)) {
                partDividend = dividend - subtrahendCheck;
                reminder = 0;
                for (int j = 0; j < dividendDigitQuantityMinusOne; j++) {
                    partDividend /= 10;
                }
                dividendDigitQuantityMinusOne--;
                if (partDividend / divisor == 0) {
                    if (dividendDigitQuantityMinusOne != quotientDigitQuantityMinusOne && divisor < quotient) {
                        quotientDigitQuantityMinusOne--;
                    }
                    continue;
                }
                minuendList.add(Math.abs(partDividend));
                if (partDividend % divisor != 0) {
                    reminder = partDividend % divisor;
                }
                partQuotient = partDividend / divisor;
                subtrahendList.add(Math.abs(partQuotient * divisor));
                for (int j = 0; j < quotientDigitQuantityMinusOne; j++) {
                    partQuotient *= 10;
                }
                quotientDigitQuantityMinusOne--;
                quotient += partQuotient;
                subtrahendCheck = quotient * divisor;
                delta = dividend - subtrahendCheck;
                if (delta != 0 && quotient == quotientCheck) {
                    reminder = delta;
                }
            }
        }
        return new Result(dividend, divisor, quotient, Math.abs(reminder), subtrahendList, minuendList);
    }
}
