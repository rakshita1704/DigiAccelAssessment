package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends BasePage{
	
	public ProductsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "add-to-cart-sauce-labs-backpack")
	WebElement addToCartSauceLabsBackpack;
	
	@FindBy(id = "add-to-cart-sauce-labs-bike-light")
	WebElement addToCartSauceLabsBikeLight;
	
	@FindBy(xpath="//a[@class='shopping_cart_link']")
	WebElement cart;
	

	
	public void addToCart() {
		addToCartSauceLabsBackpack.click();
		addToCartSauceLabsBikeLight.click();
	}
	public void clickOnCart() {
		cart.click();
	}
	
	
	
}
