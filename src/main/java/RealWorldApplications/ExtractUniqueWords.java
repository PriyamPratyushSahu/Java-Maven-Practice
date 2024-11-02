package RealWorldApplications;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class ExtractUniqueWords {
    public static void main(String[] args) {
        // Step 1: Create a single string with all items separated by commas
        String allItems = "Flat Rent\n" +
                "Term Life Insurance\n" +
                "Apple iPad EMI bill\n" +
                "Multi Asset Fund SIP\n" +
                "Large Cap SIP\n" +
                "Debt Fund SIP\n";

        // Step 2: Split the string into an array
        String[] allItemsArray = allItems.split("\n");

        // Step 3: Use a TreeSet to store unique items and sort them in ascending order
        Set<String> uniqueItems = new TreeSet<>(Arrays.asList(allItemsArray));

        // Step 4: Print the unique items in ascending order
        //System.out.println("Unique items in the expense list (sorted in ascending order):");
        for (String item : uniqueItems) {
            System.out.println(item);
        }
    }
}
