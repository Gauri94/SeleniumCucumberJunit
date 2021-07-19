package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	private By email = By.xpath("//input[@name = 'email']");
	private By password = By.xpath("//input[@name = 'passwd']");
	private By signInButton = By.xpath("//button[@id = 'SubmitLogin']");
	private By forgotPassLink = By.linkText("Forgot your password?");
	
	public WebElement getEmail()
	{
		return getElement(email);
	}
	
	public WebElement getPassword()
	{
		return getElement(password);
	}
	
	public WebElement getSignInButton()
	{
		return getElement(signInButton);
	}
	
	public WebElement getForgotPassword()
	{
		return getElement(forgotPassLink);
	}
	
	public String getLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean isForgotPassDisplayed()
	{
		return getForgotPassword().isDisplayed();
	}
	
	public void enterUserName(String username)
	{
		getEmail().sendKeys(username);
	}
	
	public void enterPassword(String pass)
	{
		getPassword().sendKeys(pass);
	}
	
	public void clickOnLogin()
	{
		getSignInButton().click();
	}
	
	public AccountsPage doLogin(String username, String password)
	{
		getEmail().sendKeys(username);
		getPassword().sendKeys(password);
		getSignInButton().click();
		return getInstance(AccountsPage.class);
	}

}
