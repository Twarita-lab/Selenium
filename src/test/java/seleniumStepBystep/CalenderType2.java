package seleniumStepBystep;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalenderType2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		
		String year="2025";
		String month = "11";
		String day = "24";
		
		CalenderType2 calendar2 = new CalenderType2();
		
		
		WebElement yearTextBox = driver.findElement(By.xpath("//input[@name='year']"));
		String yearTextBoxValue = yearTextBox.getAttribute("value");
		
		WebElement dayTextBox = driver.findElement(By.xpath("//input[@name='day']"));
		String dayTextBoxValue = dayTextBox.getAttribute("value");
		
		WebElement monthTextBox = driver.findElement(By.xpath("//input[@name='month']"));
		String monthTextBoxValue = monthTextBox.getAttribute("value");
		String monthText = calendar2.getMonthEquivalent(driver, month);
		
		if(yearTextBoxValue.equals(year) && dayTextBoxValue.equals(day) && monthTextBoxValue.equals(month)) {
			System.out.println("Correct date is selected");
			
			}
		else if(yearTextBoxValue.equals(year) && monthTextBoxValue.equals(month)) {
			System.out.println("Correct day needs to be is selected");
			dayTextBox.click();
			calendar2.daySelector(driver, year, monthText, day);
			
			}
		else if(yearTextBoxValue.equals(year)) {
			System.out.println("Correct month and day needs to be is selected");
			monthTextBox.click();
			calendar2.monthSelector(driver, monthText);
			System.out.println("Correct month is selected. Now day needs to be is selected");
			calendar2.daySelector(driver, year, monthText, day);
			
			}
		else {
			System.out.println("Correct year, month and day needs to be is selected");
			monthTextBox.click();
			calendar2.yearSelector(driver, year);
			
			calendar2.monthSelector(driver, monthText);
			System.out.println("Correct month is selected. Now day needs to be is selected");
			calendar2.daySelector(driver, year, monthText, day);
		}
		//driver.quit();
	}

	private void yearSelector(WebDriver driver, String year) throws Exception {
		WebElement dateHeader = driver.findElement(By.cssSelector("span.react-calendar__navigation__label__labelText"));
		String dateHeaderYear = dateHeader.getText().split(" ")[1];
		dateHeader.click();
		Thread.sleep(1000);
		dateHeader.click();
		List<WebElement> years = driver.findElements(By.cssSelector("button.react-calendar__decade-view__years__year"));
		for(WebElement yearElement:years) {
			String yearText = yearElement.getText();
			if(yearText.equalsIgnoreCase(year))
				{
					yearElement.click();
					break;
				}
			else {
				
			}
		}
		
	}

	private String getMonthEquivalent(WebDriver driver, String month) {
		String monthText="January";
		if(month.equals("01"));
		else if(month.equals("02")) monthText="February";
		else if(month.equals("03")) monthText="March";
		else if(month.equals("04")) monthText="April";
		else if(month.equals("05")) monthText="May";
		else if(month.equals("06")) monthText="June";
		else if(month.equals("07")) monthText="July";
		else if(month.equals("08")) monthText="August";
		else if(month.equals("09")) monthText="September";
		else if(month.equals("10")) monthText="October";
		else if(month.equals("11")) monthText="November";
		else if(month.equals("12")) monthText="December";
		else System.out.println("Incorrect Month value. Please update month value");
		return monthText;
	}

	private void monthSelector(WebDriver driver, String monthText) {
		// TODO Auto-generated method stub
		String monthHeaderText="To be checked";
		while(!monthHeaderText.equalsIgnoreCase(monthText)) {
			WebElement nextArrow = driver.findElement(By.cssSelector("button.react-calendar__navigation__next-button"));
			nextArrow.click();
			
			WebElement monthHeader = driver.findElement(By.cssSelector("span.react-calendar__navigation__label__labelText"));
			monthHeaderText = monthHeader.getText().split(" ")[0];
		}
		
	}

	private void daySelector(WebDriver driver, String year, String monthText, String day) {
		// TODO Auto-generated method stub
		List<WebElement> dayElements = driver.findElements(By.cssSelector("button.react-calendar__month-view__days__day abbr"));
		for(WebElement dayElement:dayElements) {
			String[] calendarDate = dayElement.getAttribute("aria-label").split(" ");
			if(calendarDate[2].equalsIgnoreCase(year) && calendarDate[0].equalsIgnoreCase(monthText) && calendarDate[1].contains(day)) {
				dayElement.click();
				break;
		}
		}
		
		
	}

}
