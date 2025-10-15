package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Constant;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends Base{
	
	@Test
	public void verifyWhetherUserIsAbleToLogOutSuccessfully() throws IOException {
	String userNameValue = ExcelUtility.readStringData(0, 0, "LoginPage");
	String passwordValue = ExcelUtility.readStringData(0, 1, "LoginPage");
	LoginPage loginpage = new LoginPage(driver);
	loginpage.enterUserNameOnUserNameField(userNameValue);
	loginpage.enterPasswordOnPasswordField(passwordValue);
	loginpage.loginButtonClick();
		
	//LoginTest test = new LoginTest();
	//test.verifyWetherUserIsAbleToLoginWithValidCredentials();
	
	HomePage homePage = new HomePage(driver);
	homePage.adimnIconClick();
	homePage.logOutClick();
	
	String expected= "https://groceryapp.uniqassosiates.com/admin/login"; //Assertion
	String actual= loginpage.actualURL();
	System.out.println(actual);
	Assert.assertEquals(actual, expected,Constant.LogOutError);
	//homePage.adminUsersMoreInfoClick();

}
}