package e2e_Projects;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewlyUploadedProductCanMoveToCart {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		Wait<WebDriver> explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
											.withTimeout(Duration.ofSeconds(2))
											.pollingEvery(Duration.ofMillis(100))
											.ignoring(NoSuchElementException.class);
		//This is here present just for example
		//This method is just to check if element is present in DOM
		//For visibility of element or any other type we need to customize this method
		WebElement element = fluentWait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.cssSelector("a.cart-icon"));
			}
		});

		NewlyUploadedProductCanMoveToCart obj = new NewlyUploadedProductCanMoveToCart();

		obj.addTocart(driver, obj.data());
		
		obj.moveToCartPageAndApplyPromo(driver);
		
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("promoInfo")));
		WebElement promoInfoMsg = driver.findElement(By.className("promoInfo"));
		
		System.out.println(promoInfoMsg.getText());
		
		driver.quit();
		
		
	}

	private void moveToCartPageAndApplyPromo(WebDriver driver) {
		WebElement cartIcon = driver.findElement(By.cssSelector("a.cart-icon"));
		cartIcon.click();
		
		WebElement checkOutButtonOnCartIcon = driver.findElement(By.cssSelector("div.cart-preview button"));
		checkOutButtonOnCartIcon.click();
		
		WebElement promoCodeTextBox = driver.findElement(By.className("promoCode"));
		promoCodeTextBox.sendKeys("rahulshettyacademy");
		
		WebElement promoButton = driver.findElement(By.className("promoBtn"));
		promoButton.click();
		
		
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
