package da2_SeleniumActivity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.FacebookPage;
import utils.Driver;
import utils.dataReader;

public class FacebookActivity {

	
		
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"/Users/sheralie/Dropbox/My Mac (Iradas-MacBook-Air.local)/Desktop/In Class Activity/SleniumTools/ChromeDriver/chromedriver" );
		//WebDriver driver=new ChromeDriver();
		FacebookActivity fb=new FacebookActivity();
		fb.testcase1();
		//fb.testcase2();
		//fb.getTextPractice();
	}
		public void testcase1() throws InterruptedException {
		    fbPage=new FacebookPage();
			Driver.getDriver().get(dataReader.getProperty("appUrl"));
			fbPage.FBemailField.sendKeys(dataReader.getProperty("facebookUsername"));
			
			fbPage.FBpassField.sendKeys(dataReader.getProperty("facebookPassword"));
			
			fbPage.FBloginBtn.click();
			
			Thread.sleep(2000);
			Driver.getDriver().close();
			
		}
		
		FacebookPage fbPage;
		
		public void testcase2() throws InterruptedException {
			//WebDriver driver=new ChromeDriver();
			fbPage=new FacebookPage();
			Driver.getDriver().get(dataReader.getProperty("appUrl"));
			fbPage.FBemailField.sendKeys(dataReader.getProperty("facebookUsername"));
			Driver.getDriver().findElement(By.xpath("//a[@class=\"_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy\"]")).click();
			 Thread.sleep(2000);
			 Driver.getDriver().findElement(By.xpath("//input[@name='firstname']")).sendKeys("Automation");
			 Driver.getDriver().findElement(By.xpath("//input[@name='lastname']")).sendKeys("Automation");
			 Driver.getDriver().findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("Automation");
			 Driver.getDriver().findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("Automation");	        Thread.sleep(2000);
			 Driver.getDriver().close();
		}
	        
		public void getTextPractice() {
			
			//WebDriver driver=new ChromeDriver();
			
			Driver.getDriver().get("https://facebook.com");
			
		String loginText = Driver.getDriver().findElement(By.name("login")).getText();
		System.out.println("log in button text is: "+loginText);
		if(loginText.equals("Log In")) {
			System.out.println("Test pass");
		}else {
			System.out.println("Test Fail");
		}
		
		
		
		
		
		
		
		
		
	}

}
