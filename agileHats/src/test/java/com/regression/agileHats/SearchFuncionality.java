package com.regression.agileHats;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class SearchFuncionality {
	WebDriver driver;
	JavascriptExecutor js;
	
	
	@FindBy(id = "ember592")
	WebElement emailField;

	@FindBy(id = "ember593")
	WebElement passwordField;

	@FindBy(className = "buttons")
	WebElement loginButton;
	
	@FindBy(className = "img-circle")
	WebElement logOut;

	@FindBy(xpath = "//button[contains(.,'Logout')]")
	WebElement logOutButton;
	
	@FindBy(xpath=".//*[@class='typeahead tt-input']")
	WebElement searchItem;
	
	@FindBy(xpath=".//*[@class='fa fa-search']")
	WebElement searchButton;
	
	@FindBy(xpath=".//*[contains(text(), 'Funding Project 1')]")
	WebElement searchLink;
	
	@FindBy(xpath=".//i[@class='fa fa-remove']")
	WebElement searchRemoveButton;
	
	/////////////////////////
	
	public SearchFuncionality(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void setEmail(String email) {
		emailField.sendKeys(email);
	}

	public void setPassword(String password) {
		passwordField.sendKeys(password);
	}
	
	public void slickLoginButton() {
		loginButton.submit();
	}
	public void clickLogOut() {
		logOut.click();
	}

	public void clickLogOutButton() {
		logOutButton.click();
	}
	public void setSearchItem(String item) throws AWTException, InterruptedException{
		searchItem.sendKeys(item);
		Thread.sleep(10000);
		 Robot r = new Robot();
		 
		    r.keyPress(KeyEvent.VK_ENTER);
		    r.keyRelease(KeyEvent.VK_ENTER);
		  //  Thread.sleep(4000);
		    r.keyPress(KeyEvent.VK_ENTER);
		    r.keyRelease(KeyEvent.VK_ENTER);
	}

	public void searchResults() throws InterruptedException{	

		List<WebElement> allSearchResults=  new ArrayList<WebElement>();
		List<WebElement> elements =driver.findElements(By.xpath(".//div[@class='text']"));   
		
		for(WebElement e: elements){
        	allSearchResults.add(e);
        	System.out.println(e.toString());
        } 
		
		int expected = 5;
        int actual=allSearchResults.size();
        System.out.println(actual);
    	Thread.sleep(5000);
    //	Assert.assertEquals(actual, expected); 
    	
    	 if (actual==expected){
			 Reporter.log("|PASS  Verifying that the accurate result is displayed");
		}else{ 
		 Reporter.log("|FAIL  Verifying that the accurate result is displayed", true);
		}
		 Reporter.log("Actual value = " + actual, true);
	     Reporter.log("|Expected value = " + expected, true);
    	
    	
    	
	}
	public void removeVerification(){
		String actual = searchItem.getText();
		String expected ="";
		//Assert.assertEquals(actual, expected);
		if (actual.equals(expected)){
			 Reporter.log("|PASS  Remove search button confirmation");
		}else{ 
		 Reporter.log("|FAIL  Remove search button confirmation", true);
		}
		 Reporter.log("Actual value = " + actual, true);
	     Reporter.log("|Expected value = " + expected, true);
	}
	
	 public void clickSearchLink(){
		 searchLink.click();
	 }
		public void setSearch(String item){
			searchItem.sendKeys(item);
		
		}
	public void clickRemoveButton(){
		searchRemoveButton.click();
	}
}
