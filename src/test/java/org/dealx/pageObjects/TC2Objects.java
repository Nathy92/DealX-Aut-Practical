package org.dealx.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TC2Objects {
	// Local driver declaration
	WebDriver ldriver;

	public TC2Objects(WebDriver rdriver) {
		this.ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(name = "search_query")
	@CacheLookup
	WebElement txtSearch;

	@FindBy(name = "submit_search")
	@CacheLookup
	WebElement btnSearch;

	@FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[1]/div/div[1]/div/a[1]/img")
	@CacheLookup
	WebElement linkFirstEle;
    
	//Get String from first index
	public void searchQueue() {
		String[] cars = { "Printed Chiffon Dress", "Printed Summer Dress", "Blouse" };
		txtSearch.sendKeys(cars[0]);
	}

	
	public void clickFirstEle() {
		linkFirstEle.click();
	}

	// Action methods
	public void setQuery(String query) {
		txtSearch.sendKeys(query);
	}

	public void clickSubmit() {
		btnSearch.click();
	}

}
