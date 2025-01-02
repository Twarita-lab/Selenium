package seleniumStepBystep;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EnabledCheck {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		System.out.println("This result is false, as interaction is not disabled in disabled mode ---- "+driver.findElement(By.cssSelector("div#Div1")).isEnabled());
		
		System.out.println("If enabled it'll return true, otherwise false ----- " +driver.findElement(By.cssSelector("div#Div1")).getAttribute("style").contains("1"));
		
		

	}

}
