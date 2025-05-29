package com.stepDefinitions;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.pages.Page03_Test_File_03;

public class SD_Test_File_03 {
	
	public WebDriver driver;
	Page03_Test_File_03 obj;
	
	@When("Three_Driver is loaded")
	public void three_driver_is_loaded() {
	System.setProperty("webdriver.chrome.driver","src\\main\\resources\\Driver\\chromedriver_win32\\chromedriver.exe");
	driver = new ChromeDriver();
	obj = new Page03_Test_File_03(driver);
	System.out.println("Checked driver");
	}

	@When("Three_Property File is loaded")
	public void three_property_file_is_loaded() throws IOException {
    obj.three_property_file_is_loaded();
    }

	@Then("Three_Directed to the site")
	public void three_directed_to_the_site() {
		obj.three_directed_to_the_site();
	}

	@And("Three_Enter valid credentials and login")
	public void three_enter_valid_credentials_and_login() {
		obj.three_enter_valid_credentials_and_login();
	}

	@Then("Three_Click on PIM")
	public void three_click_on_pim() {
		obj.three_click_on_pim();
	}

	@Then("Three_Click on Configuration")
	public void three_click_on_configuration() {
		obj.three_click_on_configuration();
	}

	@Then("Three_Click on Optional Fields")
	public void three_click_on_optional_fields() {
		obj.three_click_on_optional_fields();
	}

	@Then("Three_Log Out")
	public void three_log_out() {
		obj.three_log_out();
	}

	@Then("Three_Click on Custom fields")
	public void three_click_on_custom_fields() {
		obj.three_click_on_custom_fields();
	}
	@Then("Three_Driver is closed")
	public void three_driver_is_closed() {
		driver.close();
	}
}
