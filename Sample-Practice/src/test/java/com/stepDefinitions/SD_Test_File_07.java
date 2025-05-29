package com.stepDefinitions;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import com.pages.Page02_Test_File_02;
import com.pages.Page07_Test_File_07;

public class SD_Test_File_07 {
	
	public WebDriver driver;
	Page07_Test_File_07 obj;
	
	
		@When("Seven_Driver is loaded")
	public void seven_driver_is_loaded() {
			System.setProperty("webdriver.chrome.driver","src\\main\\resources\\Driver\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			obj = new Page07_Test_File_07(driver);
			System.out.println("Checked driver");
	}
	@When("Seven_Property File is loaded")
	public void seven_property_file_is_loaded() throws IOException {
	     obj.seven_property_file_is_loaded();
	}
	@Then("Seven_Directed to the site")
	public void seven_directed_to_the_site() {
	   obj.seven_directed_to_the_site();
	}
	@And("Seven_Enter valid credentials and login")
	public void seven_enter_valid_credentials_and_login() {
	   obj.seven_enter_valid_credentials_and_login();
	}
	@Then("Seven_Click on PIM")
	public void seven_click_on_pim() {
	   obj.seven_click_on_pim();
	}
	@Then("Seven_Click on Employee List")
	public void seven_click_on_employee_list() {
	   obj.seven_click_on_employee_list();
	}
	@Then("Seven_Log Out")
	public void seven_log_out() {
	   obj.seven_log_out();
	}
	@Then("Seven_Driver is closed")
	public void seven_driver_is_closed() {
	    driver.close();
	    }

}
