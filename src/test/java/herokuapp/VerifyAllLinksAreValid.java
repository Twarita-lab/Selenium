package herokuapp;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.WebDriver;

public class VerifyAllLinksAreValid extends BaseTest{
	
	
	public static void main(String[] args) throws MalformedURLException, IOException {
		
		BaseTest base = new BaseTest();
		WebDriver driver=base.launchHerokuApp();
		
		base.getLinkName(driver).stream().forEach(a->System.out.println(a));
		
		List<String> links = base.getLinkURL(driver);
		for(String link: links) {
			HttpURLConnection url = (HttpURLConnection)(new URL(link)).openConnection();
			url.connect();
			if(url.getResponseCode()>=400) {
				System.out.println(link+ " is not valid");
			}
			//else System.out.println(link+ " is valid");
		}
		base.tearDown(driver);
	}

}
