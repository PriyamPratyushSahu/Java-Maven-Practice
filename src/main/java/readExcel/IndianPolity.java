package readExcel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class IndianPolity {
    private static final Logger logger = LoggerFactory.getLogger(IndianPolity.class);
    public static void main(String[] args) {
        String filePath = "D:" + File.separator +"Documents" + File.separator + "IAS Notes" + File.separator + "Self Notes" + File.separator + "Indian Polity Book content.xlsx";
        File file =  new File(filePath);
        //System.out.println(filePath);
        if(file.exists())
        readExcel(filePath);
        else
            System.out.println("File not found");
    }

    private static void readExcel(String filePath) {
        try (FileInputStream fileInputStream = new FileInputStream(new File(filePath));
             Workbook workbook = new XSSFWorkbook(fileInputStream)) {

            Sheet sheet = workbook.getSheetAt(0); // Assuming you want to read the first sheet

            for (Row row : sheet) {
                for (Cell cell : row) {
                    switch (cell.getCellType()) {
                        case STRING:
                            System.out.print(cell.getStringCellValue() + "\t");
                            break;
                        case NUMERIC:
                            System.out.print(cell.getNumericCellValue() + "\t");
                            break;
                        case BOOLEAN:
                            System.out.print(cell.getBooleanCellValue() + "\t");
                            break;
                        case BLANK:
                            System.out.print("BLANK\t");
                            break;
                        default:
                            System.out.print("UNKNOWN\t");
                    }
                }
                System.out.println(); // Move to the next row
            }

        } catch (IOException e) {
            logger.error("Error reading Excel file: {}", e.getMessage(), e);
        }
    }

}
