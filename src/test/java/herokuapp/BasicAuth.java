package herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class BasicAuth {

	public static void main(String[] args) {
		BaseTest b = new BaseTest();
		WebDriver driver = b.launchHerokuApp();

		SoftAssert softAssert = new SoftAssert();
		driver.findElement(By.xpath("//a[text()='Basic Auth']")).click();
		softAssert.assertNull((driver.findElements(By.cssSelector("div.example"))));
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		softAssert.assertEquals(driver.findElement(By.cssSelector("div.example")).getText(),
				"Basic Auth\r\n" + "Congratulations! You must have the proper credentials.");

		System.out.println(driver.findElement(By.cssSelector("div.example")).getText());

		driver.quit();
		softAssert.assertAll();

	}

}
