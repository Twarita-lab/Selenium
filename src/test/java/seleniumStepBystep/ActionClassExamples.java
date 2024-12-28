package seleniumStepBystep;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionClassExamples {

	public static void main(String[] args) throws Exception {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		Actions a = new Actions(driver);
		
		a.contextClick(driver.findElement(By.xpath("//span[text()='Home decor']"))).build().perform();
		System.out.println(a.getActionDuration());
		WebElement searchBox = driver.findElement(By.cssSelector("input#twotabsearchtextbox"));
		
		a.keyDown(searchBox, Keys.SHIFT).sendKeys("box").keyUp(Keys.SHIFT).keyDown(Keys.ENTER).build().perform();
		a.moveToElement(driver.findElement(By.xpath("//li[@aria-label='Get It by Tomorrow']//i[@class='a-icon a-icon-checkbox']"))).click().build().perform();
	
		Thread.sleep(1000);
		WebElement helloLink = driver.findElement(By.cssSelector("a#nav-link-accountList"));
		WebElement signInLink = driver.findElement(By.cssSelector("a.nav-action-signin-button span"));
		
		a.moveToElement(helloLink).click(signInLink).build().perform();
		

		WebElement email = driver.findElement(By.cssSelector("input#ap_email"));
		email.sendKeys("choudhurytwarita@gmail.com");
		driver.findElement(By.cssSelector("span#continue")).click();
		WebElement password = driver.findElement(By.cssSelector("input#ap_password"));
		password.sendKeys("Abc123@@@@@");
		driver.findElement(By.cssSelector("input#signInSubmit")).submit();
		System.out.println(a.getActionDuration());
		
		
		
		
	}

}
