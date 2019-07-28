package com.test.qa.test;

import javafx.scene.control.CheckBox;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.test.qa.pageobjects.pages.ABTestPage;
import com.test.qa.pageobjects.pages.CheckBoxPage;
import com.test.qa.pageobjects.pages.DropDownPage;
import com.test.qa.pageobjects.pages.ForgotPasswordPage;
import com.test.qa.pageobjects.pages.HomePage;
import com.test.qa.pageobjects.pages.LoginPage;
import com.test.qa.pageobjects.pages.LoginSecurePage;
import com.test.qa.pageobjects.utils.Constants;
import com.test.qa.testdata.UserDetailsDataProvider;
import com.test.qa.utils.TestBase;

import javax.print.attribute.standard.MediaSizeName;

import static com.sun.jmx.snmp.ThreadContext.contains;

/**
 * UiAutomationTrainingBasicTest.java - class to execute Tests Created by
 * SrirankanK on 10/3/2018.
 */
public class UiAutomationTrainingBasicTest extends TestBase {

	private static final Logger LOGGER = Logger.getLogger(UiAutomationTrainingBasicTest.class);

	/**
	 * Verify Home Page Displayed
	 */
	@Test(groups = "REGRESSION", priority = 1)
	public void testVerifyHomePage() {
		softAssert = new SoftAssert();
		softAssert.assertTrue(HomePage.isHomePageDisplayed(), "Home Page is not Displayed");
		HomePage.clickLink(Constants.AB_TEST_LINK);
		ABTestPage.waitTillHeaderLoad();
		softAssert.assertTrue(ABTestPage.isABTestPageDisplayed(), "Home Page is not Displayed");
		ABTestPage.navigateBack();
		softAssert.assertTrue(HomePage.isHomePageDisplayed(), "Home Page is not Displayed");
		softAssert.assertAll();
	}


	/**
	 * Verify Home Page Displayed Slow
	 */
	@Test(groups = "REGRESSION", priority = 2)
	public void testVerifyHomePage2() {

		//Todo - Static wait
		//Todo - Verify HomePage is displayed
		//Todo - Static wait
		//Todo - Click Home Page Link
		//Todo - Static wait
		//Todo - Wait Till Page Loads
		//Todo - Static wait
		//Todo - Verify ABTest Page is displayed
		//Todo - Static wait
		//Todo - Navigate Back to Home Page
		//Todo - Static wait
		//Todo - Verify HomePage is displayed
		//Todo - Static wait
	}

	/**
	 * Verify Check Box
	 */
	@Test(groups = "REGRESSION", priority = 3)
	public void testVerifyCheckBox() {

//		softAssert = new SoftAssert();
//		softAssert.assertTrue(HomePage.isHomePageDisplayed(), "Home Page is not Displayed");
//		HomePage.clickLink(Constants.CHECK_BOX_LINK);
//		softAssert.assertTrue(CheckBoxPage.isCheckBox1Checked(), "CheckBox Not Selected");
//		LOGGER.info("Checkbox One is Selected");
//		CheckBoxPage.checkCheckBox1();
//		softAssert.assertTrue(CheckBoxPage.isCheckBox1Checked(),"Test Not Succesfully");
//		CheckBoxPage.checkCheckBox1();
//		softAssert.assertTrue(CheckBoxPage.isCheckBox2Displayed(), "CheckBox Not Selected");
//		LOGGER.info("Checkbox Two is Selected");
//		CheckBoxPage.isCheckBox2Displayed();
//		softAssert.assertTrue(HomePage.isHomePageDisplayed(),"Home Page is not Return");
//		softAssert.assertAll();

			softAssert = new SoftAssert();
			softAssert.assertTrue(HomePage.isHomePageDisplayed(), "Home Page is not Displayed");
			HomePage.clickLink(Constants.CHECK_BOX_LINK);
			softAssert.assertTrue(CheckBoxPage.isCheckBox1Displayed(), "CheckBox1 is not Displayed");
			softAssert.assertTrue(CheckBoxPage.isCheckBox2Displayed(), "CheckBox2 is not Displayed");
			CheckBoxPage.checkCheckBox1();
			softAssert.assertTrue(CheckBoxPage.isCheckBox1Checked(), "CheckBox1 is not Checked");
			CheckBoxPage.unCheckCheckBox1();
			softAssert.assertFalse(CheckBoxPage.isCheckBox1Checked(), "CheckBox1 is Checked");
			CheckBoxPage.checkCheckBox2();
			softAssert.assertTrue(CheckBoxPage.isCheckBox2Checked(), "CheckBox2 is not Checked");
			CheckBoxPage.unCheckCheckBox2();
			softAssert.assertFalse(CheckBoxPage.isCheckBox2Checked(), "CheckBox2 is Checked");
			CheckBoxPage.navigateBack();
			softAssert.assertTrue(HomePage.isHomePageDisplayed(), "Home Page is not Displayed");
			softAssert.assertAll();
		}
	/**
	 * Verify Drop Down
	 */
	@Test(groups = "REGRESSION", priority = 4)
	public void testVerifyDropDown() throws InterruptedException {
		softAssert = new SoftAssert();
		softAssert.assertTrue(HomePage.isHomePageDisplayed(), "Home Page is not Displayed");
		Thread.sleep(3000);
		DropDownPage.dropdownlink();
		softAssert.assertTrue(DropDownPage.isDropDownDisplayed(),"Dropdown Page is not desplayed");
		Thread.sleep(3000);
		DropDownPage.getSelectedOption(Constants.OPTION_1);
		Thread.sleep(3000);
//		softAssert.assertAll();
	}

