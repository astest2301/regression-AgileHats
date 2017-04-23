package com.regression.agileHats;

import java.awt.AWTException;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.Reporter;


public class registerPage {
	WebDriver driver;
	JavascriptExecutor js;
	String actual;
	final String randomEmail = "random-" + UUID.randomUUID().toString() + "@example.com";
	final String randomEmail2 = "random-" + UUID.randomUUID().toString() + "@example.com";
	
	public String getRandom(){
		String randomE=randomEmail;
		System.out.println("random fom method ------" + randomE);
		return randomE.toString();
		
	}
	public String getRandom2(){
		String randomE2=randomEmail2;
		System.out.println("random fom method ------" + randomE2);
		return randomE2.toString();
		
	}
	@FindBy(xpath=".//div[@class='error-msg'][contains(.,'Email')]")
    WebElement emailError;
	
	@FindBy(xpath=".//div[@class='error-msg'][contains(.,'Password')]")
    WebElement passwordError;
	
	@FindBy(xpath=".//div[@class='error-msg'][contains(.,'Wrong email or password.')]")
    WebElement wrongError;
	
	@FindBy(xpath=".//div[@class='error-msg'][contains(.,'First')]")
    WebElement firstErrorRegistration;
	
	@FindBy(xpath=".//div[@class='error-msg'][contains(.,'Last')]")
    WebElement lastErrorRegistration;
	
	@FindBy(xpath=".//div[@class='error-msg'][contains(.,'Email')]")
    WebElement emailErrorRegistration;
	
	@FindBy(xpath=".//div[@class='error-msg'][contains(.,'Password')]")
    WebElement passwordErrorRegistration;
	
	@FindBy(xpath=".//div[@class='error-msg'][contains(.,'Password confirmation')]")
    WebElement passwordConfErrorRegistration;
	
	@FindBy(xpath=".//div[@class='error-msg'][contains(.,'Email is invalid')]")
    WebElement invalidEmailFormatRegistration;
	
	@FindBy(xpath=".//div[@class='error-msg'][contains(.,'Email has already been taken')]")
    WebElement takenEmailRegistration;

	
	@FindBy(css = "a[href*='projects']")
	WebElement projectsLink;

	@FindBy(css = "a[href*='projects/new")
	WebElement createProjectButton;

	@FindBy(css = "a[href*='projects/new/funding']")
	WebElement fundingLink;

	@FindBy(xpath = ".//*[@id='name']")
	WebElement projectName;

	@FindBy(xpath = ".//*[@id='description_why']")
	WebElement why;

	@FindBy(xpath = ".//*[@id='description_what']")
	WebElement what;

	@FindBy(xpath = ".//*[@id='description_how']")
	WebElement how;

	@FindBy(css = ".btn.btn-green.pull-right")
	WebElement nextButton1;

	@FindBy(css = "input[class='autocomplete-input ember-view ember-text-field']")
	WebElement addPeople;

	@FindBy(xpath = ".//*[contains(text(), 'Next')]")
	WebElement nextButton2;

	@FindBy(css = "input[class='typeahead text-input autocomplete-input ember-view ember-text-field']")
	WebElement addResponsibility;

	@FindBy(xpath = ".//*[contains(text(), 'Next')]")
	WebElement nextButton3;

	@FindBy(xpath = "//a[contains(.,'Go to project')]")
	WebElement goToProjectButton;

	@FindBy(className = "img-circle")
	WebElement logOut;

	@FindBy(xpath = "//button[contains(.,'Logout')]")
	WebElement logOutButton;
	@FindBy(xpath = ".//*[contains(text(), 'Sign up')]")
	WebElement signUpButton;
	
	@FindBy(xpath="//button[contains(.,'Sign Up')]")
	WebElement signUpButtonChoose;
	
	@FindBy(xpath = ".//*[contains(text(), 'CA Ambrosia')]")
	WebElement selectCompany;
	
	@FindBy(xpath=".//button[@class='btn btn-primary']")
	WebElement joinButtonR;
	
	@FindBy(xpath = ".//*[contains(text(), 'Ok, great')]")
	WebElement okGreatButton;
	
	@FindBy(xpath=".//*[contains(text(), 'Company')]")
	WebElement companyLink;
	
