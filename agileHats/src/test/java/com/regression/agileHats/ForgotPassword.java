package com.regression.agileHats;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class ForgotPassword {
	WebDriver driver;
	JavascriptExecutor js;
	
	
	@FindBy(xpath=".//*[@class='pull-left forgot-link ember-view']")
	WebElement forgotPasswordLink;
	
	@FindBy(xpath=".//*[@class='ember-view ember-text-field']")
	WebElement emailField;
	
	@FindBy(xpath=".//*[@class='btn btn-primary']")
	WebElement sendButton;
	
	@FindBy(xpath=".//*[@class='btn btn-green']")
	WebElement oKButton;
	
	@FindBy(xpath=".//div[@class='error-msg'][contains(.,'Couldn')]")
    WebElement userError;
	
	@FindBy(xpath=".//div[@class='info'][contains(.,'You will receive email with')]")
    WebElement emailPopup;
	
	@FindBy(xpath = "//input[@placeholder='Enter your email']")
	WebElement emailGmail;
	
	@FindBy(xpath=".//*[@class='rc-button rc-button-submit']")
	WebElement nextButtonGmail;
	
	@FindBy(xpath=".//*[@class='rc-button rc-button-submit']")
	WebElement submitButtonGmail;
	
	public ForgotPassword(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void userError(){
		 String actual_error = userError.getText();
		 System.out.println(actual_error);
		 Reporter.log("Actual message is: " + actual_error,true);
		 String expected_error = "Couldn't find User. ";
		 Reporter.log("Verifying that the accurate warrning message is displayed",true);
		// Assert.assertEquals(actual_error, expected_error);

    	 if (actual_error.equals(expected_error)){
			 Reporter.log("|PASS  Verifying that the accurate warrning message is displayed");
		}else{ 
		 Reporter.log("|FAIL  Verifying that the accurate warrning message is displayed", true);
		}
		 Reporter.log("Actual value = " + actual_error, true);
	     Reporter.log("|Expected value = " + expected_error, true);
	 }
	public void clickForgotPasswordLink(){
		forgotPasswordLink.click();
	}
	public void setEmail(String text){
		emailField.sendKeys(text);
	}
	public void clickSendButton(){
		sendButton.submit();
	}
	public void clickOKButton(){
		oKButton.click();
	}
	
	public void sendEmailConfirmation(){
		 String actual = emailPopup.getText();

		 Reporter.log("Actual message is: " + actual,true);
		 String expected = "You will receive email with link to reset your password";
		 Reporter.log("Verifying that the accurate warrning message is displayed",true);
		// Assert.assertEquals(actual_error, expected_error);

   	 if (actual.equals(expected)){
			 Reporter.log("|PASS  Verifying that the accurate warrning message is displayed");
		}else{ 
		 Reporter.log("|FAIL  Verifying that the accurate warrning message is displayed", true);
		}
		 Reporter.log("Actual value = " + actual, true);
	     Reporter.log("|Expected value = " + expected, true);
	 }
}
