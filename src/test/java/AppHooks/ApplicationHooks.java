package AppHooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {
	
	private DriverFactory driverFactory;
	private ConfigReader configReader;
	private WebDriver driver;
	Properties properties;
	
	@Before(order = 0)
	public void getProperty()
	{
		configReader = new ConfigReader();
		properties = configReader.initProperties();
	}
	
	@Before (order = 1)
	public void launchBrowser()
	{
		String browserName = properties.getProperty("browser");
		driverFactory = new DriverFactory();
		driver = driverFactory.initDriver(browserName);
	}
	
	@After (order = 0)
	public void quitBrowser()
	{
		driver.quit();
	}
	
	@After (order = 1)
	public void tearDown(Scenario scenario)
	{
		if(scenario.isFailed())
		{
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);
		}
	}

}
