package da2_SeleniumActivity;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IndeedActivity {

	public void indeed() {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://indeed.com");
		String homeURL= driver.getCurrentUrl();
		System.out.println("current URL is: "+ homeURL);
		String homeTitle=driver.getTitle();
		System.out.println("Title of this page is: "+ homeTitle);
		driver.findElement(By.xpath("//input[@id='text-input-what']")).sendKeys("SDET");
		driver.findElement(By.xpath("//button[@class='yosegi-InlineWhatWhere-primaryButton']")).click();
		String searchURL = driver.getCurrentUrl();
		if(!searchURL.equals(homeURL) && searchURL.contains("search")) {
			System.out.println("URL Test Passed");
		}else {
			System.out.println("URL Test Failed");
		}
		String searchTitle=driver.getTitle().toUpperCase();
		System.out.println("search titile is:" +searchTitle);
		if(!searchTitle.equals(homeTitle) && searchTitle.contains("SEARCH")) {
			System.out.println("Title Test Passed");
		}else {
			System.out.println("Title Test Failed");
		}
		//another way to delete the text and enter new text
		//String locationText = whereField.getAttribute("value");
		//for (int i = 0; i < locationText.length(); i++) {
		//	whereField.sendKeys(Keys.BACK_SPACE);
		//}
		WebElement whereField =driver.findElement(By.xpath("//input[@id='text-input-where']"));
		whereField.sendKeys(Keys.COMMAND +"a");
		whereField.sendKeys(Keys.DELETE);
	    whereField.sendKeys("Washigton DC");
		String locationText = driver.findElement(By.id("text-input-where")).getText();
		System.out.println("test "+ driver.findElement(By.xpath("//*[@id=\"text-input-where\"]")).getText());
		if(locationText.equals("")) {
			System.out.println("location test Passed");
		}else {
			System.out.println("lcation test failed");
		}
	}
	
	public static void main(String[] args) {
		 System.setProperty("webdriver.chrome.driver","/Users/sheralie/Dropbox/My Mac (Iradas-MacBook-Air.local)/Desktop/In Class Activity/SleniumTools/ChromeDriver/chromedriver");
         IndeedActivity ia = new IndeedActivity();
         ia.indeed();
	}

}
