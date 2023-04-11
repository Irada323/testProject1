package day8;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class sergey {

	public static void wikipedia() {

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebDriverWait wait =new WebDriverWait(driver,5);
		driver.get("https://en.wikipedia.org/wiki/Main_Page");
		driver.findElement(By.xpath("//input[@title='Search Wikipedia [ctrl-option-f]']")).sendKeys("Lionel Messi");
		driver.findElement(By.xpath("//a[@accesskey='f']")).click();
		String text=driver.findElement(By.xpath("//span[contains(text(),'Lionel Messi')]")).getText();
		System.out.println(text);
		
		

	}
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","/Users/sheralie/Dropbox/My Mac (Iradas-MacBook-Air.local)/Desktop/In Class Activity/SleniumTools/ChromeDriver/chromedriver");	
		sergey se=new sergey();
		se.wikipedia();

	}

}
