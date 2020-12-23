package Academy;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.base;

public class validatenavigation extends base {
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
        driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}
	
	@Test
	public void navigationBar() throws IOException
	{
		
		LandingPage l=new LandingPage(driver);
		Assert.assertTrue(l.getNavBar().isDisplayed());	
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}

}
