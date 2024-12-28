package seleniumStepBystep;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class InvokingNewWindow {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		driver.switchTo().newWindow(WindowType.TAB);
		driver.switchTo().newWindow(WindowType.WINDOW);
		
		
		Set<String> windowHandels = driver.getWindowHandles();
		Iterator<String> it = windowHandels.iterator();
		String parentWindow = it.next();
		String childWindow = it.next();
		
		driver.switchTo().window(childWindow);
		driver.navigate().to("https://rahulshettyacademy.com/");
		String courseName = driver.findElement(By.cssSelector("div#courses-block h2 a")).getText();
		
		driver.switchTo().window(parentWindow);
		driver.findElement(By.tagName("input")).sendKeys(courseName);
				
		
		driver.quit();
	}

}
