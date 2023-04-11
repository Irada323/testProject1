package day1_SeleniumLaunch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class day1_Selenium {

	
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/sheralie/Dropbox/My Mac (Iradas-MacBook-Air.local)/Desktop/In Class Activity/SleniumTools/ChromeDriver/chromedriver");

		WebDriver driver =new ChromeDriver();
		driver.get("https://amazon.com");
		System.out.println("home page title: "+ driver.getTitle());
		System.out.println("home page url is: "+ driver.getCurrentUrl());
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Coffee mug");
		driver.findElement(By.id("nav-search-submit-button")).click();
		driver.findElement(By.linkText("Customer Service")).click();
		
		
		
		
		Thread.sleep(2000);
		driver.close();
		
	}

}
