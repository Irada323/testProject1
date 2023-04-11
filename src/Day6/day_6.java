package Day6;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Day5_HW_WenElem_Locator.WebElem;

public class day_6 {
	
	public static void getElm() {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.navigate().to("https://saucedemo.com");
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
		List<WebElement> items=driver.findElements(By.cssSelector(".inventory_item"));
		int listSize=items.size();
		System.out.println(listSize);
		List<WebElement> itemPrices=driver.findElements(By.cssSelector(".inventory_item_price"));
		/*List<WebElement> webElm=driver.findElements(By.xpath("//div[contains(text(),'$')]"));
		System.out.println(webElm.size());
		Iterator <WebElement> it=webElm.iterator();	
		while(it.hasNext()) {
			System.out.println(it.next());
		}*/
		//for each loop
		//		for(WebElement itemPrice : itemPrices) {
		//			System.out.println(itemPrice.getText());
		//		}
		//String webElm =driver.findElement(By.xpath("//div[contains(text(),'$')]")).getText();
		int i=0;
		for(i=0;i<itemPrices.size();i++) {
			
			System.out.println(itemPrices.get(i).getText());
		}
		
	}
	public static void elementStatus() {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://indeed.com");
		WebElement whatField=driver.findElement(By.id("text-input-what"));
		WebElement whereField=driver.findElement(By.id("text-input-where"));
		
		System.out.println(whatField.isEnabled());
		System.out.println(whatField.isDisplayed());
		
		System.out.println(whereField.isEnabled());
		System.out.println(whereField.isDisplayed());
		
		if(whatField.isEnabled() && whatField.isDisplayed()) {
			System.out.println("test pass");
		}else {
			System.out.println("test fail");
		}
		
		if(whereField.isEnabled() && whereField.isDisplayed()) {
			System.out.println("test pass");
		}else {
			System.out.println("test fail");
		}
	}

	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","/Users/sheralie/Dropbox/My Mac (Iradas-MacBook-Air.local)/Desktop/In Class Activity/SleniumTools/ChromeDriver/chromedriver");	
		day_6 elm=new day_6();
		//elm.getElm();
		elm.elementStatus();
	}

}
