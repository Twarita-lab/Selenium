package interviewQuestions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//Cognizant Kolkata Tech 1 interview question Jan 11 2025
public class Switch_Window_Only_If_Not_ParentWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/windows");
		
		WebElement childWindowLink = driver.findElement(By.xpath("//h3[text()='Opening a new window']/following-sibling::a"));
		childWindowLink.click();
		
		String parentWindow = driver.getWindowHandle();
		System.out.println("Parent window's hndle is "+parentWindow);
		System.out.println("Parent window's Title is "+driver.getTitle());
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		
		while(it.hasNext()) {
			String windowHandle = it.next();
			if(!windowHandle.equals(parentWindow)) {
				driver.switchTo().window(windowHandle);
				System.out.println("Parent window's hndle is "+windowHandle);
				System.out.println("Parent window's Title is "+driver.getTitle());
				
				
			}
		}
		
		driver.quit();
	}

}
