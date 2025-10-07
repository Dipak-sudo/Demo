package com.Stepdefination;


import com.Pages.register_page;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import junit.framework.Assert;

public class Register extends BaseTest {
	register_page registrationpage =new register_page(driver);
	String email;

	@Given("user naviagtes to registration page")
	public void user_naviagtes_to_registration_page() {
		registrationpage.userNaviagtesToRegisterPAge();
	}

	@Given("enters the mandatory fields {string} {string} {string} {string} {string} {string}")
	public void enters_the_mandatory_fields(String string, String string2, String string3, String string4,
			String string5, String string6) {
		if(string3.equalsIgnoreCase("randomemail")) {
			 email=randomemail();
		}
		
		registrationpage.enetrMandatoryFileds(string, string2, email, string4, string5, string6);
		
	}

	@Given("selects privacy policy")
	public void selects_privacy_policy() {
		registrationpage.selectPrvacyPolicy();
	}

	@Given("clicks on continue button")
	public void clicks_on_continue_button() {
		registrationpage.clickOncontinueButton();
	}

	@Then("the account should get created successfully")
	public void the_account_should_get_created_successfully() {
		String currenturl =driver.getCurrentUrl();
		Assert.assertEquals("https://tutorialsninja.com/demo/index.php?route=account/success", currenturl);
		String pagetitle= driver.getTitle();
		System.out.println(pagetitle);
		Assert.assertEquals("Your Account Has Been Created!", pagetitle);
	}

}
