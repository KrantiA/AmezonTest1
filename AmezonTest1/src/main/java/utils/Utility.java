package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
	public static void captureScreenshot(WebDriver driver, int testID) throws IOException 
	{
		
      // DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy//mm//ss");
       Date date = new Date();
	   String date1= date.toString().replace(" ", "-").replace(":", " ");
	   File source =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	   File dest = new File("test-output\\Screenshot\\test"+ date1 + testID +".png");
	   FileHandler.copy(source, dest);
//	   FileUtils.copyFile(srcFile, new File("AmezonTest1\\test-output\\Screenshot"+ date1 + testID +".jpeg"));
	 }
		
    public static String getDatafromexcelsheet(String sheetname,int row, int cell) throws EncryptedDocumentException, IOException, InterruptedException{
    
    	String data = null;
		
	    FileInputStream file = new FileInputStream("C:\\Users\\HP\\Desktop\\Testdata.xlsx");
		Workbook book = WorkbookFactory.create(file);
		try {
	    Thread.sleep(3000);
		data = book.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();

		}
		catch(Exception e) {
		 double value = book.getSheet(sheetname).getRow(row).getCell(cell).getNumericCellValue();
		//code to convert double to string
		data = Double.toString(value);
		}
		//return data;
	}}


	
