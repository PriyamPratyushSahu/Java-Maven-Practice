package com.stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.pages.Page06_Test_File_06;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SD_Test_File_06 {
	
	public WebDriver driver;
	Page06_Test_File_06 obj;

	@When("Six_Driver is loaded")
	public void six_driver_is_loaded() {
	    
		System.setProperty("webdriver.chrome.driver","src\\main\\resources\\Driver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		obj = new Page06_Test_File_06(driver);
		System.out.println("Checked driver");
	}
	@When("Six_Property File is loaded")
	public void six_property_file_is_loaded() throws IOException {
	    obj.six_property_file_is_loaded();
	}
	@Then("Six_Directed to the site")
	public void six_directed_to_the_site() {
	    obj.six_directed_to_the_site();
	}
	@And("Six_Enter valid credentials and login")
	public void six_enter_valid_credentials_and_login() {
	    obj.six_enter_valid_credentials_and_login();
	}
	@Then("Six_Click on PIM")
	public void six_click_on_pim() {
	    obj.six_click_on_pim();
	}
	@Then("Six_Click on Reports")
	public void six_click_on_reports() {
	    obj.six_click_on_reports();
	}
	@Then("Six_Add a new Report")
	public void six_add_a_new_report() {
	    obj.six_add_a_new_report();
	}
	@Then("Six_Log Out")
	public void six_log_out() {
	    obj.six_log_out();
	}
	@Then("Six_Driver is closed")
	public void six_driver_is_closed() {
	    driver.close();
	}

}
