package seleniumStepBystep;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class Pagination_WebTable_JavaStreams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		List<WebElement> rightVeggieName;
		
		do {
			List<WebElement> veggieNames = driver.findElements(By.xpath("//div[@class='products']//td[1]"));
			rightVeggieName = veggieNames.stream().filter(a->a.getText().equalsIgnoreCase("Chocolate")).collect(Collectors.toList());
			
			if(rightVeggieName.size()==1) {
				rightVeggieName.forEach(a->
						System.out.println("Price of "+a.getText() +" is "
								+a.findElement(By.xpath("following-sibling::td")).getText()));
			    driver.quit();
			      
			}
			else driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
			
	}
		while(rightVeggieName.size()==0);
		
		

	}
}
