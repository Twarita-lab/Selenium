package seleniumStepBystep;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdowns {

	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		//Auto SUggestive dropdowns
		String option="India";
		autoSuggestiveDropdown(driver, option);
					
		int noOfAdults=2;
		int noOfChild=1;
		int noOfInfant=1;
		DropdownAndCounter(driver, noOfAdults, noOfChild, noOfInfant);
		
		// Static drop down with select
		staticSelect(driver);
		
		//Dynamic drop down
				String DepartureCity="PNQ";
				String ArrivalCity = "BKK";
				dynamicDropdown(driver, DepartureCity, ArrivalCity);
		
		//driver.quit();

	}

	private static void autoSuggestiveDropdown(WebDriver driver, String option) throws Exception {
		driver.findElement(By.cssSelector("input[id='autosuggest']")).sendKeys("in");;
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='"+option+"']")).click();
		
	}

	private static void dynamicDropdown(WebDriver driver, String departureCity, String arrivalCity) throws Exception {
		// TODO Auto-generated method stub
		driver.findElement(By.cssSelector("input[value='Departure City']")).click();
		driver.findElement(By.cssSelector("a[value='"+departureCity+"']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='"+arrivalCity+"']")).click();
		
		
	}

	private static void DropdownAndCounter(WebDriver driver, int noOfAdults, int noOfChild, int noOfInfant) throws Exception {

		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
		
		int adult=1;
		while(adult<noOfAdults) {
			driver.findElement(By.id("hrefIncAdt")).click();
			adult++;
		}
		
		int child=0;
		while(child<noOfChild) {
			driver.findElement(By.id("hrefIncChd")).click();
			child++;
		}
		
		int infant=0;
		while(infant<noOfInfant) {
			driver.findElement(By.id("hrefIncInf")).click();
			infant++;
		}
		
	}

	
	private static void staticSelect(WebDriver driver) {
		Select staticDropdown = new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
		staticDropdown.selectByIndex(3);
		System.out.println(staticDropdown.getFirstSelectedOption().getText());

		staticDropdown.selectByValue("INR");
		System.out.println(staticDropdown.getFirstSelectedOption().getText());

		staticDropdown.selectByVisibleText("AED");
		System.out.println(staticDropdown.getFirstSelectedOption().getText());
		
		
	}

}
