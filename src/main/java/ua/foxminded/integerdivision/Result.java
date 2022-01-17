package ua.foxminded.integerdivision;

import lombok.Data;

import java.util.LinkedList;


@Data
public class Result {
    private final int dividend;
    private final int divisor;
    private final int quotient;
    private final int reminder;

    private final LinkedList<Integer> subtrahendList;
    private final LinkedList<Integer> minuendList;

    public Result(int dividend, int divisor, int quotient, int reminder, LinkedList<Integer> subtrahendList, LinkedList<Integer> minuendList) {
        this.dividend = dividend;
        this.divisor = divisor;
        this.quotient = quotient;
        this.reminder = reminder;
        this.subtrahendList = subtrahendList;
        this.minuendList = minuendList;
    }

}
