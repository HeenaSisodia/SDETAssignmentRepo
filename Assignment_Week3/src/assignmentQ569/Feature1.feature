Feature: Orange application scenarios

@Smoke
Scenario: Login to application
Given I open my application
And I login with following credentials
|Admin | admin123|
Then Validate Login Success
And Title of page is 
|OrangeHRM|

@Others
Scenario: The sum of list of numbers should be calculated
Given a list of numbers
|4|
|5|
|6|
When I Multiply them
Then should I get 120

