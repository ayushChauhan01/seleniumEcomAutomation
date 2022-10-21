package base;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	/*
	 * 1.Load config.properties file
	 * 2.Create setup() method which open the desired site on req. browser using config file
	 * 3.Create tearDown() method which closes the site also use add @beforeMethod and @afterMethod
	 * 
	*/
	public static WebDriver driver;
	public static Logger logger;
	
	Properties conf = new Properties();
	
	public void loader() throws IOException {
		try {
			FileReader fir = new FileReader( 
					System.getProperty("user.dir") + "\\src\\test\\java\\base\\BaseTest.java");
			conf.load(fir);

		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		}
	}

	@AfterClass
	public void launchApp() {
		String url = conf.getProperty("website");
		String browser = conf.getProperty("browser");
		
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.chromedriver().setup();
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		logger = LogManager.getLogger("insertEcomSiteName");
		driver.manage().window().maximize();
		driver.get(url);
		
	
	}
	
	@BeforeClass
	public void tearDown() {
		System.out.println("closed.");
		driver.close();
		driver.quit();
	}

	
}
