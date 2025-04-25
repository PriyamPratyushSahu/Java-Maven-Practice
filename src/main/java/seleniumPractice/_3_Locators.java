package seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.time.LocalTime;
import java.util.List;

public class _3_Locators {
    void methodWaitRequest(int timeSecond) {
        System.out.println("Wait request: " + timeSecond);
        LocalTime startTime = LocalTime.now();
        LocalTime endTime = startTime.plusSeconds(timeSecond);
        do {
            // Do nothing, just wait
        } while (LocalTime.now().isBefore(endTime));
    }

    public static void main(String[] args) throws InterruptedException {


        //String chromeDriverPath = System.getProperty("user.dir") + File.separator + "resources" + File.separator + "ChromeDriver" + File.separator + "chromedriver.exe";
        //System.out.println(chromeDriverPath);

        String site = System.getProperty("user.dir") + File.separator + "resources" + File.separator + "HTML" + File.separator + "ListOfGroceries.html";
        // System.out.printf(site);
        //System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        WebDriver driver = new ChromeDriver();
        driver.get(site);
        driver.manage().window().maximize();
        // System.out.println("System: " + System.getProperty("user.dir"));
        _3_Locators ll = new _3_Locators();
        ll.methodWaitRequest(2);


//        1. child
// To display fruits name from the list of fruits
        System.out.println("1. child");
        List<WebElement> fruits = driver.findElements(By.xpath("//*[@type=\"Fruits\"]//child::li"));
        System.out.println("Total number of fruits: " + fruits.size());
        for (WebElement i : fruits)
            System.out.println(i.getText());

//        2. parent
//        To display fruits heading
        System.out.println("\n2. parent");
        WebElement parentFruit = driver.findElement(By.xpath("//*[@type=\"Fruits\"]//child::li//parent::ul"));
        System.out.println(parentFruit.getAttribute("type"));
//        3. descendant
//        4. ancestor
//        5. following-sibling
        // To display fruits name from the list of fruits
        System.out.println("5. following-sibling");
        fruits = driver.findElements(By.xpath("//*[contains(text(),\"Apple\")]//following-sibling::li"));
        System.out.println("Fruits following sibilings: " + fruits.size());
        for (WebElement i : fruits)
            System.out.println(i.getText());
//        6. preceding-sibling
        System.out.println("6. preceding-sibling");
        fruits = driver.findElements(By.xpath("//*[contains(text(),\"Watermelon\")]//preceding-sibling::li"));
        System.out.println("Fruits preceding sibilings: " + fruits.size());
        for (WebElement i : fruits)
            System.out.println(i.getText());

        driver.quit();

    }

}
