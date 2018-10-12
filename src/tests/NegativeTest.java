package tests;

import org.testng.annotations.Test;

import pages.BaseClass;
import pages.Home;

public class NegativeTest extends BaseClass{
	
	@Test(description="Verify a blank field is not accepted", groups = {"regression"})
	public void BlankField() throws InterruptedException{		
		Home home = new Home(driver);
		
		home.openHome();
		home.clickSubmit();
		home.verifyPageURL(home.homeURL());
	}
	
	@Test(description="Verify negative numbers are not accepted", groups = {"regression"})
	public void NegativeNumbers() throws InterruptedException{		
		Home home = new Home(driver);
		
		home.openHome();
		home.setRooms(-42);
		home.clickSubmit();
		home.verifyPageURL(home.homeURL());
	}
	
	@Test(description="Verify decimal numbers are not accepted", groups = {"regression"})
	public void DecimalNumbers() throws InterruptedException{		
		Home home = new Home(driver);
		
		home.openHome();
		home.setRoomsDouble(3.14);
		home.clickSubmit();
		home.verifyPageURL(home.homeURL());
	}
}