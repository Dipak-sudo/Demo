package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class search_page extends BasePage {

	WebDriver driver;

	public search_page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement ele_SearchBox;
	
	@FindBy(xpath = "//i[@class='fa fa-search']")
    WebElement ele_SearchBtn;
	
	@FindBy(xpath="//a[normalize-space()='iMac']")
    WebElement ele_SearchedProducts;
	
	@FindBy(xpath="//p[contains(text(),'There is no product that matches the search criter')]")
	WebElement ele_ErrorMessage;
	
	public void enterPRoductName() {
		ele_SearchBox.sendKeys("iMac");
	}
	public void clickoNSearchButton() {
		ele_SearchBtn.click();
	}
	public String getSeearchedProductname() {
		return ele_SearchedProducts.getText();
	}
	public void enetrInvalidProduct() {
		ele_SearchBox.sendKeys("ivnalidproduct");
		
	}
	public String getErrorMsgInvalidPRoduct() {
		return ele_ErrorMessage.getText();
	}
	
	
	
}