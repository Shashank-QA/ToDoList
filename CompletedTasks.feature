@CompleteTask
Feature: Completed Task
  Background:
  	Given I launch the the website using the "VueToDoURL"
    And I enter following tasks in the ToDo list textbox
    	| Daily StandUp |
      | Requirement Gathering|
      | Test Cases Creation|
      | Test Execution|
      | Bug Reporting |
      
		@TaskCompleted
  	Scenario: Verify on checking the task,the task gets completed.
    When I click on "Daily StandUp" radio button
    And I click on "Completed" link
    Then I validate task "Daily StandUp" is displayed under "Completed" section
    
    @ClearCompletedTask
    Scenario: Verify on clicking the ClearCompleted button,the completed tasks gets removed from the list.
    When I click on "Daily StandUp" radio button
    And I click on "Clear Completed" button
    Then I validate that the task "Daily StandUp" is not visible in the list
    

    
    
   
