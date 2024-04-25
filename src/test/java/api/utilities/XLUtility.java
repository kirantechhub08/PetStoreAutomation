package api.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtility {
	
	public static FileInputStream fis;
	public  static FileOutputStream fos;
	public static XSSFWorkbook wb;
	public static XSSFSheet sh;
	public static XSSFRow rw;
	public static XSSFCell cl;
	public static CellStyle cs;
	
	
	
	
	
	
	public static int getRowCount(String xFile,String sheet) throws IOException
	{
		fis= new FileInputStream(xFile);
		wb=new XSSFWorkbook(fis);
		
		sh=wb.getSheet(sheet);
		int rowcount=sh.getLastRowNum();
		wb.close();
		fis.close();
		return rowcount;	
		
	}
	
	
	public static int getCellCount(String xFile,String sheet, int rowNum) throws IOException
	{
		fis= new FileInputStream(xFile);
		wb=new XSSFWorkbook(fis);
		
		sh=wb.getSheet(sheet);
		rw=sh.getRow(rowNum);
		int lastcellnum=rw.getLastCellNum();
		wb.close();
		fis.close();
		return lastcellnum;	
		
	}
	
	public static String getCellData(String xFile, String sheet, int rowNum, int cellNum) throws IOException
	{
		
		fis= new FileInputStream(xFile);
		wb=new XSSFWorkbook(fis);
		
		sh=wb.getSheet(sheet);
		rw=sh.getRow(rowNum);
		cl=rw.getCell(cellNum);
		
		String CellData;
		
		try {
			DataFormatter format= new DataFormatter();
			String data=format.formatCellValue(cl);
			return data;
		}catch(Exception e)
		{
			CellData="";
		}
		wb.close();
		fis.close();
		return CellData;
	
		
	}
	
	
	public static void setCellData(String xFile, String sheet, int rowNum, int cellNum,String data) throws IOException
	{
		
		fis= new FileInputStream(xFile);
		wb=new XSSFWorkbook(fis);
		
		sh=wb.getSheet(sheet);
		rw=sh.getRow(rowNum);
		cl=rw.createCell(cellNum);
		cl.setCellValue(data);
		fos=new FileOutputStream(xFile);
		wb.write(fos);
		wb.close();
		fis.close();
		fos.close();
		
	
		
	}


	
	

}
