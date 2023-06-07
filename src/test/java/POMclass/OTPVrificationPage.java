package POMclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OTPVrificationPage {
	WebDriver driver;
	public OTPVrificationPage (WebDriver driver) {
		
			this.driver = driver;
			PageFactory.initElements(driver,this);
			
			}
	@FindBy(xpath="(//div[@class='mx-2 flex-1'])[1]")
	//@FindBy(xpath="(//input[@type='tel'])[1]")

	 private WebElement otp1;
	
	public void EnterOTP() throws AWTException {
		
		Robot robot = new Robot();
		
		StringSelection stringSelection = new StringSelection("123456");
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, null);
		otp1.click();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);

	}
	
	@FindBy(xpath="//h5[text()='Profile']")
		 private WebElement prof;
	public void verifyAcceptedOTP()
	{
		String actual=prof.getText();
		System.out.println(actual);
		String expected="PROFILE";
		Assert.assertEquals(expected, actual,"profile is not match");
		
	    
	}
}
