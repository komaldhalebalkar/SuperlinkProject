package POMclass;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.commons.lang3.RandomStringUtils;



public class ProfilePage {
	WebDriver driver;
	public ProfilePage (WebDriver driver) {
		
			this.driver = driver;
			PageFactory.initElements(driver,this);
			
			}
	@FindBy(xpath="//input[@class='mt-2']")
	 private WebElement pagename;
	public void PageName(String pname) throws InterruptedException {
		Thread.sleep(4000);
		pagename.clear();
		Thread.sleep(4000);
		pagename.sendKeys(pname);
	}
	@FindBy(xpath="//textarea[@name='IntroMessage']")
	 private WebElement Imsg;
	public void IntroMsg(String Imsgs) {
		Imsg.clear();
		Imsg.sendKeys(Imsgs);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		 
		js.executeScript("arguments[0].scrollIntoView();",slink);
	}
	@FindBy(xpath="//h5[text()='Social Links']")
	 private WebElement slink;
	public void SocialLink() {
				slink.sendKeys(Keys.ENTER);
		
		
	}
	
	@FindBy(xpath="(//div[@class='co'])[1]")
	private WebElement email;
	public void EmailClick() {

		Actions ac=new Actions(driver);
		ac.click(email).perform();;
		
		
	}
	public static String randomemailid() {
		String emailid = RandomStringUtils.randomAlphabetic(4);
		return emailid;
		
	}
	@FindBy(xpath="//input[@class='pl-[135px!important] mt-2']")
	 private WebElement email1;
	public void EnterEmail() {
		
		String s=ProfilePage.randomemailid();
		email1.clear();
		email1.sendKeys(s+"@gmail.com");
		
	}
	@FindBy(xpath="//button[@type='submit']")
	 private WebElement add;
	public void AddClick() {
		add.click();
	}
	@FindBy(xpath="//button[@class='cta button w-full mt-2 rounded-full text-white bg-black']")
	 private WebElement emsg;
	public void EnablemsgClick() {
		emsg.click();
	}
	
	@FindBy(xpath="//h5[normalize-space()='Monetization Settings']")
	 private WebElement mset;
	public void MonysetttingClick() {
		mset.click();
	}
	
	@FindBy(xpath="(//div[@class='cursor-pointer'])[2]")
	 private WebElement visaset;
	public void visasetttingClick() {
		visaset.click();
	}
	
	public void switchwindow() {
		String currentHandle= driver.getWindowHandle();
		Set<String> handles= driver.getWindowHandles();
				for(String actual: handles)
				{
					if(!actual.equalsIgnoreCase(currentHandle))
					{
						driver.switchTo().window(actual);
					}
				}
	}
}
