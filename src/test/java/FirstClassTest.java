import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FirstClassTest {
    private String[] array;
    private String expected;

    public FirstClassTest(String[] array, String expected) {
        this.array = array;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection setArray() {
        return Arrays.asList(new Object[][]{
                {new String[]{"qwe", "wqe", "qwee", "a", "a"}, "a = [3, 4] eqw = [0, 1] "},
                {new String[]{}, ""},
                {new String[]{"wee"}, ""},
                {new String[]{"a", "a", "a", "a", "a"}, "a = [0, 1, 2, 3, 4] "},
                {new String[]{"QQ", "Q", "QQ", "Q"}, "QQ = [0, 2] Q = [1, 3] "}
        });
    }

    @Test
    public void parameterizedTest() {
        assertEquals(FirstClass.getPseudoSameWordsPositions(array), expected);
    }
}
