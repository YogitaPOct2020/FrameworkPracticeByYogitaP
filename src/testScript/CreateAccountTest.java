package testScript;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.PredefinedActions;
import pages.AuthenticationPage;
import pages.CreateAccountPage;
import pages.HomePage;
import pages.ProfilePage;
import pojo.CreatAccountDetailsPojo;

public class CreateAccountTest extends TestBase {

	@Test()
	public void createAccountTest() {

		HomePage homePage = new HomePage();

		System.out.println("STEP-ClickedOnSignIn");
		AuthenticationPage authenticationPage = homePage.clickedOnSignIn();

		System.out.println("Verify-Authentication Header is displayed");
		boolean authenticationHeaderFlag = authenticationPage.isAuthencationHeaderVisible();
		Assert.assertTrue(authenticationHeaderFlag);

		System.out.println("STEP-Enter E-mail Address");
		authenticationPage.enterEmailAddress("gh123456@gmail.com");
		CreateAccountPage createAccoutnPage = authenticationPage.clickOnCreateAccount();

		System.out.println("Verify-Create Account Header");
		boolean isHeadingText = createAccoutnPage.isPageHeadingTextDisplayed();
		Assert.assertTrue(isHeadingText, "Header Text was not Displayed");

		System.out.println("Navigate to create account page");
		CreatAccountDetailsPojo creatAccountDetailsPojo = new CreatAccountDetailsPojo();
		creatAccountDetailsPojo.setMale(true);
		creatAccountDetailsPojo.setfName("Yogita");
		creatAccountDetailsPojo.setLname("Pawale");
		creatAccountDetailsPojo.setPswd("1234567");
		creatAccountDetailsPojo.setDays("14");
		creatAccountDetailsPojo.setMonth("December");
		creatAccountDetailsPojo.setYear("1995");
		creatAccountDetailsPojo.setCompany("abc");
		creatAccountDetailsPojo.setAddress("1,A-wings,abc Residency,Nashik");
		creatAccountDetailsPojo.setCity("Nashik");
		creatAccountDetailsPojo.setState("Maine");
		creatAccountDetailsPojo.setPostcode("00000");
		creatAccountDetailsPojo.setAddtionalInfo("pqrlm");
		creatAccountDetailsPojo.setHomephone("02537827085");
		creatAccountDetailsPojo.setMobileNumber("9856421030");
		creatAccountDetailsPojo.setAliasAddress("hjgjhjj");

		createAccoutnPage.enterCreateAccountDetails(creatAccountDetailsPojo);
		ProfilePage profilePage = createAccoutnPage.clickOnRegistration();

		String actual = profilePage.getHeaderText();
		String expected = "Yogita Pawale";

		Assert.assertEquals(actual, expected, "Verification not happend");

	}

	@Test
	public void createAccountUIValidationTest() {
		HomePage homePage = new HomePage();

		System.out.println("STEP-ClickedOnSignIn");
		AuthenticationPage authenticationPage = homePage.clickedOnSignIn();

		System.out.println("Verify-Authentication Header is displayed");
		boolean authenticationHeaderFlag = authenticationPage.isAuthencationHeaderVisible();
		Assert.assertTrue(authenticationHeaderFlag);

		System.out.println("STEP-Enter E-mail Address");
		authenticationPage.enterEmailAddress("hjkl12345@gmail.com");
		CreateAccountPage createAccoutnPage = authenticationPage.clickOnCreateAccount();

		System.out.println("Verify-Create Account Header");
		boolean isHeadingText = createAccoutnPage.isPageHeadingTextDisplayed();
		Assert.assertTrue(isHeadingText, "Header Text was not Displayed");

		System.out.println("Navigate to create account page");
		CreatAccountDetailsPojo creatAccountDetailsPojo = new CreatAccountDetailsPojo();
		// creatAccountDetailsPojo.setMale(true);
		// creatAccountDetailsPojo.setfName("Yogita");

		createAccoutnPage.enterCreateAccountDetails(creatAccountDetailsPojo);
		ProfilePage profilePage = createAccoutnPage.clickOnRegistration();
		List<String> expectdErrorMessages = new ArrayList<String>();
		expectdErrorMessages.add("There are 8 errors");
		expectdErrorMessages.add("You must register at least one phone number.");
		expectdErrorMessages.add("lastname is required.");
		expectdErrorMessages.add("firstname is required.");
		expectdErrorMessages.add("passwd is required.");
		expectdErrorMessages.add("address1 is required.");
		expectdErrorMessages.add("city is required.");
		expectdErrorMessages.add("The Zip/Postal code you've entered is invalid. It must follow this format: 00000");
		expectdErrorMessages.add("This country requires you to choose a State.");

		List<String> actualErrorMessages = createAccoutnPage.getErrorMsg();
		System.out.println("Print Actual Error Messages");
		System.out.println(actualErrorMessages);

		System.out.println("Print Expected Error Messages");
		System.out.println(expectdErrorMessages);
		Assert.assertEquals(actualErrorMessages, expectdErrorMessages);

	}

}
