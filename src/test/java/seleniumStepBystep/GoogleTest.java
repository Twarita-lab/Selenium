package test.test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class GoogleTest {

	@Test
	public void Test1() throws MalformedURLException, URISyntaxException {
		// TODO Auto-generated method stub
		
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setBrowserName("chrome");
		WebDriver driver = new RemoteWebDriver(new URI("http://192.168.29.253:4444").toURL(), desiredCapabilities);
		
		driver.get("https://www.google.com");
		driver.quit();
		
		
	}

}
