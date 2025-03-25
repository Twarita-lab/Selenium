package herokuapp;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BrokenImage {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		BaseTest b = new BaseTest();
		WebDriver driver = b.launchHerokuApp();

		driver.findElement(By.linkText("Broken Images")).click();

		List<WebElement> images = driver.findElements(By.cssSelector("div.example img"));
		for (WebElement image : images) {
			String url = image.getAttribute("src");
			HttpURLConnection actualUrl = (HttpURLConnection) (new URL(url)).openConnection();
			actualUrl.connect();
			if (actualUrl.getResponseCode() >= 400) {
				System.out.println("It's a broken image");

			} else
				System.out.println("This image is fine");
		}
		driver.quit();
	}

}
