package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasePage extends Page {

	
	public BasePage(WebDriver driver) {
		super(driver);
	}

	@Override
	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	@Override
	public void waitForElementPresent(By locator) {
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}

}
