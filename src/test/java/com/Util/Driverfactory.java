package com.Util;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;



public class Driverfactory {
	public static WebDriver driver;

	public void initialiseDriver() throws InterruptedException {
		String browser = System.getProperty("browser");
		if (browser == null || browser.isEmpty()) {
			PropertiesUtils.readPropertiesFile("config.properties");
			browser = PropertiesUtils.getKey("browser");
		}
		if (browser.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			//options.addArguments("headless");
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			FirefoxOptions options = new FirefoxOptions();
			//options.addArguments("--headless");
			driver = new FirefoxDriver(options);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		}
		else if (browser.equalsIgnoreCase("edge")) {
			EdgeOptions options=new EdgeOptions();
			//options.addArguments("--headless");
			driver = new EdgeDriver(options);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		}
		else {
			System.out.println("Enter correct browser in config.properties");
		}
	}

	public static WebDriver getDriver() {	
		return driver;
	}

	public void quitDriver() {
		if (getDriver() == null) { 
			getDriver().close();
		}
		getDriver().quit();
	}


}
