package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class ReadXlsxData {

//	public static void main(String[] args) throws EncryptedDocumentException, IOException {
//		// TODO Auto-generated method stub	
//		ReadXlsxData readxl= new ReadXlsxData();
//		readxl.getData("login");
//
//	}

	@DataProvider(name="Testdata")

	public  String[][] getData(Method m) throws EncryptedDocumentException, IOException {
		
		String xlsheetname=m.getName();
		System.out.println("xlsheetname is "+ xlsheetname);
		File file = new File(System.getProperty("user.dir") + "/src/test/resources/TestData/Testdata.xlsx");
		FileInputStream fis = new FileInputStream(file);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheetname = wb.getSheet(xlsheetname);
		int totalRows = sheetname.getLastRowNum();
		System.out.println("Total number of rows are " + totalRows);
		Row rowcell = sheetname.getRow(0);
		int totalCol = rowcell.getLastCellNum();
		System.out.println("Total number of Columns are " + totalCol);

		String testData[][] = new String[totalRows][totalCol];
		DataFormatter format = new DataFormatter();
		for (int i = 1; i <= totalRows; i++) {
			for (int j = 0; j < totalCol; j++) {
				testData[i - 1][j] = format.formatCellValue(sheetname.getRow(i).getCell(j));
				System.out.println(testData[i - 1][j]);
			}

		}

		return testData;
	}
}
