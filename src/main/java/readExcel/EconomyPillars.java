package readExcel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EconomyPillars {

    public static void main(String[] args) {
        String filePath = "D:\\Documents\\IAS Notes\\Self Notes\\Economics\\Pillars.xlsx"; // Replace with your Excel file path
        String sheetName = "A-Z";                    // Replace with your sheet name
        int keyColumnIndex = 1;                         // Column B = 1
        int valueColumnIndex = 2;                       // Column C = 2

        Map<String, String> dataMap = new HashMap<>();

        try (FileInputStream fis = new FileInputStream(new File(filePath));
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                System.out.println("Sheet not found: " + sheetName);
                return;
            }

            for (Row row : sheet) {
                Cell keyCell = row.getCell(keyColumnIndex);
                Cell valueCell = row.getCell(valueColumnIndex);
                if (keyCell != null && valueCell != null) {
                    keyCell.setCellType(CellType.STRING);
                    valueCell.setCellType(CellType.STRING);
                    dataMap.put(keyCell.getStringCellValue(), valueCell.getStringCellValue());
                }
            }

        } catch (Exception e) {
            System.out.println("Error reading Excel file: " + e.getMessage());
            return;
        }

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nMenu:\n1 - Find Value (partial match)\n2 - Print Map\n0 - Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter text to search in keys: ");
                    String searchKey = scanner.nextLine().toLowerCase();
                    boolean found = false;

                    System.out.printf("%-20s %-20s\n", "KEY", "VALUE");
                    for (Map.Entry<String, String> entry : dataMap.entrySet()) {
                        if (entry.getKey().toLowerCase().contains(searchKey)) {
                            System.out.printf("%-20s %-20s\n", entry.getKey(), entry.getValue());
                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println("No matching keys found.");
                    }
                    break;

                case 2:
                    System.out.println("\nMap Contents:");
                    System.out.printf("%-20s %-20s\n", "KEY", "VALUE");
                    for (Map.Entry<String, String> entry : dataMap.entrySet()) {
                        System.out.printf("%-20s %-20s\n", entry.getKey(), entry.getValue());
                    }
                    break;

                case 0:
                    System.out.println("Exiting program.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);


        scanner.close();
    }
}
