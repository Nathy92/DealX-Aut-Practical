package org.dealx.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


import org.dealx.pageObjects.TC6_AObjects;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC6_A extends BaseClass {
	
	
	
	@Test
	public void navigateMenu() throws IOException {
		
		String casualTitle ="T-shirts - My Store";
		
		driver.get(baseURL);
		driver.manage().window().maximize();
		logger.info("TC6_A - URL is opened");
		TC6_AObjects tc6_aobjects =  new TC6_AObjects(driver);
		
		tc6_aobjects.hoverWomen();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		tc6_aobjects.clickLinkTshirt();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//Validate Title
		if(validateTitle(casualTitle)){
			Assert.assertTrue(true);
			logger.info("TC6_A - Validation Successful");
			
		}else {
			
			captureScreen(driver,"navigateMenu");
			Assert.assertTrue(false);
			logger.info("TC6_A - Validation Failed");
		}
			
	}

}
