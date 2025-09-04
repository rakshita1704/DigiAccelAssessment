package TestSteps;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import PageObjectModel.ProductsPage;
import PageObjectModel.SauceDemoCheckoutPage;
import PageObjectModel.SauceDemoLogin;
import PageObjectModel.YourCartPage;
import TestBase.BaseClass;
import Utilities.TestData;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SauceDemoSteps {

	WebDriver driver;
	Logger logger;
	Properties p;
	SauceDemoLogin sd;
	ProductsPage productsPage;
	YourCartPage cartPage;
	SauceDemoCheckoutPage checkoutPage;
	
	@Given("User is on login page")
	public void userIsOnLoginPage() {
		driver = BaseClass.getDriver();
		logger = BaseClass.getLogger();
		p = BaseClass.getProperties();
		driver.get(p.getProperty("url"));
		logger.info("Url opened");
	}
	
	
	@When("User enters userName and password")
	public void userEntersUsernameAndPassword(){
		sd=new SauceDemoLogin(driver);
		sd.enterValidUserName();
		sd.enterPassword();
		logger.info("entered username and password");
	}
	
	@When("User clicks on login button")
	public void userClicksOnLoginButton() {
		sd=new SauceDemoLogin(driver);
		sd.clickloginButton();
		logger.info("clicked on login button");
	}
	
	@Then("Validate inventory")
	public void validateInventory() {
		sd=new SauceDemoLogin(driver);
		Assert.assertTrue(sd.isInventoryContainer());
		logger.info("Validate inventory");
	}
	
	@Then("Validate product page is visible")
	public void validateProductPageIsVisible() {
		sd=new SauceDemoLogin(driver);
		Assert.assertTrue(sd.isProductPageVisisble());
		logger.info("Validate product page is visible");
	}
	
	@Then("Validate product grid is displayed")
	public void validateProductGridIsDisplayed() {
		sd=new SauceDemoLogin(driver);
		Assert.assertTrue(sd.isInventoryList());
		logger.info("Validate product grid is displayed");
	}
	
	@When("User enters invalid userName and password")
	public void userEntersInvalidUsernameAndPassword() {
		sd=new SauceDemoLogin(driver);
		sd.enterInvalidUsername();
		sd.enterPassword();
		logger.info("Enters invalid username and password");
	}
	
	@Then("Validate Error message")
	public void validateErrorMessage() throws InterruptedException {
		sd=new SauceDemoLogin(driver);
		Assert.assertTrue(sd.isErrorMsgDisplayed());
		logger.info("error mssg is displayed");
	}
	
	@When("User add two products from the products page")
    public void userAddTwoProductsFromTheProductsPage() {
        productsPage = new ProductsPage(driver);
        productsPage.addToCart();
    }	
	
	@When("User click on Cart icon")
    public void userClickOnCartIcon() {
        productsPage.clickOnCart();
    }
	
	@Then("Cart badge should be two")
    public void cartBadgeShouldBeTwo() {
        cartPage = new YourCartPage(driver);
        int badgeCount = cartPage.getCartBadgeCount();
        Assert.assertEquals(2, badgeCount);
    }
	@And("Validate Both items listed correctly with prices")
    public void validateBothItemsListedCorrectlyWithPrices() {
        List<String> expectedItems = Arrays.asList("Sauce Labs Backpack", "Sauce Labs Bike Light");
        List<String> actualItems = cartPage.getCartItemNames();
        Assert.assertTrue(actualItems.containsAll(expectedItems));
        
        Map<String, String> expectedPrices = Map.of(
            "Sauce Labs Backpack", "$29.99",
            "Sauce Labs Bike Light", "$9.99"
        );
        Map<String, String> actualPrices = cartPage.getCartItemPrices();
        Assert.assertEquals(expectedPrices, actualPrices); 
    }
	
	@When("Click checkout in cart")
    public void clickCheckoutInCart() {
        cartPage = new YourCartPage(driver);
        cartPage.clickCheckoutButton();
    }

    @And("User fills name and postal code")
    public void userFillsNameAndPostalCode() {
        checkoutPage = new SauceDemoCheckoutPage(driver);
        checkoutPage.enterFirstName(TestData.FIRST_NAME);
        checkoutPage.enterLastName(TestData.LAST_NAME);
        checkoutPage.enterPostalCode(TestData.POSTAL_CODE);
    }

    @And("Clicks on Continue")
    public void clicksOnContinue() {
        checkoutPage.clickContinue();
    }

    @Then("validate Overview page displayed with items and totals")
    public void validateOverviewPageDisplayedWithItemsAndTotals() {
        Assert.assertTrue(checkoutPage.isOverviewPageDisplayed());
        Assert.assertEquals(2, checkoutPage.getOverviewItemCount());
        Assert.assertTrue(checkoutPage.validateItemTotals());
    }

    @And("On Overview page checks total")
       public void onOverviewPageChecksTotal() {
           Assert.assertTrue(checkoutPage.validateItemTotals());
       }

    
    @And("Clicks on finish")
    public void clicksOnFinish() {
        checkoutPage.clickFinishButton();
    }
    
    @Then("Checkout Message should be displayed")
    public void checkoutMessageShouldBeDisplayed() {
        Assert.assertTrue(checkoutPage.isCheckoutMessageDisplayed());
    }
}
