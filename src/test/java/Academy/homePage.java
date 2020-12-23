package Academy;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class homePage extends base{
	
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}
	
	@Test(dataProvider="getData")
	public void basePageNavigation(String username,String Password) throws IOException, InterruptedException
	{
		
		
		LandingPage l=new LandingPage(driver);
		l.getlogin().click();
		LoginPage lp=new LoginPage(driver);
		lp.getEmail().sendKeys(username);
		lp.getPassword().sendKeys(Password);
		lp.getLogin().click();
	
	}
	
	@DataProvider
	public Object[][] getData()
	{
		//Row defines the different types of data passed into the test
		//Column defines the number of values passed into the test
		Object[][] data=new Object[2][2];
		data[0][0]="prasadkaallakuri@gmail.com";
		data[0][1]="123456789";
		
		data[1][0]="prasad14aero@gmail.com";
		data[1][1]="durgaprasad";
		return data;
		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}

}