	@FindBy(xpath=".//*[@class='file-picker__dropzone']")
	WebElement selectFileC;

	@FindBy(xpath=".//div[@class='btn btn-default select-file ember-view file-picker single']")
	WebElement selectFileC2;
	
	
	@FindBy(xpath="//input[@placeholder='Company Name']")
	WebElement companyNameC;
	
	@FindBy(xpath="//input[@placeholder='Employees']")
	WebElement employeesC;
	
	@FindBy(xpath=".//button[contains(text(), 'CREATE COMPANY SPACE')]")
	WebElement createCompanySpaceButton;
	
	@FindBy(xpath="//input[@placeholder='Enter email']")
	WebElement emailCompany;

	@FindBy(xpath=".//button[contains(text(), 'ADD')]")
	WebElement addCompanySpaceButton;
	
	@FindBy(css="button[class='btn btn-primary btn-invite pull-left']")
	WebElement inviteCreateCompany;
	
	
	@FindBy(css = "a[href*='/register']")
	WebElement accauntLink;

	@FindBy(xpath = "//input[@placeholder='First name']")
	WebElement firstName;

	@FindBy(xpath = "//input[@placeholder='Last name']")
	WebElement lastName;

	@FindBy(xpath = "//input[@placeholder='Email']")
	WebElement emailR;

	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement passwordR;

	@FindBy(xpath = "//input[@placeholder='Confirm Password']")
	WebElement confirmPasswordR;
	
	@FindBy(xpath="//div[contains(@class, 'no-projects')]/h4")
	WebElement registerConfirmation;
	
	@FindBy(xpath=".//*[contains(text(), 'People')]")
	WebElement peopleCard;
	
	@FindBy(xpath=".//*[contains(text(), 'user13@gmail.com')]")
	WebElement mailConfirmation;
	
	@FindBy(xpath=".//*[@class='email']")
	WebElement mailConfirmation2;
	
	@FindBy(xpath=".//span[contains(text(),'Funding')]")
	WebElement projectLinkVerif;
	

	
	//////////////////////////////////
	public registerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	   //*****************************
    public void registerVerification(){
    	String actual = mailConfirmation.getText();
    	
    	String expected = "user13@gmail.com";
    	Assert.assertEquals(actual, expected);
    	Reporter.log("Actual message is: " + actual,true);
    	Reporter.log("Verifying that user is regired.",true);
    }
	
    ////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////
    public void registerVerification2(){
    	//boolean actual = mailConfirmation2.getText().contains(randomEmail);
    	String actual= getRandom();
    	String expected = mailConfirmation2.getText();
    	System.out.println("random fom verification "+expected);
    	System.out.println("random fom get random "+getRandom());
    	//Assert.assertTrue(true);
    	//Assert.assertEquals(actual, expected);
    	//Reporter.log("Actual message is: " + actual,true);
    	//Reporter.log("Verifying that user is registred.",true);
    	
    	
    	//Assert.assertEquals(actual, expected);
   	 if (actual.equals(expected)){
			 Reporter.log("|PASS  Register company confirmation");
		}else{ 
		 Reporter.log("|FAIL  Register company confirmation", true);
		}
		 Reporter.log("Actual value = " + actual, true);
	     Reporter.log("|Expected value = " + expected, true);
	
    }
    
    public void registerVerification3(){
    	//boolean actual = mailConfirmation2.getText().contains(randomEmail);
    	String actual= getRandom2();
    	String expected = mailConfirmation2.getText();
    	System.out.println("random fom verification "+expected);
    	System.out.println("random fom get random "+getRandom2());
   	 if (actual.equals(expected)){
			 Reporter.log("|PASS  Register company confirmation");
		}else{ 
		 Reporter.log("|FAIL  Register company confirmation", true);
		}
		 Reporter.log("Actual value = " + actual, true);
	     Reporter.log("|Expected value = " + expected, true);
	
    }
    
	public void emailError(){
		 String actual_error = emailError.getText();
		 Reporter.log("Actual message is: " + actual_error,true);
		 String expected_error = "Email can't be blank";
		// Assert.assertEquals(actual_error, expected_error);
		// Reporter.log("Verifying that the accurate warrning message is displayed",true);
		 
	 	 if (actual_error.equals(expected_error)){
			 Reporter.log("|PASS  Verifying that the accurate warrning message is displayed");
		}else{ 
		 Reporter.log("|FAIL  Verifying that the accurate warrning message is displayed", true);
		}
		 Reporter.log("Actual value = " + actual, true);
	     Reporter.log("|Expected value = " + expected_error, true);
	
    }
	 
