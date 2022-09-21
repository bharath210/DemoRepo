package com.basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.Select;

public class JavaScriptExecutorConcept {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "F:\\Selenium Files\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("http://primusbank.qedgetech.com/");
		WebElement branch_drlist = driver.findElement(By.xpath("//select[@id='drlist']"));
		Select branch = new Select(branch_drlist);
		branch.selectByVisibleText("Vijayawada");
		driver.findElement(By.xpath("//input[@id='txtuId']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@id='txtPword']")).sendKeys("Admin");
		WebElement login_btn = driver.findElement(By.xpath("//input[@id='login']"));
		
		flash(branch_drlist, driver);
		drawBorder(branch_drlist, driver);
//		generateAlert(driver, "There is issue with dropdown list");
		
		clickElementByJS(login_btn, driver); // to click on element using javascript executor
		String innerText = getInnerText(driver); // To get entire text from a page
		System.out.println(innerText);
		
		driver.findElement(By.linkText("Terms and Conditions")).click();
//		scrollPageDown(driver); // scroll till page end
		
		WebElement privacyLink = driver.findElement(By.linkText("Privacy"));
		scrollIntoView(privacyLink, driver);
		
		
	}
	
	public static void flash(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String bgcolor = element.getCssValue("backgroundColor");
		for(int i = 0; i < 100;  i++) {
			changeColor("rgb(0,200,0)", element, driver);
			changeColor(bgcolor, element, driver);
		}
	}
	
	public static void changeColor(String color, WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.backgroundColor= '"+color+"'", element);
		try {
			Thread.sleep(20);
		} catch (InterruptedException e){
		
		}
	}
	public static void drawBorder(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}
	public static void generateAlert(WebDriver driver, String message) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("alert('"+message+"')");		
	}
	public static void clickElementByJS(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();", element);		
	}
	public static String getInnerText(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String text = js.executeScript("return document.documentElement.innerText").toString();
		return text;
	}
	public static void scrollPageDown(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	public static void scrollIntoView(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
}
