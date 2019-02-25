package com.qa.util;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TestUtil {
	
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 10;
	
	public static void capturescreenshot(WebDriver driver , String screenshotName)
	{
		try 
		{
			TakesScreenshot ts=(TakesScreenshot)driver;
			
			File source=ts.getScreenshotAs(OutputType.FILE);
			
			FileUtils.copyFile(source, new File("./Screenshots/"+screenshotName+".png"));
			
			
			System.out.println("Screenshot taken");
		}
		catch (Exception e)
		{
			System.out.println("Exception while taking screenshot"+e.getMessage());
		}
	}
}