	 public void wrongError(){
		 String actual_error = wrongError.getText();
		 Reporter.log("Actual message is: " + actual_error,true);
		 String expected_error = "Wrong email or password. ";
		// Assert.assertEquals(actual_error, expected_error);
		// Reporter.log("Verifying that the accurate warrning message is displayed",true);
		 
		 if (actual_error.equals(expected_error)){
			 Reporter.log("|PASS  Verifying that the accurate warrning message is displayed");
		}else{ 
		 Reporter.log("|FAIL  Verifying that the accurate warrning message is displayed", true);
		}
		 Reporter.log("Actual value = " + actual, true);
	     Reporter.log("|Expected value = " + expected_error, true);
		 
	 }
	 public void passwordError(){
		 String actual_error = passwordError.getText();
		 Reporter.log("Actual message is: " + actual_error,true);
		 String expected_error = "Password can't be blank";
		// Assert.assertEquals(actual_error, expected_error);
		// Reporter.log("Verifying that the accurate warrning message is displayed",true);
		 if (actual_error.equals(expected_error)){
			 Reporter.log("|PASS  Verifying that the accurate warrning message is displayed");
		}else{ 
		 Reporter.log("|FAIL  Verifying that the accurate warrning message is displayed", true);
		}
		 Reporter.log("Actual value = " + actual, true);
	     Reporter.log("|Expected value = " + expected_error, true);
	 }
	 public void firstnameErrorRegistration(){
		 String actual_error = firstErrorRegistration.getText();
		 Reporter.log("Actual message is: " + actual_error,true);
		 String expected_error = "Firstname can't be blank";
		 //Assert.assertEquals(actual_error, expected_error);
		// Reporter.log("Verifying that the accurate warrning message is displayed",true);
		 
		 if (actual_error.equals(expected_error)){
			 Reporter.log("|PASS  Verifying that the accurate warrning message is displayed");
		}else{ 
		 Reporter.log("|FAIL  Verifying that the accurate warrning message is displayed", true);
		}
		 Reporter.log("Actual value = " + actual, true);
	     Reporter.log("|Expected value = " + expected_error, true);
	 }
	 public void lastnameErrorRegistration(){
		 String actual_error = lastErrorRegistration.getText();
		 Reporter.log("Actual message is: " + actual_error,true);
		 String expected_error = "Lastname can't be blank";
		// Assert.assertEquals(actual_error, expected_error);
		 //Reporter.log("Verifying that the accurate warrning message is displayed",true);
		 
		 if (actual_error.equals(expected_error)){
			 Reporter.log("|PASS  Verifying that the accurate warrning message is displayed");
		}else{ 
		 Reporter.log("|FAIL  Verifying that the accurate warrning message is displayed", true);
		}
		 Reporter.log("Actual value = " + actual, true);
	     Reporter.log("|Expected value = " + expected_error, true);
	 }
	 public void emailErrorRegistration(){
		 String actual_error = emailErrorRegistration.getText();
		 Reporter.log("Actual message is: " + actual_error,true);
		 String expected_error = "Email can't be blank";
		 Reporter.log("Actual message is: " + actual_error,true);
		// Assert.assertEquals(actual_error, expected_error);
		 //Reporter.log("Verifying that the accurate warrning message is displayed",true);
		 
		 if (actual_error.equals(expected_error)){
			 Reporter.log("|PASS  Verifying that the accurate warrning message is displayed");
		}else{ 
		 Reporter.log("|FAIL  Verifying that the accurate warrning message is displayed", true);
		}
		 Reporter.log("Actual value = " + actual, true);
	     Reporter.log("|Expected value = " + expected_error, true);
	 }
	 public void passwordErrorRegistration(){
		 String actual_error = passwordErrorRegistration.getText();
		 Reporter.log("Actual message is: " + actual_error,true);
		 String expected_error = "Password can't be blank";
		// Assert.assertEquals(actual_error, expected_error);
		 //Reporter.log("Verifying that the accurate warrning message is displayed",true);
		 if (actual_error.equals(expected_error)){
			 Reporter.log("|PASS  Verifying that the accurate warrning message is displayed");
		}else{ 
		 Reporter.log("|FAIL  Verifying that the accurate warrning message is displayed", true);
		}
		 Reporter.log("Actual value = " + actual, true);
	     Reporter.log("|Expected value = " + expected_error, true);
	 }
	 public void passwordConfErrorRegistration(){
		 String actual_error = passwordConfErrorRegistration.getText();
		 Reporter.log("Actual message is: " + actual_error,true);
		 String expected_error = "Password confirmation doesn't match password";
		// Assert.assertEquals(actual_error, expected_error);
		 //Reporter.log("Verifying that the accurate warrning message is displayed",true);
		 if (actual_error.equals(expected_error)){
			 Reporter.log("|PASS  Verifying that the accurate warrning message is displayed");
		}else{ 
		 Reporter.log("|FAIL  Verifying that the accurate warrning message is displayed", true);
		}
		 Reporter.log("Actual value = " + actual, true);
	     Reporter.log("|Expected value = " + expected_error, true);
	 }
	 public void emailInvalidFormatRegistration(){
		 String actual_error = emailErrorRegistration.getText();
		 String expected_error = "Email is invalid";
		 Reporter.log("Actual message is: " + actual_error,true);
		 //Assert.assertEquals(actual_error, expected_error);
		 //Reporter.log("Verifying that the accurate warrning message is displayed",true);
		 if (actual_error.equals(expected_error)){
			 Reporter.log("|PASS  Verifying that the accurate warrning message is displayed");
		}else{ 
		 Reporter.log("|FAIL  Verifying that the accurate warrning message is displayed", true);
		}
		 Reporter.log("Actual value = " + actual, true);
	     Reporter.log("|Expected value = " + expected_error, true);
	 }
	 public void takenEmailRegistration(){
		 String actual_error = emailErrorRegistration.getText();
		 String expected_error = "Email has already been taken";
		 Reporter.log("Actual message is: " + actual_error,true);
		// Assert.assertEquals(actual_error, expected_error);
		 //Reporter.log("Verifying that the accurate warrning message is displayed",true);
		 if (actual_error.equals(expected_error)){
			 Reporter.log("|PASS  Verifying that the accurate warrning message is displayed");
		}else{ 
		 Reporter.log("|FAIL  Verifying that the accurate warrning message is displayed", true);
		}
		 Reporter.log("Actual value = " + actual, true);
	     Reporter.log("|Expected value = " + expected_error, true);
	 }
	 public void clickProjectsLink() {
			projectsLink.click();
		}

