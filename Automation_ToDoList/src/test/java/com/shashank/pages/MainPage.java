package com.shashank.pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.shashank.testbase.BaseClass;

import java.util.List;

import org.openqa.selenium.WebElement;

public class MainPage {
	
	@FindBy(xpath ="//input[@class = 'new-todo']")
	public WebElement inputtask;
	
	@FindBy(xpath = "//ul [@class = 'todo-list']//label")
	public List<WebElement> taskList;
	
	@FindBy(xpath = "//span [@class = 'todo-count']/strong")
	public WebElement taskcount;
	
	@FindBy(xpath = "//ul [@class = 'todo-list']//button[@class = 'destroy']")
	public WebElement deltask;
	
	@FindBy(xpath = "//ul [@class = 'todo-list']//input[@type = 'checkbox']")
	public List<WebElement> checkbox;
	
	@FindBy(linkText = "Active")
	public WebElement activeTasks;
	
	@FindBy(linkText = "Completed")
	public WebElement completedTasks;
	
	@FindBy(linkText = "All")
	public WebElement All;
	
	@FindBy(xpath = "//button[@class= 'clear-completed']")
	public WebElement clearCompleted;
	
	@FindBy(xpath = "//ul[@class= 'todo-list']//label")
	public WebElement updatetask;
	
	
	public MainPage() {
		PageFactory.initElements(BaseClass.driver, this);
	}
	

}
