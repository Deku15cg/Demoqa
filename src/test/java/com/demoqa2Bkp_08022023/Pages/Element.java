package com.demoqa2Bkp_08022023.Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Element {
	WebDriver driver;
	
	public Element(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
 @FindBy(xpath="//div[contains(@class,'element-list collapse show')]/ul/li[4]")
 private WebElement webtable;
 
 @FindBy(xpath="//div[@id ='registration-form-modal']")
 private WebElement reg_form;
 
 @FindBy(xpath="//div[contains(@class,'rt-tr -odd')or @class='rt-tr -even']/parent::div/child::div")
 private  WebElement child;
 
 @FindBy(xpath="//button[@id='addNewRecordButton']")
  private WebElement add_Btn ;
 
 @FindBy(xpath="//input[@id='firstName']")
 private  WebElement first_name;
 @FindBy(xpath="//input[@id='lastName']")
 private WebElement last_name;

 @FindBy(xpath="//input[@id='userEmail']")
 private WebElement email;

 @FindBy(xpath="//input[@id='age']")
 private WebElement User_age;

 @FindBy(xpath="//input[@id='salary']")
 private WebElement User_salary;

 @FindBy(xpath="//input[@id='department']")
 private WebElement department_name;

public void Hit_Enter(){
	department_name.sendKeys(Keys.ENTER);
}
	public void enterFirst(String firstname) {
		first_name.sendKeys(firstname);
		
	}
	public void enterLast(String lastname) {
		last_name.sendKeys(lastname);
		
	}
	public void enterEmail(String emailid) {
		email.sendKeys(emailid);
		
	}
	public void enterAge(String age ) {
		User_age.sendKeys(age);
		
	}
	public void enterSalary(String salary) {
		User_salary.sendKeys(salary);
	}
	public void enterDep(String Dept) {
		department_name.sendKeys(Dept);
	}
	public  void click_on_webtbl() {
		webtable.click();
	}
   public void click_on_addbtn() {
	   add_Btn.click();
   }
   public boolean IsDisp() {
	   return reg_form.isDisplayed();
   }
	public boolean DispChild() {
		return child.isDisplayed();
	}
}

