package com.basics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PropFileHandling {
	
	public static WebDriver driver;
	public static void main(String[] args) throws IOException {
		
		Properties prop = new Properties();
		FileInputStream ip = new FileInputStream("F:\\Selenium Workspace\\SeleniumLearning\\src\\config.properties");
		prop.load(ip);
		System.out.println(prop.getProperty("name"));
		System.out.println(prop.getProperty("age"));
		
		String browser = prop.getProperty("browser");
		String url = prop.getProperty("url");
		if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "F:\\Selenium Files\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		else if(browser.equalsIgnoreCase("chrome")){
			
		}
		driver.get(url);
		driver.findElement(By.xpath(prop.getProperty("searchField_xpath"))).sendKeys("Selenium");
		driver.findElement(By.xpath("btn_xpath")).click();

	}

}
