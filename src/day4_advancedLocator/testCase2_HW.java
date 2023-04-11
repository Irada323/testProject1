package day4_advancedLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*Testcase 2: 

1. Go to http://practice.primetech-apps.com/practice/web-tables
2. Verify that you see Web Tables text
3. Find id, firstname, lastname, salary fields and give a relevant input. (store the information into variables, then pass the variable to sendKeys() method) 
4. Click on Add button
5. Then your inputs will display under the table. (use xpath text() contains() functions to locate those elements. get text and store them into variables)
6. Verify your input under the table match the input you added. */

public class testCase2_HW {
	
	public static void practice() throws InterruptedException {
		String ID="Batch4";
		String firstName="Ira";
		String lastName="Parhat";
		double salary =120000;
		
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://practice.primetech-apps.com/practice/web-tables");
		String text=driver.findElement(By.xpath("//h3[contains(text(),Web)]")).getText();
		System.out.println(text);
		driver.findElement(By.xpath("//input[contains(@id,\"Id\")]")).sendKeys(ID);
		driver.findElement(By.xpath("//input[contains(@id,\"Fir\")]")).sendKeys(firstName);
		driver.findElement(By.xpath("//input[@id='Last Name']")).sendKeys(lastName);
		driver.findElement(By.xpath("//input[contains(@id,'Salary')]")).sendKeys(String.valueOf(salary));
		driver.findElement(By.xpath("//button[contains(text(),'Add')]")).click();
		Thread.sleep(2000);
		String actualID=driver.findElement(By.xpath("//td[contains(text(),batch4)]")).getText();
		String actualFirstName=driver.findElement(By.xpath("//td[contains(text(),'ira')]")).getText();
		String actualLastName=driver.findElement(By.xpath("//td[contains(text(),'pa')]")).getText();
		String actualSalary=driver.findElement(By.xpath("//td[contains(text(),12)]")).getText();
		
		if(ID.equals(actualID)) {
			System.out.println("ID validation is pass");
		}else {
			System.out.println("ID validation fail");
		}
		if(firstName.equals(actualFirstName)) {
			System.out.println("firstName validation is pass");
		}else {
			System.out.println("firstName validation fail");
		}
		if(lastName.equals(actualLastName)) {
			System.out.println("lastName validation is pass");
		}else {
			System.out.println("lastName validation fail");
		}
		if(String.valueOf(salary).equals(actualSalary)) {
			System.out.println("salary validation is pass");
		}else {
			System.out.println("salary validation fail");
		}
	}
	
	

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","/Users/sheralie/Dropbox/My Mac (Iradas-MacBook-Air.local)/Desktop/In Class Activity/SleniumTools/ChromeDriver/chromedriver");
		testCase2_HW tc=new testCase2_HW();
		tc.practice();
	}

}
