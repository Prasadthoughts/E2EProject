package Academy;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.LandingPage;
import resources.base;

public class validateTitle extends base{
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}
	
	
	@Test
	public void basePageNavigation() throws IOException
	{
		
		
		LandingPage lp=new LandingPage(driver);
		System.out.println(lp.getTitle().getText());
		Assert.assertEquals(lp.getTitle().getText(), "FEATURED COURSES");	
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}

}
