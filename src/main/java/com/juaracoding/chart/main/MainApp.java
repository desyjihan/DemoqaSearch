package com.juaracoding.chart.main;

import org.openqa.selenium.WebDriver;

import com.juaracoding.pageobject.drivers.DriverSingleton;

public class MainApp {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		DriverSingleton.getInstance("Chrome");
		WebDriver driver = DriverSingleton.getDriver();
		String url = "https://shop.demoqa.com/";
		driver.get(url);
	}
	
}
