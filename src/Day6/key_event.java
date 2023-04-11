package Day6;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class key_event {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","/Users/sheralie/Dropbox/My Mac (Iradas-MacBook-Air.local)/Desktop/In Class Activity/SleniumTools/ChromeDriver/chromedriver");	
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//driver.manage().window().fullscreen();
		driver.manage().window().maximize();
		driver.navigate().to("https://google.com");
		WebElement searchBox=driver.findElement(By.name("q"));
		//driver.get("http://google.ca");
		searchBox.sendKeys("Coffee mugs"+ Keys.ENTER);
		WebElement newSearchBox=driver.findElement(By.name("q"));
		newSearchBox.clear();
		newSearchBox.sendKeys("Selenium Web driver"+ Keys.ENTER);
		driver.navigate().back();
		driver.navigate().forward();
		Thread.sleep(1000);
		driver.navigate().refresh();
		driver.close();
		

	}

}
