package day3_advanceLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


/*Go to etsy.com
Click on Sign in.
Click on Register.
Enter an email address, (jon.dow@gmail.com)
Enter first name.
Enter password.
Click on Register.
Verify you get the error message:
"Sorry, the email you have entered is already in use."*/

public class Xpath_demo {

	public void amazonSearch() throws InterruptedException {
		
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://etsy.com");
		driver.findElement(By.xpath("//button[contains(text(),'Sign in')]")).click();
		driver.findElement(By.xpath("//button[contains(text(), 'Register')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='join_neu_email_field']")).sendKeys("jon.dow@gmail.com");
		driver.findElement(By.xpath("//input[@id='join_neu_first_name_field']")).sendKeys("Ira");
		driver.findElement(By.xpath("//input[@id='join_neu_password_field']")).sendKeys("password");
		driver.findElement(By.xpath("//button[@name='submit_attempt']")).click();
		
		String expectedErrorMessage = "You need to choose a new password that you haven't used before.";
		String actualErrorMessage=driver.findElement(By.xpath("//div[contains(text(),'already in use.')]")).getText();
		if(expectedErrorMessage.equals(actualErrorMessage)) {
			System.out.println("test passed");
		}else {
			System.out.println("test failed");
		}
		Thread.sleep(1000);
		driver.close();
	}	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/Users/sheralie/Dropbox/My Mac (Iradas-MacBook-Air.local)/Desktop/In Class Activity/SleniumTools/ChromeDriver/chromedriver" );
		
		Xpath_demo xp= new Xpath_demo();
		xp.amazonSearch();
		
	}

}
