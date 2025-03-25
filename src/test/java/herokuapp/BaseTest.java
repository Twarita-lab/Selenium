package herokuapp;

import java.time.Duration;
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
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		return driver;
		

	}
	
	public List<WebElement> getLinkElement(WebDriver driver) {
		List<WebElement> linkElements = driver.findElements(By.cssSelector("div#content li a"));
		
		return linkElements;

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
