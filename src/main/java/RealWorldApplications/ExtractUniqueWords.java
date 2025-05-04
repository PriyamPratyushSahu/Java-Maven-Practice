package RealWorldApplications;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class ExtractUniqueWords {
    public static void main(String[] args) {
        // Step 1: Create a single string with all items separated by commas
        String allItems = "";

        // Step 2: Split the string into an array
        String[] allItemsArray = allItems.split("\n");

        // Step 3: Use a TreeSet to store unique items and sort them in ascending order
        Set<String> uniqueItems = new TreeSet<>(Arrays.asList(allItemsArray));

        uniqueItems.remove("Item");                                 //0
        uniqueItems.remove("House Rent");                           //1
        uniqueItems.remove("Travel Fare Office");                   //2
        uniqueItems.remove("Travel Fare Others");                   //3
        uniqueItems.remove("Term Life Insurance");                  //4
        uniqueItems.remove("Quant Multi Asset Fund Direct Growth"); //5
        uniqueItems.remove("Canara Robeco Bluechip Equity Fund");   //6
        uniqueItems.remove("ICICI Prudential Equity & Debt Fund");  //7
        uniqueItems.remove("Grocery_Monthly");                      //8


        // Step 4: Print the unique items in ascending order
        //System.out.println("Unique items in the expense list (sorted in ascending order):");
        for (String item : uniqueItems) {
            System.out.println(item);
        }
    }
}
