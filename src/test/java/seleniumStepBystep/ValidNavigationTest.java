package seleniumStepBystep;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class ValidNavigationTest {

	public static void main(String[] args) {
		// Initiating driver
		WebDriver driver = new ChromeDriver();

		// Opening Link
		driver.get("https://www.amazon.in/");

		// Maximizing window size
		driver.manage().window().maximize();

		// Manage waiting time
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

		// Finding Links of Blockbuster delas
		List<WebElement> bbd = driver.findElements(By.cssSelector("div.d-showcase a.dcl-product-link"));

		// Clicking all deals and verifying it's redirecting to appropriate page
		Actions action = new Actions(driver);
		ArrayList<String> dealProductnames = new ArrayList<>();
		for (WebElement deal : bbd) {
			// Clicking Links in below two ways

			// action.keyDown(Keys.CONTROL).click(deal).build().perform();

			deal.sendKeys(Keys.chord(Keys.CONTROL, Keys.ENTER));

			String dealProductname = deal.findElement(By.cssSelector("span.dcl-product-label")).getText();
			dealProductnames.add((dealProductname.split(" "))[0]);
		}

		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String HomePage = it.next();
		ArrayList<String> dealProductPages = new ArrayList<>();
		while (it.hasNext()) {
			String childPage = it.next();
			String childPageTitle = driver.switchTo().window(childPage).getTitle();
			dealProductPages.add((childPageTitle.split(" "))[0]);
		}

		Assert.assertEquals(dealProductPages.size(), dealProductnames.size());
		Assert.assertTrue(dealProductPages.containsAll(dealProductnames));

		/*
		 * System.out.println(dealProductPages); System.out.println(dealProductnames);
		 * 
		 * for(String dealPageTitle: dealProductPages) { if
		 * (dealPageTitle.contains("Not Found"))
		 * System.out.println(dealPageTitle+" link is broken"); else
		 * if(dealProductnames.contains(dealPageTitle)) {
		 * System.out.println(dealPageTitle +" present in dealProductsnames");
		 * dealProductnames.remove(dealPageTitle); } else
		 * System.out.println(dealPageTitle +" --- not present in dealProductsnames"); }
		 * 
		 */

		driver.quit();
	}

}
