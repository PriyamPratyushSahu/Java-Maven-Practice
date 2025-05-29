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

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;

public class Page06_Test_File_06 {
	
	WebDriver driver;
	ArrayList<String> tabs;
	JavascriptExecutor js;
	Properties prop;
	FileInputStream fs;
	File fetch_file;
	FileInputStream excel_file;
	XSSFWorkbook work_file;
	XSSFSheet sheet,sheet2;

	public Page06_Test_File_06(WebDriver driver)
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
	
	public void six_property_file_is_loaded() throws IOException{
		prop = new Properties(); fs = new FileInputStream(
				  "src\\test\\resources\\Properties\\Property06_Test_File_06.properties");
				  prop.load(fs);
				 
				  fetch_file = new File("src\\test\\resources\\Excel Files\\All_Excel_Files.xlsx");
					excel_file = new FileInputStream(fetch_file);
					work_file = new XSSFWorkbook(excel_file);
					sheet = work_file.getSheet("Login_Sheet");
					sheet2 = work_file.getSheet("Report_Sheet");
	}
	
	public void six_directed_to_the_site() {
	 
		driver.get(" https://opensource-demo.orangehrmlive.com/");
		  driver.manage().window().maximize();
		  waitTime(3000);
		System.out.println("Checked site");
	}
	
	public void six_enter_valid_credentials_and_login() {
	    
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
	
	public void six_click_on_pim() {
	    
		WebElement  module_pim = driver.findElement(By.xpath(prop.getProperty("module_pim")));
		module_pim.click();
	   waitTime(1000);
	   System.out.println("Clicked on PIM");
	}
	
	public void six_click_on_reports() {
		WebElement  click_on_reports = driver.findElement(By.xpath(prop.getProperty("click_on_reports")));
		click_on_reports.click();
	}
	
	public void six_add_a_new_report() {
	
		WebElement add_report = driver.findElement(By.xpath(prop.getProperty("add_report")));
		add_report.click();
		   waitTime(1000);
		   
		WebElement report_name  = driver.findElement(By.xpath(prop.getProperty("report_name")));
		report_name.clear();
		report_name.sendKeys(sheet2.getRow(1).getCell(0).getStringCellValue());
		waitTime(1000);
		   
		WebElement selection_type1 = driver.findElement(By.xpath(prop.getProperty("selection_type1")));
		selection_type1.click();
		   waitTime(1000);
		
		WebElement select_option1 = driver.findElement(By.xpath(prop.getProperty("select_option1")));
		select_option1.click();
		   waitTime(1000);

		WebElement selection_type2 = driver.findElement(By.xpath(prop.getProperty("selection_type2")));
		selection_type2.click();
		waitTime(1000);
		
		WebElement select_option2 = driver.findElement(By.xpath(prop.getProperty("select_option2")));
		select_option2.click();
		waitTime(1000);
		
		WebElement selection_type3 = driver.findElement(By.xpath(prop.getProperty("selection_type3")));
		selection_type3.click();
		waitTime(1000);
		selection_type3.click();
		waitTime(1000);
		
		WebElement select_option3 = driver.findElement(By.xpath(prop.getProperty("select_option3")));
		select_option3.click();
		waitTime(1000);
		js.executeScript("window.scrollBy(0,300)");
		WebElement add_option = driver.findElement(By.xpath(prop.getProperty("add_option")));
		add_option.click();
		waitTime(1000);
		
		WebElement save_option = driver.findElement(By.xpath(prop.getProperty("save_option")));
		save_option.click();
		/*
		 * waitTime(8000);
		 * 
		 * for(int i = 1; i <= 12; i++) { waitTime(1000);
		 * js.executeScript("window.scrollBy(0,200)");
		 * 
		 * }
		 * 
		 * js.executeScript("window.scrollBy(0,-2400)"); waitTime(2000);
		 */
	}
	
	public void six_log_out() {
	    
		WebElement  welcome_dropdown = driver.findElement(By.xpath(prop.getProperty("Welcome_dropdown")));
		welcome_dropdown.click();
		waitTime(1000);
		WebElement logout_option = driver.findElement(By.xpath(prop.getProperty("Logout_option")));
		logout_option.click();
		waitTime(1000);
		System.out.println("Logged out");
	}
	
}
