package com.demoqa2Bkp_08022023.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

		WebDriver driver;
		
		public HomePage(WebDriver driver) {
			// TODO Auto-generated constructor stub
			this.driver=driver;
			PageFactory.initElements(driver,this);
		}
	    
        @FindBy(xpath = "//div[@class='category-cards']/div[1]")
        private WebElement Element;
        
		@FindBy(xpath="//div[@class='accordion']/div[1]")
		private WebElement Ele;
		
		@FindBy(xpath="//span[text()='Text Box']")
		private WebElement Textbox;
		
		public String GetTitle() {
		 return driver.getTitle();
		
	}
		public void clickOnElement() {
			Element.click();
		}
		
}

