package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



import java.io.File;
import java.io.FileInputStream;

public class Page03_Test_File_03 {
	
WebDriver driver;
ArrayList<String> tabs;
JavascriptExecutor js;
Properties prop;
FileInputStream fs;
File fetch_file;
FileInputStream excel_file;


	public Page03_Test_File_03(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
		js = (JavascriptExecutor) driver;
	}
	public void waitTime(int n)
	{
		try {
			Thread.sleep(n);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void three_property_file_is_loaded() throws IOException {
		
		  prop = new Properties(); fs = new FileInputStream(
		  "src\\test\\resources\\Properties\\Property03_Test_File_03.properties");
		  prop.load(fs);
		 
		  fetch_file = new File("src\\test\\resources\\Excel Files\\All_Excel_Files.xlsx");
			excel_file = new FileInputStream(fetch_file);
			work_file = new XSSFWorkbook(excel_file);
			sheet = work_file.getSheet("Login_Sheet");
			
		System.out.println("Three_Property File is loaded");
	}
	
	public void three_directed_to_the_site() {
		 driver.get(" https://opensource-demo.orangehrmlive.com/");
		  driver.manage().window().maximize();
		  waitTime(3000);
		System.out.println("Checked site");
	}

	public void three_enter_valid_credentials_and_login() {
	   
		WebElement user_name = driver.findElement(By.xpath(prop.getProperty("user_name")));
		WebElement password = driver.findElement(By.xpath(prop.getProperty("password")));
		WebElement login_button = driver.findElement(By.xpath(prop.getProperty("login_button")));
		
		user_name.clear();
		user_name.sendKeys(sheet.getRow(1).getCell(0).getStringCellValue());
		waitTime(1000);
	    
		password.clear();
		password.sendKeys(sheet.getRow(1).getCell(1).getStringCellValue());
		waitTime(1000);
	    System.out.println("Credential entered");
	    
		login_button.click();
		waitTime(2000);
	    System.out.println("Click on Login");
	    
	}

	public void three_click_on_pim() {
		WebElement  module_pim = driver.findElement(By.xpath(prop.getProperty("module_pim")));
		module_pim.click();
	   waitTime(1000);
	   System.out.println("Clicked on PIM");
	}

	public void three_click_on_configuration() {
	   WebElement conf_option = driver.findElement(By.xpath(prop.getProperty("conf_option")));
	   conf_option.click();
	   waitTime(1000);
	   System.out.println("Clicked on Configuration Option");
	}

	public void three_click_on_optional_fields() {
		WebElement opt_fields = driver.findElement(By.xpath(prop.getProperty("opt_fields")));
		   opt_fields.click();
		   waitTime(1000);
		   System.out.println("Clicked on Optional Fields");
	}

	public void three_click_on_custom_fields() {
		WebElement custom_fields = driver.findElement(By.xpath(prop.getProperty("custom_fields")));
		   custom_fields.click();
		   waitTime(1000);
		   System.out.println("Clicked on Custom Fields");
	}

	public void three_log_out() {
		WebElement  welcome_dropdown = driver.findElement(By.xpath(prop.getProperty("Welcome_dropdown")));
		welcome_dropdown.click();
		waitTime(1000);
		WebElement logout_option = driver.findElement(By.xpath(prop.getProperty("Logout_option")));
		logout_option.click();
		waitTime(1000);
		System.out.println("Logged out");
	}

	public void three_driver_is_closed() {
	   
	}	
}