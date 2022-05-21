package org.dealx.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.dealx.pageObjects.TC1Objects;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC1 extends BaseClass {
    
	String queryT = "Printed chiffon knee length dress with tank straps. Deep v-neckline.";
	
	@Test
	public void searchQuery() throws IOException {
	
		driver.get(baseURL);
		driver.manage().window().maximize();
		logger.info("TC1 - URL is opened");
		
		TC1Objects tcObjects =  new TC1Objects(driver);
		
		tcObjects.setQuery(query);
		tcObjects.clickSubmit();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		tcObjects.clickFirstEle();
		
	
		if(validateTitle(queryT)) {
			Assert.assertTrue(true);
			logger.info("TC1 - Validation Successful");
			
		}else {
			captureScreen(driver,"searchQuery");
			Assert.assertTrue(false);
			logger.info("TC1 - Validation Failed");
			
		}							

	}

}
