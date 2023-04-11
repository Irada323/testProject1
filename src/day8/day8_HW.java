package day8;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class day8_HW {
	/*Test case 1
    go to http://demo.guru99.com/popup.php
     Get title and store it in a variable.
     Click on Click Here button and switch over to next window, provide an email click Submit. 
     Get text of the user ID and password and store them in variables, print them out. 
     Then verify the text "This access is valid only for 20 days."
     Close the window.
     Go back to main window, and get title then verify it equals to your stored title.
     Quite driver. */
	public static void guru() {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebDriverWait wait =new WebDriverWait(driver,5);
		driver.get("http://demo.guru99.com/popup.php");
		String mainTitle=driver.getWindowHandle();
		System.out.println(mainTitle);
		driver.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();
		Set<String> windowIds = driver.getWindowHandles();
		for(String id: windowIds) {
			System.out.println(id);
		}
		Iterator<String> it = windowIds.iterator();
		String window1=it.next();
		String window2=it.next();
		driver.switchTo().window(window2);
		driver.findElement(By.name("emailid")).sendKeys("irada@gmail.com");
		driver.findElement(By.name("btnLogin")).click();
		String userId=driver.findElement(By.xpath("//td[contains(text(),'mngr')]")).getText();
		String password=driver.findElement(By.xpath("//td[contains(text(), 'Password')]/following-sibling::td")).getText();
		System.out.println("User id is: "+ userId +" password is: "+ password);
		String text =driver.findElement(By.xpath("//h3[contains(text(),'This')]")).getText();
		if(text.equals("This access is valid only for 20 days.")) {
			System.out.println("text test pass");
		}else {
			System.out.println("text test fails");
		}
		driver.close();
		driver.switchTo().window(window1);
		String lastTitle=driver.getWindowHandle();
		if(lastTitle.equals(mainTitle)) {
			System.out.println("tilte test is pass");
		}else {
			System.out.println("title test is fail");
		}
	}

	/*Test case 2: 
go to http://practice.primetech-apps.com/practice/frames
Verify that there is a page header text as "Frames".
Find the iFrame element and switch into it
Find firstname, lastname, address, city, state, and zipcode, and type relative information.
Click on submit button.
Verify you see "You have submitted below information:" message.
Switch back to main frame
Verify that there is a page header text as "Frames".*/
	public static void frames() {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebDriverWait wait =new WebDriverWait(driver,5);
		driver.get("http://practice.primetech-apps.com/practice/frames");
		String header=driver.findElement(By.xpath("//h3[contains(text(),'Frames')]")).getText();
		if(header.equals("Frames")) {
			System.out.println("header verification is pass");
		}else {
			System.out.println("header verification is fail");
		}
		//driver.switchTo().frame(driver.findElement(By.id("iframe")));
		driver.switchTo().frame(0);
		driver.findElement(By.id("firstName")).sendKeys("Ira");
		driver.findElement(By.id("lastName")).sendKeys("Parhat");
		driver.findElement(By.id("address")).sendKeys("26 Ave");
		driver.findElement(By.id("city")).sendKeys("Vancouver");
		WebElement elm=driver.findElement(By.id("state"));
		Select select= new Select(elm);
		select.selectByValue("Alaska");
		driver.findElement(By.id("zipCode")).sendKeys("V3Z");
		WebElement button=driver.findElement(By.xpath("//input[@type='radio'and@id='female']"));
		button.click();
        System.out.println(button.isSelected());
		driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
		String message=driver.findElement(By.xpath("//h3[contains(text(),'You')]")).getText();
		if(message.equals("You have submitted below information:")) {
			System.out.println("message validations is pass");
		}else {
			System.out.println("message validation is fail");
		}
		driver.switchTo().defaultContent();
		String secondHeader=driver.findElement(By.xpath("//h3[contains(text(),'Frames')]")).getText();
		if(secondHeader.equals(header)) {
			System.out.println("test pass");
		}else {
			System.out.println("test fail");
		}
		
	}
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","/Users/sheralie/Dropbox/My Mac (Iradas-MacBook-Air.local)/Desktop/In Class Activity/SleniumTools/ChromeDriver/chromedriver");	
		
		day8_HW gr=new day8_HW();
		//gr.guru();
		gr.frames();
	}

}
