package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationCore.Base;
import constants.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base{

     @Test	
     public void verifyWhetherUserIsAbleToAddNewNews() throws IOException {
    	String userNameValue = ExcelUtility.readStringData(0, 0, "LoginPage");
 		String passwordValue = ExcelUtility.readStringData(0, 1, "LoginPage");
 		LoginPage loginpage = new LoginPage(driver);
 		loginpage.enterUserNameOnUserNameField(userNameValue);
 		loginpage.enterPasswordOnPasswordField(passwordValue);
 		loginpage.loginButtonClick();
 		
 		HomePage homePage = new HomePage(driver);
 		homePage.manageNewsMoreInfoClick();
 		
 		ManageNewsPage mnt = new ManageNewsPage(driver);
 		mnt.newBtnClick();
 		mnt.newsTextBoxMsg();
 		mnt.saveBtnClick();
 		
 		boolean newscreatedSuccess =mnt.isNewsCreationSuccessAlertDisplayed();
  		System.out.println(newscreatedSuccess);
  		Assert.assertTrue(newscreatedSuccess,Constant.UnabletoAddNewsError); //true
    	
  		//boolean successNews = mnt.checkNewsCreationSuccessAlertDisplayed();
		//Assert.assertTrue(successNews, "Unable to add new News");
     }
     
     @Test
     public void verifyWhetherUserIsAbleToSearchAddedNews() throws IOException {
    	String userNameValue = ExcelUtility.readStringData(0, 0, "LoginPage");
  		String passwordValue = ExcelUtility.readStringData(0, 1, "LoginPage");
  		LoginPage loginpage = new LoginPage(driver);
  		loginpage.enterUserNameOnUserNameField(userNameValue);
  		loginpage.enterPasswordOnPasswordField(passwordValue);
  		loginpage.loginButtonClick();
  		
  		HomePage homePage = new HomePage(driver);
  		homePage.manageNewsMoreInfoClick();
  		
  		ManageNewsPage mnt = new ManageNewsPage(driver);
  		mnt.searchBtnClick();
  		mnt.searchNewsText();
  		mnt.searchSubmitBtnClick();
  		
  		String expected= "News Today";
  		String actual = mnt.isUserListed();//wait applied
		Assert.assertEquals(actual,expected,Constant.UnabletoSearchNewsError); 
  		
     }
	
	
}
