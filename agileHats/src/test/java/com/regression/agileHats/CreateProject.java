package com.regression.agileHats;

import java.awt.AWTException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
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

public class CreateProject {
	WebDriver driver;
	JavascriptExecutor js;
	// String actual;

	@FindBy(css = "a[href*='responsibilities']")
	WebElement responsibilitiesLink;

	@FindBy(xpath = ".//*[@class='file-picker__dropzone']")
	WebElement uploadLogoButton;

	@FindBy(xpath = ".//*[@class='btn btn-default pull-right add-video']")
	WebElement uploadVideoButton;

	@FindBy(xpath = ".//*[@id='name']")
	WebElement projectNameFunding;

	@FindBy(xpath = ".//*[@id='description_why']")
	WebElement projectWhyFunding;

	@FindBy(xpath = ".//*[@id='description_what']")
	WebElement projectWhatFunding;

	@FindBy(xpath = ".//*[@id='description_how']")
	WebElement projectHowFunding;

	@FindBy(xpath = "//input[@placeholder='Project Test 1234']")
	WebElement projectName;

	@FindBy(xpath = "//input[@placeholder='Project Name']")
	WebElement projectNameExistingCreate;

	@FindBy(xpath = ".//*[@class='title pull-left']")
	WebElement verifivation2;

	@FindBy(xpath = "//textarea[@placeholder='Description']")
	WebElement projectDescription;

	@FindBy(xpath = ".//*[@id='startDateActive']")
	WebElement datePicker;

	@FindBy(xpath = ".//*[@id='startDate']")
	WebElement datePickerStart;

	@FindBy(xpath = ".//*[@id='endDate']")
	WebElement datePickerEnd;

	@FindBy(xpath = ".//*[contains(text(), 'Next')]")
	WebElement nexButton1;

	@FindBy(xpath = ".//*[@class='btn btn-green pull-right']")
	WebElement nexButtonFunding;

	@FindBy(xpath = ".//*[@class='typeahead text-input autocomplete-input ember-view ember-text-field']")
	WebElement responsibilityField;

	@FindBy(xpath = ".//*[contains(text(), 'Create New Responsibility')]")
	WebElement createNewResponibilityButton;

	@FindBy(xpath = ".//*[@class='row']/input")
	WebElement responsabilityName;

	@FindBy(xpath = ".//*[@class='row']/textarea")
	WebElement responsabilityDescription;

	@FindBy(xpath = ".//*[contains(text(), 'Save')]")
	WebElement saveButton1;

	@FindBy(xpath = ".//*[contains(text(), 'Save')]")
	WebElement saveButton2;

	@FindBy(xpath = ".//*[contains(text(), 'Next')]")
	WebElement nextButton2;

	@FindBy(xpath = ".//*[@class='fa fa-plus-circle']")
	WebElement addPeopleButt;

	@FindBy(xpath = "//*[@class='btn btn-add-holder pull-right ember-view']")
	WebElement inviteButt;

	@FindBy(xpath = "//*[@class='message btn-link']")
	WebElement inviteButtonFunding;

	@FindBy(xpath = ".//*[contains(text(), 'company88 company88')]")
	WebElement selectPeopleR;

	@FindBy(xpath = ".//*[contains(text(), 'company88 company88')]")
	WebElement selectPeopleF;

	@FindBy(xpath = ".//*[contains(text(), 'sss')]")
	WebElement setSSS;

	@FindBy(xpath = ".//input[@class='search-projects ember-view ember-text-field']")
	WebElement selectProjectRes;

	@FindBy(xpath = ".//*[contains(text(), 'VLC-record.mp4')]")
	WebElement videoConfirmation;

	@FindBy(xpath = ".//*[contains(text(), 'ABc Responsability')]")
	WebElement responsabilityConfirmation;

	@FindBy(css = "a[href*='projects/new/active']")
	WebElement projectCardExisting;

	@FindBy(css = "a[href*='projects/new/funding']")
	WebElement projectCardFunding;

	@FindBy(xpath = "//input[@placeholder='Search or enter email to add people...']")
	WebElement addRespInvite;

