package com.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class PropertyAgentPage extends BasePage {

	

	public PropertyAgentPage(WebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}

	By agentLogo=By.xpath("//div[@id='listings-agent']//img[@class='agent_logo']");
	By agentNo=By.xpath("//div[@id='listings-agent']//span[@class='agent_phone']");
	By agentName=By.xpath("(//div[@id='listings-agent']//p//strong)[1]");

	
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
	
	
}
