Feature: End to End Automation of SauceDemo
	
	@SauceDemoE2E
	Scenario: Complete Purchase Flow
		Given Login as standard_user and secret_sauce
		And Add two items from Products
		And Go to cart and Checkout
		And Fill checkout info and Continue
		Then Verify overview totals and click on Finish
		And Confirm Checkout message and Back Home