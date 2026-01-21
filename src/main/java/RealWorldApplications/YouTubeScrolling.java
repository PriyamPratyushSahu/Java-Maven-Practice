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
        String YouTubeLink = "";

        driver = new ChromeDriver();
        driver.get(YouTubeLink);
        driver.manage().window().maximize();
        YouTubeScrolling ew = new YouTubeScrolling();
        ew.loginAndScrollToEnd();
        System.out.println("OK");
    }

}



/*
Hi Navya,

As discussed earlier, it was planned that I would return to Bangalore in the first week of January 2026.
However, due to my root canal treatment, I had to extend my stay for the next 20 days. As a result, I will report to the office in the last week of January.

To meet the BTO compliance and as per BTO rules, I had already reported 4 days in the Bhubaneswar location, took 4 planned leaves, and was planning to report the remaining 4 days in the Bangalore location.

        But recently, with the new BTO guidelines effective from January onwards, only base location swipe in/out is being considered, and no leaves are counted in the BTO calculation. Therefore, as per the new guidelines, my total count will be 4 days, which I will complete from the Bangalore location in the last week of January.

Because of my medical condition, I will not be able to report to the office for 12 days in person in the Bangalore location.

Please consider my situation and look into it.
I have attached my medical prescription along with the payment proof below.

Thanks & regards,
Priyam Pratyush Sahu
Email: [priyam_pratyush.sahu@capgemini.com](mailto:priyam_pratyush.sahu@capgemini.com)
Contact No: +91 7205616033
Location: EPIP, Bangalore

*/
