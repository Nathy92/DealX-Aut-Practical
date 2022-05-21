package org.dealx.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TC6_BObjects {
	
	// Local driver declaration
			WebDriver ldriver;
			Actions action;

			public TC6_BObjects(WebDriver rdriver) {
				this.ldriver = rdriver;
				action = new Actions(rdriver);
				PageFactory.initElements(rdriver, this);
			}
			
			@FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[2]/a")
			@CacheLookup
			WebElement btnDresses;
			
			
			@FindBy(xpath = "//a[@title=\"Evening Dresses\"]")
			@CacheLookup
			WebElement linkEveningDresses;
			
			public void hoverDresses() {
				action.moveToElement(btnDresses).build().perform();
				
			}
			
			public void clickLinkEveningDresses() {
				action.click().click(linkEveningDresses);
			}
			
			

}
