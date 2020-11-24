package Generics;

import java.io.FileInputStream;
import java.util.Properties;

public class Property {
	public static String getPropertyValue(String filePath,String key)
	{
		String value="";
		Properties property=new Properties();
		try {
			property.load(new FileInputStream(filePath));
			value=property.getProperty(key);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 	
		return value;
	}
}
