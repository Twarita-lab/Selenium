package seleniumStepBystep;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowManagement {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		
		driver.manage().window().fullscreen(); 
		System.out.println(driver.manage().window().getPosition());
		System.out.println(driver.manage().window().getSize());
		
		System.out.println(driver.manage().window().hashCode());
		
		
		  WebDriver driver1 = new ChromeDriver();
		  driver1.get("https://www.google.com");
		  
		  driver1.manage().window().maximize();
		  
		  driver1.manage().window().minimize();
		 
		  Point point = new Point(100,200);
		  driver1.manage().window().setPosition(point);
		  
		  Dimension dimenstion=new Dimension(1,1000);
		  driver.manage().window().setSize(dimenstion);
		  
		 System.out.println(driver.manage().window().toString());
	
		driver1.close();
		 driver.quit();
	}

}
