package com.shashank.testbase;

import com.shashank.pages.MainPage;

public class PageInitializer extends BaseClass {

	
	public static MainPage mainPage;

	
	public static void initialize() {
		// initialize pages
		mainPage = new MainPage();
		
	}

}