package com.Stepdefination;

import java.util.List;
import java.util.Map;

import com.Pages.login_page;
import com.Util.ExcelUtil;
import com.Util.SeleniumUtil;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class Login_Steps extends BaseTest {

	login_page login = new login_page(driver);

	@Given("user navigate to the login page")
	public void user_navigate_to_the_login_page() {
		login.userNaviagtestoLogin();
	}
//
//	@When("user enters valid {string} and password {string}")
//	public void user_enters_valid_and_password(String string, String string2) {
//		login.enterEmailandPassword(string, string2);
//	}

	
	//------------------------------------------------------------------WITH EXCEL-----------------------------
//	@When("user logs in with data from Excel {string} and sheet {string}")
//	public void user_logs_in_with_data_from_excel_and_sheet(String filePath, String sheetName) throws Exception {
//		ExcelUtil excel = new ExcelUtil(filePath, sheetName);
//		int totalRows = excel.getRowCount(); // get number of data rows
//
//		for (int i = 1; i <= totalRows; i++) { // start from 1 if row 0 is header
//			String[] rowData = excel.getRowData(i);
//			String email = rowData[0];
//			String password = rowData[1];
//			System.out.println("Attempting login with Email: " + email + " | Password: " + password);
//			login.enterEmailandPassword(email, password);
//			login.clickOnLoginBtn();
//			Thread.sleep(2000);
//
//			String pagetitle = driver.getTitle();
//			System.out.println("The page title after login is " + pagetitle);
//			Assert.assertEquals("My Account", pagetitle);
//			driver.navigate().back();
//			login.clearEmailandPassword();
//  
//			// Close workbook after all iterations
//			excel.closeWorkbook();
//		}
//	}
//
//	@Then("the user should successfully login")
//	public void the_user_should_successfully_login() {
//		// Already handled inside the @When loop
//		System.out.println("All Excel rows processed successfully.");
//	}
//------------------------------------------------------------------WITH EXCEL UPTO 61-----------------------------
//	@And("clicks on login button") 
//	public void clicks_on_login_button() throws InterruptedException {
//		login.clickOnLoginBtn();
//		 
//
//	}

//	@Then("the user should successfully login")
//	public void the_user_should_successfully_login() {
//		String pagetitle = driver.getTitle();
//		System.out.println("The page title after login is " + pagetitle);
//		Assert.assertEquals("My Account", pagetitle);
//
//
//	}
	
	//with map from here---------------------------------------------------------------------------------------------------
	 @When("user logs in with following details")
	    public void user_logs_in_with_following_details(DataTable dataTable) {
	        // Convert DataTable to Map
	        Map<String, String> data = dataTable.asMap(String.class, String.class);

	        String email = data.get("email");
	        String password = data.get("password");

	        System.out.println("Logging in with Email: " + email + " | Password: " + password);

	        login.enterEmailandPassword(email, password);
	        login.clickOnLoginBtn();
	    }

	    @Then("the user should successfully login")
	    public void the_user_should_successfully_login() {
	        String pageTitle = driver.getTitle();
	        System.out.println("The page title is: " + pageTitle);
	        Assert.assertEquals(pageTitle, "My Account", "Login failed!");
	    }
	
//with map upto the above line--------------------------------------	
	

	@When("the user enters Invalid user name {string} and invalid password {string}")
	public void the_user_enters_invalid_user_name_and_invalid_password(String string, String string2) {
		login.enterEmailandPassword(string, string2);
	}

	@Then("the error message should be displayed")
	public void the_error_message_should_be_displayed() {
		String errormsg = login.getErrorMessage();
		System.out.println("The error message is " + errormsg);
		Assert.assertEquals("Warning: No match for E-Mail Address and/or Password.", errormsg);
	}

	@When("the user clicks on the forgot password")
	public void the_user_clicks_on_the_forgot_password() {
		login.clickOnForgotPassword();

	}

	@Then("the user should naviagte to forgot password page")
	public void the_user_should_naviagte_to_forgot_password_page() {
		String pagetitle = driver.getTitle();
		System.out.println(pagetitle);
		Assert.assertEquals("Forgot Your Password?", pagetitle);

	}
}