	@FindBy(xpath = "//input[@placeholder='Search or enter email to add people...'")
	WebElement projectFundingInvite;

	@FindBy(xpath = "//input[@placeholder='Type to search...']")
	WebElement selectProjAssign;

	@FindBy(xpath = ".//button[@class='message btn-link']")
	WebElement inviteButto;

	@FindBy(xpath = ".//button[@class='btn btn-default select-file']")
	WebElement uploadFileButton;

	@FindBy(xpath = ".//*[@class='btn btn-green pull-right ember-view']")
	WebElement goToProjectButton;

	@FindBy(xpath = ".//*[@class='btn btn-green pull-right ember-view active']")
	WebElement goToProjectButtonF;

	@FindBy(xpath = ".//span[@class='title project pull-left']")
	WebElement projectVerification;

	@FindBy(xpath = ".//div[@class='error-msg'][contains(.,'Name')]")
	WebElement nameError;

	@FindBy(xpath = ".//div[@class='error-msg'][contains(.,'Title')]")
	WebElement titleError;

	@FindBy(xpath = ".//div[@class='error-msg'][contains(.,'Name is too short')]")
	WebElement nameShortError;

	@FindBy(xpath = ".//div[@class='error-msg'][contains(.,'Title is too short')]")
	WebElement titleShortError;

	@FindBy(xpath = ".//div[@class='error-msg'][contains(.,'Description')]")
	WebElement blankDescriptionError;

	@FindBy(xpath = ".//*[@class='btn btn-gray pull-right ember-view active']")
	WebElement cancelCreateProjectButton;

	@FindBy(css = "a[href*='projects/new']")
	WebElement createProjectButton;

	@FindBy(xpath = ".//*[@class='row list no-vacant-responsibilities-list']")
	WebElement cardVerification;

	@FindBy(xpath = ".//*[@class='btn btn-green'][contains(.,'No I')]")
	WebElement noIDontButton;

	@FindBy(xpath = ".//*[@class='btn-link'][contains(.,'Yes')]")
	WebElement yesCancelButton;

	@FindBy(xpath = ".//*[@class='btn btn-green pull-right heading-button ember-view']")
	WebElement responsibilityButton;

	@FindBy(xpath = "//input[@placeholder='Responsibility name']")
	WebElement responsibilityName;

	@FindBy(xpath = "//textarea[@placeholder='Description']")
	WebElement responsibilityDescription;

	@FindBy(xpath = ".//*[@class='btn btn-white btn-assign']")
	WebElement assignButton;
	@FindBy(xpath = ".//*[@class='btn btn-blue btn-assign']")
	WebElement assignButton2;

	/////////////////////////////////////////
	public CreateProject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void selectProjectRespo(String text) throws InterruptedException, AWTException {
		// js = (JavascriptExecutor) driver;
		// js.executeScript("arguments[0].click();", selectProjectRes);
		selectProjectRes.sendKeys(text);

	}

	public void setSelectProjectREs() {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", setSSS);
	}

	public void clickAssignButton() throws InterruptedException {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", assignButton);
		Thread.sleep(3000);
	}

	public void clickAssignButton2() {
		assignButton2.click();
	}

	public void setResponsibilityName(String text) {
		responsibilityName.sendKeys(text);
	}

	public void setProjectAssign(String text) throws InterruptedException, AWTException {
		selectProjAssign.sendKeys(text);
		Thread.sleep(3000);
	}

	public void setResponsibilityDescription(String text) {
		responsibilityDescription.sendKeys(text);
		;
	}

	public void clickResponsibilitiesLink() {
		responsibilitiesLink.click();
	}

	public void clickResponsibilitiesButton() {
		responsibilityButton.click();
	}

	public void clickUploadButton() throws AWTException, InterruptedException, FindFailed {
		uploadLogoButton.click();
		Thread.sleep(3000);
		Screen s = new Screen();
		s.click("src/resources/slika1.png");
		s.wait(0.5);
		s.click("src/resources/open3.png");
	}

