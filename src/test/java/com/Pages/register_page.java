package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class register_page extends BasePage {
WebDriver driver;



public register_page(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	
}
@FindBy(xpath = "//span[normalize-space()='My Account']")
private WebElement ele_myAccount_Btn;

@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']")
private WebElement ele_Register_btn;

@FindBy(xpath = "//input[@id='input-firstname']")
private WebElement ele_FirstName;

@FindBy(xpath = "//input[@id='input-lastname']")
private WebElement ele_LastName;

@FindBy(xpath = "//input[@id='input-email']")
private WebElement ele_Email;

@FindBy(xpath = "//input[@id='input-telephone']")
private WebElement ele_Phone;

@FindBy(xpath = "//input[@id='input-password']")
private WebElement ele_Password;

@FindBy(xpath = "//input[@id='input-confirm']")
private WebElement ele_ConfirmPassword;

@FindBy(xpath = "//input[@name='agree']")
private WebElement ele_PrivacyPolicy;

@FindBy(xpath = "//input[@value='Continue']")
private WebElement ele_ContinueBtn;




public void userNaviagtesToRegisterPAge() {
	ele_myAccount_Btn.click();
	waitForElementToBeClickable(ele_Register_btn, 5);
	ele_Register_btn.click();
	waitForUrlTobe("https://tutorialsninja.com/demo/index.php?route=account/register");
}
	public void enetrMandatoryFileds(String firstname, String lastname, String email, String phno,String password,String confirmapass) {
		ele_FirstName.sendKeys(firstname);
		ele_LastName.sendKeys(lastname);
		ele_Email.sendKeys(email);
		ele_Phone.sendKeys(phno);
		ele_Password.sendKeys(password);
		ele_ConfirmPassword.sendKeys(confirmapass);
	}
	public void selectPrvacyPolicy() {
		ele_PrivacyPolicy.click();
	}
	public void clickOncontinueButton() {
		ele_ContinueBtn.click();
		waitForUrlTobe("https://tutorialsninja.com/demo/index.php?route=account/success");
	}
	
	
}





