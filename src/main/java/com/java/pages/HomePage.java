package com.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

	public HomePage(WebDriver webDriver) {
		super(webDriver);
		
	}

	By inputbox=By.id("search-input-location");
	
	public String getPageTitle()
	{
		return driver.getTitle();
	}
	
	public void search(String location)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		doSendkeys(inputbox, location);
		doSubmit(inputbox);
	}
	
}
