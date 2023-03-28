package lectures.math;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExpressionParserTest {
    private ExpressionParser parser;

    @BeforeEach
    public void beforeEach() {
        parser = new ExpressionParser();
    }

    private void test(String expression, int expectedA, int expectedB, Expression.Operator expectedOperator) {
        Expression actual = parser.parse(expression);

        Expression expected = Expression
                .builder()
                .a(expectedA)
                .b(expectedB)
                .operator(expectedOperator)
                .build();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test3plus5() {
        test("3+5", 3, 5, Expression.Operator.plus);
    }

    @Test
    public void testMinus2Minus4() {
        test("-2-4", -2, 4, Expression.Operator.minus);
    }

    @Test
    public void testFourMultiplyMinusFIve() {
        test("4*-5", 4, -5, Expression.Operator.multiply);
    }

    @Test
    public void testMinus7DivideMinus4() {
        test("-7/-4", -7, -4, Expression.Operator.divide);
    }

    @Test
    public void testMinus5MinusMinus4() {
        test("-5--4", -5, -4, Expression.Operator.minus);
    }

    @Test
    public void testThatWhiteSpacesIgnored() {
        test("  5  -  3 \t\n", 5, 3, Expression.Operator.minus);
    }

    @Test
    public void testThatInvalidInputCorrectlyHandled() {
        String[] invalidInputs = {null,
                "",
                " ",
                "7",
                "5+",
                "8-aaa",
                "2 4",
                "/",
                "-",
                 "1---9"
        };

        for (String invalidInput : invalidInputs) {
            Assertions.assertThrows(IllegalArgumentException.class, () -> parser.parse(invalidInput), invalidInput);
        }
    }
}