package Day5_HW_WenElem_Locator;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WebElem {

	public static void getElem() throws InterruptedException {
		
		WebDriver driver= new ChromeDriver();
		driver.get("http://practice.primetech-apps.com/practice/check-box");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//span[':after']")).click();
		WebElement checkElm=driver.findElement(By.xpath("//button[@id='check-box']"));
		checkElm.click();
		List<WebElement> checkAlllElm=driver.findElements(By.xpath("//h3[contains(text(),'Check Box')]/following::div"));
		System.out.println("Number of the elements in the check box are: "+  checkAlllElm.size());
		
		WebElement radioElm=driver.findElement(By.xpath("//button[@id='radio-button']"));
		radioElm.click();
		List<WebElement> allRadioElm=driver.findElements(By.xpath("//div[contains(@class,'title')]/following::div"));
		System.out.println("Number of the radio elements are: "+allRadioElm.size());
		
		WebElement buttonsElm=driver.findElement(By.xpath("//button[@id='buttons']"));
	    buttonsElm.click();
	    List<WebElement> allButtonsElm=driver.findElements(By.xpath("//div[contains(@class,'title')]/child::*/following::div"));
	    System.out.println("Number of all the buttons Elements are : "+ allButtonsElm.size());
	    buttonsElm=driver.findElement(By.xpath("//button[@id='doubleClickBtn']"));
		Actions actions =new Actions(driver);
		actions.doubleClick(buttonsElm).perform();
		Thread.sleep(1000);
		
	    WebElement linkElm=driver.findElement(By.xpath("//button[@id='links']"));
	    linkElm.click();
	    List<WebElement> allLinkElm=driver.findElements(By.xpath("//div[@class='title']/following::*"));
	    System.out.println("Number of link elements are: "+ allLinkElm.size());
	    driver.findElement(By.xpath("//a[@id='amazon']")).click();
	    Thread.sleep(2000);
		driver.close();	
		
	}
	
	
	
	
	
	
	
	public static void main(String[] args) throws InterruptedException {
	
		System.setProperty("webdriver.chrome.driver","/Users/sheralie/Dropbox/My Mac (Iradas-MacBook-Air.local)/Desktop/In Class Activity/SleniumTools/ChromeDriver/chromedriver");	
		WebElem we=new WebElem();
		we.getElem();
	}

}
