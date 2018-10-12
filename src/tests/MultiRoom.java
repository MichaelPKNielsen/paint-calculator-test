package tests;

import org.testng.annotations.Test;

import pages.BaseClass;
import pages.Dimensions;
import pages.Home;
import pages.Results;

public class MultiRoom extends BaseClass{
	
	@Test(description="Verify multiple rooms with known values", groups = {"regression"})
	public void singleRoomKnownValues() throws InterruptedException{		
		Home home = new Home(driver);
		Dimensions dimensions = new Dimensions(driver);
		Results results = new Results(driver);

		//Set amount of rooms on home page
		int rooms = 3;
		home.openHome();
		home.setRooms(rooms);
		home.clickSubmit();

		//Enter dimensions for each room
		for(int i = 0; i < rooms; i++){
			dimensions.setLength(i, 20);
			dimensions.setWidth(i, 20);
			dimensions.setHeight(i, 10);
		}
		dimensions.clickSubmit();
		
		//Verify calculations of each room for accuracy and total gallons
		for(int i = 0; i > rooms; i++){
			results.verifyFeet(i, 800);
			results.verifyGallons(i, 2);
		}
		results.verifyTotalGallons(6);
		results.clickSubmit();
		
		//Verify return to home URL
		home.verifyPageURL(home.homeURL());
	}
	
	@Test(description="Verify multiple rooms with random values", groups = {"regression"})
	public void singleRoomRandomValues(){		
		Home home = new Home(driver);
		Dimensions dimensions = new Dimensions(driver);
		Results results = new Results(driver);

		int rooms = 100;
		int[] feet = new int[rooms];
		int totalGallons = 0;

		//Set amount of rooms on home page
		home.openHome();
		home.setRooms(rooms);
		home.clickSubmit();
		
		//Randomly generate and enter dimensions for each room
		for(int i = 0; i < rooms; i++){
			int length = dimensions.random100();
			int width = dimensions.random100();
			int height = dimensions.random100();
	
			dimensions.setLength(i, length);
			dimensions.setWidth(i, width);
			dimensions.setHeight(i, height);
			feet[i] = results.calculateFeet(length, width, height);
		}
		dimensions.clickSubmit();
		
		//Verify calculations of each room for accuracy and total gallons
		for(int i = 0; i < rooms; i++){
			int gallons = results.calculateGallons(feet[i]);
			totalGallons = totalGallons + gallons;
			results.verifyFeet(i, feet[i]);
			results.verifyGallons(i, gallons);
		}
		results.verifyTotalGallons(totalGallons);
		results.clickSubmit();
		
		//Verify return to home URL
		home.verifyPageURL(home.homeURL());
	}
}