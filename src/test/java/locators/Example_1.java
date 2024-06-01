package locators;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Example_1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		WebElement emailField = driver.findElement(By.id("inputUsername"));
		WebElement passwordlField = driver.findElement(By.name("inputPassword"));
		WebElement tNc = driver.findElement(By.xpath("//input[@value='agreeTerms']"));
		WebElement signIn = driver.findElement(By.xpath("//button[@class='submit signInBtn']"));
		
		
		emailField.sendKeys("Admin");
		passwordlField.sendKeys("Admin");
		tNc.click();
		signIn.click();
		
		
		WebElement error = driver.findElement(By.cssSelector("p[class='error']"));
		System.out.println(error.getText());
		
		driver.quit();
		
		
		
		

	}

}
