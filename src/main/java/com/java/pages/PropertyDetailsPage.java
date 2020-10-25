package com.java.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class PropertyDetailsPage extends BasePage{

	public PropertyDetailsPage(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}

	/*PropertyDetailsPage(ThreadLocal<WebDriver> driver) {
		super(driver);
	}
*/
	By agentName=By.xpath("//div[@class='dp-sidebar-wrapper']//h4[@class='ui-agent__name']");
	
	By agentLogo=By.xpath("//div[@class='dp-sidebar-wrapper']//div[@class='ui-agent__logo']/img");
	
	By agentNo=By.xpath("//div[@class='dp-sidebar-wrapper']//a[@data-track-label='Agent phone number 1']");
	
	public boolean isLogoVisible()
	{
		return isElementVisible(findElement(agentLogo), 20);
	}
	
	public boolean isNameVisible()
	{
		return isElementVisible(findElement(agentName), 20);
	}
	
	public boolean isNoVisible()
	{
		return isElementVisible(findElement(agentNo), 20);
	}
	
	
	public String getAgentName()
	{
		return findElement(agentName).getText();
	}
	
	
	public String getAgentNo()
	{
		return findElement(agentNo).getText();
	}
	
	public String getLogo()
	{
		String el= findElement(agentLogo).getAttribute("src");
		return el;
	}
	
	public PropertyAgentPage clickAgentName()
	{
		implicitWaitLong();
	    findElement(agentName).click();
	    return new PropertyAgentPage(driver);
	}
	
}
