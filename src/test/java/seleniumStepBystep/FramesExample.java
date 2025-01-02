package seleniumStepBystep;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FramesExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.manage().window().maximize();
		Wait<WebDriver> explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));
		Actions action = new Actions(driver);
		
		//To get number of frames
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		
		//Switch to Frame
		driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));
		
		WebElement sourceElement = driver.findElement(By.cssSelector("div#draggable"));
		WebElement targetElement = driver.findElement(By.cssSelector("div#droppable"));
		action.dragAndDrop(sourceElement, targetElement).build().perform();
		
		
		//Switch to main page
		driver.switchTo().defaultContent();
		System.out.println(driver.findElement(By.tagName("h1")).getText());;
		
		driver.quit();
		
	}

}
