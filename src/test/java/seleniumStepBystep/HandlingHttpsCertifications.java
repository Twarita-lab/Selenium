package seleniumStepBystep;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class HandlingHttpsCertifications {

	public static void main(String[] args) {
		
		ChromeOptions optionsC = new ChromeOptions();
		optionsC.setAcceptInsecureCerts(true);
		
		FirefoxOptions optionsF = new FirefoxOptions();
		optionsF.setAcceptInsecureCerts(true);
		
		EdgeOptions optionsE = new EdgeOptions();
		optionsE.setAcceptInsecureCerts(true);
		
		ChromeDriver driver = new ChromeDriver(optionsC);
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());
		driver.quit();
        
        FirefoxDriver driverF = new FirefoxDriver(optionsF);		
		driverF.get("https://expired.badssl.com/");
		System.out.println(driverF.getTitle());
		driverF.quit();
        
		EdgeDriver driverE = new EdgeDriver(optionsE);		
		driverE.get("https://expired.badssl.com/");
		System.out.println(driverE.getTitle());
		driverE.quit();
        
		driver.quit();
	}

}
