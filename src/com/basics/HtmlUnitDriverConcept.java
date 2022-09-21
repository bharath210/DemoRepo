package com.basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
// headless browser concept
public class HtmlUnitDriverConcept {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "F:\\Selenium Files\\geckodriver.exe");
//		WebDriver driver = new FirefoxDriver();
		WebDriver driver = new HtmlUnitDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("http://google.com");
		System.out.println(driver.getTitle());
		
		driver.findElement(By.linkText("Gmail")).click();
		System.out.println(driver.getTitle());

	}

}
