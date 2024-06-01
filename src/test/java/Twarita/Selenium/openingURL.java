package Twarita.Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class openingURL {
	
	public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	driver.get("https://the-internet.herokuapp.com/");

}
}
