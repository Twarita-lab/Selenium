package seleniumStepBystep;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TableScrolling {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=500");
		
		
		List<WebElement> prices = driver.findElements(By.xpath("//div[@class='tableFixHead']//td[4]"));
		int total=0;
		for(WebElement price:prices) {
			total = total+Integer.parseInt(price.getText());
		}
		int ActualTotalPrice =Integer.parseInt(driver.findElement(By.cssSelector("div.totalAmount")).getText().split(": ")[1]);
     Assert.assertEquals(total, ActualTotalPrice);
     
	}

}
