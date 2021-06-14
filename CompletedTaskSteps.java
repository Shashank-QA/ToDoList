package com.shashank.steps;

import org.openqa.selenium.By;

import com.shashank.utils.CommonMethods;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CompletedTaskSteps extends CommonMethods {
	
	int intialtaskcount = 0;
	
@When("I click on {string} radio button")
public void i_click_on_radio_button(String string) {
	 driver.findElement(By.xpath("//ul [@class = 'todo-list']//input[@type = 'checkbox']")).click();
	
}

@When("I click on {string} link")
public void i_click_on_link(String string) {
	click(mainPage.completedTasks);
}


@Then("I validate task {string} is displayed under {string} section")
public void i_validate_task_is_displayed_under_section(String string, String string2) {
	verifyTaskisVisible(string);
	
}

@When("I click on {string} button")
public void i_click_on_button(String string) {
	click(mainPage.clearCompleted);
}

@Then("I validate that the task {string} is not visible in the list")
public void i_validate_that_the_task_is_not_visible_in_the_list(String string) {
	click(mainPage.completedTasks);
	verifyTaskisNotVisible(string);
}


}
