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

import utilities.PageUtility;
import utilities.WaitUtility;

public class AdminUsersPage {
        
	public WebDriver driver;
	WaitUtility wait = new WaitUtility();
	PageUtility pageUtil = new PageUtility();
	
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
	@FindBy(xpath="//tr[1]/td[1]")WebElement searchUser; 
	//@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[1]") WebElement searchUser;
	@FindBy(xpath="//div[contains(@class,'alert') and contains(@class,'alert-dismissible')]") WebElement alertbox;
	@FindBy(xpath="//h4[text()='Search Admin Users']")WebElement searchTab; //Title name used as userNameSearch-data may still be there after reset
	
	public AdminUsersPage newButtonClick() {
		newBtn.click();
		return this;
	}
	public AdminUsersPage enterUserName(String usernameVal) {
		userName.sendKeys(usernameVal);
		return this;
	}
	
	public AdminUsersPage enterPassword(String passwordVal) {
		passWord.sendKeys(passwordVal);
		return this;
	}
	
	public AdminUsersPage selectUserType() {
		
	//Select select = new Select(userType);
	//select.selectByValue("staff"); // by index dbt
	   pageUtil.selectDropdownWithValue(userType,"staff"); //used Page Utility
	   return this;
	}
	
	public AdminUsersPage saveButtonClick() {
		saveBtn.click();
		return this;
	}
	
	//search methods
	public AdminUsersPage searchBtnClick() { //search
		searchBtn.click();
		return this;
	}
	
	public AdminUsersPage searchUserName() {
		userNameSearch.sendKeys("pla");
		return this;
	}
	
	public AdminUsersPage searchUserType() {
		//Select select = new Select(userTypeSearch);
		//select.selectByValue("staff"); 
		pageUtil.selectDropdownWithValue(userTypeSearch,"staff"); //used Page Utility
		return this;
	}
	
	public AdminUsersPage searchUserBtnClick(){
		srchBtn.click();
		return this;
		
	}
	
	public AdminUsersPage resetBtnClick() {
		restBtn.click();
		return this;
	}
	
	//Assertion methods
	public String alertDisplayed() {
		wait.waitUntilElementIsVisible(driver, alertbox);
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//WebElement alertBox = wait.until(ExpectedConditions.visibilityOfElementLocated( //visibility .. here element
		// By.xpath("//div[contains(@class,'alert') and contains(@class,'alert-dismissible')]") // bcoz alert can be 'added successfully' or 'already registered'
		//));
		return alertbox.getText(); 
		
	}
	
	public String actualURL()
	{
		return driver.getCurrentUrl();
	}
	
	public boolean IsresetHappen() {
		 wait.waitUntilElementIsInvisible(driver, searchTab); //wait utility applied
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.invisibilityOf(userNameSearch));// invisibility of any element
		//return userNameSearch.isDisplayed();
		 return searchTab.isDisplayed();
	}
	public String searchTable()
	{
		
		wait.waitUntilElementIsVisible(driver, searchUser); // To avoid assertion failure due to invisiblity of searchUser element
		return searchUser.getText();
	}
	
}
