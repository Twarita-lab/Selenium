package interviewQuestions;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class goToSignInPageFromSignInPopUp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		
		WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.switchTo().frame(0);
		
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[aria-label*='new tab']")));
		driver.findElement(By.cssSelector("a[aria-label='Sign in (opens a new tab)']")).click();
		
		Set<String> windowHandels = driver.getWindowHandles();
		Iterator<String> it = windowHandels.iterator();
		String signInWindow = null;
		
		while(it.hasNext()) {
			signInWindow = it.next();
		}
		
		driver.switchTo().window(signInWindow);
			
		driver.findElement(By.cssSelector("input[type=\"email\"]")).sendKeys("test");
		
		driver.findElement(By.cssSelector("div#identifierNext button")).click();
		
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[aria-live=\"assertive\"]")));
		System.out.println(driver.findElement(By.cssSelector("[aria-live=\"assertive\"]")).getText());
		
		driver.quit();
		
	}

}
