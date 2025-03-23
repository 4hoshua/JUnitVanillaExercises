package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import static entities.StringReverse.reverse;

public class StringReverseTest {

    @ParameterizedTest
    @CsvSource({
        "Teste, etseT",
        "Gato, otaG",
        "Pato, otaP"
    })
    public void StringShouldBeReversed (String s, String expectedValues) {
        String result = reverse(s);

        Assertions.assertEquals(expectedValues, result);

    }

    //String com um valor ou string com valor único

    @ParameterizedTest
    @ValueSource(strings = {"a", "d", "s", "c"})
    public void StringShouldThrowIAEForOneCharacter (String s) {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
           reverse(s);
        });
    }

    @Test
    public void StringShouldThrowIAEForNullCharacter () {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            String s = "";
            reverse(s);
        });
    }
}
