package seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.time.LocalTime;
import java.util.Set;

public class _1_WebDriverMethods {
    void methodWaitRequest(int timeSecond) {
        System.out.println("Wait request: " + timeSecond);
        LocalTime startTime = LocalTime.now();
        LocalTime endTime = startTime.plusSeconds(timeSecond);
        do {
            // Do nothing, just wait
        } while (LocalTime.now().isBefore(endTime));
    }

    public static void main(String[] args) throws InterruptedException {
        _1_WebDriverMethods WM = new _1_WebDriverMethods();

        String chromeDriverPath = System.getProperty("user.dir") + File.separator + "resources" + File.separator + "ChromeDriver" + File.separator + "chromedriver.exe";
        System.out.println(chromeDriverPath);

        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.flipkart.com");
        driver.manage().window().maximize();
        System.out.println("System: " + System.getProperty("user.dir"));
        System.out.println("Title: " + driver.getTitle());
        System.out.println("URL: " + driver.getCurrentUrl());
        //System.out.println("Page Source: "+ driver.getPageSource());

        WebElement button1 = driver.findElement(By.xpath("//*[contains(text(),\"Cart\")]"));
        button1.click();

        WebElement button2 = driver.findElement(By.xpath("//*[contains(text(),\"Login\")]"));
        button2.click();
        WM.methodWaitRequest(4);
        driver.navigate().back();
        WM.methodWaitRequest(4);
        driver.navigate().forward();
        WM.methodWaitRequest(4);
        driver.navigate().refresh();

        ((JavascriptExecutor) driver).executeScript("window.open()");


        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println(windowHandles);
        for(String getWIndowsHandle: windowHandles){
            driver.switchTo().window(getWIndowsHandle);
            //break;
        }
        driver.get("https://www.amazon.in/");

        WM.methodWaitRequest(5);
        driver.quit();

    }

}
