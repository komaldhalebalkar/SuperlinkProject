package POMclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MainPage {
	
	WebDriver driver;
	public MainPage (WebDriver driver) {
		
			this.driver = driver;
			PageFactory.initElements(driver,this);
			
			}
	@FindBy(xpath="//a[text()='Login']")
	 private WebElement login;
	
	
	public void verifyMainpageTitle()
	{
		String actual=driver.getTitle();
		System.out.println(actual);
		String expected="SuperLink";
		Assert.assertEquals(expected, actual,"Title is not correct");
		
	    
	}
	
	

	public void loginClick() {
		// TODO Auto-generated method stub
		login.click();
	}
	@FindBy(xpath="//button")
	 private WebElement letStart;
	
	

	public void letsStartClick() {
		// TODO Auto-generated method stub
		letStart.click();
	}

}
