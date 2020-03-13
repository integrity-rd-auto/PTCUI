package TestUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {

	public static Object[][] excelData() throws IOException {

		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\TestData\\TestData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);

		XSSFSheet sheet = workbook.getSheet("Demo");

		XSSFRow Row = sheet.getRow(0);
		int noOfRows = sheet.getLastRowNum();

		int noOfCol = Row.getLastCellNum();

		Object Data[][] = new Object[noOfRows][noOfCol];

		for (int i = 0; i < noOfRows; i++) {
			for (int k = 0; k < noOfCol; k++) {

				Data[i][k] = sheet.getRow(i + 1).getCell(k).getStringCellValue();
			}
		}
		return Data;
	}
}