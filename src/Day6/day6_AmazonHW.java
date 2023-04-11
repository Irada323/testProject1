package Day6;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*go to amazon.com    click on signin 
verify that you are on sign in page (either by sign-in text or email field).
navigate back, and navigate forward
verify that you are on sign in page (either by sign-in text or email field).
click on create new account, verify you are on new account create page.
navigate back, verify you are on the sign-in page.
navigate forward, verify you are on the create account page.
click on the Continue button without filling the form
verify error messages displayed and get text to verify:
 Enter your name
 Enter your email or mobile phone number
 Minimum 6 characters required*/
public class day6_AmazonHW {
	public static void testCase() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.navigate().to("https://amazon.com");
		driver.findElement(By.xpath("//span[contains(text(),'Hello,')]")).click();
		WebElement signIn=driver.findElement(By.id("ap_email"));
		System.out.println(signIn.isDisplayed());
		driver.navigate().back();
		driver.navigate().forward();
		WebElement secondSignIn=driver.findElement(By.id("ap_email"));
		System.out.println(secondSignIn.isDisplayed());
		driver.findElement(By.id("createAccountSubmit")).click();
		WebElement create=driver.findElement(By.xpath("//h1[contains(text(),'Create')]"));
		System.out.println(create.isDisplayed());
		driver.navigate().back();
		WebElement thirdSignIn=driver.findElement(By.id("ap_email"));
		System.out.println(thirdSignIn.isDisplayed());
		driver.navigate().forward();
		WebElement secondCreate=driver.findElement(By.xpath("//h1[contains(text(),'Create')]"));
		System.out.println(secondCreate.isDisplayed());
		driver.findElement(By.id("continue")).click();
	    String errorName=driver.findElement(By.xpath("//div[contains(text(),'name')]")).getText();
	    String errorEmail=driver.findElement(By.xpath("//div[contains(text(),'your email')]")).getText();
	    String errorPassword=driver.findElement(By.xpath("//div[contains(text(),'Minimum ')]")).getText();
	    if(errorName.equals("Enter your name")) {
	    	System.out.println("name validation is passed");
	    }else {
	    	System.out.println("name validation is failed");
	    }
	    if(errorEmail.equals("Enter your email or mobile phone number")) {
	    	System.out.println("email validation is passed");
	    }else {
	    	System.out.println("email validation is failed");
	    }
	    if(errorPassword.equals("Minimum 6 characters required")) {
	    	System.out.println("password validation is passed");
	    }else {
	    	System.out.println("password validation is failed");
	    }
		
		driver.close();
		
	}
       public static void Optional() {
    	   WebDriver driver = new ChromeDriver();
   		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
   		driver.manage().window().maximize();
   		driver.navigate().to("https://www.ebay.com/");
   		driver.findElement(By.id("gh-ac")).sendKeys("Coffee Mug");
   		driver.findElement(By.id("gh-btn")).click();
   		List<WebElement> products=driver.findElements(By.xpath("//div[@class='s-item__info clearfix']"));
   		for(int i=0;i<products.size();i++) {
   			System.out.println(products.get(i).getText());
   			
   		}
   		
   		driver.quit();
       }
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","/Users/sheralie/Dropbox/My Mac (Iradas-MacBook-Air.local)/Desktop/In Class Activity/SleniumTools/ChromeDriver/chromedriver");	
		
		day6_AmazonHW hw=new day6_AmazonHW();
		//hw.testCase();
		hw.Optional();

	}

}
