package com.basics;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class HandlingWebTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		driver.findElement(By.xpath("//input[@id='login']")).click();
		driver.findElement(By.xpath("//img[@src='images/emp_btn.jpg']")).click();
		
		WebElement empTable = driver.findElement(By.id("DGBanker"));
		List <WebElement> rows = empTable.findElements(By.tagName("tr"));
		for(int i = 0; i <rows.size(); i++ ) {
			List <WebElement> cols = rows.get(i).findElements(By.tagName("td"));
			for(int j = 0; j < cols.size(); j ++) {
				System.out.print(cols.get(j).getText()+" ");
			}
			System.out.println();
			
		}
	}

}
