package practice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class ExtractElementsFromSite {
    public static void main(String[] args) throws IOException {
        // Set path to chromedriver (update path if needed)
        WebDriver driver;
        driver = new ChromeDriver();
        driver.manage().window().maximize();



        // Open your target URL
        String site = "";
        driver.get(site);//
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ch;
        //Manual Login
        while (true) {
            System.out.println("Press 1 to continue: ");
            ch = Integer.parseInt(br.readLine());
            if (ch == 1) break;


        }
        System.out.println("Login Successful");

        // Find all elements with the given class
        List<WebElement> lessons = driver.findElements(
                By.cssSelector(".css-k6can1-H6-LessonName.e1jho88x11")
        );

        // Print text of each element
        for (WebElement lesson : lessons) {
            System.out.println(lesson.getText());
        }

        driver.quit();
    }
}

