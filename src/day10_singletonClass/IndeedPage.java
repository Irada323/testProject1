package day10_singletonClass;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Driver;

public class IndeedPage {
	static IndeedPage indeedpage;
	
	public IndeedPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

	
	@FindBy (id="text-input-where")
	 public WebElement WhereField;	
	
	@FindBy (xpath="//input[@id='text-input-what']")
	public WebElement WhatField;
	
	//@finBy(linkText="Upload your resume")
	//public WebElement 
}
