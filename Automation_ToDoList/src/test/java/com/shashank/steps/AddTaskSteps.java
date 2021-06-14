package com.shashank.steps;

import com.shashank.utils.CommonMethods;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class AddTaskSteps extends CommonMethods{
	
	int intialtaskcount = 0; 
	
	
	@When("I enter following tasks in the ToDo list textbox")
	public void i_enter_following_tasks_in_the_to_do_list_textbox(io.cucumber.datatable.DataTable dataTable) {
		intialtaskcount = enterTask(mainPage.inputtask,dataTable);	
	}
	
	@Then("I verify {string} task is added successfully to the list")
	public void i_verify_task_is_added_successfully_to_the_list(String string) {
		verifyTaskisVisible(string);
	}
	@Then("I verify the {string} task added is {string} by default")
	public void i_verify_the_task_added_is_by_default(String string, String state) {
		click(mainPage.activeTasks);
		verifyTaskisVisible(string);
	}
	
	@Then("I verify the total count of the tasks entered in the list")
	public void i_verify_the_total_count_of_the_tasks_entered_in_the_list() {
		int actualtaskcount = Integer.parseInt(mainPage.taskcount.getText());
		Assert.assertEquals(intialtaskcount,actualtaskcount);
		
	}



}
