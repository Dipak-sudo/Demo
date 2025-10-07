package com.Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Util.Driverfactory;



public class BasePage {
	WebDriver driver;
	WebDriverWait wait;

	public BasePage() {
		this.driver = Driverfactory.getDriver();
	}

	public void waitforelementToBeVisible(int time, WebElement element) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitForElementToBeClickable(WebElement element, int timeout) {
	 wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitForUrlTobe(String url) {
		wait.until(ExpectedConditions.urlToBe(url));
	}

	public void waitForEitherUrlOrError(String successUrl, WebElement element,int time) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.or(ExpectedConditions.urlToBe(successUrl),
				ExpectedConditions.visibilityOf(element)));

	}
}
