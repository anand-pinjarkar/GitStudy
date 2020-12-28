package Mytestng.product.tc;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Mytestng.product.po.PO_Login;

public class TC_Login {
	WebDriver driver =null;
	@BeforeSuite
	public void beforeSuite() {
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
		
	}
	@BeforeClass
	public void beforeClass1() {
	    driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);		
	   Reporter.log("chrome driver invoke",true);
	}
	
	@AfterClass
	public void afterClass1() {
		driver.quit();
		Reporter.log("quit",true);
	}
	
	@Test(priority=1)
	public void t_01_validate_url_working() {
		
		//1.System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
		//2.WebDriver driver = new ChromeDriver();
        //2.driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://parabank.parasoft.com");
		Reporter.log("url - https://parabank.parasoft.com -navigated",true);
	}
		@Test(priority=2)
	public void t_02_validate_Login_page_object() {
		
		driver.get("https://parabank.parasoft.com");
		Reporter.log("URL navigated",true);
        PO_Login obj = PageFactory.initElements(driver,PO_Login.class);
        obj.enterUserName("john");
        obj.enterPassword("demo");
        obj.clickSubmitButton();
		String exp = "ParaBank | Accounts Overview";
		String actual = driver.getTitle();
		
		if(exp.equals(actual)){
			System.out.println("login successful");
			Reporter.log("login successfully",true);
		}else {
			System.out.println("failed");
			Reporter.log("login failed",true);
		}	
		}
		@Test(priority=3)
		public void t_03_fund_transfer() {
			
			
		}
}

