package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility{
	
	public String getDataFromPropertiesFile(String key) throws IOException{
		FileInputStream fis= new FileInputStream("./configData/commondata.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		
		String value = pobj.getProperty(key);
		return value;
	}

	
}
