package da2_SeleniumActivity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Etsy_Activity {

	
	public void etsyActivity() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.etsy.com/");
		driver.findElement(By.xpath("//*[@id=\"gnav-header-inner\"]/div[4]/nav/ul/li[1]/button")).click();
		driver.findElement(By.name("email")).sendKeys("automation");
		driver.findElement(By.name("password")).sendKeys("automation");
		driver.findElement(By.name("submit_attempt")).click();
		Thread.sleep(2000);
		driver.close();		
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/Users/sheralie/Dropbox/My Mac (Iradas-MacBook-Air.local)/Desktop/In Class Activity/SleniumTools/ChromeDriver/chromedriver" );
		Etsy_Activity ea =new Etsy_Activity();
	    ea.etsyActivity();
		
	}

}
