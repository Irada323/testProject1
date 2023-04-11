package day9;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import utils.Driver;

public class etsy {
	public static void demo() throws AWTException, InterruptedException {
		//WebDriver driver=new ChromeDriver();
		Driver.getDriver().manage().window().maximize();
		Driver.getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		Driver.getDriver().get("https://www.etsy.com/");
		
		Actions act=new Actions(Driver.getDriver());
		WebElement elm=Driver.getDriver().findElement(By.id("catnav-primary-link-10855"));
		act.moveToElement(elm).build().perform();
		Thread.sleep(1000);
		//Select select= new Select(elm);
		
		WebElement elm2=Driver.getDriver().findElement(By.xpath("(//span[contains(text(),'Bags & Purses')])[1]"));
		
	
		act.moveToElement(elm2).build().perform();
		Thread.sleep(1000);
		
		WebElement elm3=(Driver.getDriver().findElement(By.id("[id='catnav-l3-10867']")));
		act.moveToElement(elm3).build().perform();
		Thread.sleep(1000);
		elm3.click();
		Thread.sleep(1000);
		
		
	}
	public static void dragandDrop() {
		//WebDriver driver=new ChromeDriver();
		//Driver.driver.manage().window().maximize();
		//Driver.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		Actions act=new Actions(Driver.getDriver());
		Driver.getDriver().get("http://practice.primetech-apps.com/");
		WebElement sourse=Driver.getDriver().findElement(By.id("text"));
		WebElement target=Driver.getDriver().findElement(By.id("dropzone"));
		act.dragAndDrop(sourse, target).build().perform();
	   // Driver.quitDriver();
		
		
	}

	public static void main(String[] args) throws AWTException, InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"/Users/sheralie/Dropbox/My Mac (Iradas-MacBook-Air.local)/Desktop/In Class Activity/SleniumTools/ChromeDriver/chromedriver");	
		etsy e=new etsy();
		//e.demo();
		e.dragandDrop();
		

	}

}
