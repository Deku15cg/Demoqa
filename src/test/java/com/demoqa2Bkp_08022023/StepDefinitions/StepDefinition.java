package com.demoqa2Bkp_08022023.StepDefinitions;

import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.demoqa2Bkp_08022023.Pages.BookStore;
import com.demoqa2Bkp_08022023.Pages.Element;
import com.demoqa2Bkp_08022023.Pages.HomePage;

import UtilityPackage.ConfigReader;
import UtilityPackage.JsonFileReader;
import hook.hooks;
import io.cucumber.java.en.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class StepDefinition {
    WebDriver driver;
	HomePage home;
	Element ele;
	BookStore Bookstr;
	ConfigReader ConfigRead;
	

	// @Before
//	public void user_launch_google_chrome() {
//		System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
//		driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.manage().timeouts().getPageLoadTimeout();
//   	Duration.ofSeconds(10);
//		driver.manage().window().maximize();

	// }
		@Given("User launch the google chrome")
	public void User_launch_the_google_chrome() {
			
	System.out.println("User on the google chrome");
	    
	}

		@When("User opens url")
		public void user_opens_url() {
		ConfigRead=new ConfigReader();
		hooks.driver.get(ConfigRead.getApplicationUrl());
		}

	@Then("User is redirected to Home page")
	public void user_is_redirected_to_home_page() {
		home = new HomePage ( driver);
		boolean isEqual = false;
		try {
			isEqual = home.GetTitle().equals("DEMOQA");
			Assert.assertTrue(isEqual);
		} catch (Exception e) {
			Assert.assertFalse(isEqual);}

    	 finally {

	System.out.print(hooks.driver.getCurrentUrl());
		}
	}

	@And("User clicks on Element")
	public void user_clicks_on_element() {
		
		hooks.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(132,473)", "");
		home.clickOnElement();
	}

@Given("User is on the Element Page")
public void user_is_on_the_element_page() {
System.out.println("User is on the Element Page");
home = new HomePage(hooks.driver);

hooks.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

JavascriptExecutor js = (JavascriptExecutor) hooks.driver;
js.executeScript("window.scrollBy(132,473)", "");
home.clickOnElement();
	
}


@When("User clicks on Webtable and click the add button")
public void user_clicks_on_webtable_and_click_the_add_button() {
	ele= new Element(hooks.driver);
	
	ele.click_on_webtbl();
	ele.click_on_addbtn();
	
}

@Then("It will show the Registration Form")
public void it_will_show_the_registration_form() {
	
	boolean ifDisplay=false;
	try {
		ifDisplay=ele.IsDisp();
		Assert.assertTrue(ifDisplay);
		System.out.println("The Registration form is  displayed");
	}
	catch(Exception e){
		Assert.assertFalse(ifDisplay);
		System.out.println("The Registration form is not displayed");
	}
   
}
@Then("User enters following details from {string} with {string}")
public void user_enters_following_details_from_with(String string, String string2) throws FileNotFoundException, IOException, ParseException {
	
	String firstName = JsonFileReader.JsonReadTC1(string,string2).get("firstname").toString();  

	//System.out.println("return of steps firstname"+firstName);
	ele.enterFirst(firstName);
	String LastName = JsonFileReader.JsonReadTC1(string,string2).get("lastname").toString();  
	ele.enterLast(LastName);
	String Emailid = JsonFileReader.JsonReadTC1(string,string2).get("emailid").toString(); 
	ele.enterEmail(Emailid);
	String Age = JsonFileReader.JsonReadTC1(string,string2).get("age").toString(); 
	ele.enterAge(Age);
	String Salary = JsonFileReader.JsonReadTC1(string,string2).get("salary").toString(); 
	ele.enterSalary(Salary);
	String dept = JsonFileReader.JsonReadTC1(string,string2).get("Dept").toString();
	ele.enterDep(dept);





}

@And("hit the enter button to submit")
public void hit_the_enter_button_to_submit() {
	ele.Hit_Enter();
	hooks.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
}

@Then("The entry should be available in the table")
public void the_entry_should_be_available_in_the_table() {
	hooks.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	if(ele.DispChild()) {
		System.out.println("Exist");
	}
	else
		System.out.println("Not Exist");

}

@Given("User is on the Book Store Application")
public void user_is_on_the_book_store_application() {
	Bookstr= new BookStore(hooks.driver);
	Bookstr.click_on_bookstr();
	boolean isBooks=false;
	try {
		isBooks= Bookstr.IsDisplayed_Page();
		Assert.assertTrue(isBooks);
		System.out.println("User is on Books Page");
	}
	catch(Exception e) {
		Assert.assertFalse(isBooks);
		System.out.println("User is not on Books Page ");
	}
	
}

@When("User click on the Login Element")
public void user_click_on_the_login_element() {
	JavascriptExecutor js = (JavascriptExecutor) hooks.driver;
	js.executeScript("window.scrollBy(769, 493)", "");
	Bookstr.click_on_login();
}

	

@And("Enters {string} with following {string}")
public void enters_with_following(String string, String string2) throws FileNotFoundException, IOException, ParseException {
	String Username= JsonFileReader.JsonReadTC2().get("UserName").toString();
	String PassWord=JsonFileReader.JsonReadTC2().get("Password").toString();
	Bookstr.Enter_Invalid_Credential1(Username, PassWord);
	
}


@And("Clicks on the Login Btn")
public void clicks_on_the_login_btn() {
	JavascriptExecutor js = (JavascriptExecutor) hooks.driver;
	js.executeScript("window.scrollBy(769, 485)", "");
	Bookstr.click_on_loginbtn();
 hooks.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

}

@Then("Invalid User message will print")
public void invalid_user_message_will_print() {
	boolean isMsg=false;
	try {
		isMsg= Bookstr.IsDisplayed_Para();
		Assert.assertTrue(isMsg);
		System.out.println("Invalid Credential");
	}
	catch(Exception e) {
		Assert.assertFalse(isMsg);
		System.out.println("Valid Credential");
	}
	
}

//@After 
//public void teardown() {
//		driver.close();
//		driver.quit();
//	}

}
