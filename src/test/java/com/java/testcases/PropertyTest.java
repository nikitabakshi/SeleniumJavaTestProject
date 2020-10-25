package com.java.testcases;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.java.pages.HomePage;
import com.java.pages.PropertyAgentPage;
import com.java.pages.PropertyDetailsPage;
import com.java.pages.PropertyPage;
import com.java.util.GenericFunctions;

public class PropertyTest extends BaseTest {



	PropertyDetailsPage pd;

	@BeforeMethod
	public void setUp() {
		pd = page.getInstance(PropertyDetailsPage.class);
	}

	@Test
	public void getallPropertyPrices() {
		GenericFunctions.updateTestCaseName("Verification of Property Prices");
		logger.info("Seraching the location on Home Page");
		page.getInstance(HomePage.class).search("London");
		
		logger.info("Get All prices available on property page after entering a location");
		List<String> list = page.getInstance(PropertyPage.class).getPrices();
		logger.info("Price list is ===" + list);
		logger.info("Selecting the 5th Property");
		page.getInstance(PropertyPage.class).selectProperty(5);
		
        logger.info("Verifying whether the logo,name and no is available on selecting the 5th property");
		Assert.assertTrue(pd.isLogoVisible(), "No logo is visible");
		Assert.assertTrue(pd.isNameVisible(), "Name not visible");
		Assert.assertTrue(pd.isNoVisible(), "Number is not visible");

		String pdlogo = pd.getLogo();
		String pdname = pd.getAgentName();

		pd.clickAgentName();

		PropertyAgentPage pa = page.getInstance(PropertyAgentPage.class);

		String palogo = pa.getLogo();
		String paname = pa.getAgentName();

		Assert.assertEquals(pdlogo, palogo);
		Assert.assertEquals(pdname, paname);

	}

}
