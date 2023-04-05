package com.demoqa2Bkp_08022023.Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import hook.hooks;

public class BookStore {
	WebDriver driver;
	public BookStore(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
     @FindBy(xpath="//div[@class='card mt-4 top-card']/parent::div/child::div[6]")
     private WebElement Bookstore;
     @FindBy(xpath="//li[@class='btn btn-light active']/parent::ul/child::li[1]")
     private  WebElement Login;
     @FindBy(xpath="//input[@id='userName']")
     private  WebElement Username;
     @FindBy(xpath="//input[@id='password']")
     private WebElement Password;
     @FindBy(xpath="//button[@id='login']")
     private WebElement Loginbtn;
     @FindBy(xpath="//div[@class='main-header' and text()='Book Store']")
     private WebElement book;
     @FindBy(xpath="//p[@class='mb-1']")
     WebElement Para;
     public void click_on_bookstr() {
    	 Bookstore.click();
    	
     }
     public void click_on_login() {
    	 Login.click();
     }
     public void Enter_Invalid_Credential1(String username, String password) {
         Username.sendKeys(username);	
         Password.sendKeys(password);
    	}
     
    public void click_on_loginbtn() {
    	Loginbtn.click();
    } 
    public boolean IsDisplayed_Page() {
    	return book.isDisplayed();
    }
    public boolean IsDisplayed_Para() {
    	return Para.isDisplayed();
    }
	
}
