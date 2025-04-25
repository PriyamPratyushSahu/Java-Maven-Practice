package practice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class ExtractElements {
    public static void main(String[] args) {
        // Set the path to your chromedriver executable
       // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Create a new instance of the Chrome driver
        WebDriver driver = new ChromeDriver();

        // Navigate to the webpage
        driver.get("https://parchamclasses.in/ip/");

        // Find all elements starting with "INR 10.00"
        List<WebElement> elements = driver.findElements(By.xpath("//*[starts-with(text(),'INR 10.00')]"));

        // Print the text of each matching element
        for (WebElement element : elements) {
            String str = element.getText();
            //str = str.replace("INR 10.00 - ","");
            String stringToReplace = "INR 10.00 – ";

            // Replacement string
            String replacementString = "";
            System.out.println(str.replace(stringToReplace, replacementString));
        }
        String originalString = "INR 10.00 – Schedule of Indian Constitution";

        // String to be replaced
        String stringToReplace = "INR 10.00 – ";

        // Replacement string
        String replacementString = "";

        // Perform the replacement
        String modifiedString = originalString.replace(stringToReplace, replacementString);

        // Print the modified string
        System.out.println("shdaskjhagsdjh" + modifiedString);

        // Close the browser
        driver.quit();
    }
}
