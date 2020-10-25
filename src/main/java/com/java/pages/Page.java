package com.java.pages;

import org.openqa.selenium.WebDriver;

public class Page {

	protected WebDriver driver;
	
	
	public Page(WebDriver driver) {
		this.driver=driver;
	}

	public <Tpage extends BasePage> Tpage getInstance(Class<Tpage> pageClass)
	{
		
		try
		{
		return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	
}
