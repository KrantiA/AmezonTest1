package TestClasses;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchData {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		String path = "C:\\Users\\HP\\Desktop\\TestdataAmezon.xlsx";
		FileInputStream file = new FileInputStream(path);
		Workbook book = WorkbookFactory.create(file);
		double d = book.getSheet("TestData").getRow(1).getCell(0).getNumericCellValue();
		System.out.println(d);
	}}


