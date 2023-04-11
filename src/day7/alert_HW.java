package day7;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class alert_HW {

	public static void testCase1() {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://practice.primetech-apps.com/practice/alerts");
		driver.findElement(By.id("alert")).click();
		WebDriverWait wait =new WebDriverWait(driver,3);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert handle=driver.switchTo().alert();
		handle.accept();
	}
	public static void testCase2() {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://practice.primetech-apps.com/practice/alerts");
		WebElement confirm=driver.findElement(By.id("confirm"));
		confirm.click();
		WebDriverWait wait =new WebDriverWait(driver,3);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert handle= driver.switchTo().alert();
		if(handle.getText().equals("Do you wish to continue or cancel?")){
			System.out.println("Test pass");
			handle.accept();
		}else {
			System.out.println("test fail");
			handle.dismiss();
		}
	}
	
	public static void testCase3() {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://practice.primetech-apps.com/practice/alerts");
		WebElement prompt=driver.findElement(By.id("prompt"));
		prompt.click();
		WebDriverWait wait=new WebDriverWait(driver,3);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert handle=driver.switchTo().alert();
		handle.sendKeys("PrimeTech");
		handle.accept();
		WebElement message=driver.findElement(By.id("demo"));
		System.out.println(message.getText());
		if(message.getText().equals("Hello PrimeTech! How are you today?")) {
			System.out.println("test pass");
		}else {
			System.out.println("test fail");
		}
	}
	public static void testCase4() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://practice.primetech-apps.com/practice/alerts");
		WebElement prompt=driver.findElement(By.id("prompt"));
		prompt.click();
		WebDriverWait wait=new WebDriverWait(driver,3);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert handle=driver.switchTo().alert();
		handle.sendKeys("Primetech");
		Thread.sleep(2000);
		handle.dismiss();
		WebElement message=driver.findElement(By.id("demo"));
		System.out.println(message.getText());
		if(message.getText().equals("User cancelled the prompt.")) {
			System.out.println("test pass");
		}else {
			System.out.println("test fail");
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","/Users/sheralie/Dropbox/My Mac (Iradas-MacBook-Air.local)/Desktop/In Class Activity/SleniumTools/ChromeDriver/chromedriver");	
		
		alert_HW al=new alert_HW();
		//al.testCase1();
		//al.testCase2();
	   // al.testCase3();
		al.testCase4();
	}

}
