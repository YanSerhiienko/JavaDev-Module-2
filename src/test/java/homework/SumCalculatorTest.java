package homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumCalculatorTest {
    SumCalculator sumCalculator;

    @BeforeEach
    public void beforeEach() {
        sumCalculator = new SumCalculator();
    }

    @Test
    public void testThatSumWorksForOne() {
        Assertions.assertEquals(1, sumCalculator.sum(1));
    }

    @Test
    public void testThatSumWorksForSix() {
        Assertions.assertEquals(21, sumCalculator.sum(6));
    }

    @Test
    public void testThatIllegalArgumentExceptionThrownAtInvalidValue() {
        int[] invalidValues = {-1, 0};
        for (int invalidValue : invalidValues) {
            Assertions.assertThrows(IllegalArgumentException.class, () -> sumCalculator.sum(invalidValue));
        }
    }

}