		public void clickCreateProjectButton() {
			createProjectButton.click();
		}

		public void clickFunding() {
			fundingLink.click();
		}

		public void setProjectName(String name) {
			projectName.sendKeys(name);
		}

		public void setWhy(String pwhy) {
			why.sendKeys(pwhy);
		}

		public void setWhat(String pwhat) {
			what.sendKeys(pwhat);
		}

		public void setHow(String phow) {
			how.sendKeys(phow);
		}

		public void clickNextButton1() {
			nextButton1.click();
		}

		public void verifyAddPeople(String blank) {
			addPeople.sendKeys(blank);
		}

		public void clickNextButton2() {
			nextButton2.click();
		}

		public void verifyAddResponsibility(String blank) {
			addResponsibility.sendKeys(blank);
		}

		public void clickNexButton3() {
			nextButton3.click();
		}

		public void clickGoToProjectButton() {
			goToProjectButton.click();
		}

		public void clickLogOut() {
			logOut.click();
		}

		public void clickLogOutButton() {
			logOutButton.click();
		}

		public void clickAccLink() {
			accauntLink.click();
		}

		public void setFirstNameR(String fName) {
			firstName.sendKeys(fName);
		}

		public void setLastNameR(String lNameR) {
			lastName.sendKeys(lNameR);
		}
/////////////////////////////////////////////
		///////////////////////////////////////////////////////////////
		public void setEmailR(String email) {
			//emailR.sendKeys(email);
			 email = randomEmail;
			 System.out.println("random fom register"+randomEmail);
			 emailR.sendKeys(email);
			 System.out.println(email);
			
		}
		public void setEmailR2(String email) {
			//emailR.sendKeys(email);
			 email = randomEmail2;
			 System.out.println("random fom register"+randomEmail2);
			 emailR.sendKeys(email);
			 System.out.println(email);
			
		}

