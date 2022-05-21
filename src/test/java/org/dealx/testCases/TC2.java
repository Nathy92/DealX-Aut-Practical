package org.dealx.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.dealx.pageObjects.TC2Objects;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC2 extends BaseClass {
	
	String queryT = "Printed chiffon knee length dress with tank straps. Deep v-neckline.";
	
	@Test
	public void searchQ() throws IOException {
		driver.get(baseURL);
		driver.manage().window().maximize();
		logger.info("TC2 - URL is opened");

		TC2Objects tc2Objects = new TC2Objects(driver);
		tc2Objects.searchQueue();
		tc2Objects.clickSubmit();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		tc2Objects.clickFirstEle();


		if (validateTitle(queryT)) {	
			Assert.assertTrue(true);
			logger.info("TC2 - Validation Successful");
			
		} else {
			captureScreen(driver, "searchQuery");
			Assert.assertTrue(false);
			logger.info("TC2 - Validation Failed");
		}

	}

}