	public void clickUploadVideoButton() throws AWTException, InterruptedException, FindFailed {
		uploadVideoButton.click();
		Thread.sleep(3000);
	}

	public void setVideoUpload() throws AWTException, InterruptedException, FindFailed {
		Screen s = new Screen();
		s.doubleClick("src/resources/videoPhoto.png");
	}

	public void clickUploadFileBtn() throws InterruptedException, FindFailed {
		uploadFileButton.click();
		Thread.sleep(2000);
	}

	public void uploadFileBtn() throws InterruptedException, FindFailed {
		Screen s = new Screen();
		s.click("src/resources/filePhoto.png");
		s.wait(0.5);
		s.click("src/resources/open3.png");
	}

	public void setProjectName(String pName) {
		projectNameExistingCreate.sendKeys(pName);
	}

	public void setProjectDescription(String pdesc) {
		projectDescription.sendKeys(pdesc);
	}

	public void setDate(String date) throws InterruptedException {
		datePicker.sendKeys(date);
		// Thread.sleep(3000);
	}

	public void setStartDate(String date) {
		datePickerStart.sendKeys(date);
	}

	public void getDateVerification() throws ParseException,FindFailed, InterruptedException, AWTException{
		String start = datePickerStart.getAttribute("value");
		String end = datePickerEnd.getAttribute("value");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = sdf.parse(start);
		Date date2 = sdf.parse(end);
		if (date1.compareTo(date2) > 0) {
			
			try{
				Assert.fail();
			}catch(UnhandledAlertException e ){
			    driver.switchTo().alert().dismiss();   
			}
		
		} else if (date1.compareTo(date2) < 0) {
			Reporter.log("|PASS  Start date is before End date", true);
		} else if (date1.compareTo(date2) == 0) {
			Reporter.log("|PASS  Start date is equal End date", true);
		}
		
	}
	public void closeAlert() throws FindFailed, AWTException{
	
		    try{
		        WebDriverWait wait = new WebDriverWait(driver, 2);
		        wait.until(ExpectedConditions.alertIsPresent());
		        Alert alert = driver.switchTo().alert();
		        alert.dismiss();
		       
		        }catch(NoAlertPresentException e){
		            // Do nothing :D
		        }catch(UnhandledAlertException e){     
		    }
	}

	public void setEndDate(String date) {
		datePickerEnd.sendKeys(date);
	}

	public void clickNext1() throws InterruptedException {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", nexButton1);
	}

	public void clickNextButtonFunding1() throws InterruptedException {
		// nexButtonFunding.click();
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", nexButtonFunding);
		Thread.sleep(2000);
	}

	public void setResponsibility(String resp) {
		responsibilityField.sendKeys(resp);
	}

	public void clickCreateNewResp() throws InterruptedException {
		Thread.sleep(4000);
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", createNewResponibilityButton);
	}

	public void setNewResponsabilityName(String respName) {
		responsabilityName.sendKeys(respName);
	}

	public void setProjectNameFunding(String Name) {
		projectNameFunding.sendKeys(Name);
	}

	public void setProjectWhyFunding(String text) {
		projectWhyFunding.sendKeys(text);
	}

	public void setProjectWhatFunding(String text) {
		projectWhatFunding.sendKeys(text);
	}

	public void setProjectHowFunding(String text) {
		projectHowFunding.sendKeys(text);
	}

	public void setResponsabilityDesc(String respDesc) {
		responsabilityDescription.sendKeys(respDesc);
	}

	public void clickSaveButton1() throws InterruptedException {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", saveButton1);
		Thread.sleep(2000);
	}

	public void clickSaveButton2() throws InterruptedException {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", saveButton2);
	}

	public void clickNext2() throws InterruptedException {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", nextButton2);
		Thread.sleep(1000);
	}

	public void clickAddPeopleResp() {
		addPeopleButt.click();
	}

	public void clickInviteButto() {
		inviteButt.click();
	}

	public void clickInviteButtonFunding() throws InterruptedException {
		// inviteButtonFunding.click();
		Thread.sleep(2000);
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", inviteButtonFunding);
	}

