package base;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.ReadConfig;

public class BaseClassV2 extends ReadConfig{
	
	public ReadConfig conf = new ReadConfig();
	
	String url = conf.getUrl();
	String browser = conf.getBrowser();
	
	public static WebDriver driver;
	public static Logger logger;
	
	@BeforeClass
	public void setUp() {

		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		} else if(browser.equalsIgnoreCase("safari")) {
			WebDriverManager.edgedriver();
			driver = new SafariDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(35)); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//opening the website
		driver.get(url);
		
		logger = LogManager.getLogger("[ecomSite]V1");
		logger.info("url opened");
		
		
		
	}
	/*
	@AfterClass
	public void tearDown() {
		logger.info("< Successfully exited >");
		driver.close();
		driver.quit();
	}
	*/
}
