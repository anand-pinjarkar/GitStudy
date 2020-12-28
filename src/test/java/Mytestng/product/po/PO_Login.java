package Mytestng.product.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PO_Login {
	
//section -1 - declare driver
	WebDriver driver;
	
//section - 2 - parameterized constructor
	public PO_Login(WebDriver driver) {
		this.driver =driver;		
	}
//section - 3 - locator
	@FindBy(how = How.NAME, using = "username")
	private WebElement txt_username ;
	
	@FindBy(how = How.NAME, using = "password")
	private WebElement txt_password ;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\'loginPanel\']/form/div[3]/input")
	WebElement btn_submit ;
//section - 4 - method
	public void enterUserName(String txt) {
		txt_username.sendKeys(txt);
	}
	public void enterPassword(String txt) {
		txt_password.sendKeys(txt);
	}
	public void clickSubmitButton() {
		btn_submit.click();
	}
}
 