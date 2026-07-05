package Twarita.CloudIntegrationWithSelenium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

public class RemoteTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		MutableCapabilities capabilities = new MutableCapabilities();
		WebDriver driver = new RemoteWebDriver(new URL("https://twaritachoudhury_vR6aYe:tXERvbsMPvZsHT7XVuLL@hub.browserstack.com/wd/hub"),capabilities);
		driver.get("https://www.google.com");
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("Google"));
		driver.quit();

	}

}
