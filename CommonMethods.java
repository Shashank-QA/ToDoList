package com.shashank.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.shashank.testbase.PageInitializer;

import io.cucumber.datatable.DataTable;

public class CommonMethods extends PageInitializer {
	
	/**
	 * This method clears the textbox and sends another text
	 * 
	 * @param element
	 * @param datatable
	 */
	public static int enterTask(WebElement element, DataTable dataTable) {
		List<String> list = dataTable.asList();
		for (String el : list)
		{
			Actions action = new Actions(driver);
			action.click(mainPage.inputtask).sendKeys(el).sendKeys(Keys.ENTER).build().perform();
		}
		
		return list.size();
	}
	

	/**
	 * This method verifies the Task added in the toDo List
	 * 
	 * @param taskname
	 */
	public static void verifyTaskisVisible(String taskname)
	{
		for(WebElement task : mainPage.taskList) {
			Assert.assertEquals(task.getText(),taskname);
		}
	}
	
	/**
	 * This method verifies the Task added in the toDo List
	 * 
	 * @param taskname
	 */
	public static void verifyTaskisNotVisible(String taskname)
	{
		for(WebElement task : mainPage.taskList) {
			Assert.assertNotEquals(task.getText(), taskname);
		}
	}
	
	/**
	 * This method click in an element and has wait implemented on it
	 * 
	 * @param element
	 */
	public static void click(WebElement element) {
		waitForClickability(element);
		element.click();
	}
	
	/**
	 * 
	 * This method creates a WebDriverWait object and returns it
	 * 
	 * @return
	 */
	public static WebDriverWait getWaitObject() {
		WebDriverWait wait = new WebDriverWait(driver, Constants.EXPLICIT_WAIT_TIME);

		return wait;
	}

	/**
	 * This method waits for an item to be clickable
	 * 
	 * @param element
	 * @return
	 */
	public static WebElement waitForClickability(WebElement element) {
		return getWaitObject().until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * This method waits for an element to be visible
	 * 
	 * @param element
	 * @return
	 */
	public static WebElement waitForVisibility(WebElement element) {
		return getWaitObject().until(ExpectedConditions.visibilityOf(element));
	}


	public static void wait(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public static byte[] takeScreenshot(String filename) {
		TakesScreenshot ts = (TakesScreenshot) driver;

		byte[] picBytes = ts.getScreenshotAs(OutputType.BYTES);

		File file = ts.getScreenshotAs(OutputType.FILE);
		// create destination as : filepath + filename + timestamp + .png
		String destination = Constants.SCREENSHOT_FILEPATH + filename + getTimeStamp() + ".png";

		try {
			FileUtils.copyFile(file, new File(destination));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return picBytes;
	}

	/**
	 * Method to return the current time stamp in a String
	 * 
	 * @return
	 */
	public static String getTimeStamp() {

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");

		return sdf.format(date.getTime());

	}

}