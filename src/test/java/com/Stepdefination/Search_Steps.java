package com.Stepdefination;

import org.testng.Assert;

import com.Pages.search_page;
import com.Util.SeleniumUtil;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Search_Steps extends BaseTest {
	search_page searchpage = new search_page(driver);
	
	
	@Given("User is already logged in the application")
	public void user_is_already_logged_in_the_application() {
		SeleniumUtil.loginToApplication();
	}

	@Given("User enters a valid prodct in the search filed")
	public void user_enters_a_valid_prodct_in_the_search_filed() {
		searchpage.enterPRoductName();
	}

	@Given("Clicks on the seach button")
	public void clicks_on_the_seach_button() {
		searchpage.clickoNSearchButton();
	}

	@Then("the valid product should be displayed")
	public void the_valid_product_should_be_displayed() {
		String name= searchpage.getSeearchedProductname();
		Assert.assertEquals("iMac", name);
	}

	@Given("User enters an invalid prodct in the search filed")
	public void user_enters_an_invalid_prodct_in_the_search_filed() {
		searchpage.enetrInvalidProduct();
	}

	@Then("the customer should be informed about the non eistance of the product")
	public void the_customer_should_be_informed_about_the_non_eistance_of_the_product() {
		String message = searchpage.getErrorMsgInvalidPRoduct();
		Assert.assertEquals("There is no product that matches the search criteria.", message);
	}
	
}
