package TestSteps;

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
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SauceDemoE2ESteps {
	 WebDriver driver;
	 Logger logger;
	    SauceDemoLogin loginPage;
	    ProductsPage productsPage;
	    Properties p;
	    SauceDemoLogin sd;
		SauceDemoCheckoutPage checkoutPage;
	    YourCartPage cartPage;
	  

	    @Given("Login as standard_user and secret_sauce")
	    public void LoginaAsstandard_userAndsecret_sauce() {
	    	driver = BaseClass.getDriver();
			logger = BaseClass.getLogger();
			p = BaseClass.getProperties();
			driver.get(p.getProperty("url"));
			logger.info("Url opened");
			sd=new SauceDemoLogin(driver);
			sd.enterValidUserName();
			sd.enterPassword();
			logger.info("entered username and password");
			sd.clickloginButton();
	    }


	    @When("Add two items from Products")
	    public void add_two_items() {
	        productsPage = new ProductsPage(driver);
	        productsPage.addToCart();
	    }

	    @When("Go to cart and Checkout")
	    public void go_to_cart_and_checkout() {
	        productsPage.clickOnCart();
	        cartPage = new YourCartPage(driver);
	        cartPage.clickCheckoutButton();
	    }

	    @When("Fill checkout info and Continue")
	    public void fill_checkout_info() {
	        checkoutPage = new SauceDemoCheckoutPage(driver);
	        checkoutPage.enterFirstName(TestData.FIRST_NAME);
	        checkoutPage.enterLastName(TestData.LAST_NAME);
	        checkoutPage.enterPostalCode(TestData.POSTAL_CODE);
	        checkoutPage.clickContinue();
	    }

	    @Then("Verify overview totals and click on Finish")
	    public void verify_and_finish() {
	    	Assert.assertTrue(checkoutPage.validateItemTotals());
	        checkoutPage.clickFinishButton();
	    }

	    @Then("Confirm Checkout message and Back Home")
	    public void confirm_checkout_message() {
	        Assert.assertEquals("Thank you for your order!", checkoutPage.getCheckoutMessage());
	        checkoutPage.clickBackHome();
	
	    }
}
