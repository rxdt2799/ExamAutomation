package UserPreference;

import org.testng.annotations.Test;

//import CheckOutOperation.MenuRedirection;
import Common.BrowserLaunch;

import Common.ExcelUtils;
import Common.GlobalUtils;
import InfraStructure.GlobalCommon;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Login extends BrowserLaunch
{
	@BeforeTest
	public void beforeTest() throws Exception 
	{

		BrowserLaunch.load();
	}

	@Test(priority=0)
	public static void SignIN() throws Exception 
	{
		Thread.sleep(1000);

		ExcelUtils.intialize("LoginCredentials");
		ExcelUtils.rowcount = ExcelUtils.sheet.getLastRowNum() - ExcelUtils.sheet.getFirstRowNum();			
		for(int i =1; i<ExcelUtils.rowcount+1; i++)
		{

			BrowserLaunch.driver.findElement(By.xpath(props.getProperty("Username"))).sendKeys(ExcelUtils.fetchData(i,"LoginCredentials","Username"));
			BrowserLaunch.driver.findElement(By.xpath(props.getProperty("Password"))).sendKeys(ExcelUtils.fetchData(i,"LoginCredentials","password"));


		}
		Thread.sleep(1000);
		BrowserLaunch.driver.findElement(By.xpath(props.getProperty("LoginBUtton"))).click();

		String Title =	BrowserLaunch.driver.getTitle();
		System.out.println(Title);

		Thread.sleep(3000);		






	}





	@AfterTest
	public void afterTest() 
	{
		GlobalUtils.TearDown();
	}


}








