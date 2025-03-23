package tests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import java.util.HashMap;

public class HashMapTest {

    private HashMap<Integer, String> map;
    Integer keys;
    String  value;

    @BeforeEach
    public void setUp() {
        map = new HashMap<>();
    }

    //an object stored with the put() method can be retrieved with the get() method

    @ParameterizedTest
    @CsvSource({
            "1, Rato, Rato",
            "2, Gato, Gato",
            "3, Pato, Pato"
    })
    public void objectStoredWithPutShouldBeRetrievedWithGet (Integer keys, String value, String expected) {
        map.put(keys, value);
        Assertions.assertEquals(expected, map.get(keys));
    }

    //adding a second object with the same key results in the old value being replaced

    @ParameterizedTest
    @CsvSource({
            "1, Tigre, Vaca, Vaca",
            "2, Baleia, Peixe, Peixe",
            "3, Tartaruga, Coelho, Coelho"
    })
    public void objectStoredWithSameKeyReplaceOldValue (Integer keys, String value, String newValue, String expected) {
            map.put(keys, value);
            map.put(keys, newValue);
            Assertions.assertEquals(expected, map.get(keys));
    }

    //the clear() method removes all its content

    @ParameterizedTest
    @CsvSource({
            "1, Tigre, true",
            "2, Baleia, true",
            "3, Coelho, true"
    })
    public void clearShouldRemoveAllContent (Integer keys, String value, Boolean expected) {
        map.put(keys, value);
        map.clear();
        Assertions.assertEquals(expected, map.isEmpty());
    }

    //the null value can be used as a key

    @ParameterizedTest
    @CsvSource({
            ", 5 ,",
            ", 6 ,",
            ", 8 ,"
    })
    public void nullShouldBeUsedAsAKey (Integer keys, String value, Integer expected) {
        map.put(keys, value);
        Assertions.assertEquals(expected, map.keySet().toArray()[0]);
    }


}
