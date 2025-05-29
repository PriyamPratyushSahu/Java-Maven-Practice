package com.stepDefinitions;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.pages.Page01_Test_File_01;

public class SD_Test_File_01  {
	
	public WebDriver driver;
	Page01_Test_File_01 obj; 
	
	@When("One_Driver is loaded")
	public void one_driver_is_loaded() {		   
		   
		   System.setProperty("webdriver.chrome.driver","src\\main\\resources\\Driver\\chromedriver_win32\\chromedriver.exe");
		   driver = new ChromeDriver();
		   obj = new Page01_Test_File_01(driver);
		   System.out.println("Checked driver");
		}
	 	
	@When("One_Property File is loaded")
	public void one_property_file_is_loaded() throws IOException {
		obj.one_property_file_is_loaded();
	}

	@Then("One_Directed to the site")
	public void one_directed_to_the_site() throws IOException  {
		obj.one_directed_to_the_site();
	}

	@Then("One_Enter the user name")
	public void one_enter_the_user_name() throws IOException {
	    obj.one_enter_the_user_name();
	    
	}

	@Then("One_Enter the password")
	public void one_enter_the_password() throws IOException {
	    obj.one_enter_the_password();
	    
	}

	@Then("One_Click on Login")
	public void one_click_on_login() throws IOException {
	    obj.one_click_on_login();
	}
	@Then ("One_Log Out")
	public void one_log_out() throws IOException	{
		obj.one_log_out();
	}

    @Then("One_Enter the invalid user name")
	public void one_enter_the_invalid_user_name() throws IOException {
	    obj.one_enter_the_invalid_user_name();
	    
	}

	@Then("One_Enter the invalid password")
	public void one_enter_the_invalid_password() throws IOException {
	    obj.one_enter_the_invalid_password();
	    
	}
	
	@And ("One_Click on Forgot your password")
	public void one_click_on_forgot_your_password() throws IOException	{
		obj.one_click_on_forgot_your_password();
	}
	@And("One_Driver is closed")
	public void one_Driver_is_closed() {
		driver.close();
	}
}
