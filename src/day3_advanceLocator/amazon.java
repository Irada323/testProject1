package day3_advanceLocator;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class amazon {

	public static void main(String[] args) {
System.setProperty("webdriver.chrome.driver","/Users/sheralie/Dropbox/My Mac (Iradas-MacBook-Air.local)/Desktop/In Class Activity/SleniumTools/ChromeDriver/chromedriver");	
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.navigate().to("https://amazon.com");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Coffee Mug");
		driver.findElement(By.id("nav-search-submit-button")).click();
	    driver.navigate().back();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("pretty coffee mug");
		driver.findElement(By.id("nav-search-submit-button")).click();
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
		
	}

}
