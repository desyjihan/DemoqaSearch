package com.juaracoding.chart;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.juaracoding.chart.drivers.DriverSingleton;
import com.juaracoding.chart.pages.SampleSearch;

public class TestSearch {

	public static WebDriver driver;
	private SampleSearch sampleSearch;

	@BeforeClass
	public void setup() {
		DriverSingleton.getInstance("Chrome");
		driver = DriverSingleton.getDriver();
		String url = "https://shop.demoqa.com/";
		driver.get(url);
	}

	@BeforeMethod
	public void pageObject() {
		sampleSearch = new SampleSearch(driver);
	}

	@Test(priority = 1)
	public void TestItem1() {
		sampleSearch.AlertDismiss();
		sampleSearch.SearchItem("Pink Floral");
		delay(3);
		scroll(500);
		sampleSearch.SelectSize(3);
		delay(3);
	}

	@Test(priority = 2)
	public void TestItem2() {
		sampleSearch.SearchItem("White Lace");
		delay(3);
		scroll(500);
		sampleSearch.SelectColorSize(1,3);
		delay(3);
	}

	@Test(priority = 3)
	public void ShowCart() {
		sampleSearch.ViewCart();
		scroll(500);
	}

	@AfterClass
	public void closeBrowser() {
		delay(10);
		driver.quit();
	}

	static void delay(int detik) {
		try {
			Thread.sleep(1000 * detik);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	static void scroll(int vertikal) {
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,"+vertikal+")");
}
}