	/**
	 * Verify Forgot Password
	 */
	@Test(groups = "REGRESSION", priority = 5)
	public void testVerifyForgotPassword() {
			softAssert = new SoftAssert();
			softAssert.assertTrue(HomePage.isHomePageDisplayed(), "Home Page is not Displayed");
			HomePage.clickLink(Constants.FORGOT_PASSWORD_LINK);
			ForgotPasswordPage.setEmail(Constants.SAMPLE_MAIL);
			ForgotPasswordPage.clickSubmit();
			softAssert.assertEquals(ForgotPasswordPage.getMessage(),Constants.EMAIL_RESULT,  "Message are not equal");
			softAssert.assertAll();
		}

	/**
	 * Verify Login Valid Scenario
	 */
	@Test(groups = "REGRESSION", priority = 6)
	public void testVerifyLogin() throws InterruptedException {
//		softAssert = new SoftAssert();
//		softAssert.assertTrue(HomePage.isHomePageDisplayed(), "Home Page is not Displayed");
//		HomePage.clickLink(Constants.LOGIN_LINK);
//		LoginPage.setusername(Constants.LOGIN_USER_NAME);
//		LoginPage.setPassword(Constants.LOGIN_PASSWORD);
//		LoginPage.clickSubmit();
//		softAssert.assertTrue(LoginPage.getLogoutPage().contains(Constants.LOGIN_SUCCESS_MSG), "Message are not equal");
//		softAssert.assertAll();

		softAssert.assertTrue(HomePage.isHomePageDisplayed(), "Home Page is not Displayed");
		HomePage.clickLink(Constants.LOGIN_LINK);
		softAssert.assertTrue(LoginPage.isLoginPageDisplayed(), "Login Page is not Displayed");
		LoginPage.setUseraName(Constants.LOGIN_USER_NAME);
		LoginPage.setPassword(Constants.LOGIN_PASSWORD);
		LoginPage.clickSubmit();
		Thread.sleep(3000);
		softAssert.assertTrue(LoginSecurePage.isLoginSecurePageDisplayed(), "Login Secure Page is not Displayed");
		softAssert.assertTrue(LoginSecurePage.isLoginAlertDisplayed(), "Alert Message is not displayed");
		softAssert.assertEquals(LoginSecurePage.getLoginAlertMessage(), Constants.LOGIN_SUCCESS_MSG, "Messages are not equal");
		LoginSecurePage.clickLogout();
		Thread.sleep(3000);
		softAssert.assertTrue(LoginPage.isLoginPageDisplayed(), "Login Page is not Displayed");
		softAssert.assertTrue(LoginPage.isAlertMessageDisplayed(), "Alert Message is not displayed");
		softAssert.assertTrue(LoginPage.getAlertMessage().contains(Constants.LOGOUT_SUCCESS_MSG), "Messages are not equal");
		softAssert.assertAll();



	}

	@Test(groups = "REGRESSION", priority = 7, dataProvider = "MultipleUserDetails", dataProviderClass = UserDetailsDataProvider.class)
	public void testVerifyLogin11(String username, String password) {

	}
}
