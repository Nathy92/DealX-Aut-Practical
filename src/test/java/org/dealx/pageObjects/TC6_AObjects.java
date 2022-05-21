package org.dealx.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TC6_AObjects {
	
	// Local driver declaration
		WebDriver ldriver;
		Actions action;

		public TC6_AObjects(WebDriver rdriver) {
			this.ldriver = rdriver;
			action = new Actions(rdriver);
			PageFactory.initElements(rdriver, this);
		}

		@FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[1]/a")
		@CacheLookup
		WebElement btnWomen;
		
		@FindBy(xpath = "//a[@title=\"T-shirts\"]")
		@CacheLookup
		WebElement linkTShirts;
		
		@FindBy(xpath = "//a[@title=\"Casual Dresses\"]")
		@CacheLookup
		WebElement linkCasualDresses;
	
		
		public void hoverWomen() {
			action.moveToElement(btnWomen).build().perform();
		}
		
		public void clickLinkTshirt() {
			action.click().click(linkTShirts);
		}
		
		
		public void clickLinkCasualDresses() {
			action.click().click(linkCasualDresses);
		}
			

}
