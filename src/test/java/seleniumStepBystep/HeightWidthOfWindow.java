package seleniumStepBystep;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HeightWidthOfWindow {

	public static void main(String[] args) throws Exception {

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");

		WebElement name = driver.findElement(By.cssSelector("div.form-group label"));

		// Height of WebElement
		System.out.println(name.getRect().height);
		System.out.println(name.getRect().getHeight());
		System.out.println(name.getRect().getDimension().getHeight());
		System.out.println(name.getRect().getDimension().height);

		// Weidth of WebElement
		System.out.println(name.getRect().getWidth());
		System.out.println(name.getRect().width);
		System.out.println(name.getRect().getDimension().getWidth());
		System.out.println(name.getRect().getDimension().width);

		// Y axis position of webElement
		System.out.println(name.getRect().y);
		System.out.println(name.getRect().getY());

		// Position of WebElement X and Y axis
		System.out.println(name.getRect().getPoint());
		System.out.println(name.getRect().getX());

		driver.quit();
	}

}
