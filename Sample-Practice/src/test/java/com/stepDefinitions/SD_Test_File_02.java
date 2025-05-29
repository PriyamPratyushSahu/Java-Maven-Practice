package com.stepDefinitions;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.pages.Page02_Test_File_02;

public class SD_Test_File_02 {
	
	public WebDriver driver;
	Page02_Test_File_02 obj;
	
	
		@When("Two_Driver is loaded")
	public void two_driver_is_loaded() {
		System.setProperty("webdriver.chrome.driver","src\\main\\resources\\Driver\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		obj = new Page02_Test_File_02(driver);
		System.out.println("Checked driver");
	}
	@When("Two_Property File is loaded")
	public void two_property_file_is_loaded() throws IOException {
	     obj.two_property_file_is_loaded();
	}
	@Then("Two_Directed to the site")
	public void two_directed_to_the_site() {
	   obj.two_directed_to_the_site();
	}
	@And("Two_Enter valid credentials and login")
	public void two_enter_valid_credentials_and_login() {
	   obj.two_enter_valid_credentials_and_login();
	}
	@Then("Two_Click on PIM")
	public void two_click_on_pim() {
	   obj.two_click_on_pim();
	}
	@Then("Two_Click on Employee List")
	public void two_click_on_employee_list() {
	   obj.two_click_on_employee_list();
	}
	@Then("Two_Log Out")
	public void two_log_out() {
	   obj.two_log_out();
	}
	@Then("Two_Driver is closed")
	public void two_driver_is_closed() {
	    driver.close();
	    }

}
