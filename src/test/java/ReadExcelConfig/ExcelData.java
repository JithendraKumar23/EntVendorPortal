package ReadExcelConfig;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {

	
	 XSSFWorkbook wb ;
	 XSSFSheet sheet1;
	 
	//Excel Sheet is loaded using this constructer 
	public ExcelData(String path) throws IOException
	{
	    try {
			File file = new File(path);
			
			FileInputStream iputstream = new FileInputStream(file);
			
			wb = new XSSFWorkbook(iputstream);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public String getData(String sheetnumber, int row, int column )
	{
		sheet1 = wb.getSheet("User_Data");

		String data = sheet1.getRow(row).getCell(column).getStringCellValue();
		return data;
	}
	


}
