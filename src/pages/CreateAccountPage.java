package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.PredefinedActions;
import pojo.CreatAccountDetailsPojo;

public class CreateAccountPage extends PredefinedActions {
	WebDriverWait wait;

	public boolean isPageHeadingTextDisplayed() {
		wait = new WebDriverWait(driver, 30);
		return wait.until(ExpectedConditions.textToBe(By.cssSelector("#noSlide h1"), "CREATE AN ACCOUNT"));

	}

	private void selectGender(boolean isMale) {
		wait = new WebDriverWait(driver, 30);
		WebElement titleElement;
		System.out.println("STEP - Select title");

		if (isMale) {
			titleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("id_gender1")));
		} else {
			titleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("id_gender2")));
		}
		wait.until(ExpectedConditions.elementToBeClickable(titleElement));
		titleElement.click();

	}

	private void enterFirstName(String firstName) {
		if (firstName != null) {
			System.out.println("STEP-Enter First Name");
			driver.findElement(By.id("customer_firstname")).sendKeys(firstName);
		} else {
			System.out.println("First Name field is Blank");
		}
	}

	private void enterLastName(String lastName) {
		if (lastName != null) {
			System.out.println("STEP-Enter Last Name");
			driver.findElement(By.id("customer_lastname")).sendKeys(lastName);

		} else {
			System.out.println("Last Name field is Blank");
		}
	}

	private void enterPassword(String pswd) {
		if (pswd != null) {
			System.out.println("STEP-Enter Password");
			driver.findElement(By.id("passwd")).sendKeys(pswd);
		} else {
			System.out.println("Password Fields is blank");
		}
	}

	private void selectDay(String day) {
		if (day != null) {
			System.out.println("STEP-Select Birthdate ");
			wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("uniform-days")))).click();
			Select s = new Select(driver.findElement(By.id("days")));
			s.selectByValue(day);
		} else {
			System.out.println("Day is not selected");
		}
	}

	private void selectMonth(String month) {
		if (month != null) {
			System.out.println("STEP-Select Birth month");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("uniform-months"))).click();
			Select s = new Select(driver.findElement(By.id("months")));
			s.selectByVisibleText(month + " ");
		} else {
			System.out.println("Month is not selected");
		}
	}

	private void selectYear(String year) {
		if (year != null) {
			System.out.println("STEP-Select Birth year ");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("uniform-years"))).click();
			Select s = new Select(driver.findElement(By.id("years")));
			s.selectByValue(year);
		} else {
			System.out.println("Year is not selected");
		}
	}

	private void enterCompanyName(String companyName) {
		if (companyName != null) {
			System.out.println("STEP-Enter " + "Company Name");
			driver.findElement(By.id("company")).sendKeys(companyName);
		} else {
			System.out.println("Company Name Fields is blank");
		}
	}

	private void enterAddress(String address) {
		if (address != null) {
			System.out.println("STEP-Enter Address ");
			driver.findElement(By.id("address1")).sendKeys(address);
		} else {
			System.out.println("Address Fields is blank");
		}
	}

	private void enterCityName(String city) {
		if (city != null) {
			System.out.println("STEP-Enter City Name");
			driver.findElement(By.id("city")).sendKeys(city);
		} else {
			System.out.println("City Fields is blank");
		}
	}

	private void enterStateName(String state) {
		if (state != null) {
			System.out.println("STEP-Enter State Name");
			wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("uniform-id_state")))).click();
			Select s = new Select(driver.findElement(By.id("id_state")));
			s.selectByVisibleText(state);
		} else {
			System.out.println("State Fields is blank");
		}
	}

	private void enterPostcode(String postcode) {
		if (postcode != null) {
			System.out.println("STEP-Enter Postcode");
			driver.findElement(By.id("postcode")).sendKeys(postcode);
		} else {
			System.out.println("Postcode Fields is blank");
		}
	}

	private void enterAdditionalInfo(String addtionalInfo) {
		if (addtionalInfo != null) {
			System.out.println("STEP-Enter Additional information ");
			driver.findElement(By.id("other")).sendKeys(addtionalInfo);
		} else {
			System.out.println("AdditionalInfo Fields is blank");
		}
	}

	private void enterHomeNumber(String homeNumber) {
		if (homeNumber != null) {
			System.out.println("STEP-Enter Home mobile number ");
			driver.findElement(By.id("phone")).sendKeys(homeNumber);
		} else {
			System.out.println("Home NumberFields is blank");
		}
	}

	private void enterMobileNumber(String mobileNumber) {
		if (mobileNumber != null) {
			System.out.println("STEP-Enter Mobile number");
			driver.findElement(By.id("phone_mobile")).sendKeys(mobileNumber);
		} else {
			System.out.println("Mobile NumberFields is blank");
		}
	}

	public void enterCreateAccountDetails(CreatAccountDetailsPojo creatAccountDetailsPojo) {
		selectGender(creatAccountDetailsPojo.isMale());
		enterFirstName(creatAccountDetailsPojo.getfName());
		enterLastName(creatAccountDetailsPojo.getLname());
		enterPassword(creatAccountDetailsPojo.getPswd());
		selectDay(creatAccountDetailsPojo.getDays());
		selectMonth(creatAccountDetailsPojo.getMonth());
		selectYear(creatAccountDetailsPojo.getYear());
		enterCompanyName(creatAccountDetailsPojo.getCompany());
		enterAddress(creatAccountDetailsPojo.getAddress());
		enterCityName(creatAccountDetailsPojo.getCity());
		enterStateName(creatAccountDetailsPojo.getState());
		enterPostcode(creatAccountDetailsPojo.getPostcode());
		enterAdditionalInfo(creatAccountDetailsPojo.getAddtionalInfo());
		enterHomeNumber(creatAccountDetailsPojo.getHomephone());
		enterMobileNumber(creatAccountDetailsPojo.getMobileNumber());

	}

	public ProfilePage clickOnRegistration() {
		System.out.println("Details Registered in Application");
		wait.until(ExpectedConditions.elementToBeClickable(By.id("submitAccount"))).click();
		
		return new ProfilePage();

	}

	public List<String> getErrorMsg() {
		List<WebElement> listOfErrorElement = driver.findElements(By.cssSelector("ol>li"));
		List<String> listOfErrorTxt = new ArrayList<String>();
		String errorCount = driver.findElement(By.cssSelector(".alert.alert-danger>p")).getText();
		listOfErrorTxt.add(errorCount);
		for (WebElement element : listOfErrorElement) {
			listOfErrorTxt.add(element.getText());
		}
		return listOfErrorTxt;
	}

}
