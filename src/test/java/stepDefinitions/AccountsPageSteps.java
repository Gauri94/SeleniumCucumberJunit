package stepDefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.pages.AccountsPage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


public class AccountsPageSteps {
	
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private AccountsPage accountsPage;
	
	@Given("User is already logged into the application")
	public void user_is_already_logged_into_the_application(DataTable dataTable) {
	   
		List<Map<String, String>> credList = dataTable.asMaps();
		String username = credList.get(0).get("username");
		String password = credList.get(0).get("password");
		
		DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		
		accountsPage = loginPage.doLogin(username, password);
	}

	@Given("User is on Accounts Page")
	public void user_is_on_accounts_page() {
	    accountsPage.getAccountsPageTitle();
	}

	@Then("User gets Account Section")
	public void user_gets_account_section(DataTable sectionTable) {
		List<String> expectedSections = sectionTable.asList();
		List<String> actualSections = accountsPage.getAccountSectionList();
		
		System.out.println("Expected sections :::" +expectedSections);
		System.out.println("Actual sections :::" +actualSections);
		Assert.assertTrue(expectedSections.equals(actualSections));
	}

	@Then("Accounts section count should be {int}")
	public void accounts_section_count_should_be(int expectedSize) {
		Assert.assertEquals(accountsPage.getAccountSectionsSize(), expectedSize);
	}

}
