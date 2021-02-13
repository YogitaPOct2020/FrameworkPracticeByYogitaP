package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.PredefinedActions;

public class HomePage extends PredefinedActions{
	public AuthenticationPage clickedOnSignIn()
	{
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div/child::a[@class='login']"))).click();
		System.out.println("Clicked on sign in");
        return new AuthenticationPage();
	}

}
