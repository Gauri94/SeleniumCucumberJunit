package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {
	
	public WebDriver driver;
	public WebDriverWait wait;
	
	public Page(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public abstract WebElement getElement(By locator);
	
	public abstract void waitForElementPresent(By locator);

	public <TPage extends BasePage> TPage getInstance(Class<TPage> pageClass)
	{
		try {
			return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(driver);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
