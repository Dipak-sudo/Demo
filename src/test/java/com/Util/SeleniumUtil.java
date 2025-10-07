package com.Util;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;

import com.Pages.login_page;



public class SeleniumUtil {
	static WebDriver driver;
	static login_page loginpage ;
	
	public static void loginToApplication() {
		driver =Driverfactory.getDriver();
		loginpage = new login_page(driver);
		loginpage.userNaviagtestoLogin();
		loginpage.enterEmailandPassword("mogoge7150@flektel.com", "Test@1234");
		loginpage.clickOnLoginBtn();
		
	}
}
	
	
   
	