package seleniumStepBystep;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalculateNoOfLinks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/practice-project");
		
		List<WebElement> Links = driver.findElements(By.tagName("a"));
		System.out.println("No of Links are --- "+Links.size());
		
		int noOfVisibleLinks = 0;
		for(WebElement Link:Links) {
			
			if(Link.isDisplayed()) {
				noOfVisibleLinks++;
			}
		}
		System.out.println("No of visible Links are --- "+noOfVisibleLinks);
		
		WebElement footer = driver.findElement(By.className("footer-bottom"));
		List<WebElement> footerLinks = footer.findElements(By.tagName("a"));
		
		System.out.println("No of footer Links are ---- "+	footerLinks.size());
		
		driver.quit();

}
}
