package com.stepDefinitions;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.pages.Page08_Test_File_08;

public class SD_Test_File_08  {
	
	public WebDriver driver;
	Page08_Test_File_08 obj; 
	
	@When("Eight_Driver is loaded")
	public void eight_driver_is_loaded() {		   
		   
		   System.setProperty("webdriver.chrome.driver","src\\main\\resources\\Driver\\chromedriver_win32\\chromedriver.exe");
		   driver = new ChromeDriver();
		   obj = new Page08_Test_File_08(driver);
		   System.out.println("Checked driver");
		}
	 	
	@When("Eight_Property File is loaded")
	public void eight_property_file_is_loaded() throws IOException {
		obj.eight_property_file_is_loaded();
	}

	@Then("Eight_Directed to the site")
	public void eight_directed_to_the_site() throws IOException  {
		obj.eight_directed_to_the_site();
	}

	@Then("Eight_Enter the user name")
	public void eight_enter_the_user_name() throws IOException {
	    obj.eight_enter_the_user_name();
	    
	}

	@Then("Eight_Enter the password")
	public void eight_enter_the_password() throws IOException {
	    obj.eight_enter_the_password();
	    
	}

	@Then("Eight_Click on Login")
	public void eight_click_on_login() throws IOException {
	    obj.eight_click_on_login();
	}
	@Then ("Eight_Log Out")
	public void eight_log_out() throws IOException	{
		obj.eight_log_out();
	}

    @Then("Eight_Enter the invalid user name")
	public void eight_enter_the_invalid_user_name() throws IOException {
	    obj.eight_enter_the_invalid_user_name();
	    
	}

	@Then("Eight_Enter the invalid password")
	public void eight_enter_the_invalid_password() throws IOException {
	    obj.eight_enter_the_invalid_password();
	    
	}
	
	@And ("Eight_Click on Forgot your password")
	public void eight_click_on_forgot_your_password() throws IOException	{
		obj.eight_click_on_forgot_your_password();
	}
	@And("Eight_Driver is closed")
	public void eight_Driver_is_closed() {
		driver.close();
	}
}
