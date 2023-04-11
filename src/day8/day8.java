package day8;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class day8 {

	public static void newTabDemo() {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebDriverWait wait =new WebDriverWait(driver,5);
		//System.out.println(driver.getWindowHandle());
		driver.get("http://practice.primetech-apps.com/practice/browser-windows");
		String mainWindowId=driver.getWindowHandle();
		System.out.println(mainWindowId);
		
		driver.findElement(By.id("newTab")).click();
		Set<String> windowIds=driver.getWindowHandles();
		for (String windowId : windowIds) {
			System.out.println("Window id is : "+windowId);
			
		}

		Iterator<String> it= windowIds.iterator();
		String firstWindow =it.next();
		String secondWindow = it.next();
		System.out.println(firstWindow);
		System.out.println(secondWindow);
		
		driver.switchTo().window(secondWindow);
		String newTabTextOnSecondWindow=driver.findElement(By.xpath("//h1[text()='New Tab']")).getText();
		System.out.println(newTabTextOnSecondWindow);
		driver.close();
		driver.switchTo().window(firstWindow);
	 

		
	}
	/*go to http://practice.primetech-apps.com/practice/browser-windows
		1. Get the main window ID and store it in a String called mainWindowId, 
		2. Click on the 'New Tab' button
		3. Get window IDs and store it into a Set
		4. Get the first window ID from the Set and Verify it matches with the main window id in step 1.  Then get the second window id and store it in variable called secondWindowId.
		5. Switch to the second window
		 6. Verify that there is a button called 'New Tab'
		7. Close the window,  Switch back to the main window, Verify you are on the main window. 
*/
	public static void Demo() {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebDriverWait wait =new WebDriverWait(driver,5);
		       //Test case 2 
				//go to http://practice.primetech-apps.com/practice/browser-windows
				driver.get("http://practice.primetech-apps.com/practice/browser-windows");
				//1. Get the main window ID and store it in a String called mainWindowId, 
				String mainWindowId = driver.getWindowHandle();
				//2. Click on the ‘New Tab’ button
				driver.findElement(By.id("newTab")).click();
				//3. Get window IDs and store it into a Set
				Set<String> windowIds = driver.getWindowHandles();
				//4. Get the first window ID from the Set 
				Iterator<String> iterate = windowIds.iterator();
				String firstWindowId = iterate.next();
				//Verify it matches with the main window id in step 1. 
				if (firstWindowId.equals(mainWindowId)) {
					System.out.println("First window id match the main window id.");
				}else {
					System.out.println("First window id does not match the main window id.");
				}
				//Then get the second window id and store it in variable called secondWindowId.
				String secondWindowId = iterate.next();
				//5. Switch to the second window
				driver.switchTo().window(secondWindowId);
				//6. Verify that there is a button called ‘New Tab’
				if (driver.findElement(By.id("newTab")).isDisplayed()) {
					System.out.println("New tab button is available on the second window");
				}else {
					System.out.println("New tab button is not available on the second window");
				}
				//7. Close the window,   
				driver.close();
				//Switch back to the main window,
				driver.switchTo().window(mainWindowId);
				//Verify you are on the main window.
				if (driver.getWindowHandle().equals(mainWindowId)) {
					System.out.println("We are back to the main window.");
				}else {
					System.out.println("We are lost.");
				}
			}
	public static void frameDemo() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		
		driver.get("http://practice.primetech-apps.com/practice/frames");
		
		//driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='iframe1']")));
		driver.switchTo().frame(0);
		driver.findElement(By.id("firstName")).sendKeys("Hello");
		
		driver.switchTo().parentFrame(); // goes back to one step out of the iframe. 
		//driver.switchTo().defaultContent(); // goes back to original page.
		
		System.out.println(driver.findElement(By.xpath("//h3[text()='Frames']")).getText());
		
	}

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","/Users/sheralie/Dropbox/My Mac (Iradas-MacBook-Air.local)/Desktop/In Class Activity/SleniumTools/ChromeDriver/chromedriver");	
		
		day8 tab=new day8();
		//tab.newTabDemo();
		//tab.Demo();
		tab.frameDemo();
		
	}

}
