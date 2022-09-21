package com.basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HandlingCalender {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "F:\\Selenium Files\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://vcalendar.io/datepicker.html");
		
		String date = "9-Sep-2025";
		String dateArr[] = date.split("-");
		String day = dateArr[0];
		String month = dateArr[1];
		String year = dateArr[2];
		
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[3]/main[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]")).click();
		WebElement calYearElement = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[3]/main[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/span[2]"));
		String calYear = calYearElement.getText();
		int int_calYear = Integer.parseInt(calYear);
		int int_year = Integer.parseInt(year);
		System.out.println(calYear);
		// Finding the year
		if(int_calYear > int_year) {
			while(int_calYear > int_year) {
				driver.findElement(By.xpath("//span[@class='vc-nav-arrow is-left']//*[@class='vc-svg-icon']")).click();
				calYear = calYearElement.getText();
				int_calYear = Integer.parseInt(calYear);
				
			}
		} else if(int_calYear < int_year) {
			while(int_calYear < int_year) {
				driver.findElement(By.xpath("//span[@class='vc-nav-arrow is-right']//*[@class='vc-svg-icon']")).click();
				calYear = calYearElement.getText();
				int_calYear = Integer.parseInt(calYear);
		}
	}
		//Finding Month 
		driver.findElement(By.xpath("//span[contains(text(),'"+month+"')]")).click();
		
		//Finding Day
		for(int i = 8; i <= 49; i++) {
			WebElement dayElement = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[3]/main[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div["+i+"]/span[1]"));
			String calDay = dayElement.getText();
			if(calDay.equals(day)) {
				dayElement.click();
				break;
			}
		}
		
		
	}

}
