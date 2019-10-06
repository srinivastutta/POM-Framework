package Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Util.UtilClass;

public class BaseClass extends UtilClass{
	public static WebDriver driver;
	public static Properties prop;
	
	public static void InitProp() throws IOException {
			prop= new Properties();
			FileInputStream fi= new FileInputStream("E:\\Selenium\\Workspace\\POMwithDataDrivenFramework\\src\\main\\java\\Config\\config.properties");
			prop.load(fi);
		
		
}
	public static void initialization() {
		String browsername = prop.getProperty("browser");
		if (browsername.equals("chrome")) {
        	System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Selenium Setup Files\\chromedriver.exe");
			driver = new ChromeDriver();
			
	} else if (browsername.equals("FF")) {
		System.setProperty("webdriver.gecko.driver", "E:\\Selenium\\Selenium Setup Files\\geckodriver.exe");
		driver = new FirefoxDriver();
		
	}
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(UtilClass.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(UtilClass.IMPLICIT_WAIT, TimeUnit.SECONDS);
	
	driver.get(prop.getProperty("url"));
		
	}

}
