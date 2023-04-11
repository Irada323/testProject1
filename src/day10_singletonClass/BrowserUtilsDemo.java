package day10_singletonClass;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import utils.BrowserUtils;
import utils.Driver;

public class BrowserUtilsDemo {
	static IndeedPage indeedpage;
	static BrowserUtils utils=new BrowserUtils();
public void indeed() {
		indeedpage=new IndeedPage();
		//WebDriver driver = new ChromeDriver();
		Driver.getDriver().get("https://indeed.com");
		utils.clearText(indeedpage.WhereField);
		indeedpage.WhereField.sendKeys(Keys.COMMAND+"a");
		
		
		//indeedpage.WhatField.sendKeys(null)
		
		String homeURL= Driver.getDriver().getCurrentUrl();
		System.out.println("current URL is: "+ homeURL);
		String homeTitle=Driver.getDriver().getTitle();
		System.out.println("Title of this page is: "+ homeTitle);
		Driver.getDriver().findElement(By.xpath("//input[@id='text-input-what']")).sendKeys("SDET");
		Driver.getDriver().findElement(By.xpath("//button[@class='yosegi-InlineWhatWhere-primaryButton']")).click();
		String searchURL = Driver.getDriver().getCurrentUrl();
		if(!searchURL.equals(homeURL) && searchURL.contains("search")) {
			System.out.println("URL Test Passed");
		}else {
			System.out.println("URL Test Failed");
		}
		String searchTitle=Driver.getDriver().getTitle().toUpperCase();
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
		WebElement whereField =Driver.getDriver().findElement(By.xpath("//input[@id='text-input-where']"));
		whereField.sendKeys(Keys.COMMAND +"a");
		whereField.sendKeys(Keys.DELETE);
	    whereField.sendKeys("Washigton DC");
		String locationText = Driver.getDriver().findElement(By.id("text-input-where")).getText();
		System.out.println("test "+ Driver.getDriver().findElement(By.xpath("//*[@id=\"text-input-where\"]")).getText());
		if(locationText.equals("")) {
			System.out.println("location test Passed");
		}else {
			System.out.println("lcation test failed");
		}
}
	public static void main(String[] args) {
		

	}

}
