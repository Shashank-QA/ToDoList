//Hooks class is udes to ensure to run scenarios before and after feature files.

package com.shashank.steps;

import com.shashank.testbase.BaseClass;
import com.shashank.utils.CommonMethods;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;

public class Hooks {

	@Given("I launch the the website using the {string}")
	public void i_launch_the_the_website_using_the(String string) {
		BaseClass.setUp();
	}

	@After
	public void end(Scenario scenario) {

		byte[] picture;
		if (scenario.isFailed()) {
			// take screenshot and save it in /failed
			picture = CommonMethods.takeScreenshot("failed/" + scenario.getName());
		} else {
			// take screenshot and put it in /passed folder
			picture = CommonMethods.takeScreenshot("passed/" + scenario.getName());
		}

		scenario.attach(picture, "image/png", scenario.getName());

		BaseClass.tearDown();
	}

}
