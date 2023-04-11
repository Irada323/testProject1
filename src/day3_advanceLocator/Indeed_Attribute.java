package day3_advanceLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Indeed_Attribute {

	
	public void indeedSearch() {
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://indeed.com");
		String text=driver.findElement(By.xpath("//div[@class='yosegi-EmbeddedLabelInput yosegi-InlineWhatWhere-where']//input[@id='text-input-where']")).getAttribute("value");
		System.out.println(text);
		String color=driver.findElement(By.cssSelector("label[id='label-text-input-where']")).getAttribute("color");
		System.out.println(color);
		String expectedTagname="label";
		String tagname=driver.findElement(By.id("label-text-input-where")).getTagName();
		System.out.println(tagname);
		if(expectedTagname.equals(tagname)) {
			System.out.println("test pass");
		}else {
			System.out.println("test fail");
		}
		driver.close();		
		
		
		
		
		
		
		
		
	}
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","/Users/sheralie/Dropbox/My Mac (Iradas-MacBook-Air.local)/Desktop/In Class Activity/SleniumTools/ChromeDriver/chromedriver");
		Indeed_Attribute ia = new Indeed_Attribute();
		ia.indeedSearch();
	}

}
