package day7;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class dropdown {
	public static void dropDownDemo() {
		  WebDriver driver = new ChromeDriver();
	   		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	   		driver.manage().window().maximize();
	   		driver.get("https://amazon.com");
	   		WebElement selectElement=driver.findElement(By.id("searchDropdownBox"));
	   		selectElement.click();
	   		Select choose = new Select(selectElement);
	   		choose.selectByVisibleText("Home & Kitchen");
	   		choose.selectByIndex(2);
	   		choose.selectByValue("search-alias=baby-products-intl-ship");
	   		WebElement first=choose.getFirstSelectedOption();
	   		System.out.println(first.getText());
	   		List<WebElement> allOptions=choose.getOptions();
	   		System.out.println(allOptions.size());
	   		for(WebElement element: allOptions){
	   			System.out.println(element.getText());
	   			
	   		}
	   
	   		driver.quit();
		
	}
	public static void dropDownDemo2() throws InterruptedException {
		  WebDriver driver = new ChromeDriver();
	   		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	   		driver.manage().window().maximize();
	   		
	   		WebDriverWait letsWait = new WebDriverWait(driver,3);
	   		
	   		driver.get("https://semantic-ui.com/modules/dropdown.html");
	   		WebElement dropdown=driver.findElement(By.xpath("//div[@class='ui fluid selection dropdown'][1]"));
	   		letsWait.until(ExpectedConditions.visibilityOf(dropdown));
	   		dropdown.click();
	   		WebElement matt=driver.findElement(By.xpath("//input[@data-value='matt']"));
	   		letsWait.until(ExpectedConditions.visibilityOf(matt));
	   		matt.click();
	   		
	   		
	}
	public static void alert() {
		WebDriver driver = new ChromeDriver();
   		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
   		driver.manage().window().maximize();
   		driver.get("http://practice.primetech-apps.com/practice/alert");
   		driver.findElement(By.id("confirm")).click();
   		WebDriverWait letsWait = new WebDriverWait(driver,3);
   		letsWait.until(ExpectedConditions.alertIsPresent());
		Alert handle=driver.switchTo().alert();
		
		handle.accept();
		driver.findElement(By.id("prompt")).click();
		letsWait.until(ExpectedConditions.alertIsPresent());
		
		Alert handle2 = driver.switchTo().alert();
		System.out.println(handle2.getText());
		handle2.sendKeys("Shav");
		handle2.dismiss();
	}

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","/Users/sheralie/Dropbox/My Mac (Iradas-MacBook-Air.local)/Desktop/In Class Activity/SleniumTools/ChromeDriver/chromedriver");	
		
		dropdown amazon =new dropdown();
		//amazon.dropDownDemo();
		amazon.dropDownDemo2();
	}

}
