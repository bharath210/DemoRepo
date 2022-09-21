package com.basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LaunchingBrowser {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver", "F:\\Selenium Files\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://facebook.com");
		String title = driver.getTitle();
		System.out.println(title);
		if(title.equalsIgnoreCase("Google")) {
			System.out.println("Correct title");
		}else {
			System.out.println("incorrect Title");
		}
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getWindowHandle());
		driver.quit();
	}

}
