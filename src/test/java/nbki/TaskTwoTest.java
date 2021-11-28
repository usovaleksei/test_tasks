package nbki;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TaskTwoTest {
    @Test
    public void whenStringIsPositiveThenReturnPositiveInt() {
        String testString = "1458";
        int result = TaskTwo.stringToInt(testString);
        int expected = 1458;
        assertThat(expected, is(result));
    }

    @Test
    public void whenStringWithNegativeSymbolThenReturnNegativeInt() {
        String testString = "-148";
        int result = TaskTwo.stringToInt(testString);
        int expected = -148;
        assertThat(expected, is(result));
    }

    @Test(expected = NumberFormatException.class)
    public void whenInputStringIsEmptyThenNFException() {
        String testString = "";
        TaskTwo.stringToInt(testString);
    }

    @Test(expected = NumberFormatException.class)
    public void whenInputStringIsNullThenNFException() {
        TaskTwo.stringToInt(null);
    }

    @Test(expected = NumberFormatException.class)
    public void whenInputStringContainsNotIntValueThenReturnNFException() {
        String testString = "1a2";
        TaskTwo.stringToInt(testString);
    }

    @Test
    public void whenStringIsPositiveThenReturnPositiveDouble() {
        String testString = "12.54";
        double result = TaskTwo.stringToDouble(testString);
        double expected = 12.54;
        assertThat(expected, is(result));
    }

    @Test
    public void whenStringWithNegativeSymbolThenReturnNegativeDouble() {
        String testString = "-12.54";
        double result = TaskTwo.stringToDouble(testString);
        double expected = -12.54;
        assertThat(expected, is(result));
    }

    @Test(expected = NumberFormatException.class)
    public void whenInputStringDoubleIsEmptyThenNFException() {
        String testString = "";
        TaskTwo.stringToDouble(testString);
    }
}