		public void setPasswordR(String password) {
			passwordR.sendKeys(password);
		}

		public void confirmPasswordR(String confirm) {
			confirmPasswordR.sendKeys(confirm);
		}

		public void clickSignUp() {
			signUpButton.submit();
		}

		public void selectCompany() throws InterruptedException {
			//selectCompany.click();
			js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", selectCompany);	
		
		   
		}

		public void clickJoinButton() throws InterruptedException, FindFailed {
			

			 Screen s = new Screen();	
				 s.click("src/resources/join.png");
				 s.wait(0.5);
				 s.click("src/resources/join.png");
					
			
			
			//WebDriverWait wait = new WebDriverWait(driver, 30);// 1 minute 
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//button[@class='btn btn-primary']")));
			//driver.findElement(By.xpath(".//button[@class='btn btn-primary']")).click();
		 //   js = (JavascriptExecutor)driver;
		//	js.executeScript("arguments[0].click();", joinButtonR);	
		//	js.executeScript("arguments[0].click();", joinButtonR);	
		//	Thread.sleep(5000);
		}
		public void clickOKGreatButton() {
		okGreatButton.click();
		}
		public void after(){
			driver.quit();
		}
		public void clickSignUpChoose(){
			signUpButtonChoose.submit();
		}
		public void clickCompanyTab(){
			companyLink.click();
		}
		
		public void clearRegistrationFields(){
			firstName.clear();
			lastName.clear();
			emailR.clear();
			passwordR.clear();
			confirmPasswordR.clear();
		}
		public void clickSelectFileButton(){
			selectFileC.click();
		}
		public void clickSelectFileButton2(){
			selectFileC2.click();
	}
		public void selectPhoto() throws AWTException, InterruptedException, FindFailed {
			Thread.sleep(1000);			
			
			 Screen s = new Screen();	
				 s.click("src/resources/documents.png");
				 s.click("src/resources/xxx.png");
				 s.click("src/resources/open3.png");
			 s.wait(0.5);
			    s.doubleClick("src/resources/slika1.png");
			    //s.wait(0.5);		   
			    //s.click("src/resources/open4.png");	  	   
		 }
			
		public void setCompanyName(String name){
			companyNameC.sendKeys(name);
		}
		public void setEmployees(int number){
			employeesC.sendKeys(String.valueOf(number));
		}
		public void clickCreateCompanySpaceButton() throws InterruptedException{
			 Thread.sleep(2000);
			createCompanySpaceButton.submit();
		}
		public void setEmailCompany(String mail){
			emailCompany.sendKeys(mail);
		}
		public void clickAddButtonCompany(){
			addCompanySpaceButton.click();
		}
		public void clickInviteCreateCompanyButton(){
			inviteCreateCompany.click();
		}
		public void setEmployeesStr(String number){
			employeesC.sendKeys(number);
		}
		public void registerConfirmation(){			
			String actual = registerConfirmation.getText();
			String expected = "You are waiting for acceptance";		
			 if (actual.equals(expected)){
				 Reporter.log("|PASS  Register employee confirmation");
			}else{ 
			 Reporter.log("|FAIL  Register employee confirmation", true);
			}
			 Reporter.log("Actual value = " + actual, true);
		     Reporter.log("|Expected value = " + expected, true);
		}
	    public void clickPeopleCard(){
		    peopleCard.click();
	}
	    
	    public void projectLinkVerification(){
	    	String actual = projectLinkVerif.getText();
	    	String expected = "Funding Project 1";
	    	Assert.assertEquals(actual, expected);
	    	
	    	 if (actual.equals(expected)){
				 Reporter.log("|PASS  Verifying that the accurate warrning message is displayed");
			}else{ 
			 Reporter.log("|FAIL  Verifying that the accurate warrning message is displayed", true);
			}
			 Reporter.log("Actual value = " + actual, true);
		     Reporter.log("|Expected value = " + expected, true);
	    }
}
