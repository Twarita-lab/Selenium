package seleniumStepBystep;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HttpsAuthentication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		System.out.println(driver.getTitle());
		
		WebElement pageContent = driver.findElement(By.cssSelector(".example"));
		System.out.println(pageContent.getText());
		driver.quit();

	}

}
