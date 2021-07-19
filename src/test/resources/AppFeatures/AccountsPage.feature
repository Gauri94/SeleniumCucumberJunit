Feature: Account Page Feature

Background: 
Given User is already logged into the application
| username                | password |
| gouri.maftest@gmail.com | Maftest@123 | 

Scenario: Accounts Page Title
Given User is on Accounts Page
When User gets the title of the page
Then Page title should be "My account"

Scenario: Accounts section count
Given User is on Accounts Page
Then User gets Account Section
| ORDER HISTORY AND DETAILS  | 
| MY CREDIT SLIPS            |
| MY ADDRESSES 							 | 
| MY PERSONAL INFORMATION    |
| MY WISHLISTS 	 						 | 
And Accounts section count should be 5