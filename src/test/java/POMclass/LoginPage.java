package POMclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {
	WebDriver driver;
	public LoginPage (WebDriver driver) {
		
			this.driver = driver;
			PageFactory.initElements(driver,this);
			
			}
	@FindBy(xpath="//input[@class='form-control ']")
	 private WebElement phno;
	
	public void EnterloginNo(String no) {
		// TODO Auto-generated method stub
		phno.sendKeys(no);
	}

	
	@FindBy(xpath="//button[@type='submit']")
	 private WebElement continue1;
	
	public void ContinueClick() {
		// TODO Auto-generated method stub
		continue1.click();
	}
	
	
	@FindBy(xpath="//b[text()='+91 44444-44444']")
	 private WebElement succmsg;
	public void SuccMsg()
	{
		String actual=succmsg.getText();
		String expected="+91 44444-44444.";
		Assert.assertEquals(expected, actual);
		
	    
	}
}
