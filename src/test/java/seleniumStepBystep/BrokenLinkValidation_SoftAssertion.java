package seleniumStepBystep;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class BrokenLinkValidation_SoftAssertion {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		SoftAssert a = new SoftAssert();
		
		List<WebElement> links = driver.findElements(By.cssSelector("div[class*=\" footer\"] a"));
		for(WebElement link:links) {
			HttpURLConnection url = (HttpURLConnection)(new URL(link.getAttribute("href"))).openConnection();
			//url.setRequestMethod("HEAD");
			url.connect();
			a.assertTrue(url.getResponseCode()<400, link.getText()+" is a broken link is broken with "+url.getResponseCode()+" code");
		}
		driver.quit();

		a.assertAll();
		
	}

}
