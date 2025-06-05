package RealWorldApplications;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class SampleSelenium {
    public static void main(String[] args) {
        // Set path to your chromedriver executable
        //System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Launch Chrome
        WebDriver driver = new ChromeDriver();
        //String siteLink = "https://unacademy.com/course/comprehensive-course-on-polity-for-upsc-cse-gs-560/Q60SXGJY";
        String siteLink = "https://unacademy.com/course/comprehensive-course-on-polity-for-upsc-cse-gs-888/9K3PJXW0";


        try {
            // Open the Unacademy course page
            driver.get(siteLink);
            driver.manage().window().fullscreen();

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int ch;
            //Manual Login & Enter wishlist & Select Books as wishlist
            while (true) {
                System.out.println("Press 1 to continue: ");
                ch = Integer.parseInt(br.readLine());
                if (ch == 1) break;
                else
                    Thread.sleep(4000);

            }
            System.out.println("Login Successful");

            JavascriptExecutor js = (JavascriptExecutor) driver;
            long lastHeight = (long) js.executeScript("return document.body.scrollHeight");

            while (true) {
                js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
                Thread.sleep(2000); // wait for new content to load

                long newHeight = (long) js.executeScript("return document.body.scrollHeight");
                if (newHeight == lastHeight) {
                    break; // end of page reached
                }
                lastHeight = newHeight;
            }
            // Optional: wait for elements to load if needed
            Thread.sleep(5000);  // Better to use WebDriverWait in production


            // XPath selector to match the elements
            String xpath = "//div[@class = 'itemContainer css-14vmtud-ItemContainer e1jho88x6']/div/div/div/h3";
            xpath = "//p[@class = 'css-1n0t4io-P2-CourseInfo e1jho88x0']";

            // Find all matching elements
            List<WebElement> elements = driver.findElements(By.xpath(xpath));

            // Print text of each matched element
            for (WebElement element : elements) {
                System.out.println(element.getText());
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
