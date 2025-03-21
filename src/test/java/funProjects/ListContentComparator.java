package funProjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ListContentComparator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get(
				"https://www.goclasses.in/courses/GATE-CSE--DA-Complete-Course-Combo-65cccbdae4b0d6798976d67f#tableofcontents");
		driver.findElement(By.xpath("//a[contains(text(),'Content')]")).click();
		List<WebElement> CSEDAEleList = driver.findElements(By.cssSelector("div#courseslist span.text-dark"));
		ArrayList<String> CSEDAList = new ArrayList<>();
		for (WebElement subject : CSEDAEleList) {
			String subjectName = subject.getText();
			if (!subjectName.contains("PYQs")) {
				if (subjectName.contains("GATE DA")) {
					if (subjectName.contains("for"))
						subjectName = subjectName.replace("for GATE DA", "");
					else if (subjectName.contains("("))
						subjectName = subjectName.replace("(GATE DA)", "");
					else
						subjectName = subjectName.replace("GATE DA", "");
				}

				CSEDAList.add(subjectName.trim());
			}
		}

		driver.get(
				"https://www.goclasses.in/courses/GATE-CSE-Complete-Course-635e946de4b08e8c9d8b1aac#tableofcontents");
		driver.findElement(By.xpath("//a[contains(text(),'Content')]")).click();
		List<WebElement> CSEEleList = driver.findElements(By.cssSelector("div#courseslist span.text-dark"));
		ArrayList<String> CSEList = new ArrayList<>();
		for (WebElement subject : CSEEleList) {
			String subjectName = subject.getText();
			if (!subjectName.contains("PYQs")) {
				CSEList.add(subjectName.trim());
			}
		}

		System.out.println("CSE DA courses are \n" + CSEDAList);
		System.out.println("CSE courses are \n" + CSEList);

		CSEDAList.removeAll(CSEList);

		System.out
				.println(CSEDAList.size() + " number of courses are extra. The Extra courses of DA are \n" + CSEDAList);

		driver.quit();

	}

}
