package nbki;

/**
 * Class for transform string to int, double
 *
 * @author Aleksei Usov
 * @since 27/11/2021
 */

public class TaskTwo {

    /**
     * Method to transform string to int value
     *
     * @param inputString - string for transforming
     * @return - int value
     */
    public static int stringToInt(String inputString) {
        int result = 0;
        int exp = 1;
        int firstChar = 0;
        boolean isNegative = false;

        if (inputString == null || inputString.isEmpty()) {
            throw new NumberFormatException("Null or empty");
        }

        if (inputString.charAt(0) == '-') {
            isNegative = true;
            firstChar = 1;
        }

        for (int i = inputString.length() - 1; i >= firstChar; i--) {
            char curChar = inputString.charAt(i);

            if (curChar < 48 || curChar > 57) {
                throw new NumberFormatException("Not number format");
            }
            result += (curChar - '0') * exp;
            exp *= 10;
        }

        return isNegative ? -result : result;
    }

    /**
     * Method to transform string to double value
     *
     * @param inputString - string for transforming
     * @return - double value
     */
    public static double stringToDouble(String inputString) {
        double result = 0;
        double numberBeforeDot = 0;
        int dotIndex = inputString.indexOf('.');
        boolean isNegative = false;
        String tempString;
        int firstChar = 0;

        if (inputString.isEmpty()) {
            throw new NumberFormatException("Null or empty");
        }

        if (dotIndex != -1) {
            tempString = inputString.substring(0, dotIndex);
            for (int i = inputString.length() - 1; i >= dotIndex + 1; i--) {
                numberBeforeDot = (numberBeforeDot + inputString.charAt(i) - '0') / 10;
            }
        } else {
            tempString = inputString;
        }

        if (tempString.charAt(0) == '-') {
            isNegative = true;
            firstChar++;
        } else if (tempString.charAt(0) == '+') {
            firstChar++;
        }

        for (int i = firstChar; i < tempString.length(); i++) {
            if (tempString.charAt(i) == ',') {
                continue;
            }
            result *= 10;
            result += tempString.charAt(i) - '0';
        }

        result = result + numberBeforeDot;
        if (isNegative) {
            result = -1 * result;
        }
        return result;
    }
}
