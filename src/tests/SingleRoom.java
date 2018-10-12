package tests;

import org.testng.annotations.Test;

import pages.BaseClass;
import pages.Dimensions;
import pages.Home;
import pages.Results;

public class SingleRoom extends BaseClass{
	
	@Test(description="Verify a single room with known values", groups = {"regression"})
	public void singleRoomKnownValues(){		
		Home home = new Home(driver);
		Dimensions dimensions = new Dimensions(driver);
		Results results = new Results(driver);

		//Set amount of rooms on home page
		home.openHome();
		home.setRooms(1);
		home.clickSubmit();

		//Enter dimensions of room
		dimensions.setLength(0, 20);
		dimensions.setWidth(0, 20);
		dimensions.setHeight(0, 10);
		dimensions.clickSubmit();
		
		//Verify calculations for accuracy
		results.verifyFeet(0, 800);
		results.verifyGallons(0, 2);
		results.verifyTotalGallons(2);
		results.clickSubmit();
		
		//Verify return to home URL
		home.verifyPageURL(home.homeURL());
	}
	
	@Test(description="Verify a single room with random values", groups = {"regression"})
	public void singleRoomRandomValues(){		
		Home home = new Home(driver);
		Dimensions dimensions = new Dimensions(driver);
		Results results = new Results(driver);

		//Set amount of rooms on home page
		home.openHome();
		home.setRooms(1);
		home.clickSubmit();
		
		//Randomly generate room dimensions
		int length = dimensions.random100();
		int width = dimensions.random100();
		int height = dimensions.random100();

		//Enter dimensions of room
		dimensions.setLength(0, length);
		dimensions.setWidth(0, width);
		dimensions.setHeight(0, height);
		dimensions.clickSubmit();
		
		//Verify calculations for accuracy
		int feet = results.calculateFeet(length, width, height);
		results.verifyFeet(0, feet);
		results.verifyGallons(0, results.calculateGallons(feet));
		results.verifyTotalGallons(results.calculateGallons(feet));
		results.clickSubmit();
		
		//Verify return to home URL
		home.verifyPageURL(home.homeURL());
	}
}