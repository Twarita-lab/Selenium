package seleniumStepBystep;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class WebTableSorting_JavaStreams {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		driver.findElement(By.cssSelector("span.sort-icon")).click();
		
		List<WebElement> itemList = driver.findElements(By.xpath("//table[@class='table table-bordered']//td[1]"));
		
		List<String> itemNameList = itemList.stream().map(i->i.getText()).collect(Collectors.toList());
		System.out.println(itemNameList);
		List<String> itemNameListSorted = itemNameList.stream().sorted().collect(Collectors.toList());
		Assert.assertEquals(itemNameList, itemNameListSorted);

//Extracting price of specified veggie
  //Process 1
		itemList.stream().forEach(a->{
			if(a.getText().equalsIgnoreCase("Banana")) {
				System.out.println("price of "+a.getText()+" is "
						+a.findElement(By.xpath("following-sibling::td")).getText());
				
			}
		});
		
	//Process 2
		itemList.stream().filter(a->(a.getText()).equalsIgnoreCase("banana"))
			.forEach(a->System.out.println(
					"price of "+a.getText()+" is "
							+a.findElement(By.xpath("following-sibling::td")).getText()));
		
	//Process 3	
		for(WebElement item:itemList) {
			String itemName = item.getText();
			if(itemName.equalsIgnoreCase("Banana")) {
				System.out.println("price of "+itemName+" is "
						+item.findElement(By.xpath("following-sibling::td")).getText());
				break;
			}
		}
		
		driver.quit();
	}

}
