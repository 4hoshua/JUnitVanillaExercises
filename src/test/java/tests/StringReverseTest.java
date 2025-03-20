package tests;

import entities.StringReverse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import static entities.StringReverse.reverse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringReverseTest {


    public void stringShouldBeReversed () {

        String s = "Teste";
        String result = reverse(s);

        Assertions.assertEquals("etseT", result);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, -3, 15, Integer.MAX_VALUE}) // six numbers
    void isOdd_ShouldReturnTrueForOddNumbers(int number) {
        assertTrue(StringReverse.Numbers.isOdd(number));
    }
}
