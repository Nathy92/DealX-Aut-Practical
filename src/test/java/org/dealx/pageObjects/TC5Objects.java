package org.dealx.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TC5Objects {

	// Local driver declaration
	WebDriver ldriver;
	Actions action;

	public TC5Objects(WebDriver rdriver) {
		this.ldriver = rdriver;
		action = new Actions(rdriver);
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[2]/a")
	@CacheLookup
	WebElement btnDresses;

	@FindBy(xpath = "//div[@id='center_column']/ul/li/div/div[2]/div[2]/a/span")
	@CacheLookup
	WebElement dress1;

	@FindBy(xpath = "//img[@title='Faded Short Sleeve T-shirts']")
	@CacheLookup
	WebElement clickAddToCart;

	@FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span/span")
	@CacheLookup
	WebElement clickContinueShp;

	// Methods
	public void clickDresses() {
		btnDresses.click();
	}

	public void hooverDress() {
		// Actions action = new Actions(ldriver);
		// action.moveToElement(dress1).perform();

		clickAddToCart.click();
	}

	public void hooverDress2() {
		clickAddToCart.click();
	}

	public void clickContShpng() {
		clickContinueShp.click();
	}

	// Scrolling method
	public void scrollDown(WebDriver driver) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("window.scrollBy(0,700)", "");

	}

	// Mouse Over method
	public void performMouseOver(WebElement element) {
		action.moveToElement(element).build().perform();
	}

	// Click on the Hovered Element
	public void clickUsingJavaExe(WebElement element, WebDriver driver) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	// Latest
	@FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/h5/a")
	@CacheLookup
	WebElement prod1Img;

	@FindBy(xpath = "//*[@id=\"quantity_wanted\"]")
	@CacheLookup
	WebElement txtQuantity;

	@FindBy(xpath = "//*[@id=\"group_1\"]/option[2]")
	@CacheLookup
	WebElement dropDwnSize;

	@FindBy(xpath = "//*[@id=\"color_16\"]")
	@CacheLookup
	WebElement selectColor;

	@FindBy(xpath = "//*[@id=\"add_to_cart\"]/button/span")
	@CacheLookup
	WebElement btnAdd2Cart;

	@FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span")
	@CacheLookup
	WebElement clickProceedCheckput;

	// For calculations
	@FindBy(xpath = "//td[@class='cart_unit']/span/span")
	@CacheLookup
	WebElement txtUnitPrice;

	@FindBy(xpath = "//span[@id='total_price']")
	@CacheLookup
	WebElement txtTotPrice;

	@FindBy(xpath = "//span[text()='Proceed to checkout']")
	@CacheLookup
	WebElement btnProceedToCheckout;
	

	@FindBy(xpath ="//i[@class=\"icon-plus\"]")
	@CacheLookup
	WebElement plusLink;
	
	
	@FindBy(xpath ="//input[@name=\"quantity_2_7_0_0\" and @class=\"cart_quantity_input form-control grey\"]")
	@CacheLookup
	WebElement txtQuantity2;

	//Increase Quantity 
	public void IncreasQuantity() {
		for (int i = 0; i < 2; i++) {
			plusLink.click();
		}
	}

	//Get unit price
	public double getUnitPrice() {
		String unitPrice = txtUnitPrice.getText();
		String unit = unitPrice.replaceAll("[^a-zA-Z0-9]", "");
		double finalUnitPrice = Double.parseDouble(unit);
		return finalUnitPrice / 100;
	}

	//Get total Price
	public double getTotPrice() {
		String totalPrice = txtTotPrice.getText();
		String tot = totalPrice.replaceAll("[^a-zA-Z0-9]", "");
		double finalTotPrice = Double.parseDouble(tot);
		return finalTotPrice / 100;
	}
	
	//Get Quantity
	public int getQuantity() {
		String quantity = txtQuantity2.getText();
		int finalQuantity = Integer.parseInt(quantity);
		return finalQuantity;
	}
	
	// Calculate Total
	public double Total(double unitP, double Quantity) {
		double result = getUnitPrice() * getQuantity();
		return result;
	}

	public void clickCheckout() {
		btnProceedToCheckout.click();
	}

	public void clickImg() {
		prod1Img.click();
	}

	public void addQuantity(String quant) {
		txtQuantity.sendKeys(quant);
	}

	public void selectSize() {
		dropDwnSize.click();
	}

	public void selectColor() {
		selectColor.click();
	}

	public void clickAdd2Cart() {
		btnAdd2Cart.click();
	}

	public void proceedCheckOut() {
		clickProceedCheckput.click();
	}

	
	
	
	


}
