package sample.PageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	public WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); //To make finding elements easier
	}
	
	//Generic Method to navigate to specific URL, maximise all the page elements
	public void navigateToURL(String url) {
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}	
	
	@FindBy(css="#user-name")
    WebElement userNameTextBox;
	
	@FindBy(css="#password")
    WebElement passwordTextBox;
	
	@FindBy(css="#login-button")
    WebElement loginBtn;
	
	@FindBy(css="#react-burger-menu-btn")
    WebElement hamburgerMenuBtn;
	
	@FindBy(css="#about_sidebar_link")
    WebElement aboutSideBarLink;
	
	@FindBy(css="div.inventory_item_description")
	List<WebElement> itemElements;
	
	@FindBy(css="button[class*='btn_inventory']")
	List<WebElement> addToCartButtons;
	
	@FindBy(css="a.shopping_cart_link")
	WebElement shoppingCartButton;
	
	
	public void enterUserNamePasswordAndLogin(String username, String password) {
		userNameTextBox.sendKeys(username);
		passwordTextBox.sendKeys(password);
		loginBtn.click();
	}
	
	public LabsPage openMenuButton() {
		hamburgerMenuBtn.click();
		aboutSideBarLink.click();
		LabsPage LABS_PAGE = new LabsPage(driver);
		return LABS_PAGE;
	}
	
	public void clickOnTheHighestAmountItem() {
        // Create a list to store the item prices
        List<Double> itemPrices = new ArrayList<>();

        // Extract the prices from the elements and store them in the list
        for (WebElement itemElement : itemElements) {
            String priceText = itemElement.findElement(By.cssSelector("div.inventory_item_price")).getText();
            double price = Double.parseDouble(priceText.replace("$", ""));
            itemPrices.add(price);
        }

        // Find the maximum price in the list
        double maxPrice = Collections.max(itemPrices);

        // Find the index of the item with the maximum price
        int maxPriceIndex = itemPrices.indexOf(maxPrice);

        // Click the "Add to Cart" button for the item with the maximum price
        WebElement addToCartButton = addToCartButtons.get(maxPriceIndex);
        addToCartButton.click();
	}
	
	public CartPage clickOnShoppingCartBtn() {
		shoppingCartButton.click();
		return new CartPage(driver);
	}
	
}
