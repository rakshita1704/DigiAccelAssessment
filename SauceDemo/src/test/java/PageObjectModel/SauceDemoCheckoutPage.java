package PageObjectModel;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SauceDemoCheckoutPage extends BasePage{

	public SauceDemoCheckoutPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}


	@FindBy(xpath = "//input[@id='first-name']")
	WebElement firstNameInput;
	
	@FindBy(xpath = "//input[@id='last-name']")
	WebElement lastNameInput;
	
	@FindBy(xpath = "//input[@id='postal-code']")
	WebElement postalCodeInput;
	
	@FindBy(id="continue")
	WebElement continueBtn;
	
	@FindBy(xpath="//span[text()='Checkout: Overview']")
	WebElement overviewPage;

	@FindBy(xpath = "//div[@class='summary_total_label']")
	WebElement validateTotal;

	@FindBy(className = "inventory_item_price")
    List<WebElement> itemPrices;

    @FindBy(className = "summary_tax_label")
    WebElement taxLabel;

    @FindBy(xpath = "//div[@class='cart_quantity']")
    List<WebElement> overviewItems;
    
    @FindBy(id="finish")
    WebElement finishBtn;
    
   
	@FindBy(xpath = "//h2[@class='complete-header']")
	WebElement checkoutMessage;
	
    @FindBy(id = "back-to-products")
    WebElement backHomeBtn;
	

	public void enterFirstName(String firstName) {
	    firstNameInput.clear();
	    firstNameInput.sendKeys(firstName);
	}
	
	public void enterLastName(String lastName) {
	    lastNameInput.clear();
	    lastNameInput.sendKeys(lastName);
	}
	
	public void enterPostalCode(String postalCode) {
	    postalCodeInput.clear();
	    postalCodeInput.sendKeys(postalCode);
	}
	public void clickContinue() {
		continueBtn.click();
	}

	public boolean isOverviewPageDisplayed() {
            return overviewPage.isDisplayed();
	}

	public int getOverviewItemCount() {
		 return overviewItems.size();
	}

	public boolean validateItemTotals() {
	    String totalText = validateTotal.getText().trim(); // e.g., "Total: $43.18"
	    double actualTotal = Double.parseDouble(totalText.replaceAll("[^\\d.]", ""));
	    double expectedTotal = 0.0;
	    for (WebElement price : itemPrices) {
	        expectedTotal += Double.parseDouble(price.getText().replace("$", ""));
	    }
	    expectedTotal += Double.parseDouble(taxLabel.getText().replaceAll("[^\\d.]", ""));
	    return Math.abs(actualTotal - expectedTotal) < 0.01;
	}

	public boolean isCheckoutMessageDisplayed() {
    return checkoutMessage.isDisplayed();
	}

	public void clickFinishButton() {
    finishBtn.click();
}

	public String getCheckoutMessage() {
		return checkoutMessage.getText();
	}
	public void clickBackHome() {
        backHomeBtn.click();
    }

	
}
