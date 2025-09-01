package RealWorldApplications;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


import java.io.IOException;
import java.time.LocalTime;

public class YouTubeScrolling {

    static WebDriver driver;

    void methodWaitRequest(int timeSecond) {
        System.out.println("Wait request: " + timeSecond);
        LocalTime startTime = LocalTime.now();
        LocalTime endTime = startTime.plusSeconds(timeSecond);
        do {
            // Do nothing, just wait
        } while (LocalTime.now().isBefore(endTime));
    }

    void loginAndScrollToEnd() throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int ch;
//        //Manual Login & Enter wishlist & Select Books as wishlist
//        while (true) {
//            System.out.println("Press 1 to continue: ");
//            ch = Integer.parseInt(br.readLine());
//            if (ch == 1) break;
//            else methodWaitRequest(30);
//
//        }
        System.out.println("Login Successful");
        methodWaitRequest(10);

        // Initialize JavaScript Executor
        JavascriptExecutor js = (JavascriptExecutor) driver;

// Use documentElement instead of body for better compatibility
        long lastHeight = (long) js.executeScript("return document.documentElement.scrollHeight");


        while (true) {
            // Scroll to the bottom
            js.executeScript("window.scrollTo(0, document.documentElement.scrollHeight);");


            // Wait for loading (increase if site loads slowly)
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            long newHeight = (long) js.executeScript("return document.documentElement.scrollHeight");


            if (newHeight == lastHeight) {
                break; // No more content
            }
            lastHeight = newHeight;
        }

        System.out.println("Reached the end of the page!1");
    }

    public static void main(String[] args) throws InterruptedException, IOException {

        //Paste the YouTube link here
        String YouTubeLink = "https://www.youtube.com/@PujyaRajanJee/streams";

        driver = new ChromeDriver();
        driver.get(YouTubeLink);
        driver.manage().window().maximize();
        YouTubeScrolling ew = new YouTubeScrolling();
        ew.loginAndScrollToEnd();
        System.out.println("OK");
    }

}
