package com_Pearson_Search_genericlib;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com_Pearson_Search_genericlib.IConstant;

/**
 * 
 * @author Shradda
 *
 */
public class FileUtility {
	
	/**
	 *    used to get data from property file based on key
	 * @param key
	 * @return value
	 * @throws IOException
	 */
	public String getPropertyKeyValue(String key) throws Throwable  {
		  
			FileInputStream fis = new FileInputStream(IConstant.commonDataFilePath);
			 Properties pObj = new Properties();
			 pObj.load(fis);
			 String value = pObj.getProperty(key);
		
		return value;
	}

}
