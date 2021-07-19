package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountsPage extends BasePage {
	
	public AccountsPage(WebDriver driver)
	{
		super(driver);
	}
	
	By accountSections = By.cssSelector("div.row.addresses-lists span");
	
	public List<String> getAccountSectionList()
	{
		List<String> accountList = new ArrayList<>();
		List<WebElement> accountsHeaderList = driver.findElements(accountSections);
		
		for(WebElement e: accountsHeaderList)
		{
			String text = e.getText();
			accountList.add(text);
		}
		return accountList;
	}
	
	public String getAccountsPageTitle()
	{
		return driver.getTitle();
	}
	
	public int getAccountSectionsSize()
	{
		return driver.findElements(accountSections).size();
	}
}
