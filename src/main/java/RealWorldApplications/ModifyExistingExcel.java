package RealWorldApplications;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ModifyExistingExcel {
    public static void main(String[] args) {
        String excelPath = System.getProperty("user.dir") + File.separator + "resources" + File.separator + "BookList.xlsx";

        // Load the existing workbook
        Workbook workbook = null;
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(excelPath);
            workbook = new XSSFWorkbook(inputStream);

            // Get the sheet (assuming it's named "Books", change as per your sheet name)
            Sheet sheet = workbook.getSheet("Books");

            // If sheet doesn't exist, create a new one
            if (sheet == null) {
                sheet = workbook.createSheet("Books");
                // Create headers if the sheet is newly created
                String[] headers = {"Sl.no", "Book", "Url"};
                Row headerRow = sheet.createRow(0);
                for (int i = 0; i < headers.length; i++) {
                    Cell cell = headerRow.createCell(i);
                    cell.setCellValue(headers[i]);
                }
            }

            // Example data to append (you can replace with your logic to fetch data)
            Object[][] newData = {
                    {4, "Book 4", "https://www.example.com/book4"},
                    {5, "Book 5", "https://www.example.com/book5"}
            };

            // Append new data to the end of the sheet
            int lastRowNum = sheet.getLastRowNum();
            for (Object[] rowData : newData) {
                Row row = sheet.createRow(++lastRowNum);
                int colNum = 0;
                for (Object field : rowData) {
                    Cell cell = row.createCell(colNum++);
                    if (field instanceof String) {
                        cell.setCellValue((String) field);
                    } else if (field instanceof Integer) {
                        cell.setCellValue((Integer) field);
                    }
                    // Add additional conditions as needed for different data types
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
            // Close workbook and input stream
            if (workbook != null) {
                try {
                    workbook.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

