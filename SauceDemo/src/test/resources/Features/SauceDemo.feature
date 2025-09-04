Feature: Automation of SauceDemo
	
	@SuccessfulLogin @SauceDemo
	Scenario:Successful Login
		Given User is on login page
		When User enters userName and password
		And User clicks on login button
		Then Validate inventory
		And Validate product page is visible
		And Validate product grid is displayed
	
	@InvalidLogin @SauceDemo
	Scenario:Invalid Login
		Given User is on login page
		When User enters invalid userName and password
		And User clicks on login button
		Then Validate Error message
	
	@AddMultipleItems @SauceDemo
	Scenario: Add multiple items to cart
		Given User is on login page
		When User enters userName and password
		And User clicks on login button
		And User add two products from the products page
		And User click on Cart icon
		Then Cart badge should be two
		And Validate Both items listed correctly with prices
	
	@CheckoutInformation @SauceDemo
	Scenario: Checkout your information
		Given User is on login page
		When User enters userName and password
		And User clicks on login button
		And User add two products from the products page
		And User click on Cart icon
		When Click checkout in cart
		And User fills name and postal code
		And Clicks on Continue
		Then validate Overview page displayed with items and totals
	
	@FinishCheckout	@SauceDemo
	Scenario: Finish Checkout
		Given User is on login page
		When User enters userName and password
		And User clicks on login button
		When User add two products from the products page
		And User click on Cart icon
		When Click checkout in cart
		And User fills name and postal code
		And Clicks on Continue
		And On Overview page checks total
		And Clicks on finish
		Then Checkout Message should be displayed
		
		
		