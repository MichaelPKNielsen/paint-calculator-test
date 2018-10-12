package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Results {
	
	WebDriver driver;
	
	public By feet(int row){
		return By.xpath(".//*[@name='feet-"+(row+1)+"']");
	}
	
	public By gallons(int row){
		return By.xpath(".//*[@name='gallons-"+(row+1)+"']");
	}
	
	By totalGallons = By.xpath(".//*[@name='total_gallons']");
	By submitButton = By.xpath(".//*[@type='submit']");
	
	public Results(WebDriver driver){
		this.driver=driver;
	}
	
	public String getFeet(int row){
		return driver.findElement(feet(row)).getText().toString();
	}
	
	public String getGallons(int row){
		return driver.findElement(gallons(row)).getText().toString();
	}
	
	public String getTotalGallons(){
		return driver.findElement(totalGallons).getText().toString();
	}
	
	public void verifyFeet(int row, int expectedFeet){
		String expectedFeetString = Integer.toString(expectedFeet);
		Assert.assertEquals(getFeet(row), expectedFeetString);
	}
	
	public void verifyGallons(int row, int expectedGallons){
		String expectedGallonsString = Integer.toString(expectedGallons);
		Assert.assertEquals(getGallons(row), expectedGallonsString);
	}
	
	public void verifyTotalGallons(int expectedGallons){
		String expectedGallonsString = Integer.toString(expectedGallons);
		Assert.assertTrue(getTotalGallons().contains(expectedGallonsString));
	}
	
	public void clickSubmit(){
		driver.findElement(submitButton).click();
	}
	
	public int calculateFeet(int length, int width, int height){	
		int feet = ((length * 2) + (width * 2)) * height;
		//Reporter.log("Feet:"+feet,true);
		return feet;
	}
	
	public int calculateGallons(int feet){
		int gallons = ((int) Math.ceil(feet / 400.0));
		//Reporter.log("Gallons:"+gallons,true);
		return gallons;
	}
}
