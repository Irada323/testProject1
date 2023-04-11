package day4_advancedLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase1_HW {

	
	/*Homework: Please use Xpath or Css selector only:

Testcase 1: 

Go to http://practice.primetech-apps.com/practice/text-box
Find first name, last name, email, password, address fields, and type relevant information. 
(Create variables for those information and pass the variable to the sendkey() method).
Then click on submit button. (your inputs displays under user info section).
Find your inputs and get text of each and store them into variables.
Then compare your input with the displayed user information if they match.*/
	
	public  void primeTech() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		String firstName="Ira";
		String lastName = "Parhat";
		String email="irada@gmail.com";
		String password="password";
		String address="Vancouber, BC";
		driver.get("http://practice.primetech-apps.com/practice/text-box");
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys(firstName);
		driver.findElement(By.cssSelector("input[id='lastName']")).sendKeys(lastName);
		driver.findElement(By.cssSelector("input[id='email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		//driver.findElement(By.xpath("//button[contains(text(),\"Enable\")]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//textarea[contains(@id,'address')]")).sendKeys(address);
		driver.findElement(By.xpath("//button[contains(text(),\"Enable\")]")).click();
		driver.findElement(By.xpath("//button[contains(text(),\"Sub\")]")).click();
		String actualName=driver.findElement(By.xpath("//div[contains(text(),\"ira\")]")).getText();
		String actualLastName=driver.findElement(By.xpath("//div[contains(text(),\"pa\")]")).getText();
		String actualEmail=driver.findElement(By.xpath("//div[contains(text(),\"@\")]")).getText();
		String actualPassword = driver.findElement(By.xpath("//div[contains(text(),\"pass\")]")).getText();
		String actualAddress=driver.findElement(By.xpath("//div[contains(text(),\"Van\")]")).getText();
		if(firstName.equals(actualName)) {
			System.out.println("test pass");
		}else {
			System.out.println("test fails");
		}
		if(lastName.equals(actualLastName)) {
			System.out.println("test pass");
		}else {
			System.out.println("test fails");
		}
		if(email.equals(actualEmail)) {
			System.out.println("test pass");
		}else {
			System.out.println("test fails");
		}
		if(password.equals(actualPassword)) {
			System.out.println("test pass");
		}else {
			System.out.println("test fails");
		}
		if(address.equals(actualAddress)) {
			System.out.println("test pass");
		}else {
			System.out.println("test fails");
		}
		
		
		}

	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","/Users/sheralie/Dropbox/My Mac (Iradas-MacBook-Air.local)/Desktop/In Class Activity/SleniumTools/ChromeDriver/chromedriver");
		TestCase1_HW hw=new TestCase1_HW ();
		hw.primeTech();
	}

}
