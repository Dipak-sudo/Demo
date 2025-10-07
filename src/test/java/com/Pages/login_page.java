package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class login_page extends BasePage {
	WebDriver driver;

	public login_page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//span[normalize-space()='My Account']")
	private WebElement ele_myAccount_Btn;

	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']")
	private WebElement ele_MyaccLogin_Btn;

	@FindBy(xpath = "//input[@id='input-email']")
	private WebElement ele_email_Inputbox;

	@FindBy(xpath = "//input[@id='input-password']")
	private WebElement ele_password_Inputbox;

	@FindBy(xpath = "//input[@value='Login']")
	private WebElement ele_login_Btn;
	
	@FindBy(xpath = "//div[contains(@class, 'alert-danger') and contains(text(), 'Warning')]")
	private WebElement ele_Error_Message;
	
	@FindBy(xpath = "//div[@class='form-group']//a[normalize-space()='Forgotten Password']")
	private WebElement ele_forgotPassword;

	
	
	
	

	public void userNaviagtestoLogin()  {
		waitforelementToBeVisible(10, ele_myAccount_Btn);
		ele_myAccount_Btn.click();
		waitforelementToBeVisible(10, ele_MyaccLogin_Btn);
		ele_MyaccLogin_Btn.click();
		waitForUrlTobe("https://tutorialsninja.com/demo/index.php?route=account/login");
	}

	public void enterEmailandPassword(String email, String password) {
		ele_email_Inputbox.sendKeys(email);
		ele_password_Inputbox.sendKeys(password);
	}
	public void clearEmailandPassword() {
		ele_email_Inputbox.clear();
		ele_password_Inputbox.clear();
	}

	public void clickOnLoginBtn() {
		ele_login_Btn.click();
		
		try {
			waitForEitherUrlOrError("https://tutorialsninja.com/demo/index.php?route=account/account",
					ele_Error_Message, 5);
		}
		catch(Exception e) {
			System.out.println("Neither success nor failure condition met within timeout");
	}
		
	}
	public String getErrorMessage() {
		waitforelementToBeVisible(10, ele_Error_Message);
		return ele_Error_Message.getText();
	}
	public void clickOnForgotPassword() {
		ele_forgotPassword.click();
		waitForUrlTobe("https://tutorialsninja.com/demo/index.php?route=account/forgotten");
	}
}
