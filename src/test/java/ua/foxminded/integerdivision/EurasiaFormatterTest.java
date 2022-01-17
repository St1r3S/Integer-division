package ua.foxminded.integerdivision;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EurasiaFormatterTest {

    Formatter formatter = FormatterFactory.getInstance().get("Eurasia Formatter");


    @Test
    void shouldVerifyPositiveDividendAndPositiveDivisor() {
        LinkedList<Integer> subtrahendList = new LinkedList<>(Arrays.asList(8, 40, 56));
        LinkedList<Integer> minuendList = new LinkedList<>(Arrays.asList(8, 40, 56));
        assertEquals("_84564|8\n" +
                        " 8    |-----\n" +
                        " -    |10570\n" +
                        " _40\n" +
                        "  40\n" +
                        "  --\n" +
                        "  _56\n" +
                        "   56\n" +
                        "   --\n" +
                        "     4",
                formatter.format(new Result(84564, 8, 10570, 4, subtrahendList, minuendList)));
    }

    @Test
    void shouldVerifyPositiveDividendAndNegativeDivisor() {
        LinkedList<Integer> subtrahendList = new LinkedList<>(Arrays.asList(8, 40, 56));
        LinkedList<Integer> minuendList = new LinkedList<>(Arrays.asList(8, 40, 56));
        assertEquals("_84564|-8\n" +
                        " 8    |------\n" +
                        " -    |-10570\n" +
                        " _40\n" +
                        "  40\n" +
                        "  --\n" +
                        "  _56\n" +
                        "   56\n" +
                        "   --\n" +
                        "     4",
                formatter.format(new Result(84564, -8, -10570, 4, subtrahendList, minuendList)).toString());
    }

    @Test
    void shouldVerifyNegativeDividendAndPositiveDivisor() {
        LinkedList<Integer> subtrahendList = new LinkedList<>(Arrays.asList(8, 40, 56));
        LinkedList<Integer> minuendList = new LinkedList<>(Arrays.asList(8, 40, 56));
        assertEquals("_-84564 |8\n" +
                        "  8     |------\n" +
                        "  -     |-10570\n" +
                        "  _40\n" +
                        "   40\n" +
                        "   --\n" +
                        "   _56\n" +
                        "    56\n" +
                        "    --\n" +
                        "      4",
                formatter.format(new Result(-84564, 8, -10570, 4, subtrahendList, minuendList)));
    }

    @Test
    void shouldVerifyNegativeDividendAndNegativeDivisor() {
        LinkedList<Integer> subtrahendList = new LinkedList<>(Arrays.asList(8, 40, 56));
        LinkedList<Integer> minuendList = new LinkedList<>(Arrays.asList(8, 40, 56));
        assertEquals("_-84564 |-8\n" +
                        "  8     |-----\n" +
                        "  -     |10570\n" +
                        "  _40\n" +
                        "   40\n" +
                        "   --\n" +
                        "   _56\n" +
                        "    56\n" +
                        "    --\n" +
                        "      4",
                formatter.format(new Result(-84564, -8, 10570, 4, subtrahendList, minuendList)));
    }

    @Test
    void shouldVerifySameDividendAndDivisor() {
        LinkedList<Integer> subtrahendList = new LinkedList<>(Arrays.asList(15));
        LinkedList<Integer> minuendList = new LinkedList<>(Arrays.asList(15));
        assertEquals("_15|15\n" +
                        " 15|-\n" +
                        " --|1\n" +
                        "   0",
                formatter.format(new Result(15, 15, 1, 0, subtrahendList, minuendList)));
    }

    @Test
    void shouldVerifyPositiveDividendLessThanPositiveDivisor() {
        LinkedList<Integer> subtrahendList = new LinkedList<>(Arrays.asList());
        LinkedList<Integer> minuendList = new LinkedList<>(Arrays.asList());
        assertEquals("There is integer divider!\n" +
                        "Your answer is 0 with 15 in the reminder.",
                formatter.format(new Result(15, 30, 0, 15, subtrahendList, minuendList)));
    }

    @Test
    void shouldVerifyNegativeDividendLessThanPositiveDivisor() {
        LinkedList<Integer> subtrahendList = new LinkedList<>(Arrays.asList());
        LinkedList<Integer> minuendList = new LinkedList<>(Arrays.asList());
        assertEquals("There is integer divider!\n" +
                        "Your answer is 0 with 6 in the reminder.",
                formatter.format(new Result(-6, 8, 0, 6, subtrahendList, minuendList)));
    }

    @Test
    void shouldVerifyNegativeDividendLessThanNegativeDivisor() {
        LinkedList<Integer> subtrahendList = new LinkedList<>(Arrays.asList());
        LinkedList<Integer> minuendList = new LinkedList<>(Arrays.asList());
        assertEquals("There is integer divider!\n" +
                        "Your answer is 0 with 6 in the reminder.",
                formatter.format(new Result(-6, -8, 0, 6, subtrahendList, minuendList)));
    }

    @Test
    void shouldVerifyPositiveDividendLessThanNegativeDivisor() {
        LinkedList<Integer> subtrahendList = new LinkedList<>(Arrays.asList());
        LinkedList<Integer> minuendList = new LinkedList<>(Arrays.asList());
        assertEquals("There is integer divider!\n" +
                        "Your answer is 0 with 6 in the reminder.",
                formatter.format(new Result(6, -8, 0, 6, subtrahendList, minuendList)));
    }

    @Test
    void shouldVerifyLargePositiveDividendAndLargePositiveDivisor() {

        LinkedList<Integer> subtrahendList = new LinkedList<>(Arrays.asList(45598, 58626, 13028, 58626));
        LinkedList<Integer> minuendList = new LinkedList<>(Arrays.asList(51654, 60561, 19352, 63243));
        assertEquals("_51654123|6514\n" +
                        " 45598   |----\n" +
                        " -----   |7929\n" +
                        " _60561\n" +
                        "  58626\n" +
                        "  -----\n" +
                        "  _19352\n" +
                        "   13028\n" +
                        "   -----\n" +
                        "   _63243\n" +
                        "    58626\n" +
                        "    -----\n" +
                        "      4617",
                formatter.format(new Result(51654123, 6514, 7929, 4617, subtrahendList, minuendList)));
    }
}
