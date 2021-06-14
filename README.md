ProjectName : ToDoList
Branch : master

Note - The below steps are created assuming Java and Maven are already installed in the local machine. If they are not already installed please follow the instruction on How to Install Java for Java installation and How to Install Maven for Maven installation.

Execution Of Project Through IDE Using Maven
1.	Clone the project to a folder in the local machine 
2.	Open the IDE and import the project to the IDE 
3.	Right click on the project and Run As and select Maven Build... 
4.	In the screen that is opened enter the command “clean install” under goals and click run 
5.	The necessary dependencies will be downloaded and the project will be built 
6.	All the tests are executed when this command is used 
7.	If individual tests needs to be executed enter the command “mvn clean test 
-Dcucumber.options="--tags @tagName” under goals and run (Tag to the test scenario mapping could be found below) 

Tag Name to Test Scenario mapping
Feature

1.**@AddTasks**
The "@AddTasks" feature contains scenarios related to the adding of the new taks in the ToDo List.Following are the scenario with their respective tags :

**@AddNewTask**	Add single task in Todo List

**@AddMultipleTasks**	Add multiple tasks in Todo List and verify the total task count added in the list

2.**@EditTask**
The "@EditTask" feature contains scenarios relaed to edit operations of tasks.Following are the scenario with their respective tags :

**@UpdateTask**	Verify user is able to update the existing task name

**@DeleteTask** Verify user is able to delete the tasks from the list

3.**@CompleteTask**
The "@CompleteTask" feature contains scenaios related to behaviour of the tasks once completed.

**@TaskCompleted** Verify on checking the task, the task gets completed

**@ClearCompletedTask** Verify on clicking the Clear Completed button, the completed tasks gets removed from the list

Test Execution Reports
The reports are created below following path :
ToDoList/Automation_ToDoList/target/cucumber-html-reports/