	public void clickProjectCard() {
		projectCardExisting.click();
	}

	public void clickProjectCardFunding() {
		projectCardFunding.click();
	}

	public void setRespInvite(String invite) {
		addRespInvite.sendKeys(invite);
	}

	public void setProjectInviteFunding(String invite) throws InterruptedException {
		projectFundingInvite.sendKeys(invite);
		Thread.sleep(2000);
	}

	public void setRespInvite2(String invite) throws InterruptedException {
		addRespInvite.sendKeys(invite);
		Thread.sleep(2000);
	}

	public void clickInviteButton() throws InterruptedException {
		Thread.sleep(2000);
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", inviteButto);
	}

	public void setSelectPeopleR() {
		selectPeopleR.click();
	}
	//////////////////

	public void setSelectPeopleProjectFunding() {
		// selectPeopleF.click();
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", selectPeopleF);
	}

	public void clickUploadFileButton() throws InterruptedException, AWTException, FindFailed {
		// Thread.sleep(1000);
		Screen s = new Screen();
		// s.click("src/resources/documents.png");
		// s.click("src/resources/xxx.png");
		// s.click("src/resources/open3.png");
		s.click("src/resources/filePhoto.png");
		s.wait(0.5);
		s.click("src/resources/open3.png");
	}

	public void clickGotToProjectButton() throws InterruptedException {
		Thread.sleep(3000);
		goToProjectButton.click();
	}

	public void clickGotToProjectButtonF() throws InterruptedException {
		Thread.sleep(3000);
		goToProjectButtonF.click();
	}

	public void projectCreateVerification() {
		String actual = projectVerification.getText();
		System.out.println(actual);
		String expected = "Project Test 22";
		 Assert.assertEquals(actual, expected);

		if (actual.equals(expected)) {
			Reporter.log("|PASS  Verifying that Existing Project is Created");
		} else {
			Reporter.log("|FAIL  Verifying that Existing Project is Created", true);
		}
		Reporter.log("Actual value = " + actual, true);
		Reporter.log("|Expected value = " + expected, true);
	}

	public void videoVerification() {
		String actual = videoConfirmation.getText();
		System.out.println(actual);
		String expected = "VLC-record.mp4";
		 Assert.assertEquals(actual, expected);

		if (actual.equals(expected)) {
			Reporter.log("|PASS  Verifying Video file is Uploaded");
		} else {
			Reporter.log("|FAIL  Verifying Video file is Uploaded", true);
		}
		Reporter.log("Actual value = " + actual, true);
		Reporter.log("|Expected value = " + expected, true);
	}

	public void responsabilityVerification() {
		String actual = responsabilityConfirmation.getText();
		System.out.println(actual);
		String expected = "ABc Responsability";
		Assert.assertEquals(actual, expected);
		if (actual.equals(expected)) {
			Reporter.log("|PASS  Verifying Responsibility is created");
		} else {
			Reporter.log("|FAIL  Verifying Responsibility is created", true);
		}
		Reporter.log("Actual value = " + actual, true);
		Reporter.log("|Expected value = " + expected, true);
	}

	public void fundingProjectCreateVerification() {
		String actual = projectVerification.getText();
		System.out.println(actual);
		String expected = "Funding Project";
		 Assert.assertEquals(actual, expected);
		if (actual.equals(expected)) {
			Reporter.log("|PASS  Verifying Funding Project is created");
		} else {
			Reporter.log("|FAIL  Verifying Funding Project is created", true);
		}
		Reporter.log("Actual value = " + actual, true);
		Reporter.log("|Expected value = " + expected, true);

	}

	public void blankTitleError1() {
		String actual_error = titleError.getText();
		System.out.println(actual_error);
		String expected_error = "Title can't be blank";
		 Assert.assertEquals(actual_error, expected_error);
		if (actual_error.equals(actual_error)) {
			Reporter.log("|PASS  Verifying accurate message is displayed");
		} else {
			Reporter.log("|FAIL  Verifying accurate message is displayed", true);
		}
		Reporter.log("Actual value = " + actual_error, true);
		Reporter.log("|Expected value = " + expected_error, true);
	}

