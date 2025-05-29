package com.stepDefinitions;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import com.pages.Page02_Test_File_02;
import com.pages.Page04_Test_File_04;

public class SD_Test_File_04 {
	
	public WebDriver driver;
	Page04_Test_File_04 obj;

	@When("Four_Driver is loaded")
	public void four_driver_is_loaded() {
		System.setProperty("webdriver.chrome.driver","src\\main\\resources\\Driver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		obj = new Page04_Test_File_04(driver);
		System.out.println("Checked driver");
	}
	@When("Four_Property File is loaded")
	public void four_property_file_is_loaded() throws IOException{
	
		obj.four_property_file_is_loaded();
	}
	@Then("Four_Directed to the site")
	public void four_directed_to_the_site() {
	
		obj.four_directed_to_the_site();
	}
	@And("Four_Enter valid credentials and login")
	public void four_enter_valid_credentials_and_login() {
	
		obj.four_enter_valid_credentials_and_login();
	}
	@Then("Four_Click on Employee List")
	public void four_click_on_employee_list() {
		obj.four_click_on_employee_list();
	}
	
	@Then("Four_Log Out")
	public void four_log_out() {
	    
		obj.four_log_out();
	}
	@Then("Four_Driver is closed")
	public void four_driver_is_closed() {
	    
		driver.close();
	}

}
