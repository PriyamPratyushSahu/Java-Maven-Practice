package seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.time.LocalTime;

public class _2_WebElementMethods {
    void methodWaitRequest(int timeSecond) {
        System.out.println("Wait request: " + timeSecond);
        LocalTime startTime = LocalTime.now();
        LocalTime endTime = startTime.plusSeconds(timeSecond);
        do {
            // Do nothing, just wait
        } while (LocalTime.now().isBefore(endTime));
    }

    public static void main(String[] args) throws InterruptedException {
        _2_WebElementMethods WM = new _2_WebElementMethods();

        //String chromeDriverPath = System.getProperty("user.dir") + File.separator + "resources" + File.separator + "ChromeDriver" + File.separator + "chromedriver.exe";
        //System.out.println(chromeDriverPath);

       // System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.flipkart.com");
        driver.manage().window().maximize();
        System.out.println("System: " + System.getProperty("user.dir"));

        WebElement button1 = driver.findElement(By.xpath("//*[contains(text(),\"Cart\")]"));
        System.out.println("Button is Displayed: " + button1.isDisplayed());
        Actions aa = new Actions(driver);
        aa.contextClick(button1).perform();
        WM.methodWaitRequest(5);

        driver.quit();

    }

}
