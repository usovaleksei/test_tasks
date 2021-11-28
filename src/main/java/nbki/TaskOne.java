package nbki;

/**
 * Class to replace symbol in string
 * @author Aleksei Usov
 * @since 27/11/2021
 */
public class TaskOne {

    /**
     * method to replace symbol in string
     * @param inputString - string for searching and replacing
     * @param oldChar - replaceable symbol
     * @param newChar - replaced symbol
     * @return - new string with replaced symbol
     * @exception RuntimeException - if input string is null
     */
    public static String replaceChar(String inputString, char oldChar, char newChar) {
        if (inputString == null) {
            throw new RuntimeException("Input string can not be null");
        }
        if (inputString.isEmpty() || oldChar == newChar) {
            return inputString;
        }
        char[] inputArray = inputString.toCharArray();
        for (int i = 0; i < inputArray.length; i++) {
            if (inputString.charAt(i) == oldChar) {
                inputArray[i] = newChar;
            }
        }
        return new String(inputArray);
    }
}
