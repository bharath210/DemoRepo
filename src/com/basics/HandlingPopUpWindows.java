package com.basics;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.Iterator;


import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

public class HandlingPopUpWindows {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "F:\\Selenium Files\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://www.webopedia.com/definitions/pop-up-window/");
		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.xpath("//a[contains(text(),'window')]")).click();
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it =windows.iterator();
		
		String parentWindow = it.next();
		System.out.println(parentWindow);
		
		String childWindow = it.next();
		System.out.println(childWindow);
		
		driver.switchTo().window(childWindow);
		Thread.sleep(5000);
		System.out.println(driver.getCurrentUrl());

		driver.close();
		driver.switchTo().window(parentWindow);
		System.out.println(driver.getCurrentUrl());
	}


}
