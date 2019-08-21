package com.demo.mediware_appointment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Hello world!
 *
 */
public class App 
{
	/*public void read() throws Exception {
		FileInputStream fis = new FileInputStream("C:\\Users\\SE-MENTOR\\Desktop\\testsheet.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);
		String s=""+cell;
		System.out.println(s);
		int data= (int)workbook.getSheetAt(0).getRow(0).getCell(1).getNumericCellValue();
		System.out.println(cell);
		System.out.println(data);
	}*/
	public void write() throws Exception {
		FileInputStream fis = new FileInputStream("C:\\Users\\SE-MENTOR\\Desktop\\DEMOTEST.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		Row row= sheet.createRow(0);
		Cell cell = row.createCell(0);
		Cell cell1=row.createCell(1);
		cell.setCellType(cell.CELL_TYPE_STRING);
		cell.setCellValue("AMAL");
		cell1.setCellType(cell1.CELL_TYPE_NUMERIC);
		cell1.setCellValue("8129901197");
		FileOutputStream fos = new FileOutputStream("C:\\\\Users\\\\SE-MENTOR\\\\Desktop\\\\DEMOTEST.xlsx");
		workbook.write(fos);
		fos.close();
	}
	public static void main (String [] args) throws Exception{ 


		App obj=new App();
		obj.write();



}
}
