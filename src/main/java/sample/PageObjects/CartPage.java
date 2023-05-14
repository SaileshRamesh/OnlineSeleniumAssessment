package sample.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

	public WebDriver driver;

	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // To make finding elements easier
	}

	@FindBy(css = "#checkout")
	WebElement checkOutButton;

	public CheckOutPage clickOnCheckOutButton() {
		checkOutButton.click();
		return new CheckOutPage(driver);
	}

}
