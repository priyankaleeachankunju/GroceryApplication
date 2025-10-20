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

	HomePage homePage;
	ManageNewsPage mnp;
     @Test	
     public void verifyWhetherUserIsAbleToAddNewNews() throws IOException {
    	String userNameValue = ExcelUtility.readStringData(0, 0, "LoginPage");
 		String passwordValue = ExcelUtility.readStringData(0, 1, "LoginPage");
 		LoginPage loginpage = new LoginPage(driver);
 		loginpage.enterUserNameOnUserNameField(userNameValue).enterPasswordOnPasswordField(passwordValue);
 		homePage=loginpage.loginButtonClick();
 		
 		mnp=homePage.manageNewsMoreInfoClick();
 		
 		mnp.newBtnClick().newsTextBoxMsg().saveBtnClick();
 		
 		boolean newscreatedSuccess =mnp.isNewsCreationSuccessAlertDisplayed();
  		System.out.println(newscreatedSuccess);
  		Assert.assertTrue(newscreatedSuccess,Constant.UnabletoAddNewsError); //true
    	
  		//boolean successNews = mnp.checkNewsCreationSuccessAlertDisplayed();
		//Assert.assertTrue(successNews, "Unable to add new News");
     }
     
     @Test
     public void verifyWhetherUserIsAbleToSearchAddedNews() throws IOException {
    	String userNameValue = ExcelUtility.readStringData(0, 0, "LoginPage");
  		String passwordValue = ExcelUtility.readStringData(0, 1, "LoginPage");
  		LoginPage loginpage = new LoginPage(driver);
  		loginpage.enterUserNameOnUserNameField(userNameValue).enterPasswordOnPasswordField(passwordValue);
  		homePage=loginpage.loginButtonClick();
  		
  		mnp=homePage.manageNewsMoreInfoClick();
  		
  		mnp.searchBtnClick().searchNewsText().searchSubmitBtnClick();
  		
  		//String expected= "News Today";
  		//String actual = mnp.isUserListed();//wait applied
		//Assert.assertEquals(actual,expected,Constant.UnabletoSearchNewsError); 
  		
     }
	
	
}
