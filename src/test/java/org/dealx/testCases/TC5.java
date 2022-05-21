package org.dealx.testCases;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.dealx.pageObjects.TC1Objects;
import org.dealx.pageObjects.TC5Objects;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC5 extends BaseClass{
	
	String quantity = "1";
	
	@Test
	public void addToCart() throws InterruptedException, IOException {
		
		driver.get(baseURL);
		driver.manage().window().maximize();
		logger.info("TC5 - URL is opened");
		
		
		TC5Objects tc5objects = new TC5Objects(driver);
	    TC1Objects tcObjects =  new TC1Objects(driver);
		
		tcObjects.setQuery(query);
		tcObjects.clickSubmit();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		tcObjects.clickFirstEle();
		tc5objects.scrollDown(driver);
	
		
	
		tc5objects.clickDresses();
		tc5objects.scrollDown(driver);
		tc5objects.clickImg();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		tc5objects.addQuantity(quantity);
		tc5objects.selectSize();
		tc5objects.clickAdd2Cart();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		tc5objects.proceedCheckOut();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		tc5objects.IncreasQuantity();
	
		
		tc5objects.scrollDown(driver);
		int quantityFinal =  tc5objects.getQuantity();
		double unitPrice = tc5objects.getUnitPrice();
		double totalPrice = tc5objects.getTotPrice();
		double totalExpectedPrice = tc5objects.Total(unitPrice, quantityFinal);
	
		//Validate Prices
		if(totalPrice == totalExpectedPrice) {
			Assert.assertTrue(true);
			logger.info("TC5 - Total Price Validation Successful");
		}
		else {
			//If validation fails, take screenshot
			captureScreen(driver, "addToCart");
			Assert.assertTrue(false);
			logger.info("TC5 - Total Price Validation Fail");
		}
		
	}

}
