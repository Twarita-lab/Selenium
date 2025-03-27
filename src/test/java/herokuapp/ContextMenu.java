package herokuapp;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;



public class ContextMenu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BaseTest b = new BaseTest();
		WebDriver driver = b.launchHerokuApp();
		b.getLinkElement(driver).get(6).click();
		
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.id("hot-spot"))).contextClick().build().perform();
		
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals(alert.getText(), "You selected a context menu");
		alert.accept();
		
		b.tearDown(driver);

	}

}
