package sample.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {
	
    public WebDriver driver;
	
	public CheckOutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); //To make finding elements easier
	}
	
	@FindBy(css="#first-name")
	WebElement firstNamePlaceHolder;
	
	@FindBy(css="#last-name")
	WebElement lastNamePlaceHolder;
	
	@FindBy(css="#postal-code")
	WebElement postalCodePlaceHolder;
	
	@FindBy(css="#continue")
	WebElement continueBtn;
	
	public void enterDetailsInInformation(String firstName, String lastName, String postalCode) {
		firstNamePlaceHolder.sendKeys(firstName);
		lastNamePlaceHolder.sendKeys(lastName);
		postalCodePlaceHolder.sendKeys(postalCode);
	}
	
	public OverviewPage clickOnContinueBtn() {
		continueBtn.click();
		return new OverviewPage(driver);
	}
	

}
