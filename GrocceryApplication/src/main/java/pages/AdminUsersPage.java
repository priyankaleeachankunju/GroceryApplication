package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminUsersPage {
        
	public WebDriver driver;	
	public AdminUsersPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(name="username")WebElement userName; //or id
	@FindBy(name="password")WebElement passWord;
	@FindBy(name="user_type")WebElement userType;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")WebElement newBtn;  //or @FindBy(xpath="//a[@onclick='click_button(1)']") WebElement newBtn;
	@FindBy(xpath="//i[@class='fa fa-save']")WebElement saveBtn;// or 	@FindBy(xpath="//button[@name='Create']") WebElement saveBtn;
	
	//search
	@FindBy(xpath="//a[@onclick='click_button(2)']")WebElement searchBtn;
	@FindBy(id="un")WebElement userNameSearch;
	@FindBy(id="ut")WebElement userTypeSearch;
	@FindBy(xpath="//button[@name='Search']")WebElement srchBtn; // or xpath="//button[@value='sr']
	
	//Reset
	@FindBy(xpath="//a[@class='btn btn-rounded btn-warning']")WebElement restBtn; // check //i[@class='ace-icon fa fa-sync-alt']
	
	//Assertion
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement newAlert;
	
	public void newButtonClick() {
		newBtn.click();
	}
	public void enterUserName(String usernameVal) {
		userName.sendKeys(usernameVal);
	}
	
	public void enterPassword(String passwordVal) {
		passWord.sendKeys(passwordVal);
	}
	
	public void selectUserType() {
		
	Select select = new Select(userType);
	select.selectByValue("staff"); // by index dbt
		
	}
	
	public void saveButtonClick() {
		saveBtn.click();
	}
	
	public void searchBtnClick() { //search
		searchBtn.click();
	}
	
	public void searchUserName() {
		userNameSearch.sendKeys("pla");
	}
	
	public void searchUserType() {
		Select select = new Select(userTypeSearch);
		select.selectByValue("staff"); 
	}
	
	public void searchUserBtnClick(){
		srchBtn.click();
		
	}
	
	public void resetBtnClick() {
		restBtn.click();
	}
	
	//Assertion methods
	public String alertDisplayed() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement alertBox = wait.until(ExpectedConditions.visibilityOfElementLocated( //visibility .. here element?
		    By.xpath("//div[contains(@class,'alert') and contains(@class,'alert-dismissible')]") // bcoz alert can be 'added successfully' or 'already registered'
		));
		return alertBox.getText(); 
		
	}
	
	public String actualURL()
	{
		return driver.getCurrentUrl();
	}
	
	public boolean IsresetHappen() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOf(userNameSearch));// invisibility of any element?
		return userNameSearch.isDisplayed();
	}
	
	
}
