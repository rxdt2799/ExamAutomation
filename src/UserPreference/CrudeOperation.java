package UserPreference;

import org.testng.annotations.Test;

import Common.BrowserLaunch;
import Common.GlobalUtils;
import InfraStructure.GlobalCommon;

import org.testng.annotations.BeforeTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class CrudeOperation  extends BrowserLaunch
{
	String Product1=GlobalUtils.RandomName();
	@BeforeTest
	public void beforeTest() throws Exception 
	{
		BrowserLaunch.load();
		Login.SignIN();

	}


	@Test(priority=0)
	public void AddProduct1() throws Exception 
	{
		BrowserLaunch.driver.findElement(By.xpath(GlobalCommon.AddProductBUtton)).click();


		BrowserLaunch.driver.findElement(By.xpath(props.getProperty("ProductName"))).sendKeys(Product1);



		Thread.sleep(1000);
		BrowserLaunch.driver.findElement(By.xpath(props.getProperty("UnAssignedProduct1"))).click();

		BrowserLaunch.driver.findElement(By.xpath(props.getProperty("MoveBUtton"))).click();

		BrowserLaunch.driver.findElement(By.xpath(props.getProperty("UnAssginedProduct2"))).click();
		BrowserLaunch.driver.findElement(By.xpath(props.getProperty("MoveBUtton"))).click();

		BrowserLaunch.driver.findElement(By.xpath(props.getProperty("UnAssginedProduct3"))).click();
		BrowserLaunch.driver.findElement(By.xpath(props.getProperty("MoveBUtton"))).click();

		BrowserLaunch.driver.findElement(By.xpath(props.getProperty("UnAssginedProduct4"))).click();
		BrowserLaunch.driver.findElement(By.xpath(props.getProperty("MoveBUtton"))).click();

		BrowserLaunch.driver.findElement(By.xpath(props.getProperty("UnAssginedProduct5"))).click();
		BrowserLaunch.driver.findElement(By.xpath(props.getProperty("MoveBUtton"))).click();


		BrowserLaunch.driver.findElement(By.xpath(props.getProperty("SelectBlock"))).click();


		List<WebElement>allOption=driver.findElements(By.xpath("//*[@id=\"block\"]/option"));
		String Option="Full Width Background" ;
		for(int i=0; i < allOption.size();i++)
		{
			if(allOption.get(i).getText().contains(Option))
			{
				allOption.get(i).click();
				System.out.println("selected");
				break;
			}
		}
		Thread.sleep(1000);
		GlobalUtils.ScrollMore();

		BrowserLaunch.driver.findElement(By.xpath(props.getProperty("AddBlockButton"))).click();

		BrowserLaunch.driver.findElement(By.xpath(props.getProperty("Check1"))).click();
		Thread.sleep(500);
		BrowserLaunch.driver.findElement(By.xpath(props.getProperty("Check2"))).click();
		Thread.sleep(500);
		BrowserLaunch.driver.findElement(By.xpath(props.getProperty("Check3"))).click();
		Thread.sleep(500);

		BrowserLaunch.driver.findElement(By.xpath(props.getProperty("SaveandBackBUtton"))).click();
		Thread.sleep(2000);



	}

	@Test(priority=1)
	public void PreviewProduct() throws Exception 
	{
		BrowserLaunch.driver.findElement(By.xpath("//input[@aria-controls='ops-table']")).sendKeys(Product1);
		BrowserLaunch.driver.findElement(By.xpath(props.getProperty("Preview"))).click();
		BrowserLaunch.driver.findElement(By.xpath(props.getProperty("ClosePR"))).click();


	}


	@Test(priority=2)
	public void DeleteProduct() throws Exception 
	{

		BrowserLaunch.driver.findElement(By.xpath("//input[@aria-controls='ops-table']")).sendKeys(Product1);
		BrowserLaunch.driver.findElement(By.xpath(props.getProperty("DeleteButton"))).click();
		Thread.sleep(500);
		BrowserLaunch.driver.findElement(By.xpath(props.getProperty("ConfirmationDelete"))).click();


	}


	@AfterTest
	public void afterTest() {
	}

}
