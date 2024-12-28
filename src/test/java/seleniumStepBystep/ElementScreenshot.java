package seleniumStepBystep;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementScreenshot {

	public static void main(String[] args) throws Exception {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
				
		WebElement name = driver.findElement(By.cssSelector("div.form-group label"));
		File fs = name.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(fs, new File("elementScreenshot.png"));
				
		
		driver.quit();
	}

}
