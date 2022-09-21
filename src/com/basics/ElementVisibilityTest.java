package com.basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class ElementVisibilityTest {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "F:\\Selenium Files\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("http://facebook.com/");
		driver.findElement(By.linkText("Create New Account")).click();
		WebElement female = driver.findElement(By.xpath("//input[@name='sex' and @value='1']"));
		System.out.println(female.isDisplayed());
		System.out.println(female.isEnabled());
		System.out.println(female.isSelected());
		
		if(!female.isSelected()) {
			female.click();
		}
		System.out.println(female.isSelected());
		
		WebElement dayElement = driver.findElement(By.xpath("//select[@id='day']"));
		Select day = new Select(dayElement);
		day.selectByVisibleText("27");
		System.out.println(dayElement.getAttribute("value"));
		System.out.println(dayElement.isSelected());
	}

}
