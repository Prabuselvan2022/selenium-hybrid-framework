package utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {

	public static void main(String[] args) throws IOException {
		FileReader file = new FileReader(
				"/Users/prabuselvan/Desktop/selenium-framework/Selenium-Automation/src/test/resources/Configfiles/config.properties");
		Properties props = new Properties();

		props.load(file);
		
		System.out.println("browser is " + props.get("browser"));
		
		System.out.println("testurl is "+ props.get("testurl"));
	}
}

