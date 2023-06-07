package Tests;

import java.awt.AWTException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import POMclass.LoginPage;
import POMclass.MainPage;
import POMclass.OTPVrificationPage;
import POMclass.ProfilePage;
import POMclass.StripePage;

public class TestCases {
	
	WebDriver driver;
	MainPage Mp;
	LoginPage lp;
	OTPVrificationPage otp;
	ProfilePage pp;
	StripePage sp;
	
	@BeforeClass
	public void browser() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.get("https://develop-v2.superlink.io/");
	}
	@Test(priority=0)
	public void LoginTest1() {
		Mp=new MainPage(driver);
		Mp.loginClick();
		Mp.letsStartClick();
		
	}
	@Test(priority=1)
	public void LoginWithNo() throws InterruptedException {
		lp=new LoginPage(driver);
		Thread.sleep(4000);
		lp.EnterloginNo("4444444444");
		lp.ContinueClick();
	}
	@Test(priority=2)
	public void OTPVerification() throws AWTException, InterruptedException {
		otp=new OTPVrificationPage(driver);
		otp.EnterOTP();
		Thread.sleep(4000);
	}
	
	@Test(priority=3)
	public void profilePage() throws InterruptedException {
		pp=new ProfilePage(driver);
		pp.PageName("komal");
		Thread.sleep(4000);
		pp.IntroMsg("I am from Pune");
		
		
		Thread.sleep(2000);
		
		pp.EmailClick();
		Thread.sleep(4000);
		pp.EnterEmail();
		pp.AddClick();
		pp.EnablemsgClick();
		pp.MonysetttingClick();
		pp.visasetttingClick();
		Thread.sleep(4000);
		pp.switchwindow();
		Thread.sleep(4000);
	}

	@Test(priority=4)
	public void StripeAction() throws AWTException {
		sp=new StripePage(driver);
		sp.StripeOTP();
		
		
	}
	@AfterClass
	public void CloseBrowser() {
		driver.quit();
	}
}
