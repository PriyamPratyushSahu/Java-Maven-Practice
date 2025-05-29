package com.stepDefinitions;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import com.pages.Page05_Test_File_05;

public class SD_Test_File_05 {
	
	public WebDriver driver;
	Page05_Test_File_05 obj;

	@When("Five_Driver is loaded")
	public void five_driver_is_loaded() {
		System.setProperty("webdriver.chrome.driver","src\\main\\resources\\Driver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		obj = new Page05_Test_File_05(driver);
		System.out.println("Checked driver");
	}

	@When("Five_Property File is loaded")
	public void five_property_file_is_loaded() throws IOException {
	    obj.five_property_file_is_loaded();
	}

	@Then("Five_Directed to the site")
	public void five_directed_to_the_site() {
	    obj.five_directed_to_the_site();
	}

	@And("Five_Enter valid credentials and login")
	public void five_enter_valid_credentials_and_login() {
	    obj.five_enter_valid_credentials_and_login();
	}

	@Then("Five_Click on PIM")
	public void five_click_on_pim() {
	    obj.five_click_on_pim();
	}

	@Then("Five_Click on Add Employee")
	public void five_click_on_add_employee() {
	    obj.five_click_on_add_employee();
	}

	@Then("Five_Enter New Employee data")
	public void five_enter_new_employee_data() {
	    obj.five_enter_new_employee_data();
	}

	@Then("Five_Log Out")
	public void five_log_out() {
	    obj.five_log_out();
	}

	@Then("Five_Driver is closed")
	public void five_driver_is_closed() {
	    driver.close();
	}
}
