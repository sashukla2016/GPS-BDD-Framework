Feature: GPS Login 

@RegressionTest @End2End
Scenario Outline: GPS login
	Given I am on the application login page
	When I enter the "<Username>" and "<Password>"
	Then I should be navigated to home page
	
	Examples:
		| Username | Password |
		| jhjhhj   | ss@12	  |
		|  abcde   | pass123  |
		| jjhdhdk  | 123	  |