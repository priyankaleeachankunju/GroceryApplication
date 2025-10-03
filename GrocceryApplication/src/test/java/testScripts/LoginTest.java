package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {
	@Test
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

	@Test
	public void verifyWetherUserIsAbleToLoginWithValidUsernameAndInvalidPassword() throws IOException {
		String userNameValue = ExcelUtility.readStringData(1, 0, "LoginPage");
		String passwordValue = ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userNameValue);
		loginpage.enterPasswordOnPasswordField(passwordValue);
		loginpage.loginButtonClick();
		
		String expected ="7rmart supermarket"; //Assert Equals
		String actual=loginpage.isTitleDisplayed();// A E
		Assert.assertEquals(actual, expected,"user was able to login with Invalid credentials");// A E
	
	}

	@Test
	public void verifyWetherUserIsAbleToLoginWithInvalidUsernameAndValidPassword() throws IOException {
		String userNameValue = ExcelUtility.readStringData(2, 0, "LoginPage");
		String passwordValue = ExcelUtility.readStringData(2, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userNameValue);
		loginpage.enterPasswordOnPasswordField(passwordValue);
		loginpage.loginButtonClick();
	}
	
	@Test
	public void verifyWetherUserIsAbleToLoginWithInvalidUsernameAndInvalidPassword() throws IOException {
		String userNameValue = ExcelUtility.readStringData(3, 0, "LoginPage");
		String passwordValue = ExcelUtility.readStringData(3, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userNameValue);
		loginpage.enterPasswordOnPasswordField(passwordValue);
		loginpage.loginButtonClick();
	}
	
}
