package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class AdminUsersTest extends Base {
    @Test 
	public void verifyWhetherUserIsAbleToAddNewUser() throws IOException {
		String userNameValue = ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userNameValue);
		loginpage.enterPasswordOnPasswordField(passwordValue);
		loginpage.loginButtonClick();
		
		HomePage homePage = new HomePage(driver);
		homePage.adminUsersMoreInfoClick();
		
		 AdminUsersPage aup = new  AdminUsersPage(driver);
		 
		 RandomDataUtility random = new RandomDataUtility();
		 String usernameVal =random.createRandomUsername();
		 String passwordVal= random.createRandomPassword();
		 
		 aup.newButtonClick();
		 aup.enterUserName(usernameVal);
		 aup.enterPassword(passwordVal);
		 aup.selectUserType();
		 aup.saveButtonClick();
		 
		 //Assertion
		 //String expected= "×\r\n"+ "Alert!\r\n"+ "User Created Successfully";
		 String actual= aup.alertDisplayed();
		 //System.out.println(admin.AlertDisplayed());
		 Assert.assertTrue(actual.contains("User Created Successfully"),"User not added successfully");
		 
	}
    
    @Test
    public void verifyWhetherUserIsAbleToSearchNewlyAddedUser() throws IOException {
    	String userNameValue = ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userNameValue);
		loginpage.enterPasswordOnPasswordField(passwordValue);
		loginpage.loginButtonClick();
		
		HomePage homePage = new HomePage(driver);
		homePage.adminUsersMoreInfoClick();
		
		AdminUsersPage aup = new  AdminUsersPage(driver);
		aup.searchBtnClick();
		aup.searchUserName();
		aup.searchUserType();
		aup.searchUserBtnClick();
		
		//Assertion
		//String expected="https://groceryapp.uniqassosiates.com/admin/user/index?un=&ut=&Search=sr"; (after searchBtn click url)
		String actual= aup.actualURL();
		System.out.println(actual);
		boolean val= actual.contains("Search=sr");
		System.out.println(val);
		Assert.assertTrue(val,"search not happened");
    }
    
    @Test
    public void verifyWhetherUserIsAbleToResetUsersList() throws IOException {
    	String userNameValue = ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordValue = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameOnUserNameField(userNameValue);
		loginpage.enterPasswordOnPasswordField(passwordValue);
		loginpage.loginButtonClick();
		
		HomePage homePage = new HomePage(driver);
		homePage.adminUsersMoreInfoClick();
		
		AdminUsersPage aup = new  AdminUsersPage(driver);
		aup.searchBtnClick(); // searched to check reset
		aup.searchUserName(); 
		aup.resetBtnClick();//reset
		
		
		boolean resetHappened= aup.IsresetHappen(); //Assertion
		System.out.println(resetHappened);
		Assert.assertFalse(resetHappened,"reset has not happened");
    }
    
}
