package com.shashank.steps;

import org.apache.maven.shared.utils.StringUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import com.shashank.utils.CommonMethods;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EditTaskSteps extends CommonMethods{
	
@When("I update the {string} task as {string}")
public void i_update_the_task_as(String string, String string2) {
	String s = StringUtils.difference(string, string2);
	Actions action = new Actions(driver);
	action.doubleClick(mainPage.taskList.get(0)).sendKeys(Keys.SPACE).sendKeys(s).sendKeys(Keys.ENTER).build().perform();
	
}

@When("I verify the task name gets updated as {string}")
public void i_verify_the_task_name_gets_updated_as(String string) {
	verifyTaskisVisible(string);
}

// DeleteTask
@Then("I click on delete button")
public void i_click_on_delete_button() {
	Actions action = new Actions(driver);
	action.moveToElement(mainPage.taskList.get(0)).click(mainPage.deltask).build().perform();;
}

@Then("I verify the task {string} is removed from the list")
public void i_verify_the_task_is_removed_from_the_list(String string){
	verifyTaskisNotVisible(string);

}

	

	

}
