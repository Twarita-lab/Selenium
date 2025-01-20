package funProjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MovingThroughAllTableCells {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://github.com/Twarita-lab/IssuesAndSolutions/wiki/InterviewQuestionSet_8YOE_2025");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		WebElement table = driver.findElement(By.cssSelector("table[role='table']"));
		List<WebElement> tableRows = table.findElements(By.cssSelector(" tr"));
		List<WebElement> tableHeaders = tableRows.get(0).findElements(By.cssSelector(" th"));

		int colNo = tableHeaders.size();
		ArrayList<String> columnHeader = new ArrayList<>();

		for (int i = 0; i < colNo; i++) {
			columnHeader.add(tableHeaders.get(i).getText());
		}

		for (int i = 1; i < tableRows.size(); i++) {
			List<WebElement> tableCol = tableRows.get(i).findElements(By.cssSelector(" td"));
			System.out.println("Data of row no " + i + " is - ");
			for (int j = 0; j < colNo; j++) {
				System.out.println("Value of " + columnHeader.get(j) + " is " + tableCol.get(j).getText());
			}

		}
		
		driver.quit();

	}

}
