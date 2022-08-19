package com.juaracoding.chart.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class SampleSearch {

 WebDriver driver;
	
	public SampleSearch(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@class='woocommerce-store-notice__dismiss-link']")
	private WebElement btnAlert;

	@FindBy(xpath = "//a[@class='noo-search']")
	private WebElement btnSearch;

	@FindBy(xpath = "//input[@name='s']")
	private WebElement InputSearch;

	@FindBy(xpath="//select[@id='pa_color']")
	private WebElement InputColor;

	@FindBy(xpath="//select[@id='pa_size']")
	private WebElement InputSize;

	@FindBy(xpath="//button[normalize-space()='Add to cart']")
	private WebElement btnAddCart;

	@FindBy(xpath="//div[@role='alert']")
	private WebElement Alert;

	@FindBy(xpath="//a[@class='button wc-forward']")
	private WebElement btnCart;

	public void AlertDismiss() {
		btnAlert.click();
	}

	public void SearchItem(String Cari) {
		btnSearch.click();
		InputSearch.sendKeys(Cari);
		InputSearch.sendKeys(Keys.ENTER);
	}

	public void SelectSize(int size) {
		Select ukuran = new Select(InputSize);
		ukuran.selectByIndex(size);
		btnAddCart.click();
		System.out.println(Alert.getText());
	}

	
	public void SelectColorSize(int color, int size) {
		Select warna = new Select(InputColor);
		Select ukuran = new Select(InputSize);
		warna.selectByIndex(color);
		ukuran.selectByIndex(size);
		btnAddCart.click();
		System.out.println(Alert.getText());
	}

	public void ViewCart() {
		btnCart.click();

	}		
}
