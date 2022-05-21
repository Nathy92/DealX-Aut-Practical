package org.dealx.testCases;

import java.io.IOException;


import org.dealx.pageObjects.TC4Objects;
import org.junit.Assert;
import org.testng.annotations.Test;

public class TC4 extends BaseClass {

	@Test
	public void login() throws IOException {
         
		String valTitle = "My account - My Store1";
		driver.get(baseURL);
		driver.manage().window().maximize();
		logger.info("TC4 - URL is opened");

		TC4Objects tc4Objects = new TC4Objects(driver);
		tc4Objects.clickBtnLogin();
		tc4Objects.sendEmail(_email);
		tc4Objects.sendPass(_pass);
		tc4Objects.clickFinaSub();
		
		//Validate if login was successful
		if(validateTitle(valTitle)) {
			Assert.assertTrue(true);
			logger.info("TC4 - Login Successful");
			
		}else {
			captureScreen(driver,"login");
			Assert.assertTrue(false);
			logger.info("TC4 - Login Not Successful");
		}
		
	}

}
