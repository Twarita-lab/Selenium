package herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import org.junit.Assert;

public class VerifyElementDisplay {

	public static void main(String[] args) {

		BaseTest b = new BaseTest();
		WebDriver driver = b.launchHerokuApp();

		WebElement addRemoveElement = driver.findElement(By.cssSelector("li:nth-child(2) a"));
		addRemoveElement.click();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(2));

		WebElement addEle = driver.findElement(By.tagName("button"));
		addEle.click();

		WebElement deleteEle = driver.findElement(By.cssSelector("[onclick*='delete']"));
		Assert.assertTrue(deleteEle.isDisplayed());

		deleteEle.click();

		Assert.assertTrue(driver.findElements(By.cssSelector("[onclick*='delete']")).size()==0);
		
		b.tearDown(driver);

	}

}
