package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Constant;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {
	
	@Test(priority=1,description="User is trying to login with valid credentials",groups= {"smoke"})
	public void verifyWetherUserIsAbleToLoginWithValidCredentials() throws IOException {
		String userNameValue = ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userNameValue);
		loginpage.enterPasswordOnPasswordField(passwordValue);
		loginpage.loginButtonClick();
		
		Boolean dashBoardDisplay = loginpage.isDashboardDisplayed(); //Assert True
		Assert.assertTrue(dashBoardDisplay,Constant.validCredentialError); //Assertion message Constant class variable
	}

	@Test(priority=2,description="User is trying to login with invalid credential",retryAnalyzer = retry.Retry.class)
	public void verifyWetherUserIsAbleToLoginWithValidUsernameAndInvalidPassword() throws IOException {
		String userNameValue = ExcelUtility.readStringData(11, 0, "LoginPage");
		String passwordValue = ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userNameValue);
		loginpage.enterPasswordOnPasswordField(passwordValue);
		loginpage.loginButtonClick();
		
		String expected ="7rmart supermarket"; //Assert Equals
		String actual=loginpage.isTitleDisplayed();// A E
		Assert.assertEquals(actual,expected,Constant.InValidPasswordError);// A E
	
	}

	@Test(priority=3,description="User is trying to login with invalid credential")
	public void verifyWetherUserIsAbleToLoginWithInvalidUsernameAndValidPassword() throws IOException {
		String userNameValue = ExcelUtility.readStringData(2, 0, "LoginPage");
		String passwordValue = ExcelUtility.readStringData(2, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userNameValue);
		loginpage.enterPasswordOnPasswordField(passwordValue);
		loginpage.loginButtonClick();
		
		//boolean alertBoxDisplayed= loginpage.isAlertboxDisplayed();
		//Assert.assertTrue(alertBoxDisplayed, "user is able to login with invalid credentials");
		
		String expected ="https://groceryapp.uniqassosiates.com/admin/login"; //Assert Equals with URL check 
		String actual=loginpage.actualURL();
		Assert.assertEquals(actual, expected,Constant.InValidUsernameError);
	}
	
	@Test(priority=4,description="User is trying to login with invalid credential",groups= {"smoke"},dataProvider ="loginProvider")
	public void verifyWetherUserIsAbleToLoginWithInvalidUsernameAndInvalidPassword(String userNameValue,String passwordValue) throws IOException {
		//String userNameValue = ExcelUtility.readStringData(3, 0, "LoginPage");
		//String passwordValue = ExcelUtility.readStringData(3, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userNameValue);
		loginpage.enterPasswordOnPasswordField(passwordValue);
		loginpage.loginButtonClick(); 
		
		Boolean alertboxDisplay = loginpage.isAlertboxDisplayed(); //assertFalse
		System.out.println(alertboxDisplay); 
		Assert.assertFalse(!alertboxDisplay,Constant.InValidCredentialError); // ! = NOT, here false
	}
	@DataProvider(name = "loginProvider")
	public Object[][] getDataFromDataProvider() throws IOException {

	return new Object[][] { new Object[] { "admin", "admin22" }, new Object[] { "admin123", "123" },
	// new Object[] {ExcelUtility.getStringData(3,
	// 0,"Login"),ExcelUtility.getStringData(3,1 ,"Login")}
	};
	}
}
