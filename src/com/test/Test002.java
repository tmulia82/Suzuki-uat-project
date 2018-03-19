package com.test;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.utilities.UITestConstans;

public class Test002 {
	
		WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", UITestConstans.CHROME_PATH);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
//		Navigate to http://www.suzukicycles.com/
		driver.get(UITestConstans.WEB_ORDERS_URL);
	}	
		@Test
		public void test002() {
			
//		Verify Title of the page
			String actual=driver.getTitle();
			String expected="Suzuki Cycles";
			Assert.assertEquals(actual, expected);
			
//		Verify “Suzuki” icon is present (highlighted in the picture)
		WebElement icon=driver.findElement(By.id("suzuki"));
		icon.isDisplayed();
		
//		Click on MOTORCYCLES
		driver.findElement(By.id("cycles")).click();
		
//		Click on 2015 Suzuki
		driver.findElement(By.id("body_0_rptYears_yearItem_3")).click();
		
//		Verify the text is “V-Strom 650 ABS Adventure” (see highlighted picture)
		WebElement text=driver.findElement(By.id("body_0_rptCat_rptBike_4_lnkProductName_5"));
		text.isDisplayed();
		actual=text.getText();
		expected="V-Strom 650 ABS Adventure";
		assertEquals(actual, expected);		
		
//		Click on the “V-Storm 650 ABS Adventure” motorcycle
		text.click();
		
//		Verify “2015 V-Storm 650 ABS Adventure” text is present
		driver.findElement(By.tagName("h1")).isDisplayed();
		actual=driver.findElement(By.tagName("h1")).getText();
		expected="2015 V-Strom 650 ABS Adventure";
		assertEquals(actual, expected);
		//System.out.println(driver.findElement(By.tagName("h1")).getText());
		
//		Click on the “Features” tab
		driver.findElement(By.id("FeaturesLink")).click();
		
//		Verify text “2015 V-Strom 650 ABS Adventure Features” is present
		WebElement text1=driver.findElement(By.id("TabContentHeader"));
		text1.isDisplayed();
		actual=driver.findElement(By.id("TabContentHeader")).getText();
		expected="2015 V-Strom 650 ABS Adventure Features";
		assertEquals(actual, expected);
		
//		Verify the following feature text is present on the page (by comparing to the expected
//		text features present below):
//		KEY FEATURES
//		ENGINE FEATURES
//		TRANSMISSION FEATURES
//		CHASSIS FEATURES
//		ADDITIONAL FEATURES
		ArrayList<String> feturess=new ArrayList<>();
		feturess.add("KEY FEATURES");
		feturess.add("ENGINE FEATURES");
		feturess.add("TRANSMISSION FEATURES");
		feturess.add("CHASSIS FEATURES");
		feturess.add("ADDITIONAL FEATURES");
		System.out.println(feturess.size());
		for(String arrayaF:feturess) {
			System.out.println(arrayaF.toString());
			
		}
		
		List<WebElement> feature=driver.findElements(By.xpath("//td[@class='FeaturesSectionHeader']"));
		for (WebElement features : feature) {
			System.out.println(features.getText());
			for(String arrayaF:feturess) {
				if(features.getText().contains(arrayaF.toString())) {
					System.out.println("PASS");
					assertEquals(features.getText(), arrayaF.toString());
				}
					
				
			}
			
			
		}
			
		}

		@AfterTest
		public void tearDown() {
			driver.close();
		}
}
