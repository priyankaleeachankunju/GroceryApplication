package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.WaitUtility;

public class ManageNewsPage {
	public WebDriver driver;
	WaitUtility wait = new WaitUtility();
	
	public ManageNewsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//a[@onclick='click_button(1)']")WebElement newButton; 
	@FindBy(id="news")WebElement newsTextBox; 
	@FindBy(xpath="//button[@type='submit']")WebElement saveBtn;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")WebElement searchBtn;
	@FindBy(xpath="//input[@type='text']")WebElement searchText;
	@FindBy(xpath="//button[@type='submit']")WebElement searchSubmitBtn;
	
	//Assertion
	@FindBy(xpath = "//div[contains(@class, 'alert-success')]")WebElement newsCreationSuccessMsg;
	//@FindBy(xpath="//div[contains(@class,'alert') and contains(@class,'alert-dismissible')]") WebElement alertbox;
	
	@FindBy(xpath = "//tr[1]/td[1]")WebElement searchResultTable;
	//or @FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[1]") WebElement searchResultTable;
	
	public ManageNewsPage newBtnClick() {
		newButton.click();
		return this;
	}
	
	public ManageNewsPage newsTextBoxMsg() {
		newsTextBox.sendKeys("News Today");
		return this;
	}
	public ManageNewsPage saveBtnClick() {
		saveBtn.click();
		return this;
	}
	
	public ManageNewsPage searchBtnClick() {
		searchBtn.click();
		return this;
	}
	
	public ManageNewsPage searchNewsText() {
		searchText.sendKeys("News Today");
		return this;
	}
	
	public ManageNewsPage searchSubmitBtnClick() {
		searchSubmitBtn.click();
		return this;
	}
	
	//Assertion
	public boolean isNewsCreationSuccessAlertDisplayed() {
		return newsCreationSuccessMsg.isDisplayed();
	}
	public String isUserListed() {
		String userlisted=null;
		try {
			
			wait.waitUntilElementIsVisible(driver, searchResultTable); // To avoid assertion failure due to invisiblity of searchUser element
			userlisted = searchResultTable.getText();
			
	    } catch (StaleElementReferenceException e) {
	        // Re-locate the element if it becomes stale
	    	//@FindBy(xpath = "//tr[1]/td[1]")WebElement searchResultTable;
	       WebElement element = driver.findElement(By.xpath("//tr[1]/td[1]"));
	       userlisted = element.getText();
	    }
		 return userlisted;
		//return searchResultTable.getText();
	}
	
	
	/*public boolean checkNewsCreationSuccessAlertDisplayed() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf( newsCreationSuccessMsg));
		return  newsCreationSuccessMsg.isDisplayed();
	}*/
	
}
