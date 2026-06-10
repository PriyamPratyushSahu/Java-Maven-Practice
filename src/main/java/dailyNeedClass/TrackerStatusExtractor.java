package dailyNeedClass;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class TrackerStatusExtractor {

    public static void main(String[] args) {

        String folderPath = "D:\\Documents\\Habits\\2026\\Everyday Tracker";
        String fileName = "06_June Monthly Tracker.xlsx";
        String filePath = folderPath + File.separator + fileName;
        System.out.println(filePath);

        DataFormatter formatter = new DataFormatter();
        double sum = 0.0;
        int count = 0;
        Scanner sc = new Scanner(System.in);

        String[] categories = {"Sleep","Urgent","Studies","Optional","On Track","House hold work","Leisure","Work/Job"};
        System.out.println("Press" +
                "Press:\n" +
                "1. Sleep\n" +
                "2. Urgent\n" +
                "3. Studies\n" +
                "4. Optional\n" +
                "5. On Track\n" +
                "6. House hold work\n" +
                "7. Leisure\n" +
                "8. Work/Job");
        System.out.println("Enter your choice: ");

        int choice = sc.nextInt();
        sc.close();

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet("Weekly Status");

            String categoryType = categories[choice-1];
            System.out.println("Choice - "+categories[choice-1]+"\n\n");
            System.out.println("---- "+categoryType+" Status till now ----");

            for (int rowIndex = 0; rowIndex <= sheet.getLastRowNum(); rowIndex++) {

                Row row = sheet.getRow(rowIndex);

                Cell cell = row.getCell(0);

                if (cell != null
                        && cell.getCellType() == CellType.STRING
                        && categoryType.equalsIgnoreCase(cell.getStringCellValue())) {

                    String date = formatter.formatCellValue(sheet.getRow(rowIndex - choice).getCell(0));

                    String percentage = formatter.formatCellValue(sheet.getRow(rowIndex).getCell(1));
                    String status = formatter.formatCellValue(sheet.getRow(rowIndex).getCell(2));
                    if(percentage.trim().isEmpty())
                        break;
                    else {
                        System.out.println("Date : " + date);
                        double value = Double.parseDouble(percentage.replace("%", "").trim());
                        double hrs = (value * 0.48)/2;
                        hrs = Math.round(hrs * 2) / 2.0;
                        System.out.println(percentage+" ("+hrs+")hrs"+" - "+status);



                        sum += value;
                        count++;
                    }
                }
            }
            double average = sum/count;
            System.out.printf("\nAverage = %.2f%%%n", average);
            System.out.println("Hours per day - "+ Math.round((average * 0.48)/2));



        } catch (IOException e) {
            System.err.println("Error reading Excel file: " + e.getMessage());
        }
    }
}
