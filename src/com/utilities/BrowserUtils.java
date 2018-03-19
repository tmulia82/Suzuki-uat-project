package com.utilities;

import org.openqa.selenium.WebDriver;

public class BrowserUtils {
	
	public static void verifyTitleMatches( String actualTitle , String expectedTitle) {
		if(actualTitle.equals(expectedTitle)) {
			System.out.println("Pass");
			
		}else {
		System.out.println("False");
	}}
	
	public static void verifyTitleContains(WebDriver driver, String actualTitle, String expectedTitle) {
		if(actualTitle.contains(expectedTitle)) {
			System.out.println("Pass");
		}else {
			System.out.println("False");
		}}
	
	public static void verifyUrlMatches(WebDriver driver, String actualUrl, String expectedUrl) {
		if(actualUrl.equals(expectedUrl)) {
			System.out.println("Pass");
			
		}else {
			System.out.println("False");
		}}
	
	public static void verifyUrlContains(WebDriver driver, String actualUrl, String expectedUrl ) {
		if(actualUrl.contains(expectedUrl)) {
			System.out.println("Pass");
		}else {
			System.out.println("False");
		}}
}
