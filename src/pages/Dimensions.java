package pages;

import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Dimensions {
	
	WebDriver driver;
	
	public By length(int row){
		return By.xpath(".//*[@name='length-"+row+"']");
	}
	
	public By width(int row){
		return By.xpath(".//*[@name='width-"+row+"']");
	}
	
	public By height(int row){
		return By.xpath(".//*[@name='height-"+row+"']");
	}
	
	By submitButton = By.xpath(".//*[@type='submit']");
	
	public Dimensions(WebDriver driver){
		this.driver=driver;
	}
	
	public void setLength(int row, int length){
		String lengthString = Integer.toString(length);
		driver.findElement(length(row)).sendKeys(lengthString);
	}
	
	public void setWidth(int row, int width){
		String widthString = Integer.toString(width);
		driver.findElement(width(row)).sendKeys(widthString);
	}
	
	public void setHeight(int row, int height){
		String heightString = Integer.toString(height);
		driver.findElement(height(row)).sendKeys(heightString);
	}
	
	public void clickSubmit(){
		driver.findElement(submitButton).click();
	}
	
	//Generates random number between 1 and 100
	public int random100(){
		int random = ThreadLocalRandom.current().nextInt(1, 100 + 1);
		//Reporter.log("Random number:"+random,true);
		return random;
	}
}
