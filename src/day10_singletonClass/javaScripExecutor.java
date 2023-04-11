package day10_singletonClass;

import org.openqa.selenium.JavascriptExecutor;

import utils.Driver;

public class javaScripExecutor {

	public static void main(String[] args) {
		JavascriptExecutor js =(JavascriptExecutor)Driver.getDriver();
		js.executeScript("alert('SW Test Academy!');");
Driver.getDriver().get("https://indeed.com");
//js.executeScript("arguments[0], args)
	}

}
