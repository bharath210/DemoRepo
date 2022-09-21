package com.basics;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FindElementsDemo {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "F:\\Selenium Files\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("http://facebook.com");
		List <WebElement> linkList = driver.findElements(By.tagName("a"));
		System.out.println(linkList.size());
		
		for(int i = 0; i < linkList.size(); i++) {
			String linkText = linkList.get(i).getText();
			System.out.println(linkText);
		}
	}

}
