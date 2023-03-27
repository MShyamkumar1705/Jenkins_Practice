package com.resume.Utility;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility {
	public String propertyFile(String key) throws Throwable {
		FileInputStream fis=new FileInputStream(iPathConstant.file);
		Properties p=new Properties();
		p.load(fis);
		String data = p.getProperty(key);
		return data;
		
		
	}

}
