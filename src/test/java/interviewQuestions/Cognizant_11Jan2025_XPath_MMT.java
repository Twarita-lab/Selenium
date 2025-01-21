package interviewQuestions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Cognizant_11Jan2025_XPath_MMT {

	public static void main(String[] args) throws Exception {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		
		
		WebElement closePopup = driver.findElement(By.cssSelector("span.commonModal__close"));
		closePopup.click();
		Thread.sleep(1000);
		
		//Write xPath for selecting special fare radio button using typeOfPax text
		String typeOfPaxForPromo = "Student";
		WebElement promoRadioBtn = driver.findElement
				(By.xpath("//div[text()='"+typeOfPaxForPromo+"']//ancestor::div[@class='fareCardItem ']//span"));
		String radiButtonStyle = promoRadioBtn.findElement(By.xpath("//ancestor::div[@class='fareCardItem ']")).getAttribute("style");
		System.out.println(radiButtonStyle);
		
		promoRadioBtn.click();
		
		Thread.sleep(2000);
		radiButtonStyle = promoRadioBtn.findElement(By.xpath("//ancestor::div[@class='fareCardItem ']")).getAttribute("style");
		System.out.println(radiButtonStyle);
		
		if(radiButtonStyle.contains("background-color: rgb(255, 255, 255); border-color: rgb(216, 216, 216)")) System.out.println("Pass");
		else System.out.println(radiButtonStyle);
		
		// style when not selected - background-color: rgb(234, 245, 255); border-color: rgb(0, 140, 255);
		//style when selected - background-color: rgb(255, 255, 255); border-color: rgb(216, 216, 216);
		
		
		
		//Write xPath for selecting date from calendar based on integer date
		String month="Jan";
		int date = 22;
		
		WebElement dateCalendar = driver.findElement(By.cssSelector("label[for='departure']"));
		dateCalendar.click();
		
		Thread.sleep(2000);
		WebElement dateTobeSelected = driver.findElement
				(By.xpath("//div[contains(text(),'"+month+"')]/parent::div//following-sibling::div//p[text()='"+date+"']"));
		dateTobeSelected.click();
		
		List<WebElement> selectedDate = driver.findElements(By.xpath("//p[@data-cy='departureDate']/span"));
		for(int i=0; i<selectedDate.size(); i++) {
			System.out.println(selectedDate.get(i).getText());
		}
		Assert.assertEquals(selectedDate.get(1).getText(), month);
		
		Assert.assertEquals(selectedDate.get(0).getText(), Integer.toString(date));
		
		driver.quit();
		

	}

}
