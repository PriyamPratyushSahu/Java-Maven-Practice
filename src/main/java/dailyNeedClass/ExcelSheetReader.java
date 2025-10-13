package dailyNeedClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelSheetReader {
    public static void main(String[] args) {
      String fileName = "D:\\Documents\\Habits\\Everyday Tracker\\10_October 2025 Tracker.xlsx";

        File file = new File(fileName);

        if (!file.exists()) {
            System.out.println("File not found. Please check the path or name.");
            return;
        }

        try (FileInputStream fis = new FileInputStream(file);
             Workbook workbook = WorkbookFactory.create(fis)) {

            int sheetCount = workbook.getNumberOfSheets();
            System.out.println("\nSheets present in the Excel file:");
            for (int i = 0; i < sheetCount; i++) {
                System.out.println((i + 1) + ". " + workbook.getSheetName(i));
            }

        } catch (IOException e) {
            System.out.println("Error reading the Excel file: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }
}
