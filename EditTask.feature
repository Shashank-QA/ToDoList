@EditTask
Feature: Edit Operations in ToDo List
Background: 
    Given I launch the the website using the "VueToDoURL"

 		@UpdateTask
  	Scenario: Verify user is able to update the existing task name
    When I enter following tasks in the ToDo list textbox
    	| Daily StandUp |
    And I update the "Daily StandUp" task as "Daily StandUp Reschedule"
    Then I verify the task name gets updated as "Daily StandUp Reschedule"
    
    @DeleteTask
    Scenario: Verify user is able to delete the tasks from the list
    When I enter following tasks in the ToDo list textbox
    	| Daily StandUp |
    Then I click on delete button
    And I verify the task "Daily StandUp" is removed from the list

