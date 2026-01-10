package com.comcast.crm.generic.excelutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	public String getStringData(String sheetname, int rownum, int cellnum) throws EncryptedDocumentException, IOException {
		FileInputStream fis= new FileInputStream("./testData/OrgContactTestscriptdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data=wb.getSheet(sheetname).getRow(rownum).getCell(cellnum).getStringCellValue();
		wb.close();
		return data;
	}
	
//	public void setStringData(String sheetname, int rownum, int cellnum, String data) throws EncryptedDocumentException, IOException {
//		FileInputStream fis= new FileInputStream("./testData/OrgContactTestscriptdata.xlsx");
//		Workbook wb = WorkbookFactory.create(fis);
//		wb.getSheet(sheetname).createRow(rownum).createCell(cellnum).setCellValue(data);
//		FileOutputStream fos= new FileOutputStream("./testData/OrgContactTestscriptdata.xlsx");
//		wb.write(fos);
//		wb.close();
//
//	}
	
	public void setStringData(String sheetname, int rownum, int cellnum, String data)
	        throws EncryptedDocumentException, IOException {

	    FileInputStream fis = new FileInputStream("./testData/OrgContactTestscriptdata.xlsx");
	    Workbook wb = WorkbookFactory.create(fis);
	    Sheet sh = wb.getSheet(sheetname);

	    if (sh == null) {
	        sh = wb.createSheet(sheetname);
	    }

	    Row row = sh.getRow(rownum);
	    if (row == null) {
	        row = sh.createRow(rownum);
	    }

	    Cell cell = row.getCell(cellnum);
	    if (cell == null) {
	        cell = row.createCell(cellnum);
	    }

	    cell.setCellValue(data);

	    FileOutputStream fos = new FileOutputStream("./testData/OrgContactTestscriptdata.xlsx");
	    wb.write(fos);
	    wb.close();
	}

	
	public int getRowCount(String sheetname) throws EncryptedDocumentException, IOException {
		FileInputStream fis= new FileInputStream("./testData/OrgContactTestscriptdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int rowCount=wb.getSheet(sheetname).getLastRowNum();
		wb.close();
		return rowCount;
	}
}
