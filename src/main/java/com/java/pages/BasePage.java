package com.java.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.java.appconstants.Constants.DynamicWaits;


public class BasePage extends Page {


	/*protected BasePage(ThreadLocal<WebDriver> driver) {
		super(driver);
	}*/
    
	
	public BasePage(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}

	public WebElement findElement(By locator)
	{
		return driver.findElement(locator);
	}
	
	public List<WebElement> findElements(By locator)
	{
		return driver.findElements(locator);
	}
	
	public void doClick(By locator) {
		driver.findElement(locator).click();
	}

	public void doSubmit(By locator) {
		WebElement el = driver.findElement(locator);
		el.submit();
	}

	public void doSendkeys(By locator, String text) {
		driver.findElement(locator).sendKeys(text);
	}

	public void doGetText(By locator) {
		driver.findElement(locator).getText();
	}
	

	public void implicitWaitLong()
	{
		driver.manage().timeouts().implicitlyWait(DynamicWaits.IMPLICIT_WAIT_LONG, TimeUnit.SECONDS);
		
	}
	public void implicitWaitMedium()
	{
		driver.manage().timeouts().implicitlyWait(DynamicWaits.IMPLICIT_WAIT_MEDIUM, TimeUnit.SECONDS);
	}
	
	public void implicitWaitSmall()
	{
		driver.manage().timeouts().implicitlyWait(DynamicWaits.IMPLICIT_WAIT_SMALL, TimeUnit.SECONDS);
	}
	
	public boolean isElementVisible(WebElement webElement, int timeOutInSeconds) {
		try {
			return new WebDriverWait(driver, timeOutInSeconds).until(ExpectedConditions.visibilityOf(webElement))
					.isDisplayed();
		} catch (TimeoutException e) {
			return false;
		}
	}
}
