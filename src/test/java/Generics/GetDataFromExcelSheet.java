package Generics;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GetDataFromExcelSheet {


	public void getRowCount()
	{
		String projectpath;
		String Filename="ExcelData/User_Information_Automation.xlsx";
		try 
		{
			projectpath = System.getProperty("user.dir");
			System.out.println(projectpath);
			File file = new File(projectpath+"/"+Filename);
			FileInputStream is = new FileInputStream(file);
			System.out.println(file.getAbsolutePath());

			Workbook wb = new XSSFWorkbook(is);

			Sheet sheet = wb.getSheet("User_Data");
			System.out.println(sheet.getSheetName());
			int n1 = sheet.getLastRowNum();
			System.out.println(n1);
		}
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
	}
	
	public void getCellDataString()
	{
		String projectpath;
		String Filename="ExcelData/User_Information_Automation.xlsx";
		try 
		{
			projectpath = System.getProperty("user.dir");
			System.out.println(projectpath);
			File file = new File(projectpath+"/"+Filename);
			FileInputStream is = new FileInputStream(file);
			//System.out.println(file.getAbsolutePath());

			Workbook wb = new XSSFWorkbook(is);
			Sheet sheet = wb.getSheet("User_Data");
			//int n1 = sheet.getLastRowNum();
			//int n2 = sheet.getPhysicalNumberOfRows();

			//It will take only the STRING value
			String celldata = sheet.getRow(1).getCell(0).getStringCellValue();
			System.out.println(celldata);

			//System.out.println(n1);
		}
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
	}

	public void getCellDataNumber()
	{
		String projectpath;
		String Filename="ExcelData/User_Information_Automation.xlsx";
		try {
			projectpath = System.getProperty("user.dir");
			//System.out.println(projectpath);
			File file = new File(projectpath+"/"+Filename);
			FileInputStream is = new FileInputStream(file);
			//System.out.println(file.getAbsolutePath());

			Workbook wb = new XSSFWorkbook(is);
			Sheet sheet = wb.getSheet("User_Data");
			//int n1 = sheet.getLastRowNum();
			//int n2 = sheet.getPhysicalNumberOfRows();

			//It will take only the STRING value
			double celldata = sheet.getRow(0).getCell(1).getNumericCellValue();
			System.out.println(celldata);

			//System.out.println(n1);
		}
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
	}

}
