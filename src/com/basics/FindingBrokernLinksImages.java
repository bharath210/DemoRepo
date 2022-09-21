package com.basics;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.gargoylesoftware.htmlunit.html.HtmlAcronym;

import graphql.relay.Connection;

public class FindingBrokernLinksImages {

	public static void main(String[] args) throws MalformedURLException, IOException {
		System.setProperty("webdriver.gecko.driver", "F:\\Selenium Files\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		links.addAll(driver.findElements(By.tagName("img")));
		
		System.out.println("Number of available Links "+links.size());
		List<WebElement> activeLinks = new ArrayList<WebElement>();
		for(int i =0; i < links.size(); i++) {
			System.out.println(links.get(i).getAttribute("href"));
			if(links.get(i).getAttribute("href") != null) {
				activeLinks.add(links.get(i));
			}
		}
		System.out.println("Active Links "+activeLinks.size());
		for(int i = 0; i < activeLinks.size(); i++) {
			HttpURLConnection connection = (HttpURLConnection) new URL(activeLinks.get(i).getAttribute("href")).openConnection();
			connection.connect();
			String response = connection.getResponseMessage();
			connection.disconnect();
			System.out.println(activeLinks.get(i).getAttribute("href")+"--------- "+response);
		}

	}

}
