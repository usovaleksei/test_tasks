package nbki;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TaskOneTest {

    @Test
    public void whenInputStringTrueReturnNewString() {
        String testString = "Test string";
        String result = TaskOne.replaceChar(testString, 'e', 'Q');
        String expected = "TQst string";
        assertThat(expected, is(result));
    }

    @Test(expected = RuntimeException.class)
    public void whenInputStringNullReturnException() {
        TaskOne.replaceChar(null, 'e', 'Q');
    }

    @Test
    public void whenInputstringIsEmptyReturnInputstring() {
        String emptyString = "";
        String result = TaskOne.replaceChar(emptyString, 'e', 'Q');
        String expected = "";
        assertThat(expected, is(result));
    }
}
