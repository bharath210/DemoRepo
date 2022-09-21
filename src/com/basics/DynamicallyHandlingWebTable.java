package com.basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class DynamicallyHandlingWebTable {

	public static void main(String[] args) throws InterruptedException {
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
		
		String before_xpath = "//table[@id='DGBanker']/tbody/tr[";
		String after_xpath = "]/td[1]";
		
		for (int i = 2; i <= 6; i++) {
			String id = driver.findElement(By.xpath(before_xpath+i+after_xpath)).getText();
			System.out.println(id);
			if(id.equals("12")) {
				driver.findElement(By.xpath(before_xpath+i+"]/td[7]/a")).click();
				Thread.sleep(2000);
				Alert alert = driver.switchTo().alert();
				alert.accept();
				Thread.sleep(2000);
				Alert alert2 = driver.switchTo().alert();
				alert2.accept();
			}
		}

	}

}
