package com.nexsoft.testng.dashboard;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import org.testng.Assert;
import org.testng.Reporter;
import com.nexsoft.testng.frontpage.*;

public class CRUDBuilder {

	private static final WebElement chooseFile = null;
	WebDriver driver;
	private JavascriptExecutor jse;
	
	@BeforeClass
	public void init() {
		System.setProperty("url", "http://localhost/cicool/");
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		jse = (JavascriptExecutor) driver;
//		driver.get(System.getProperty("url"));
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Test (priority = 0)
	public void Login() {
		driver.get("http://localhost/cicool");
		driver.findElement(By.cssSelector(".fa.fa-sign-in")).click();
		try{
			Thread.sleep(2000);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.findElement(By.cssSelector("input[placeholder='Email']")).clear();
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("Intanjuniar101@gmail.com");
		driver.findElement(By.cssSelector("input[placeholder='Password']")).clear();
		driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys("10101010");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		String username=driver.findElement(By.cssSelector("span[class='hidden-xs']")).getText();
	
	}
	
	@Test(priority = 1,dataProvider = "getNexsoftData", dataProviderClass = com.nexsoft.testng.dataprovider.DataProviderUser.class)
	public void createData(String param1, String param2, String param3, String param4) {
			
		
		driver.get("http://localhost/cicool/administrator/userbiodata");
		
	
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
		System.out.println( "create data --> "+ sdf2.format(new  Date().getTime()));
		driver.findElement(By.id("btn_add_new")).click();
//		Input data userbiodata
		driver.findElement(By.id("first_name")).click();
		driver.findElement(By.id("first_name")).sendKeys(param1);
		driver.findElement(By.id("last_name")).click();
	    driver.findElement(By.id("last_name")).sendKeys(param2);
		driver.findElement(By.id("email")).click();
	    driver.findElement(By.id("email")).sendKeys(param3);
		driver.findElement(By.id("gender")).click();
	    driver.findElement(By.id("gender")).sendKeys(param4);
	    jse.executeScript("window.scrollBy(100, 500)", "");

	    WebElement upload_photo = driver.findElement(By.cssSelector("input[title='file input"));

		int randomPhoto = 1 + (int) (Math.random() * ((5 - 1) + 1));
		if (randomPhoto == 1)
			upload_photo.sendKeys("C:\\nexsoft\\com.nexsoft.testng.tugas\\src\\test\\resources\\01.jpg");
		else if (randomPhoto == 2)
			upload_photo.sendKeys("C:\\nexsoft\\com.nexsoft.testng.tugas\\src\\test\\resources\\02.jpg");
		else if (randomPhoto == 3)
			upload_photo.sendKeys("C:\\nexsoft\\com.nexsoft.testng.tugas\\src\\test\\resources\\03.jpg");
		else if (randomPhoto == 4)
			upload_photo.sendKeys("C:\\nexsoft\\com.nexsoft.testng.tugas\\src\\test\\resources\\04.jpg");
		else if (randomPhoto == 5)
			upload_photo.sendKeys("C:\\nexsoft\\com.nexsoft.testng.tugas\\src\\test\\resources\\05.jpg");
		else
			upload_photo.sendKeys("C:\\nexsoft\\com.nexsoft.testng.tugas\\src\\test\\resources\\00.jpg");

		try{
			Thread.sleep(500);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//a[@id='btn_save']")).click();

		try{
			Thread.sleep(500);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
//	@Test(priority = 1)
//	public void getUsername() {
//		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
//		System.out.println(driver.findElement(By.linkText("Wiwin Gulo")).getText() + sdf2.format(new Date().getTime()));
//	}
//
//	@Test(priority = 1)
//	public void getUsername2() {
//		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
//		System.out.println(driver.findElement(By.linkText("Wiwin Gulo")).getText() + sdf2.format(new Date().getTime()));
//	}
	
	
	@Test (priority = 2)
	public void gotoWeb_and_Logout() {
		driver.findElement(By.xpath("//span[@class='hidden-xs']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Exit']")).click();
	}


}