package com.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class Test001 {
	WebDriver driver;
	String actual, expected;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				 "C:/Users/Owner/Documents/Libraries/drivers/chromedriver_win32/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://www.suzukicycles.com/");
	}
	@Test
	public void test1() {
//		Verify Title of the page		
		actual=driver.getTitle();
		expected="Suzuki Cycles";
		assertEquals(expected, actual);
		
//		Verify “Suzuki” icon is present (highlighted in the picture)
		WebElement icon=driver.findElement(By.id("suzuki"));
		icon.isDisplayed();
		
//		Click on MOTORCYCLES
		driver.findElement(By.id("cycles")).click();
		
//		Verify the following motorcycle options exist by comparing text of the following
//		expected types names :
//		SPORTBIKE
//		CRUISER
//		TOURING
//		STANDARD
//		ADVENTURE
//		DUALSPORT
//		SUPERMOTO
//		MOTOCROSS
//		OFF ROAD
		
//		Save all motorcycle options in the ArrayList named motoTypes
		ArrayList<String> motoTypes=new ArrayList<>();
		
		List<WebElement> names=driver.findElements(By.tagName("h2"));
		for(WebElement name: names) {
			//System.out.println(name.getText());	
			motoTypes.add(name.getText());
					
		
		}
		
		for(WebElement name: names) {
			for(String moto:motoTypes) {
			//for(int i=0;i<motoTypes.size();i++) {
				if(name.getText().contains(moto.toString())) {
					Assert.assertTrue(name.getText().equals(moto.toString()));
				}
			}
		}
		
	}
	@Test
	public void test2() {
		
//		Click on MOTORCYCLES
		driver.findElement(By.id("cycles")).click();
		
		WebElement btn2016=driver.findElement(By.id("body_0_rptYears_yearItem_2"));
		btn2016.click();
		
//		Save all 2016 motorcycle options in the ArrayList named motoTypes2016
		ArrayList<String> motoCycle2=new ArrayList<>();
		List<WebElement> names2=driver.findElements(By.tagName("h2"));
		for(WebElement name2: names2) {
			System.out.println(name2.getText());
			motoCycle2.add(name2.getText());
		}
		System.out.println("*********ARRAYLIST*********");
		System.out.println(motoCycle2.toString());
		
//		Compare to ArrayLists and make sure both lists has same content
		for(WebElement name2: names2) {
			for(String moto2:motoCycle2) {
				if(name2.getText().contains(moto2.toString())) {
					System.out.println("Pass");
					Assert.assertTrue(moto2.toString().equals(name2.getText()));
				}
				
			}
		}
		
		}	
		
		
		
		
		
		
		
	
	@After
	public void tearDown() {
//		driver.close();
	}

}
