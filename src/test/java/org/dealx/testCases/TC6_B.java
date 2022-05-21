package org.dealx.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


import org.dealx.pageObjects.TC6_BObjects;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC6_B extends BaseClass{
	
	String querySearch ="Evening Dresses - My Store";
	@Test
	public void navigateSubCat() throws IOException {
		driver.get(baseURL);
		driver.manage().window().maximize();
		logger.info("TC6_B - URL is opened");
		TC6_BObjects tc6_bobjects =  new TC6_BObjects(driver);
		tc6_bobjects.hoverDresses();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		tc6_bobjects.clickLinkEveningDresses();
		System.out.println("Link clicked");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	   //Validate Title
		if(validateTitle(querySearch)) {
			Assert.assertTrue(true);
			logger.info("TC6_B - Validation Successful");
			
		}else {
			captureScreen(driver,"navigateSubCat");
			Assert.assertTrue(false);
			logger.info("TC6_B - Validation Failed");
		}

	
	}
	

}
