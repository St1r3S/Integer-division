package ua.foxminded.integerdivision;

import lombok.Data;

import java.util.Collections;
import java.util.List;


@Data
public class Result {
    private final int dividend;
    private final int divisor;
    private final int quotient;
    private final int reminder;

    private final List<Integer> subtrahendList;
    private final List<Integer> minuendList;

    public Result(int dividend, int divisor, int quotient, int reminder, List<Integer> subtrahendList, List<Integer> minuendList) {
        this.dividend = dividend;
        this.divisor = divisor;
        this.quotient = quotient;
        this.reminder = reminder;
        this.subtrahendList = Collections.unmodifiableList(subtrahendList);
        this.minuendList = Collections.unmodifiableList(minuendList);
    }
}
