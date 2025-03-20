package herokuapp;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
	private WebDriver driver;
	
	public WebDriver launchHerokuApp() {
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		return driver;
		

	}
	
	public List<String> getLinkName(WebDriver driver) {
		List<WebElement> linkElements = driver.findElements(By.cssSelector("div#content li a"));
		List<String> linksNameList = linkElements.stream().map(a->a.getText()).collect(Collectors.toList());		
		
		return linksNameList;

	}
	
	public List<String> getLinkURL(WebDriver driver) {
		List<WebElement> linkElements = driver.findElements(By.cssSelector("div#content li a"));
		List<String> linksURLList = linkElements.stream().map(a->a.getAttribute("href")).collect(Collectors.toList());		
		
		return linksURLList;

	}
	
	public void tearDown(WebDriver driver) {
		driver.quit();
	}

}
