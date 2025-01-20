package interviewQuestions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelectSecondCheckbox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/checkboxes");

		List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
		checkboxes.get(0).click();
		
		System.out.println(driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]")).isSelected());
		
		driver.quit();
		

	}

}
