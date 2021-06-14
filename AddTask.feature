@AddTasks
Feature: AddTasks in ToDo List
Background: 
    Given I launch the the website using the "VueToDoURL"
   
  @AddNewTask
  Scenario: Add single task in Todo List
    When I enter following tasks in the ToDo list textbox
    	| Daily StandUp |
    Then I verify "Daily StandUp" task is added successfully to the list
		And I verify the "Daily StandUp" task added is "Active" by default
		
	@AddMultipleTasks
  Scenario: Add multiple tasks in Todo List and verify the total task count added in the list
    When I enter following tasks in the ToDo list textbox
    	| Daily StandUp |
      | Requirement Gathering|
      | Test Cases Creation|
      | Test Execution|
      | Bug Reporting |
    Then I verify the total count of the tasks entered in the list

   
