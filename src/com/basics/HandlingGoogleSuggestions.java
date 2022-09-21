package com.basics;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HandlingGoogleSuggestions {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "F:\\Selenium Files\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("http://google.com/");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("selenium");
		List<WebElement> list = driver.findElements(By.xpath("//ul[@jsname='bw4e9b']//li/descendant::div[@class='wM6W7d']//span"));
		System.out.println(list.size());
		
		for(int i =0; i < list.size(); i++) {
			String suggestion = list.get(i).getText();
			System.out.println(suggestion);
			if(suggestion.equalsIgnoreCase("selenium webdriver")) {
				list.get(i).click();
			}
		}
	}

}
