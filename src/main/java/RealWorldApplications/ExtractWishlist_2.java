
package RealWorldApplications;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.*;
import java.time.LocalTime;
import java.util.List;

public class ExtractWishlist_2 {
    void methodWaitRequest(int timeSecond) {
        System.out.println("Wait request: " + timeSecond);
        LocalTime startTime = LocalTime.now();
        LocalTime endTime = startTime.plusSeconds(timeSecond);
        do {
            // Do nothing, just wait
        } while (LocalTime.now().isBefore(endTime));
    }

    public static void main(String[] args) throws InterruptedException, IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //String chromeDriverPath = System.getProperty("user.dir") + File.separator + "resources" + File.separator + "ChromeDriver" + File.separator + "chromedriver.exe";
        //System.out.println(chromeDriverPath);
        String excelPath = System.getProperty("user.dir") + File.separator + "resources" + File.separator + "BookList.xlsx";

        //System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        // System.out.println("System: " + System.getProperty("user.dir"));
        ExtractWishlist_2 ew = new ExtractWishlist_2();
        int ch;
        //Manual Login & Enter wishlist & Select Books as wishlist
        while (true) {
            System.out.println("Press 1 to continue: ");
            ch = Integer.parseInt(br.readLine());
            if (ch == 1) break;
            else ew.methodWaitRequest(30);

        }
        System.out.println("Login Successful");

        // Initialize JavaScript Executor
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Variables to keep track of the current scroll height and the new scroll height
        long lastHeight = (long) js.executeScript("return document.body.scrollHeight");

        while (true) {
            // Scroll down to the bottom of the page
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

            // Wait for the page to load
            try {
                Thread.sleep(2000); // you can adjust the sleep time as needed
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Calculate the new scroll height and compare it with the last scroll height
            long newHeight = (long) js.executeScript("return document.body.scrollHeight");

            // Break the loop if the scroll height has not changed
            if (newHeight == lastHeight) {
                break;
            }

            lastHeight = newHeight;
        }

        // Perform any other actions needed after scrolling is complete
        System.out.println("Reached the end of the page!");

        List<WebElement>  priceElement = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
        List<WebElement> bookListTitle = driver.findElements(By.xpath("//*[@data-id='H15GSZNFJH64']//a[@title]"));
        int listSize = bookListTitle.size() / 2;
        System.out.println("List Size: " + listSize);
        float totalPrice = 0;

        for (int i = 1; i <= listSize; i++) {


            // Wait for the new tab to open
            try {
                Thread.sleep(2000); // you can adjust the sleep time as needed
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Use XPath to find the span element


            // Get the text content of the span element
            String priceText = priceElement.get(i).getText();

            // Remove the currency symbol (₹)
            String priceWithoutCurrency = priceText.replace("₹", "").replace(",", "").trim();
            //System.out.println(priceText +": "+ priceWithoutCurrency);

            // Convert the string to a floating-point number
            float price = Float.parseFloat(priceWithoutCurrency);

            // Print the floating-point number
            System.out.println(i + " . " + price);
            totalPrice += price;
            /*if(i == 5)
                break;*/
        }
        System.out.println("Total Price: " + totalPrice);


        driver.quit();

    }
}

