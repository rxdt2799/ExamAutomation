package Common;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import CommonUtils.BrowserFire;
import InfraStructure.GlobalCommon;


public class GlobalUtils
{

	public static void TearDown()
	{

		BrowserLaunch.driver.close();
	}

	//-------------------------------------------------------------------------------------------------	

	public static  String RandomName()
	{
		Random rand=new Random();
		int n=rand.nextInt(1000)+1;
		String RName="Product "+String.valueOf(n)+"";
		return RName;
	}

	//-------------------------------------------------------------------------------------------------	


	public static  int RandomNumber()
	{
		Random rand=new Random();
		int rand_int1 = rand.nextInt(10000)+1;

		return rand_int1;
	}

	//-------------------------------------------------------------------------------------------------	

	public static void Scroll()
	{
		JavascriptExecutor js = (JavascriptExecutor)BrowserLaunch.driver;  
		js.executeScript("scrollBy(300)");  
	}

	//-------------------------------------------------------------------------------------------------	



	public static void ScrollMore()
	{
		JavascriptExecutor js = (JavascriptExecutor)BrowserLaunch.driver;  
		js.executeScript("scrollBy(0,4000)");  
	}



	public static String getFilePath(String PathToFile){

		File currDir= new File(".");

		String CurrentPathOfProject=currDir.getAbsolutePath();

		CurrentPathOfProject=currDir.getAbsolutePath().substring(0,CurrentPathOfProject.length()-1);

		if(!System.getProperty("os.name").toLowerCase().equals("linux")){

			PathToFile=PathToFile.replace("/", "\\");
		}

		return CurrentPathOfProject+PathToFile;

	}


	//-------------------------------------------------------------------------------------------------	
	
	

	public static WebElement explicitWait(WebDriver driver, By xpath, long timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		By locator = null;
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return driver.findElement(locator);
	}
}



