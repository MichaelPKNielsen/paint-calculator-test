package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Home {
	
	WebDriver driver;
	
	By numberInput = By.xpath(".//*[@type='number']");
	By submitButton = By.xpath(".//*[@type='submit']");
	
	public Home(WebDriver driver){
		this.driver=driver;
	}
	
	public String homeURL(){
		return "http://127.0.0.1:5000/?";
	}
	
	//Waits for page to load then verifies expected URL
	public void verifyPageURL(String expectedPageURL){
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.urlContains(expectedPageURL));
		String actualPageURL = driver.getCurrentUrl();
		Assert.assertEquals(actualPageURL, expectedPageURL);
	}
	
	public void openHome(){
		driver.get(homeURL());
		verifyPageURL(homeURL());
	}

	public void setRooms(int rooms){
		String roomString = Integer.toString(rooms);
		driver.findElement(numberInput).sendKeys(roomString);
	}
	
	public void setRoomsDouble(double rooms){
		String roomString = Double.toString(rooms);
		driver.findElement(numberInput).sendKeys(roomString);
	}
	
	public void clickSubmit(){
		driver.findElement(submitButton).click();
	}
}
