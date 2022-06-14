package com.nexsoft.testng.frontpage;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import org.testng.Assert;
import org.testng.Reporter;

//Run All
public class Frontpage {

	WebDriver driver;
	
	public String screenshoot() {
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String waktu = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		String namaFile = "C:\\Users\\62822\\Pictures)"+waktu+".png";
		File screenshoot = new File(namaFile);
		try {
			FileUtils.copyFile(srcFile, screenshoot);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return namaFile;
	}
	
	
	@Test(dataProvider="data-provider", dataProviderClass = com.nexsoft.testng.dataprovider.DataProviderUser.class)
	public void consumeData(String data) {
		System.out.println(data);
	}
	
	@BeforeClass
	public void init() {
		System.setProperty("url", "http://localhost/cicool/");
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(System.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Test
	public void Login() {
	driver.findElement(By.cssSelector(".fa.fa-sign-in")).click();driver.findElement(By.cssSelector("input[placeholder='Email']")).clear();
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("Intanjuniar101@gmail.com");
		driver.findElement(By.cssSelector("input[placeholder='Password']")).clear();
		driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys("10101010");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		String username=driver.findElement(By.cssSelector("span[class='hidden-xs']")).getText();
//		Assert.assertEquals(username, "Intanjuniar101");
		
		String file = "<img src='file://"+screenshoot()+"' />";
		Reporter.log(file);
	}
	
	@Test
	public void ImageTest() {
		Reporter.log("https://ebooks.gramedia.com/ebook-covers/58976/image_highres/BLK_AM2020951784.jpg");
	}
}

