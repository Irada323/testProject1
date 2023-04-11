package Day6;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class day6_HW {
	
	public static void practice() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.navigate().to("http://practice.primetech-apps.com/practice/radio-button");
		WebElement usa=driver.findElement(By.id("USA"));
		WebElement ca= driver.findElement(By.id("Canada"));
		WebElement Eng= driver.findElement(By.id("England"));
		WebElement Japan= driver.findElement(By.id("Japan"));
		System.out.println(usa.isDisplayed());
		System.out.println(usa.isEnabled());
		
		System.out.println(ca.isDisplayed());
		System.out.println(ca.isEnabled());
		
		System.out.println(Eng.isDisplayed());
		System.out.println(Eng.isEnabled());
		
		System.out.println(Japan.isDisplayed());
		System.out.println(Japan.isEnabled());
		
		if(usa.isDisplayed()&& usa.isEnabled()) {
			
		if(usa.isSelected()) {
			System.out.println("no further validation is required");
		}else {
			usa.click();
			
		} if(usa.isSelected() && usa.isDisplayed()&&usa.isEnabled()) {
			System.out.println("test pass");
		} else {
			System.out.println("test fails");
		}
		}
		
		if(ca.isDisplayed()&& ca.isEnabled()) {
			
			if(ca.isSelected()) {
				System.out.println("no further validation is required");
			}else {
				ca.click();
				
			} if(ca.isSelected() && ca.isDisplayed()&& ca.isEnabled()) {
				System.out.println("test pass");
			} else {
				System.out.println("test fails");
			}
			}
		
	}
	public static void testCase3() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://practice.primetech-apps.com/practice/check-box");
		WebElement java=driver.findElement(By.id("Java"));
		WebElement JS= driver.findElement(By.id("JavaScript"));
		WebElement C= driver.findElement(By.id("C#"));
		WebElement Py= driver.findElement(By.id("Python"));
		if(java.isDisplayed()) {
			if(java.isEnabled()) {
				if(java.isSelected()) {
					System.out.println("No further validation is required");
				}else {java.click();
			}if(java.isDisplayed()&&java.isEnabled()&&java.isSelected()) {
				System.out.println("test passed");
			}else {
				System.out.println("test failed");
			}
			}
		}
	
		if(JS.isDisplayed()) {
			if(JS.isEnabled()) {
				if(JS.isSelected()) {
					System.out.println("No further validation is required");
				}else {JS.click();
			}if(JS.isDisplayed()&&JS.isEnabled()&&JS.isSelected()) {
				System.out.println("test passed");
			}else {
				System.out.println("test failed");
			}
			}
			
		}
		if(C.isDisplayed()) {
			if(C.isEnabled()) {
				if(C.isSelected()) {
					System.out.println("No further validation is required");
				}else {C.click();
			}if(C.isDisplayed()&&C.isEnabled()&&C.isSelected()) {
				System.out.println("test passed");
			}else {
				System.out.println("test failed");
			}
			}
			
		}
		if(Py.isDisplayed()) {
			if(Py.isEnabled()) {
				if(Py.isSelected()) {
					System.out.println("No further validation is required");
				}else {Py.click();
			}if(Py.isDisplayed()&&Py.isEnabled()&&Py.isSelected()) {
				System.out.println("test passed");
			}else {
				System.out.println("test failed");
			}
			}
			
		}
		driver.close();
	}
	
	

	public static void main(String[] args) {
		
System.setProperty("webdriver.chrome.driver","/Users/sheralie/Dropbox/My Mac (Iradas-MacBook-Air.local)/Desktop/In Class Activity/SleniumTools/ChromeDriver/chromedriver");	
		
day6_HW hw=new day6_HW();
//hw.practice();
hw.testCase3();
		
		
	}

}
