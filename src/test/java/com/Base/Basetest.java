package com.Base;

import org.openqa.selenium.WebDriver;

import com.Util.Driverfactory;
import com.Util.SeleniumUtil;
import com.github.javafaker.Faker;

public class Basetest {
	
	WebDriver driver = Driverfactory.getDriver();
	SeleniumUtil seleniumutils = new SeleniumUtil();
	
	
	public String randomemail() {
	    Faker faker = new Faker();
	    return faker.name().username() + System.currentTimeMillis() + "@yopmail.com";
	}


}

