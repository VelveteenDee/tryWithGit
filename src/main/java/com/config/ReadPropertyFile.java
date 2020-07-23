package com.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.base.TestBase;

public class ReadPropertyFile extends TestBase{
	// This class is executed to read data from properties file
	public static String get(String PropertyName)
	{
		String returnProperty="";
		Properties property = new Properties();
		try {
			log("Loading Properties File");
			FileInputStream file =
					new FileInputStream(System.getProperty("user.dir")+"/resources/config.properties");
			property.load(file);
			returnProperty=property.getProperty(PropertyName);
			log("Properties File Loaded");
			if(returnProperty==null)
			{
				throw new Exception("Property with name : "+PropertyName+" not found in "+System.getProperty("user.dir")+"//resources//TestRunDetails.properties Please check again");
			}
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			log("File not found");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnProperty;
	}
	
	

}
