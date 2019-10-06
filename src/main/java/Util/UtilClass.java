package Util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class UtilClass {
	public static long PAGE_LOAD_TIMEOUT = 50;
	public static long IMPLICIT_WAIT = 30;
	
	public static ArrayList<Object[]> getDataFromExcel() throws BiffException, IOException {

		ArrayList<Object[]> myData = new ArrayList<Object[]>();

		File fi = new File("E:\\Selenium\\Workspace\\POMwithDataDrivenFramework\\src\\main\\java\\TestData\\SpiceJet TestData.xls");

		Workbook wb = Workbook.getWorkbook(fi);
		Sheet ws = wb.getSheet("Sheet1");

		// to find number of rows
		System.out.println("Number of rows are : " + ws.getRows());

		for (int rowCount = 1; rowCount <= ws.getRows()-1; rowCount++) {
			String DepCity = ws.getCell(0, 1).getContents();
			String ArvCity = ws.getCell(1, rowCount).getContents();
			
			Object ab[] = { DepCity, ArvCity};
			myData.add(ab);

		}
		return myData;

	}
	
	
	
}
