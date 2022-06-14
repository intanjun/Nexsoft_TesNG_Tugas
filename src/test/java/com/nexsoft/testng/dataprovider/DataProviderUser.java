package com.nexsoft.testng.dataprovider;

//import org.testng.annotations.DataProvider;
import com.github.hemanthsridhar.CSVUtils;
import com.github.hemanthsridhar.ExcelUtils;
import com.github.hemanthsridhar.lib.ExtUtils;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class DataProviderUser {

	@DataProvider(name = "data-provider")
	public Object[][] dataProviderMethod() {
		return new Object[][] { { "Intanjuniar101" }, { "nexSoft" } };
	}

	@DataProvider(parallel = false)
	public Object[][] getNexsoftData() throws Exception {
		ExtUtils ext = new CSVUtils(getPathOfTheFile("MOC_DATA.csv"), true);
		return ext.parseData();
	}

	String getPathOfTheFile(String fileName) throws Exception {
		String path;
		try {
			path = getClass().getClassLoader().getResource(fileName).getPath();
		} catch (NullPointerException e) {
			throw new Exception("External TestNG dataprovider file not found");
		}
		return path;
	}

}
