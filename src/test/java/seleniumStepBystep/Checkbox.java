package seleniumStepBystep;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Checkbox {

	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		WebElement friendsandfamilyCheckBox = driver.findElement(By.cssSelector("input[id*='friendsandfamily']"));
				friendsandfamilyCheckBox.click();
				System.out.println(friendsandfamilyCheckBox.isSelected());
				
				//driver.quit();
		
	}
}
