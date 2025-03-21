package herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.junit.Assert;

public class VerifyTextContent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BaseTest b = new BaseTest();
		WebDriver driver = b.launchHerokuApp();
		
		
		WebElement abTest = driver.findElement(By.xpath("//div[@id='content']/descendant::a[1]"));
		abTest.click();
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "The Internet");
				
		WebElement pageHeader = driver.findElement(By.cssSelector("div h3"));
		System.out.println(pageHeader.getText());
		Assert.assertTrue(pageHeader.getText().contains("A/B Test"));
		
		WebElement pageContent = driver.findElement(By.cssSelector("div p"));
		System.out.println(pageContent.getText());
		
		b.tearDown(driver);
		

	}

}
