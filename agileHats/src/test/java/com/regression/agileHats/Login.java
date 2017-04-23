package com.regression.agileHats;

import java.awt.AWTException;
import java.util.UUID;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.Reporter;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Login {
	WebDriver driver = null;
	JavascriptExecutor js;
	ExtentReports report;
	ExtentTest test;

	@FindBy(xpath = "//input[@placeholder='Email']")
	WebElement emailField;

	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement passwordField;

	@FindBy(className = "buttons")
	WebElement loginButton;

	@FindBy(xpath = ".//div[@class='error-msg'][contains(.,'Email')]")
	WebElement emailError;

	@FindBy(xpath = ".//div[@class='error-msg'][contains(.,'Password')]")
	WebElement passwordError;

	@FindBy(xpath = ".//span[@class='show-info'][contains(.,'blabla4@gmail.com')]")
	WebElement validLoginMail;

	@FindBy(xpath = ".//div[@class='error-msg'][contains(.,'Wrong email or password.')]")
	WebElement wrongError;

	@FindBy(xpath = ".//div[@class='error-msg'][contains(.,'Email is invalid')]")
	WebElement invalidEmailFormatRegistration;

	@FindBy(className = "img-circle")
	WebElement logOut;

	@FindBy(xpath = "//button[contains(.,'Logout')]")
	WebElement logOutButton;

	@FindBy(xpath = "//a[contains(.,'Profile')]")
	WebElement profileButton;

	@FindBy(xpath = ".//*[@src='/assets/images/edit-profile-photo-hover.png']")
	WebElement addProfilePhotoButton;

	@FindBy(xpath = ".//*[contains(text(), 'SAVE')]")
	WebElement saveButton;

	@FindBy(xpath = "//button[contains(.,'ADD')]")
	WebElement addButton;

	@FindBy(xpath = "//button[contains(.,'EDIT')]")
	WebElement editButton;

	@FindBy(xpath = "//input[@placeholder='Phone']")
	WebElement phone;

	@FindBy(xpath = "//input[@placeholder='Skype']")
	WebElement skype;

	@FindBy(xpath = "//button[contains(.,'DONE')]")
	WebElement doneButton;

	@FindBy(xpath = "//span[contains(.,'123456')]")
	WebElement editedPhoneField;

	@FindBy(xpath = ".//*[@class='buttons text-center footer-btns']")
	WebElement frame;

	@FindBy(xpath = "//span[contains(.,'skype accaunt')]")
	WebElement editedSkypeField;

	///////////////////////////////
	public Login(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	public void setEmail2(String email) {
		final String randomEmail = "random-" + UUID.randomUUID().toString() + "@example.com";
		email = randomEmail;
		emailField.sendKeys(email);
	}

	public void setEmail(String email) {
		emailField.sendKeys(email);
	}

	public void setPassword(String password) {
		passwordField.sendKeys(password);
	}

	public void emailError() {
		String actual_error = emailError.getText();
		String expected_error = "Email can't be blank";
		// Assert.assertEquals(actual_error, expected_error);
		if (actual_error.equals(expected_error)) {
			Reporter.log("|PASS  Verifying Email Warnning");
		} else {
			Reporter.log("|FAIL   Verifying Email Warnning", true);
		}
		Reporter.log("|Actual value = " + actual_error, true);
		Reporter.log("|Expected value = " + expected_error, true);
	}

	public void wrongError() {
		String actual_error = wrongError.getText();
		String expected_error = "Wrong email or password. ";
		Reporter.log("Actual value = " + actual_error, true);
		Reporter.log("|Expected value = " + expected_error, true);
		// Assert.assertEquals(actual_error, expected_error);
		if (actual_error.equals(expected_error)) {
			Reporter.log("|PASS  Verifying Invalid Email Warnning");
		} else {
			Reporter.log("|FAIL Verifying Invalid Email Warnning", true);
		}

	}

	public void passwordError() {
		String actual_error = passwordError.getText();
		String expected_error = "Password can't be blank";
		Reporter.log("Actual value = " + actual_error, true);
		Reporter.log("|Expected value = " + expected_error, true);
		// Assert.assertEquals(actual_error, expected_error);
		if (actual_error.equals(expected_error)) {
			Reporter.log("|PASS  Verifying Password Warnning");
		} else {
			Reporter.log("|FAIL   Verifying Password Warnning", true);
		}

	}

	public void verifyPhoneEdit() throws InterruptedException {
		Thread.sleep(5000);
		String actual = editedPhoneField.getText();
		String expected = "123456";
		Reporter.log("Actual value = " + actual, true);
		Reporter.log("|Expected value = " + expected, true);
		if (actual.equals(expected)) {
			Reporter.log("|PASS  Verifying Phone Edit");
		} else {
			Reporter.log("|FAIL   Verifying Phone Edit", true);
		}

	}

	public void verifySkypeEdit() throws InterruptedException {
		Thread.sleep(5000);
		String actual = editedSkypeField.getText();
		String expected = "skype accaunt";
		Reporter.log("Actual value = " + actual, true);
		Reporter.log("|Expected value = " + expected, true);
		if (actual.equals(expected)) {
			Reporter.log("|PASS  Verifying Skype Edit");
		} else {
			Reporter.log("|FAIL   Verifying Skype Edit", true);
		}
	}

	public void verifyValidLogin() {
		String actual = validLoginMail.getText();
		String expected = "blabla4@gmail.com";
		if (actual.equals(expected)) {
			Reporter.log("|PASS  Verifying Valid Login");
		} else {
			Reporter.log("|FAIL   Verifying Valid Login", true);
		}
	}

	public void slickLoginButton() throws InterruptedException {
		loginButton.submit();
		Thread.sleep(500);
	}

	public void closeBrowser() throws InterruptedException, FindFailed {
		 Screen s = new Screen();					   
		    s.click("src/resources/close1.png");
	}
	
	public void checkForLoginButton() {

		boolean loginPresent = driver.findElements(By.className("buttons")).size() > 0;
		if (!loginPresent) {
			Assert.fail();
			Reporter.log("|PASS  Verifying user is not Logged Out");
		} else {
			Reporter.log("|FAIL Verifying user is not Logged Out", true);
		}
	}

	public void clearLoginFields() {
		emailField.clear();
		passwordField.clear();
	}

	public void checkLoginFields() {
		String actual = emailField.getAttribute("value");
		String expected = "";
		if (actual.equals(expected)) {
			Reporter.log("|PASS  Verifying clear Login field");
		} else {
			Reporter.log("|FAIL   Verifying clear Login field", true);
		}
	}

	public void clickLogOut() {
		logOut.click();
	}
	public void clickLogOut2() throws FindFailed {
		logOut.click();
		driver.switchTo().activeElement();
		Screen s = new Screen();
		s.click("src/resources/close1.png");
	}

	public void clickLogOutButton() {
		logOutButton.click();
	}

	public void clickProfile() {
		profileButton.click();
	}

	public void after() {
		driver.quit();
	}

	public void clickAddProfilePhotoButton() throws InterruptedException {
		addProfilePhotoButton.click();
		Thread.sleep(2000);
	}

	public void selectPhoto() throws InterruptedException, AWTException, FindFailed {
		Screen s = new Screen();
		s.click("src/resources/documents.png");
		s.click("src/resources/xxx.png");
		s.click("src/resources/open3.png");
		s.click("src/resources/slika1.png");
		s.wait(0.5);
		s.click("src/resources/open3.png");
		Thread.sleep(6000);
	}

	public void clickSaveButton() throws InterruptedException {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", saveButton);
		System.out.println("save clicked");
	}

	public void clickAddButton() throws InterruptedException {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", addButton);
		Thread.sleep(1000);
	}

	public void clickEditButton() throws InterruptedException {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", editButton);
		System.out.println("edit clicked");
		Thread.sleep(1000);

	}

	public void addPhone(String phon) {
		phone.sendKeys(phon);
		System.out.println("phone entered");
	}

	public void clearPhoneField() {
		phone.clear();
		System.out.println("phone cleared");
	}

	public void clearSkypeField() {
		skype.clear();
		System.out.println("skype cleared");
	}

	public void addSkype(String skyp) {
		skype.sendKeys(skyp);
		System.out.println("skype entered");
	}

	public void done() {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", doneButton);
		System.out.println("done clicked");
	}
}
