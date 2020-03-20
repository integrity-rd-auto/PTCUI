package test_cases;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class abc {

	public static void main(String[] args) throws IOException {
		
		readExcel();
		
	}
			
		public static Object[][] readExcel() throws IOException {

			FileInputStream file = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\main\\java\\TestData\\TestData.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			XSSFSheet sheet = workbook.getSheet("Demo");

			XSSFRow Row = sheet.getRow(0);
			int noOfRows = sheet.getLastRowNum();

			int noOfCol = Row.getLastCellNum();
			
			System.out.println("Hello");

			Object Data[][] = new Object[noOfRows - 1][noOfCol];

			for (int i = 0; i < noOfRows-1; i++) {
				for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {

					Data[i][k] = sheet.getRow(i+1).getCell(k).getStringCellValue();

					System.out.println(Data[i][k]);
				}
			}
			return Data;

		}
		

	}


