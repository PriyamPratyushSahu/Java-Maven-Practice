package dailyNeedClass;

/**
 * This program takes a string and converts any uppercase letters in the string to lowercase.
 */
public class CapitalToSmallCase {

    public static void main(String[] args) {
        String ss  = "LIBERALIZATION, PRIVATIZATION AND GLOBALIZATION";

        // Convert the string to lowercase using the built-in toLowerCase() method
        String lowerCaseString = ss.toLowerCase();

        // Print the original string and the converted string
        //System.out.println("\nOriginal string: " + ss);
        System.out.println(lowerCaseString);
    }
}
