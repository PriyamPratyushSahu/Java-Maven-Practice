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

public class Page05_Test_File_05 {
	
WebDriver driver;
ArrayList<String> tabs;
JavascriptExecutor js;
Properties prop;
FileInputStream fs;
File fetch_file;
FileInputStream excel_file;
XSSFWorkbook work_file;
XSSFSheet sheet,sheet2;

	public Page05_Test_File_05(WebDriver driver)
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


public void five_property_file_is_loaded() throws IOException{
	    
	prop = new Properties(); fs = new FileInputStream(
			  "src\\test\\resources\\Properties\\Property05_Test_File_05.properties");
			  prop.load(fs);
			 
			  fetch_file = new File("src\\test\\resources\\Excel Files\\All_Excel_Files.xlsx");
				excel_file = new FileInputStream(fetch_file);
				work_file = new XSSFWorkbook(excel_file);
				sheet = work_file.getSheet("Login_Sheet");
				sheet2 = work_file.getSheet("Add_Employee_Sheet");
				
			System.out.println("Property File is loaded");
	}

	
	public void five_directed_to_the_site() {
		driver.get(" https://opensource-demo.orangehrmlive.com/");
		  driver.manage().window().maximize();
		  waitTime(3000);
		System.out.println("Checked site");
	}

	
	public void five_enter_valid_credentials_and_login() {
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

	
	public void five_click_on_pim() {
		WebElement  module_pim = driver.findElement(By.xpath(prop.getProperty("module_pim")));
		module_pim.click();
	   waitTime(1000);
	   System.out.println("Clicked on PIM");
	}

	
	public void five_click_on_add_employee() {
	    
		WebElement  add_employee = driver.findElement(By.xpath(prop.getProperty("add_employee")));
		add_employee.click();
		waitTime(1000);
		System.out.println("Clicked on Add Employee");
	}

	
	public void five_enter_new_employee_data() {
	    WebElement first_name =  driver.findElement(By.xpath(prop.getProperty("first_name")));
	    WebElement middle_name = driver.findElement(By.xpath(prop.getProperty("middle_name")));
	    WebElement last_name = driver.findElement(By.xpath(prop.getProperty("last_name")));
	    WebElement emp_id =  driver.findElement(By.xpath(prop.getProperty("emp_id")));
	    WebElement save_button =  driver.findElement(By.xpath(prop.getProperty("save_button")));
	    
	    first_name.clear();
	    first_name.sendKeys(sheet2.getRow(1).getCell(0).getStringCellValue());
	    waitTime(1000);
	    middle_name.clear();
	    middle_name.sendKeys(sheet2.getRow(1).getCell(1).getStringCellValue());
	    waitTime(1000);
	    last_name.clear();
	    last_name.sendKeys(sheet2.getRow(1).getCell(2).getStringCellValue());
	    waitTime(1000);
	    emp_id.clear();
	    String val =String.valueOf((int)sheet2.getRow(1).getCell(3).getNumericCellValue());    
	    emp_id.sendKeys(val);;
	    waitTime(1000);
	    save_button.click();
	    waitTime(3000);
	}

	
	public void five_log_out() {
	    
		WebElement  welcome_dropdown = driver.findElement(By.xpath(prop.getProperty("Welcome_dropdown")));
		welcome_dropdown.click();
		waitTime(1000);
		WebElement logout_option = driver.findElement(By.xpath(prop.getProperty("Logout_option")));
		logout_option.click();
		waitTime(1000);
		System.out.println("Logged out");
	}
}
