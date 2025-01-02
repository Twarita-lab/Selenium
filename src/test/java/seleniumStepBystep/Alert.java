package seleniumStepBystep;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		String text = "Twarita";
		WindowAlert(driver, text);
		
	}

	private static void WindowAlert(WebDriver driver, String text) {
		// TODO Auto-generated method stub
		driver.findElement(By.cssSelector("input#name")).sendKeys(text);
		
		//Click on button to get Alert 1
		driver.findElement(By.cssSelector("input#alertbtn")).click();
		 org.openqa.selenium.Alert Alert1 = driver.switchTo().alert();
		//Grab text of the alert
		 System.out.println(Alert1.getText().contains(text));
		 //Accept the Alert
		 Alert1.accept();
		 
		//Click on button to get Alert 2
		 driver.findElement(By.cssSelector("input#name")).sendKeys(text);
		driver.findElement(By.cssSelector("input#confirmbtn")).click();

		org.openqa.selenium.Alert Alert2 = driver.switchTo().alert();
			//Grab text of the alert
			 System.out.println(Alert2.getText().contains(text));
			//Dismiss the Alert
			 Alert2.dismiss();
			 
			 driver.quit();
		
	}

}
