package sample.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LabsPage {

	public WebDriver driver;

	public LabsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // To make finding elements easier
	}

	public String returnCurrentURL() {
		return driver.getCurrentUrl();
	}
}
