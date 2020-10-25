package com.java.testcases;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.java.pages.HomePage;
import com.java.util.GenericFunctions;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class HomeTest extends BaseTest {



	@Test
	@Description("Verify Title")
	@Severity(SeverityLevel.NORMAL)
	public void verifyTitle() {
		
		GenericFunctions.updateTestCaseName("Verify Title");
		String title = page.getInstance(HomePage.class).getPageTitle();
		Assert.assertEquals("Zoopla > Search Property to Buy, Rent, House Prices, Estate Agents", title);
	}

	@Test
	@Description("Search Location Test Case")
	@Severity(SeverityLevel.TRIVIAL)
	public void verifySearchLocation() {
		
		GenericFunctions.updateTestCaseName("Search Location");
		page.getInstance(HomePage.class).search("London");

	}

}


