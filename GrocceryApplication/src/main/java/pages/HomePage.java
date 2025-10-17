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
	@FindBy(xpath="//i[@class='ace-icon fa fa-power-off']")WebElement logOut;//or @FindBy(className=" fa-power-off")WebElement logOut; 
	@FindBy(xpath="//a[@class='small-box-footer']")WebElement adminUsersMoreInfo;
	// or @FindBy(xpath="//p[text()='Admin Users']/ancestor::div[@class='small-box bg-info']/a") WebElement moreInfolink;
	@FindBy(xpath="//a[@class='small-box-footer' and contains(@href, 'list-news')]")WebElement manageNewsMoreInfo;
	// or //p[text()='Manage News']/ancestor::div[@class='small-box bg-info']/a
	
	/*public void adimnIconClick() {
		adminIcon.click();
	}*/
	public HomePage adimnIconClick() {  //chaining
		adminIcon.click();
		return this;
	}
	
	/*public void logOutClick() {
		logOut.click();
	}*/
	public LoginPage logOutClick() { //chaining
		logOut.click();
		return new LoginPage(driver);
	}
	
	public AdminUsersPage adminUsersMoreInfoClick() {
		adminUsersMoreInfo.click();
		return new AdminUsersPage(driver);
	}
	
	public ManageNewsPage manageNewsMoreInfoClick() {
		manageNewsMoreInfo.click();
		return new ManageNewsPage(driver);
	}
}
