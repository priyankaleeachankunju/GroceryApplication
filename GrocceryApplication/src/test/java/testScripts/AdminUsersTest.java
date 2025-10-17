package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Constant;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class AdminUsersTest extends Base {
	
	HomePage homePage;
	AdminUsersPage adminUsersPage;
	
    @Test 
	public void verifyWhetherUserIsAbleToAddNewUser() throws IOException {
		String userNameValue = ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userNameValue).enterPasswordOnPasswordField(passwordValue);
		homePage=loginpage.loginButtonClick();
		
		adminUsersPage=homePage.adminUsersMoreInfoClick();
		
		 RandomDataUtility random = new RandomDataUtility();//Faker class
		 String usernameVal =random.createRandomUsername();
		 String passwordVal= random.createRandomPassword();
		 
		 adminUsersPage.newButtonClick().enterUserName(usernameVal).enterPassword(passwordVal).selectUserType().saveButtonClick();//Page utility used in selectUserType()
		 
		 //Assertion
		 //String expected= "×\r\n"+ "Alert!\r\n"+ "User Created Successfully";
		 String actual= adminUsersPage.alertDisplayed(); 
		 //System.out.println(admin.AlertDisplayed());
		 Assert.assertTrue(actual.contains("User Created Successfully"),Constant.UserNotAddedError);
		 
	}
    
    @Test
    public void verifyWhetherUserIsAbleToSearchNewlyAddedUser() throws IOException {
    	String userNameValue = ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userNameValue).enterPasswordOnPasswordField(passwordValue);
		homePage=loginpage.loginButtonClick();
		
		adminUsersPage=homePage.adminUsersMoreInfoClick();
		
		adminUsersPage.searchBtnClick().searchUserName().searchUserType().searchUserBtnClick();//Page utility used insearchUserType()
		
		//Assertion
		/*String expected="https://groceryapp.uniqassosiates.com/admin/user/index?un=&ut=&Search=sr"; (after searchBtn click url)
		String actual= aup.actualURL();
		boolean val= actual.contains("Search=sr");
		System.out.println(val);
		Assert.assertTrue(val,Constant.UnabletoSearchError)*/
		
		String expected="pla";
		String actual= adminUsersPage.searchTable(); //wait applied 
		System.out.println(actual);
		Assert.assertEquals(actual,expected,Constant.UnabletoSearchError); 
    }
    
    @Test
    public void verifyWhetherUserIsAbleToResetUsersList() throws IOException {
    	String userNameValue = ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userNameValue).enterPasswordOnPasswordField(passwordValue);
		homePage=loginpage.loginButtonClick();
		
		
		adminUsersPage=homePage.adminUsersMoreInfoClick();
		
		adminUsersPage.searchBtnClick().searchUserName().resetBtnClick();// searched to check reset
		
		
		boolean resetHappened= adminUsersPage.IsresetHappen(); //Assertion
		System.out.println(resetHappened);
		Assert.assertFalse(resetHappened,Constant.UnAbletoResetError);
    }
    
}
