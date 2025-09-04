package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utilities.TestData;

public class SauceDemoLogin extends BasePage {

	public SauceDemoLogin(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "user-name")
	WebElement username;
	
	@FindBy(xpath = "//input[@id='password']")
	WebElement password;
	
	@FindBy(xpath = "//input[@id='login-button']")
	WebElement loginButton;
	
	@FindBy(id="inventory_container")
	WebElement inventoryContainer;
	
	@FindBy(xpath="//div[@class='inventory_list']")
	WebElement inventoryList;
	
	@FindBy(xpath="//div[@id='header_container']/div[2]/span")
	WebElement productsPage;
	
	@FindBy(xpath="//div[@class='error-message-container error']/h3")
	WebElement errorMsg;
	
	public void enterValidUserName() {
		username.sendKeys(TestData.USERNAME);
	}
	public void enterPassword() {
		password.sendKeys(TestData.PASSWORD);
	}
	public void clickloginButton() {
		loginButton.click();
	}
	public boolean isInventoryContainer() {
		return inventoryContainer.isDisplayed();
	}
	public boolean isProductPageVisisble() {
		return productsPage.isDisplayed();
	}
	public boolean isInventoryList() {
		return inventoryList.isDisplayed();
	}
	public void enterInvalidUsername(){
		username.sendKeys(TestData.inValidUsername);
	}
	public boolean isErrorMsgDisplayed() throws InterruptedException {
		Thread.sleep(4000);
		System.out.println("Error mssg: "+errorMsg.getText());
		return errorMsg.isDisplayed();
	}
	
	
	

	
}
