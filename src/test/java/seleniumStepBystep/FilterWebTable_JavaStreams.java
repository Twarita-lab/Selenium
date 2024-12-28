package seleniumStepBystep;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class FilterWebTable_JavaStreams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
            WebDriver driver = new ChromeDriver();
            driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
            SoftAssert a = new SoftAssert();
            
            String exactSearchItemName = "cherry";
            String twoInitialsSearchItemName = "Ch";
            String InitialsSearchItemName = "a";
            String inValidData = "veggie";
             
            
            WebElement searchBox = driver.findElement(By.cssSelector("input#search-field"));
            
            searchBox.sendKeys(exactSearchItemName);
            String returnedResult = driver.findElement(By.tagName("td")).getText();
            a.assertTrue(returnedResult.equalsIgnoreCase(exactSearchItemName), "exact search result matchs");
            
            searchBox.clear();
            
            searchBox.sendKeys(twoInitialsSearchItemName);
            List<WebElement> returnedResultList = driver.findElements(By.xpath("//td[1]"));
            System.out.println(returnedResultList.size());
            List<String> filteredList = returnedResultList.stream()
            		.map(s->s.getText().toLowerCase()).filter(s->s.startsWith(twoInitialsSearchItemName.toLowerCase())).collect(Collectors.toList());
            System.out.println(filteredList.size());
            a.assertEquals(returnedResultList.size(), filteredList.size());
            
            searchBox.clear();
            
            
            searchBox.sendKeys(InitialsSearchItemName);
            List<String> returnedResultList2 = new ArrayList<String>();
            WebElement nextButton;
            
            do {
            	List<WebElement> rR = driver.findElements(By.xpath("//td[1]"));
            	 returnedResultList2.addAll(rR.stream().map(s->s.getText()).collect(Collectors.toList()));  
            	nextButton = driver.findElement(By.xpath("//a[@aria-label='Next']"));
            	
            	if(nextButton.getAttribute("aria-disabled").equalsIgnoreCase("false")) nextButton.click();
            	               
            }
            while(nextButton.getAttribute("aria-disabled").equalsIgnoreCase("false"));
            
            
            System.out.println(returnedResultList2.size());
            List<String> filteredList2 = returnedResultList2.stream()
            		.map(s->s.toLowerCase()).filter(s->s.contains(InitialsSearchItemName.toLowerCase())).collect(Collectors.toList());
            System.out.println(filteredList2.size());
            a.assertEquals(returnedResultList2.size(), filteredList2.size());
           
            searchBox.clear();
            searchBox.sendKeys(inValidData);
            a.assertTrue(driver.findElement(By.tagName("td")).getText().equals("No data"));
            
           a.assertAll();
            driver.quit();
            
		
	}

}
