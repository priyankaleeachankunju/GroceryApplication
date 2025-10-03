package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public WebDriver driver;	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//a[@data-toggle='dropdown']")WebElement adminIcon;
	@FindBy(xpath="//i[@class='ace-icon fa fa-power-off']")WebElement logOut;

	//@FindBy(className=" fa-power-off")WebElement logOut; 
	
	public void adimnIconClick() {
		adminIcon.click();
	}
	
	public void logOutClick() {
		logOut.click();
	}
}