	public void blankTitleError2() {
		String actual_error = titleShortError.getText();
		System.out.println(actual_error);
		String expected_error = "Title is too short (minimum is 3 characters)";
		 Assert.assertEquals(actual_error, expected_error);
		if (actual_error.equals(actual_error)) {
			Reporter.log("|PASS  Verifying accurate message is displayed");
		} else {
			Reporter.log("|FAIL  Verifying accurate message is displayed", true);
		}
		Reporter.log("Actual value = " + actual_error, true);
		Reporter.log("|Expected value = " + expected_error, true);
	}

	public void blankNameError1() {
		String actual_error = nameError.getText();
		System.out.println(actual_error);
		String expected_error = "Name can't be blank";
		 Assert.assertEquals(actual_error, expected_error);
		if (actual_error.equals(actual_error)) {
			Reporter.log("|PASS  Verifying accurate message is displayed");
		} else {
			Reporter.log("|FAIL  Verifying accurate message is displayed", true);
		}
		Reporter.log("Actual value = " + actual_error, true);
		Reporter.log("|Expected value = " + expected_error, true);
	}

	public void blankNameError2() {
		String actual_error = nameShortError.getText();
		System.out.println(actual_error);
		String expected_error = "Name is too short (minimum is 3 characters)";
		 Assert.assertEquals(actual_error, expected_error);
		if (actual_error.equals(actual_error)) {
			Reporter.log("|PASS  Verifying accurate message is displayed");
		} else {
			Reporter.log("|FAIL  Verifying accurate message is displayed", true);
		}
		Reporter.log("Actual value = " + actual_error, true);
		Reporter.log("|Expected value = " + expected_error, true);
	}

	public void blankDescriptionError() {
		String actual_error = blankDescriptionError.getText();
		System.out.println(actual_error);
		String expected_error = "Description can't be blank";
		 Assert.assertEquals(actual_error, expected_error);
		if (actual_error.equals(actual_error)) {
			Reporter.log("|PASS  Verifying accurate message is displayed");
		} else {
			Reporter.log("|FAIL  Verifying accurate message is displayed", true);
		}
		Reporter.log("Actual value = " + actual_error, true);
		Reporter.log("|Expected value = " + expected_error, true);
	}

	public void clickCancelCreateProject() {
		cancelCreateProjectButton.click();
	}

	public void cancelProjectVerificationWithoutInputs() {
		String actual = createProjectButton.getText();
		String expected = "Create Project";
		 Assert.assertEquals(actual, expected);
		if (actual.equals(expected)) {
			Reporter.log("|PASS  Verifying project is canceled");
		} else {
			Reporter.log("|FAIL  Verifying project is canceled", true);
		}
		Reporter.log("Actual value = " + actual, true);
		Reporter.log("|Expected value = " + expected, true);
	}

	public void clickNoIDont() {
		noIDontButton.click();
	}

	public void cancelProjectWithInputsVerification() {
		String actual = projectName.getAttribute("value");
		String expected = "Project Test 1234";
		 Assert.assertEquals(actual, expected);
		if (actual.equals(expected)) {
			Reporter.log("|PASS  Verifying project is canceled");
		} else {
			Reporter.log("|FAIL  Verifying project is canceled", true);
		}
		Reporter.log("Actual value = " + actual, true);
		Reporter.log("|Expected value = " + expected, true);
	}

	public void cancelProjectWithInputsVerification2() {
		String actual = verifivation2.getText();
		String expected = "Create Existing Project";
		Assert.assertEquals(actual, expected);
		if (actual.equals(expected)) {
			Reporter.log("|PASS  Verifying project is canceled");
		} else {
			Reporter.log("|FAIL  Verifying project is canceled", true);
		}
		Reporter.log("Actual value = " + actual, true);
		Reporter.log("|Expected value = " + expected, true);
	}

	public void clickYesCancel() {
		yesCancelButton.click();
	}
}
