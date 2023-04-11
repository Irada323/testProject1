package day10_singletonClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import day9.action_hw;

public class singleton {
	
	public static WebDriver driver;
	
	public static WebDriver getDriver() {
		
		if(driver==null) {
			driver=new ChromeDriver();
		}
		return driver;
	}
	public static void quitDriver() {
		if(driver !=null) {
			driver.quit();
			driver=null;
		}
	}

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","/Users/sheralie/Dropbox/My Mac (Iradas-MacBook-Air.local)/Desktop/In Class Activity/SleniumTools/ChromeDriver/chromedriver");	
		singleton single=new singleton();
		single.getDriver();
	}

}
