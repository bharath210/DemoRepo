package com.basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Locators {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "F:\\Selenium Files\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("http://primusbank.qedgetech.com/");
		System.out.println(driver.getTitle());
		WebElement element =driver.findElement(By.xpath("//select[@id='drlist']"));
		Select select = new Select(element);
		select.selectByVisibleText("Vijayawada");
		driver.findElement(By.id("txtuId")).sendKeys("Admin");
		driver.findElement(By.cssSelector("#txtPword")).sendKeys("Admin");
		driver.findElement(By.id("login")).click();
	}

}
