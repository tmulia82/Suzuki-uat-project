package com.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.utilities.UITestConstans;

public class Test003 {
	
		WebDriver driver;
		String actual, expected;
		
		@BeforeTest
		public void setUp() {
			System.setProperty("webdriver.chrome.driver", UITestConstans.CHROME_PATH);
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			
//			Navigate to http://www.suzukicycles.com/
			driver.get(UITestConstans.WEB_ORDERS_URL);
		}
	
	
		@Test
		public void test003() throws InterruptedException {
			
//		Verify Title of the page
			actual=driver.getTitle();
			expected="Suzuki Cycles";
			assertEquals(actual, expected);
			
//		Verify “Suzuki” icon is present (highlighted in the picture)
			WebElement icon=driver.findElement(By.id("suzuki"));
			icon.isDisplayed();
			
//		Click on MOTORCYCLES
			driver.findElement(By.id("cycles")).click();
			
//		Click on 2016
			driver.findElement(By.id("body_0_rptYears_yearItem_2")).click(); 
			
//		Verify the text is “GSX-S750” (see highlighted picture)
			WebElement text1=driver.findElement(By.id("body_0_rptCat_rptBike_3_lnkProductName_6"));
			actual=text1.getText();
			expected="GSX-S750";
			assertEquals(actual, expected);
			
			
//		Click on the “GSX-S750” motorcycle
			text1.click();
			
//		Verify “2016 GSX-S750” text is present
			driver.findElement(By.tagName("h1")).isDisplayed();
			actual=driver.findElement(By.tagName("h1")).getText();
			expected="2016 GSX-S750";
			assertEquals(actual, expected);
			
//		Verify text “This model is not available in California.” is present
			WebElement text2=driver.findElement(By.id("productOutline"));
			actual=text2.getText();
			expected="This model is not available in California.";
			boolean b=false;
			if (actual.contains(expected)) {
				b=true;
			}
			assertTrue(b,"California does not work");
			
//		Click on the “Financing” tab
			driver.findElement(By.id("FinancingLink")).click();
		Thread.sleep(1500);
//		Verify text “2016 GSX-S750 Financing” is present
			assertEquals(driver.findElement(By.xpath("//span[contains(text(),'2016 GSX-S750 Financing')]")).getText(),
					                                 "2016 GSX-S750 Financing","Financing String");
			
//		Verify Base MSRP is “$7,999”
			assertEquals(driver.findElement(By.id("msrp")).getAttribute("value"),"$7,999");
System.out.println(driver.findElement(By.id("msrp")).getAttribute("value"));
}
		
}
