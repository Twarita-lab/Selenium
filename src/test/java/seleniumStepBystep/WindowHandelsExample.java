package seleniumStepBystep;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowHandelsExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.manage().window().maximize();
		Wait<WebDriver> explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));

		WebElement freeAccessText = driver.findElement(By.xpath("//a[contains(text(),'Free Access')]"));
		freeAccessText.click();

		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentWindow = it.next();
		String childWindow = it.next();
		driver.switchTo().window(childWindow);

		String mailId = driver.findElement(By.cssSelector("a[href*='mail']")).getText();
		System.out.println(mailId);

		driver.switchTo().window(parentWindow);

		driver.findElement(By.cssSelector("input#username")).sendKeys(mailId);
		driver.findElement(By.cssSelector("input#password")).sendKeys(mailId);
		driver.findElement(By.cssSelector("input#terms")).click();
		driver.findElement(By.cssSelector("input#signInBtn")).click();
		WebElement errorText = driver.findElement(By.cssSelector("div.alert.alert-danger.col-md-12"));
		explicitWait.until(ExpectedConditions.visibilityOf(errorText));
		System.out.println(driver.findElement(By.cssSelector("div.alert.alert-danger.col-md-12")).getText());

		driver.quit();

	}

}
