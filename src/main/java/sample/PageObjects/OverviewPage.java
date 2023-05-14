package sample.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OverviewPage {

	public WebDriver driver;

	public OverviewPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // To make finding elements easier
	}

	@FindBy(css = ".summary_info")
	WebElement summaryElement;

	@FindBy(css = "#finish")
	WebElement finishBtn;

	public void printAllOverviewDetails() {
		System.out.println(summaryElement.getText());
	}

	public void clickOnFinishBtn() {
		finishBtn.click();
	}

}
