package day8;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class practice {
	public static void  demo() {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/popup.php");
		String title=driver.getTitle();
		driver.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();
		Set<String> ids=driver.getWindowHandles();
		for(String id: ids) {
			System.out.println(id);
		}
		Iterator<String> it = ids.iterator();
		String id1=it.next();
		String id2=it.next();
		driver.switchTo().window(id2);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("irada@gmail.com");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		String userId=driver.findElement(By.xpath("//td[contains(text(),'mn')]")).getText();
		String password=driver.findElement(By.xpath("//td[contains(text(),'Pass')]/following-sibling::td")).getText();
		System.out.println("user id is: "+userId+"password is: "+password);
		String text =driver.findElement(By.xpath("//h3[contains(text(),'This')]")).getText();
		if(text.equals("This access is valid only for 20 days.")) {
			System.out.println("text test pass");
		}else {
			System.out.println("text test fails");
		}
		driver.close();
	
		driver.switchTo().window(id1);
		if(driver.getTitle().equals(title)){
			System.out.println("test pass");
		}else {
			System.out.println("test fail");
		}
		
	}
	
	public static void demo2() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get("http://practice.primetech-apps.com/practice/frames");
		String header=driver.findElement(By.xpath("//h3[contains(text(),'Frames')]")).getText();			
		if(header.equals("Frames")) {
			System.out.println("header verification is pass");
		}else {
			System.out.println("header verification is fail");
		}
		driver.switchTo().frame(driver.findElement(By.id("iframe1")));
		driver.findElement(By.id("firstName")).sendKeys("Ira");
		driver.findElement(By.id("lastName")).sendKeys("Parhat");
		driver.findElement(By.id("address")).sendKeys("26 Ave");
		driver.findElement(By.id("city")).sendKeys("Vancouver");
		WebElement elm=driver.findElement(By.id("state"));
		//elm.click();
		Select select=new Select(elm);
		select.selectByVisibleText("Alaska");
		driver.findElement(By.id("zipCode")).sendKeys("99501");
		//Actions action=new Actions(driver);
		//action.moveToElement(driver.findElement(By.id("female"))).build().perform();
		//WebElement radioButton=driver.findElement(By.id("female"));
		
		//radioButton.isEnabled();
	
		//action.doubleClick(radioButton).perform();
		//System.out.println(radioButton.isSelected());
		//driver.findElement(By.id("gridCheck")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
		Thread.sleep(1000);
		WebElement message=driver.findElement(By.xpath("//h3[contains(text(),\"You have submited below information:\")]"));
		if(message.isDisplayed()) {
			System.out.println("test pass");
		}else {
			System.out.println("test fail");
		}
		driver.switchTo().defaultContent();
		
		
	}

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","/Users/sheralie/Dropbox/My Mac (Iradas-MacBook-Air.local)/Desktop/In Class Activity/SleniumTools/ChromeDriver/chromedriver");	
		
		practice guru=new practice();
		//guru.demo();
		guru.demo2();
	}

}
