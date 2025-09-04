package PageObjectModel;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YourCartPage extends BasePage{

	public YourCartPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	

	@FindBy(xpath = "//div[@class='inventory_item_name']")
	List<WebElement> cartItemNames;

	@FindBy(xpath="//span[@class='shopping_cart_badge']")
	WebElement cartBadge;
	
	@FindBy(xpath = "//div[@class='inventory_item_price']")
	List<WebElement> cartItemPrices;

	@FindBy(id="checkout")
	WebElement checkout;
	
	public int getCartBadgeCount() {
	    try {
		String badgeText = cartBadge.getText();
	        return Integer.parseInt(badgeText);
	    } catch (NumberFormatException | NullPointerException e) {
	        // If badge is not present or not a number, return 0
	        return 0;
	    }
	}
	

	public List<String> getCartItemNames() {
	    List<String> itemNames = new ArrayList<>();
	    for (WebElement item : cartItemNames) {
	        itemNames.add(item.getText().trim());
	    }
	    return itemNames;
	}


	public Map<String, String> getCartItemPrices() {
	    Map<String, String> itemPrices = new LinkedHashMap<>();
	    for (int i = 0; i < cartItemNames.size(); i++) {
	        String name = cartItemNames.get(i).getText().trim();
	        String price = cartItemPrices.get(i).getText().trim();
	        itemPrices.put(name, price);
	    }
	    return itemPrices;
	}
	
	public void clickCheckoutButton() {
	    checkout.click();
	}


	
}
