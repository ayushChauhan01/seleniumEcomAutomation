package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	Properties propReaderConf;
	String path	= System.getProperty("user.dir")+"\\configuration\\config.properties";
	
	public ReadConfig()  {
		try{
			FileInputStream fis = new FileInputStream(path);
			propReaderConf = new Properties();
			propReaderConf.load(fis);
			} 
		catch(IOException e) {
			e.printStackTrace();
		}
		}
	
	public String getUrl() {
		String value = propReaderConf.getProperty("url");
		if (value!=null) {
			return value;
		}else {
			throw new RuntimeException("url not found!!!");
		}
	}
	public String getBrowser() {
		String value = propReaderConf.getProperty("browser");
		if (value!=null) {
			return value;
		}else {
			throw new RuntimeException("browser not found!!!");
		}
	}
	public String getEmail() {
		String value = propReaderConf.getProperty("email");
		if (value!=null) {
			return value;
		}else {
			throw new RuntimeException("email not found!!!");
		}
	}
}
