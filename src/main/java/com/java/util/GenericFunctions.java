package com.java.util;



import io.qameta.allure.Allure;
import io.qameta.allure.AllureLifecycle;

public class GenericFunctions {

	public static void updateTestCaseName(String message)
	{
		 AllureLifecycle lifecycle = Allure.getLifecycle();
	       lifecycle.updateTestCase(testResult -> testResult.setName(message));
	}
}
