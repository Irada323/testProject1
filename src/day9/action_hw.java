package day9;

import java.sql.Driver;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class action_hw {
	// go to "http://practice.primetech-apps.com/practice/drag-and-drop"
			// Verify Drag And Drop text displays
			// drag the Text element to target window
			// drag the Textarea element to target window
			// drag the Number element to target window
			// delete all those dragged items from target window
	
	
	public  static void action() {
		WebDriver driver=new ChromeDriver();
		//driver.manage().window().maximize();
	//	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		Actions act=new Actions(driver);
		driver.get("http://practice.primetech-apps.com/practice/drag-and-drop");
		WebElement drop=driver.findElement(By.xpath("//h3[contains(text(),'Drag And Drop')]"));
		System.out.println(drop.isDisplayed());
		Actions action=new Actions(driver);
		WebElement text=driver.findElement(By.id("text"));
		WebElement textarea=driver.findElement(By.id("textarea"));
		WebElement number=driver.findElement(By.id("Number"));
		WebElement target=driver.findElement(By.id("dropzone"));
	     action.dragAndDrop(text, target).build().perform();
	     action.dragAndDrop(textarea, target).build().perform();
	     action.dragAndDrop(number, target).build().perform();
	     List<WebElement> removes=driver.findElements(By.cssSelector(".remove"));
	     for(WebElement remove: removes ) {
	    	 System.out.println(remove);
	    	 remove.click();
	     }
	     
	     
		
		
	}
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","/Users/sheralie/Dropbox/My Mac (Iradas-MacBook-Air.local)/Desktop/In Class Activity/SleniumTools/ChromeDriver/chromedriver");	
		action_hw act=new action_hw();
         act.action();
	}

}
