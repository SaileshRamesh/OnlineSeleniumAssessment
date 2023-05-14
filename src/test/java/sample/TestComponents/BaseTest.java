package sample.TestComponents;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import sample.PageObjects.LandingPage;

public class BaseTest {
	public WebDriver driver;

	// Using chromedriver as per requirement
	public WebDriver invokeDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		return driver;
	}

	public LandingPage navigateToTheURL() {
		driver = invokeDriver();
		LandingPage LANDING_PAGE = new LandingPage(driver);
		LANDING_PAGE.navigateToURL("https://www.saucedemo.com/");
		return LANDING_PAGE;
	}

	public void waitUntilCompletePageIsLoaded() {
		JavascriptExecutor j = (JavascriptExecutor) driver;
		if (j.executeScript("return document.readyState").toString().equals("complete")) {
			System.out.println("Page has loaded completely");
		}
	}

	public void navigateBack() {
		driver.navigate().back();
	}

	public String getTitle() {
		return driver.getTitle();
	}

	@AfterTest
	public void closeDriver() {
		driver.close();
	}

}
