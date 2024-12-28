package locators;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class relativeLocator_ {
	
	public static void main(String[] args) {
				WebDriver driver = new ChromeDriver();
	            driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
	           	            
	           WebElement pageSize = driver.findElement(By.id("page-menu"));
	           
	           System.out.println(  driver.findElement(with(By.tagName("label")).below(pageSize)).getText());
	           
	           System.out.println(driver.findElement(with(By.tagName("label")).toLeftOf(pageSize)).getText());
	           
	           System.out.println(driver.findElement(with(By.tagName("a")).toRightOf(pageSize)).getText());
	           
	          System.out.println(driver.findElement(with(By.tagName("label")).above(By.cssSelector("label[for='search-field']"))).getText()); 
	           
	           driver.quit();
	            
	            
	            
}
}

