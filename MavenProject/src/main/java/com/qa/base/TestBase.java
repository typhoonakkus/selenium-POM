package com.qa.base;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.qa.util.TestUtil;

public class TestBase {
	
	static WebDriver driver;
	static Properties prop;
	
	public TestBase() {
		
		try 
		{
			prop = new Properties();
			
			FileInputStream ip= new FileInputStream("/Users/tayfunakkus/eclipse-workspace/MavenProject/src/main/java/com/qa/config/config");
			prop.load(ip);
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}
	
	public static void initialization() {
		
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			
			//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "/chromedriver");	 
			driver = new ChromeDriver();		    
		}
		else if(browserName.equals("safari")) {
			
			//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "/chromedriver");	 
			driver = new SafariDriver();
	}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
		
	}

}
	
	
	
	
