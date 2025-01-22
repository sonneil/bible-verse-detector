package utils;

import com.bibledetector.utils.NumberUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;

public class NumberUtilsTest {

    @Test
    public void testTextNumberToDigitsConversion() {
        for (String[] parameter : parameters()) {
            String original = parameter[0];
            String expected = parameter[1];
            String actual = NumberUtils.convertAllNumbersToDigits(parameter[0]);
            Assert.assertEquals(expected, actual);
        }
    }

    public static Collection<String[]> parameters() {
        return Arrays.asList(
                new String[] {null, ""},
                new String[] {"uno", "1"},
                new String[] {"dos", "2"},
                new String[] {"tres", "3"},
                new String[] {"este es un cuatro", "este es un 4"},
                new String[] {"y dijo que el ciento cuarenta y siete pasa por aca", "y dijo que el 147 pasa por aca"},
                new String[] {"cuarenta y cuatro? sí, el mismo", "44? sí, el mismo"},
                new String[] {"el veintidós? no lo conozco", "el 22? no lo conozco"},
                new String[] {"juan tres dieciseis", "juan 3 16"});
    }
}
