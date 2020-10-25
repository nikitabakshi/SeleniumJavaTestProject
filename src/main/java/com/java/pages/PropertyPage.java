package com.java.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PropertyPage extends BasePage {

	
	public PropertyPage(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}


	/*PropertyPage(ThreadLocal<WebDriver> driver) {
		super(driver);
	}
*/
	By priceslist=By.xpath("//li[contains(@class,'srp clearfix')]//a[@class='listing-results-price text-price']");
	
	
	public List<String> getPrices()
	{
		List<WebElement> price=findElements(priceslist);
		List<String> list=new ArrayList<String>();
		for(WebElement el : price)
		{
		  String text=el.getText();
		  text=text.replaceAll("\\D+","");
          list.add(text);
		  
		}
		Collections.sort(list);
		System.out.println("Sorted list of prices :" + list);
		return list;
	}
	
	
	public PropertyDetailsPage selectProperty(int no)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,300)");
		implicitWaitLong();
		findElement(By.xpath("//li[contains(@class,'srp clearfix')]["+no+"]//a[@class='listing-results-price text-price']")).click();
		return new PropertyDetailsPage(driver);
	
	}
}
