//To extract the book name, url & price from site and save them in the Excel

package RealWorldApplications;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.time.LocalDateTime;
import java.time.Duration;

public class ExtractWishlistRobust {

    static WebDriver driver;
    static String excelPath;
    static String originalWindow;
    static List<WebElement> bookListTitle;
    //List<WebElement>  priceElement = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
    static List<WebElement> priceElement;
    static int listSize;
    static String[][] newData;
    static int totalPrice;

    void methodWaitRequest(int timeSecond) {
        System.out.println("Wait request: " + timeSecond);
        LocalTime startTime = LocalTime.now();
        LocalTime endTime = startTime.plusSeconds(timeSecond);
        do {
            // Do nothing, just wait
        } while (LocalTime.now().isBefore(endTime));
    }

    void loginAndScrollToEnd() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ch;
        //Manual Login & Enter wishlist & Select Books as wishlist
        while (true) {
            System.out.println("Press 1 to continue: ");
            ch = Integer.parseInt(br.readLine());
            if (ch == 1) break;
            else methodWaitRequest(30);

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
        System.out.println("Reached the end of the page!");
    }

    void extractInfo() {
        bookListTitle = driver.findElements(By.xpath("//*[@data-id='H15GSZNFJH64']//a[@title]"));
        //List<WebElement>  priceElement = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
        priceElement = driver.findElements(By.cssSelector("li[data-id='H15GSZNFJH64']"));
        //WebElement element = driver.findElement(By.cssSelector("li[data-id='H15GSZNFJH64']"));
        //String priceString = element.getAttribute("data-price");
        //float price = Float.parseFloat(priceString);


        //Extract Wishlist

        listSize = bookListTitle.size();
        System.out.println("List Size: " + listSize / 2);
        System.out.println("Price count: " + priceElement.size());
        newData = new String[listSize / 2][4];
        totalPrice = 0;

        for (int i = 1, j = 0; i <= listSize; i += 2, j++) {
            String priceText = priceElement.get(j).getAttribute("data-price");
            float priceFloat = Float.parseFloat(priceText);  // Convert to float first
            // Remove the currency symbol (₹) & (,)
            //String priceWithoutCurrency = priceText.replace("₹", "").replace(",", "").trim();
            //System.out.println(priceText +": "+ priceWithoutCurrency);

            // Convert the string to a floating-point number
            int price = (int) priceFloat;
            price = (price < 0) ? 101 : price;
            System.out.println(j + 1 + ". " + bookListTitle.get(i).getAttribute("title") + " : ₹ " + price);
            totalPrice += price;


            newData[j][0] = String.valueOf(j + 1);
            newData[j][1] = bookListTitle.get(i).getAttribute("title");
            newData[j][2] = switchWindowExtractURL(i);
            newData[j][3] = "₹ " + price;


        }
    }

    String switchWindowExtractURL(int i) {
        Actions actions = new Actions(driver);
        String str;

        // Perform a Control+Click (or Command+Click on Mac) on the link to open it in a new tab
        actions.keyDown(Keys.CONTROL).click(bookListTitle.get(i)).keyUp(Keys.CONTROL).build().perform();
        // Wait for the new tab to open
        try {
            Thread.sleep(2000); // you can adjust the sleep time as needed
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Loop through until we find a new window handle
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        // Display the URL of the new window
        System.out.println("New window URL: " + driver.getCurrentUrl());
        str = driver.getCurrentUrl();
        // Close the new window
        driver.close();

        // Switch back to the original window
        driver.switchTo().window(originalWindow);
        return str;
    }

    void writeInWorkbook() {
        // Load the existing workbook
        Workbook workbook = null;
        FileInputStream inputStream = null;
        // Get today's date in DD-MMM-YYYY format
        String datePattern = "dd-MMM-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(datePattern);
        String sheetName = simpleDateFormat.format(new Date());
        try {
            inputStream = new FileInputStream(excelPath);
            workbook = new XSSFWorkbook(inputStream);

            // Get the sheet (assuming it's named "Books", change as per your sheet name)
            Sheet sheet = workbook.createSheet(sheetName);

            // If sheet doesn't exist, create a new one
            if (sheet == null) {
                sheet = workbook.createSheet("Books");
                // Create headers if the sheet is newly created
                String[] headers = {"Sl.no", "Book", "Url", "Price"};
                Row headerRow = sheet.createRow(0);
                for (int i = 0; i < headers.length; i++) {
                    Cell cell = headerRow.createCell(i);
                    cell.setCellValue(headers[i]);
                }
            }

            // Example data to append (you can replace with your logic to fetch data)

            // Append new data to the end of the sheet
            int lastRowNum = sheet.getLastRowNum();
            for (String[] rowData : newData) {
                Row row = sheet.createRow(++lastRowNum);
                int colNum = 0;
                for (String field : rowData) {
                    Cell cell = row.createCell(colNum++);
                    cell.setCellValue(field);
                    // No need for additional type checks since field is already String
                }
            }

            // Write workbook to file
            try (FileOutputStream outputStream = new FileOutputStream(excelPath)) {
                workbook.write(outputStream);
                System.out.println("Excel file has been updated successfully.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Close workbook
            if (workbook != null) {
                try {
                    workbook.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public static void main(String[] args) throws InterruptedException, IOException {


        //String chromeDriverPath = System.getProperty("user.dir") + File.separator + "resources" + File.separator + "ChromeDriver" + File.separator + "chromedriver.exe";
        //System.out.println(chromeDriverPath);
        excelPath = System.getProperty("user.dir") + File.separator + "resources" + File.separator + "BookList.xlsx";

        //System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        driver = new ChromeDriver();
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        // System.out.println("System: " + System.getProperty("user.dir"));
        ExtractWishlistRobust ew = new ExtractWishlistRobust();
        originalWindow = driver.getWindowHandle();
        ew.loginAndScrollToEnd();
        LocalDateTime startTime = LocalDateTime.now();
        System.out.println("Start Time: " + startTime);
        ew.extractInfo();
        ew.writeInWorkbook();

        driver.quit();
        System.out.println("Total Price: ₹" + totalPrice);

        LocalDateTime endTime = LocalDateTime.now();
        System.out.println("End Time: " + endTime);
        Duration duration = Duration.between(startTime, endTime);
        long minuteDifference = duration.toMinutes();
        System.out.println("Minute Difference: " + minuteDifference + " minute(s)");

    }

}

