package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
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
		Assert.assertTrue(dashBoardDisplay, "User was unable to Login with valid credentials"); //AssertTrue
	}

	@Test(priority=2,description="User is trying to login with invalid credential")
	public void verifyWetherUserIsAbleToLoginWithValidUsernameAndInvalidPassword() throws IOException {
		String userNameValue = ExcelUtility.readStringData(1, 0, "LoginPage");
		String passwordValue = ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userNameValue);
		loginpage.enterPasswordOnPasswordField(passwordValue);
		loginpage.loginButtonClick();
		
		//String expected ="7rmart supermarket"; //Assert Equals
		//String actual=loginpage.isTitleDisplayed();// A E
		//Assert.assertEquals(actual,expected,"user was able to login with Invalid credentials");// A E
	
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
		Assert.assertEquals(actual, expected,"user is able to login with invalid credentials");
	}
	
	@Test(priority=4,description="User is trying to login with invalid credential",groups= {"smoke"})
	public void verifyWetherUserIsAbleToLoginWithInvalidUsernameAndInvalidPassword() throws IOException {
		String userNameValue = ExcelUtility.readStringData(3, 0, "LoginPage");
		String passwordValue = ExcelUtility.readStringData(3, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userNameValue);
		loginpage.enterPasswordOnPasswordField(passwordValue);
		loginpage.loginButtonClick(); 
		
		Boolean alertboxDisplay = loginpage.isAlertboxDisplayed(); //assertFalse
		System.out.println(alertboxDisplay); 
		Assert.assertFalse(!alertboxDisplay,"user is able to login with invalid credentials"); // ! = NOT, here false
	}
	
}
