package seleniumStepBystep;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calendar {
	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.findElement(By.cssSelector("button.ui-datepicker-trigger")).click();
		//Select current date
		driver.findElement(By.cssSelector("a.ui-state-default.ui-state-highlight")).click();
	}
		

}
