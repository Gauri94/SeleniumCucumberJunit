Feature: Login Page feature

Scenario: Login page title
Given User is on login page
When User gets the title of the page
Then Page title should be "My Store"

Scenario: Forgot Password link
Given User is on login page
Then Forgot password link should be displayed

Scenario: Login with correct credentials
Given User is on login page
When User enters username "gouri.maftest@gmail.com"
And User enters password "Maftest@123"
And User clicks on Login button
Then User gets the title of the page
And Page title should be "My account"