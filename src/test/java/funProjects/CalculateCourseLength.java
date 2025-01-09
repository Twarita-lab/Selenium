package funProjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CalculateCourseLength {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		//options.setExperimentalOption("debuggerAddress", "127.0.0.1:9222");
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://courses.rahulshettyacademy.com/courses/enrolled/1561306");

		List<WebElement> chapterLists = driver.findElements(By.xpath("//a[@class='item']"));
		int totalMinTime=0;
		int totalSecTime=0;
		
		for(WebElement chapter : chapterLists) {
			String chapterName =  chapter.getAttribute("textContent");
			String chapterNameTimeStart=chapterName.split("\\(")[1];
			String[] chapterTimeLength = chapterNameTimeStart.split(":");
			int chapterMinLength = Integer.parseInt(chapterTimeLength[0]);
			int chapterSecLength = Integer.parseInt(chapterTimeLength[1].split("[ )]")[0]);
			totalMinTime=totalMinTime+chapterMinLength;
			totalSecTime=totalSecTime+chapterSecLength;
					
		}
		int totalHrTime = (totalMinTime/60);
		
		totalMinTime = ((totalMinTime%60)+(totalSecTime/60));
		
		if(totalMinTime>60) {
			totalHrTime=totalHrTime+(totalMinTime/60);
			totalMinTime = (totalMinTime%60);
			
		}
System.out.println("Total Time is "+totalHrTime+" hr "+totalMinTime+" min");
driver.quit();
	}

}
