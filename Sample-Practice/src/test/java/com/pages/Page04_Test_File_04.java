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



import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;

public class Page04_Test_File_04 {
	
WebDriver driver;
ArrayList<String> tabs;
JavascriptExecutor js;
Properties prop;
FileInputStream fs;
File fetch_file;
FileInputStream excel_file;
XSSFWorkbook work_file;
XSSFSheet sheet;

	public Page04_Test_File_04(WebDriver driver)
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

	public void four_property_file_is_loaded() throws IOException {
	
		prop = new Properties(); fs = new FileInputStream(
				  "src\\test\\resources\\Properties\\Property04_Test_File_04.properties");
				  prop.load(fs);
				 
				  fetch_file = new File("src\\test\\resources\\Excel Files\\All_Excel_Files.xlsx");
					excel_file = new FileInputStream(fetch_file);
					work_file = new XSSFWorkbook(excel_file);
					sheet = work_file.getSheet("Login_Sheet");
					
				System.out.println("One_Property File is loaded");
	}
	
	public void four_directed_to_the_site() {
	
		 driver.get(" https://opensource-demo.orangehrmlive.com/");
		  driver.manage().window().maximize();
		  waitTime(3000);
		System.out.println("Checked site");
	}
	
	public void four_enter_valid_credentials_and_login() {
	
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
	
	public void four_click_on_employee_list() {
	    WebElement emp_list = driver.findElement(By.xpath(prop.getProperty("emp_list")));
	    emp_list.click();
	    
	    waitTime(1000);
		   
		   for(int i = 1; i <= 12; i++)
		    {
		    	waitTime(1000);
		    	js.executeScript("window.scrollBy(0,200)");
			    
		    }
		   waitTime(1000);
		   js.executeScript("window.scrollBy(0,-2400)");
		   waitTime(1000);
		   System.out.println("Clicked on employee_list");
	}
	
	public void four_log_out() {
		WebElement  welcome_dropdown = driver.findElement(By.xpath(prop.getProperty("Welcome_dropdown")));
		welcome_dropdown.click();
		waitTime(1000);
		WebElement logout_option = driver.findElement(By.xpath(prop.getProperty("Logout_option")));
		logout_option.click();
		waitTime(1000);
		System.out.println("Logged out");
	}
}
