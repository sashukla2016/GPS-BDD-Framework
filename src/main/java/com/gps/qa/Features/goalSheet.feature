Feature: Add Goals
Background:
	Given User successfully logs in
	When User navigates to GoalSheet

@RegressionTest @End2End
Scenario: Adding goals
	Given Navigates to add goal
	When I add a Goal
		|Add Goal|
		|Hooks- Order of hooks |
		|WebDriver- close v/s quit |
		|Exception Handling in Hooks|
		|Feature Files- Priority  |
	Then Verify Goal is added to the GoalSheet

@SmokeTest @End2End
Scenario: Update GoalSheet
	Given Navigates to status
	When I update a goal
	Then Goal is updated successfully
	
Scenario: Adding notes
	Given I am at notes section
	When I add notes against a goal
		|Notes|
		|Adding Notes Test|
		|Add Notes testing|
	Then Notes are added successfully
	