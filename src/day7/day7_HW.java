package day7;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/* go to amazon.com 
     get all the options in the departments select dropdown
    verify there are total 58 departments. And print them out.*/
public class day7_HW {
	
	public static void dropDown() {
		 WebDriver driver = new ChromeDriver();
	   		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	   		driver.manage().window().maximize();
	   		driver.get("https://amazon.com");
	   		WebElement dropDown=driver.findElement(By.id("searchDropdownBox"));
	   		dropDown.click();
	   		Select elm=new Select(dropDown);
	    	List<WebElement> allOptions= elm.getOptions();
	    	System.out.println(allOptions.size());
	    	int actualSize=allOptions.size();
	    	if(actualSize==58) {
	    		System.out.println("test passed");
	    	}else {
	    		System.out.println("test failed");
	    	}
	    	for (WebElement option: allOptions) {
	    		System.out.println(option.getText());	
			}
	}
	/* go to amazon.com
     verify that you are on the amazon home page. (verify with title). 
     verify dropdown value is by default "All Departments"
     select department Home & Kitchen, and search coffee mug.
     verify you are on coffee mug search results page (use title).
     verify you are in Home & Kitchen department.*/
	
      public static void testCase2() {
    	  WebDriver driver = new ChromeDriver();
	   		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	   		driver.manage().window().maximize();
	   		driver.get("https://amazon.com");
	   		String title=driver.getTitle();
	   		System.out.println(title);
	   		if(title.equals("Amazon.com. Spend less. Smile more.")){
	   			System.out.println("title verifications is passed");
	   		}else {
	   			System.out.println("title verifications is failed");
	   		}
	   		WebElement dropDown=driver.findElement(By.id("searchDropdownBox"));
	   		dropDown.click();
	   		Select elm=new Select(dropDown);
	   		WebElement first=elm.getFirstSelectedOption();
	   		System.out.println(first.getText());
	   		if(first.getText().equals("All Departments")){
	   			System.out.println("default value is matched");
	   		}else {
	   			System.out.println("default value didn't match");
	   		}
	   		elm.selectByVisibleText("Home & Kitchen");
	   		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Coffee Mugs");
	   		driver.findElement(By.id("nav-search-submit-button")).click();
	   		String mugTitle=driver.getTitle();
	   		System.out.println(mugTitle);
	   		if(mugTitle.equals("Amazon.com : Coffee Mugs")) {
	   			System.out.println("mug title is verified");
	   		}else {
	   			System.out.println("mug title is not verified");
	   		}
	   		if((elm.getFirstSelectedOption().getText()).equals("Home & Kitchen")) {
	   			System.out.println("test pass");
	   		}else {
	   			System.out.println("test fail");
	   		}
	   		
	   		
	   		
}
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","/Users/sheralie/Dropbox/My Mac (Iradas-MacBook-Air.local)/Desktop/In Class Activity/SleniumTools/ChromeDriver/chromedriver");	
		
		day7_HW dr=new day7_HW();
		//dr.dropDown();
		dr.testCase2();



	}

}
