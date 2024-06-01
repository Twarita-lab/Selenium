package Twarita.Selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.base.Verify;

public class Add_Remove_Elements {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
		
		WebElement addElement = driver.findElement(By.tagName("button"));
		addElement.click();
		

		WebElement deleteElement = driver.findElement(By.xpath("//button[text()='Delete']"));
		
		Verify.verify(deleteElement.isDisplayed());
		deleteElement.click();
		
		List<WebElement> buttons = driver.findElements(By.tagName("button"));
		Verify.verify(buttons.size()==1);
		
		driver.quit();

	}

}
