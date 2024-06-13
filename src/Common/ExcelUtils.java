package Common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils 
{
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook workbook;
	public static  XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static CellStyle style;
	public static int rowcount;
	String path=null;
	
	  public ExcelUtils(String path) 
	  {
			this.path=path;
	}
	
	  
	
	
	public int getRowCount(String sheetName) throws IOException
	{
		fi= new FileInputStream(path);
		workbook= new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetName);
		int rowCount=sheet.getLastRowNum();
		fi.close();
		return rowCount;
		
	}
	public static int writeintoexcel(String path,String SheetName,int rowcount,int cellcount) throws Exception 
	{
		File file =    new File(path);
		FileInputStream inputStream = new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(inputStream);
		XSSFSheet sheet=wb.getSheet(SheetName);
		XSSFRow row=sheet.createRow(1);

		return cellcount;
		
	}
	public int getCellCount(String sheetName,int rownum) throws IOException

	{
		
		
		
		
		
		
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rownum);
		int cellCount=row.getLastCellNum();
		workbook.close();
		return cellCount;
	}
	
	public String getCellData(String sheetName,int rownum,int Colnum)throws IOException
	{
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rownum);
		cell=row.getCell(Colnum);
		DataFormatter formatter =new DataFormatter();
		String data;
		try {
			data=formatter.formatCellValue(cell);
		}catch(Exception exp)
		{
			data="";
		}
		workbook.close();
		fi.close();
		return data;

	}
	
	public void setCellData(String sheetName,int rownum,int Colnum,String data )throws IOException
	{
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rownum);
		cell=row.getCell(Colnum);
		cell.setCellValue(data);
		fo=new FileOutputStream(path);
		workbook.write(fo);
		workbook.close();
		fi.close();
		fo.close();
	}
public static String fetchData(int row , String sheetname , String colName ) throws IOException {
		
		fi = new FileInputStream("D:\\Workspace\\Automation_Test\\Excelsheet\\UserData.xlsx");
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetname);
			
		int rowcount = sheet.getLastRowNum()-sheet.getFirstRowNum();
		
		 String returnData = null;
		
		for(int i =0; i<rowcount+1; i++)
		{
		 XSSFRow r1 = sheet.getRow(i);
			
			for(int j =0; j< r1.getLastCellNum();j++)
			{
				
				String cellValue = r1.getCell(j).toString();
				
				if(cellValue.equals(colName))
				{
					XSSFRow row2 = sheet.getRow(row);
					returnData = row2.getCell(j).toString();
					break;
				}
			}		
			
		}
			return returnData;			
	}

	public static void intialize(String sheetname) throws IOException
	{
		
		fi = new FileInputStream("D:\\Workspace\\Automation_Test\\Excelsheet\\UserData.xlsx");
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetname);	
		
	}




	

}
