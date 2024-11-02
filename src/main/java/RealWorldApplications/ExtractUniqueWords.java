package RealWorldApplications;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ExtractUniqueWords {
    public static void main(String[] args) {
        // Step 1: Create a single string with all items separated by commas
        String allItems = "Flat Rent\n" +
                "Term Life Insurance\n" +
                "Apple iPad EMI bill\n" +
                "Multi Asset Fund SIP\n" +
                "Large Cap SIP\n" +
                "Debt Fund SIP\n" +
                "Monthly Grocery\n" +
                "Monthly Grocery\n" +
                "Homecoming expenditure\n" +
                "Jockey Underwear's(Pack of 2)\n" +
                "Jockey Boxer Shorts(Pack of 2)\n" +
                "Jockey Vest(Pack of 2)\n" +
                "Louis Philips Shirt\n" +
                "Louis Philips Shirt\n" +
                "Bus Fare Other\n" +
                "Bus Fare Other\n" +
                "Books\n" +
                "Outside food\n" +
                "Milk\n";

        // Step 2: Split the string into an array
        String[] allItemsArray = allItems.split("\n");

        // Step 3: Use a HashSet to store unique items
        Set<String> uniqueItems = new HashSet<>(Arrays.asList(allItemsArray));

        // Step 4: Print the unique items
        System.out.println("Unique items in the expense list:");
        for (String item : uniqueItems) {
            System.out.println(item);
        }
    }
}
