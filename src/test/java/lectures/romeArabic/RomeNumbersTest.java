package lectures.romeArabic;

import lectures.romeArabic.RomeNumbers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

class RomeNumbersTest {
    //Test that roman number is translated into arabic
    @Test
    public void testThatRomanToArabicMethodWorksOk() {
        Map<String, Integer> testCases = new LinkedHashMap<>();
        testCases.put("I", 1);
        testCases.put("II", 2);
        testCases.put("III", 3);
        testCases.put("IV", 4);
        testCases.put("V", 5);
        testCases.put("VI", 6);
        testCases.put("VII", 7);
        testCases.put("VIII", 8);
        testCases.put("IX", 9);
        testCases.put("X", 10);
        testCases.put("XII", 12);
        testCases.put("LIII", 53);
        testCases.put("XCVIII", 98);
        testCases.put("CLI", 151);
        testCases.put("CC", 200);
        testCases.put("MDCCC", 1800);
        testCases.put("MMIII", 2003);
        testCases.put("MCMXCVII", 1997);

        testCases.forEach((String rome, Integer expectedArabic) -> Assertions.assertEquals(expectedArabic, new RomeNumbers().romanToArabic(rome), rome));
    }

    @Test
    public void testThatArabicToRomanMethodWorksOk() {
        Map<Integer, String> testCases = new LinkedHashMap<>();
        testCases.put(1, "I");
        testCases.put(2, "II");
        testCases.put(3, "III");
        testCases.put(4, "IV");
        testCases.put(5, "V");
        testCases.put(6, "VI");
        testCases.put(7, "VII");
        testCases.put(8, "VIII");
        testCases.put(9, "IX");
        testCases.put(10, "X");
        testCases.put(12, "XII");
        testCases.put(53, "LIII");
        testCases.put(98, "XCVIII");
        testCases.put(151, "CLI");
        testCases.put(200, "CC");
        testCases.put(1800, "MDCCC");
        testCases.put(2003, "MMIII");
        testCases.put(1997, "MCMXCVII");

        testCases.forEach((Integer arabic, String expectedRome) -> Assertions.assertEquals(expectedRome, new RomeNumbers().arabicToRoman(arabic), Integer.toString(arabic)));
    }

    @Test
    public void testThatCalculateMethodWorksOk() {
        Map<String, String> testCases = new HashMap<>();
        testCases.put("III+IV", "VII");
        testCases.put("II+II", "IV");
        testCases.put("XIII+XCIX", "CXII");
        testCases.put("MDC+CCXXXIII", "MDCCCXXXIII");
        testCases.put("MDCCCXXXIII+CLXVI", "MCMXCIX");
        testCases.put("MCMXCIX+I", "MM");
        testCases.put("LXXX+X", "XC");

        testCases.forEach((expression, expected) -> Assertions.assertEquals(expected, new RomeNumbers().calculate(expression), expression));
    }

    @Test
    public void testThatIllegalArgumentExceptionThrownForInvalidInput() {
        int[] invalidInput = {0, 4001};

        for (int input : invalidInput) {
            Assertions.assertThrows(IllegalArgumentException.class, ()-> new RomeNumbers().arabicToRoman(input));
        }
    }
}