package seleniumStepBystep;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Waits {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();

		Waits obj = new Waits();

		obj.addTocart(driver, obj.data());

		//driver.quit();

	}

	public void addTocart(WebDriver driver, String[] products) {
		List<WebElement> productName = driver.findElements(By.cssSelector("h4.product-name"));

		int count = 0;
		List<String> productsList = Arrays.asList(products);

		for (int i = 0; i < productName.size(); i++) {
			String currentProductName = (productName.get(i).getText().split(" "))[0];
			if (productsList.contains(currentProductName)) {
				WebElement addToCartButton = productName.get(i).findElement(By.xpath("following-sibling::div/button"));
				addToCartButton.click();
				count++;
				if (count == products.length)
					break;
			}
		}
	}

	public String[] data() {
		// TODO Auto-generated method stub
		String[] products = { "Brocolli", "Beans", "Banana", "Walnuts" };
		return products;
	}

}
