package org.dealx.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TC4Objects {
	//Local driver declaration
		WebDriver ldriver;
		
		public TC4Objects(WebDriver rdriver){
			this.ldriver = rdriver;
			PageFactory.initElements(rdriver, this);
		}
		
		@FindBy(xpath="//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
		@CacheLookup
		WebElement btnLogin;
		
		@FindBy(xpath="//*[@id=\"email\"]")
		@CacheLookup
		WebElement txtEmailAddr;
		
		@FindBy(xpath="//*[@id=\"passwd\"]")
		@CacheLookup
		WebElement txtPassword;
		
		@FindBy(xpath="//*[@id=\"SubmitLogin\"]/span")
		@CacheLookup
		WebElement btnFinalSub;
		
		public void clickBtnLogin() {
			btnLogin.click();
		}
		
		
		public void sendEmail(String email) {
			txtEmailAddr.sendKeys(email);
		}
		
		public void sendPass(String pass) {
			txtPassword.sendKeys(pass);
		}
		

		public void clickFinaSub() {
			btnFinalSub.click();
		}
		
		

}
