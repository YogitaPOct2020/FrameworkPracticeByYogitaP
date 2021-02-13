package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.PredefinedActions;

public class AuthenticationPage extends PredefinedActions {

	public void enterEmailAddress(String emailId) {
		WebDriverWait wait = new WebDriverWait(driver, 30);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/child::input[@id='email_create']")))
				.sendKeys(emailId);
		System.out.println("Enter email addressfor the create user name");

	}

	public CreateAccountPage clickOnCreateAccount() {
		WebDriverWait wait = new WebDriverWait(driver, 30);

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#SubmitCreate"))).click();
		System.out.println("Clicked on the submit button to fill the other details");

		return new CreateAccountPage();
	}

	public boolean isAuthencationHeaderVisible() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Authentication']")));
		return element.isDisplayed();
	}
}
