package Common;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;




public class BrowserLaunch 
{
	public static WebDriver driver;
	//public static WebDriver webDriverwait;
	public static Properties props;
	public static FileInputStream fInput;

	public static Properties load() throws Exception
	{

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("https://ops-auto.radixdev79.com/admin/product_info_layout_listing.php");
		driver.manage().window().maximize();
		File objFile = new File(GlobalUtils.getFilePath("PropertyFile/Data.properties"));
		fInput = new FileInputStream(objFile);
		props=new Properties();
		props.load(fInput);
		return props;

	}



}


