package sample.Tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import sample.PageObjects.CartPage;
import sample.PageObjects.CheckOutPage;
import sample.PageObjects.LabsPage;
import sample.PageObjects.LandingPage;
import sample.PageObjects.OverviewPage;
import sample.TestComponents.BaseTest;

public class RunnerTestNG extends BaseTest{
	
	public WebDriver driver;
	LandingPage LANDING_PAGE;
	LabsPage LABS_PAGE;
	CartPage CART_PAGE;
	CheckOutPage CHECK_OUT_PAGE;
	OverviewPage OVERVIEW_PAGE;
	
	@Test
	public void validateTests() {
		LANDING_PAGE = navigateToTheURL();
		LANDING_PAGE.enterUserNamePasswordAndLogin("standard_user", "secret_sauce");
		LABS_PAGE = LANDING_PAGE.openMenuButton();
		waitUntilCompletePageIsLoaded();
		Assert.assertEquals(LABS_PAGE.returnCurrentURL(), "https://saucelabs.com/"); 
		navigateBack();
		Assert.assertEquals(getTitle(), "Swag Labs");
		LANDING_PAGE.clickOnTheHighestAmountItem();
		CART_PAGE = LANDING_PAGE.clickOnShoppingCartBtn();
		CHECK_OUT_PAGE = CART_PAGE.clickOnCheckOutButton();
		CHECK_OUT_PAGE.enterDetailsInInformation("Sailesh", "Ramesh", "560042");
		OVERVIEW_PAGE = CHECK_OUT_PAGE.clickOnContinueBtn();
		OVERVIEW_PAGE.printAllOverviewDetails();
		OVERVIEW_PAGE.clickOnFinishBtn();
	}
}
