package org.dealx.testCases;

import java.io.IOException;

import org.dealx.pageObjects.TC1Objects;
import org.dealx.utilities.XLUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class TC3 extends BaseClass{
	
	String queryT = "Printed chiffon knee length dress with tank straps. Deep v-neckline.";
	
	@Test(dataProvider="QueryData")
	public void performSearch(String _query) throws IOException {
		
		driver.get(baseURL);
		driver.manage().window().maximize();
		logger.info("TC3 - URL is opened");
		TC1Objects tc10gj = new TC1Objects(driver);
		tc10gj.setQuery(_query);
	    tc10gj.clickSubmit();
		//tc10gj.setQuery(val);	
	    
	    logger.info("Search Query Submitted");
		
		if(validateTitle(queryT)) {
			
			Assert.assertTrue(true);
			logger.info("TC3 - Validation Successful");
			
		}else {
		
			captureScreen(driver,"performSearch");
			Assert.assertTrue(false);
			logger.info("TC3 - Validation Not Successful");
			
		}
	}
	
	//ATTEMPTING - Excel function for getting data
	@DataProvider(name="QueryData")
	String[] getData() throws IOException{
		
		String path = System.getProperty("user.dir") + "/src/test/java/org/dealx/testData/userData.xlsx";

		int rownum = XLUtils.getRowCount(path, "Sheet1");

		String userData[] = new String[rownum];

		for (int i = 1; i < rownum; i++) {
				userData[i] = XLUtils.getCellData(path, "Sheet1", i,0);	
			}
		
		return userData;
		
	}
	
	
	}



