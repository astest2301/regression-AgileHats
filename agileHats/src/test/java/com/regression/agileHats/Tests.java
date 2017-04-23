package com.regression.agileHats;

import java.awt.AWTException;
import java.io.IOException;
import java.text.ParseException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.sikuli.script.FindFailed;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Tests {
	WebDriver driver;
	private String baseUrl;
	Login searchPage;
	SearchFuncionality search;
	registerPage register;
	ForgotPassword forgot;
	CreateProject create;
	final String randomEmail = null;
	final String randomEmail2 = null;
	ExtentReports report;
	ExtentTest test;

	@Parameters("browserType")
	@BeforeClass
	public void beforeClass(String browser) {
		if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "/home/anita/Desktop/geckodriver/geckodriver");
			driver = new FirefoxDriver();
			report = new ExtentReports("/home/anita/Desktop/agileHatsFireFox.html");
		}
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/home/anita/Desktop/chromedriver99/chromedriver");						
			driver = new ChromeDriver();
			report = new ExtentReports("/home/anita/Desktop/agileHatsChrome.html");
		}
		searchPage = new Login(driver);
		register = new registerPage(driver);
		search = new SearchFuncionality(driver);
		forgot = new ForgotPassword(driver);
		create = new CreateProject(driver);
		baseUrl = "http://ah-test.abhapp.com";
		// report = new ExtentReports("/home/anita/Desktop/regressionAH.html");
		test = report.startTest("Agile Hats Regression Tests");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get(baseUrl);
		test.log(LogStatus.INFO, "Application Starting...");
	}

	@Test(groups = { "Login" }, priority = 0)
	public void loginBlankEmailAndPassword() throws InterruptedException {
		test.log(LogStatus.INFO, "-------------   LOGIN  PAGE  TESTS  --------------");
		test.log(LogStatus.INFO, "BLANK PASSWORD AND EMAIL");
		test.log(LogStatus.INFO, "Expected = Email can't be blank");
		test.log(LogStatus.INFO, "Expected = Password can't be blank");
		driver.get(baseUrl + "/login");
		searchPage.clearLoginFields();
		searchPage.setEmail("");
		searchPage.setPassword("");
		searchPage.slickLoginButton();
		searchPage.emailError();
		searchPage.passwordError();
	}

	@Test(groups = { "Login" }, priority = 1)
	public void loginBlankEmail() throws InterruptedException {
		test.log(LogStatus.INFO, "BLANK EMAIL");
		test.log(LogStatus.INFO, "Expected = Email can't be blank");
		searchPage.clearLoginFields();
		searchPage.setEmail("");
		searchPage.setPassword("matejsvoboda");
		searchPage.slickLoginButton();
		searchPage.emailError();
		test.log(LogStatus.INFO, "Blank Email Test");
	}

	@Test(groups = { "Login" }, priority = 2)
	public void LoginBlankPassword() throws InterruptedException {
		test.log(LogStatus.INFO, "BLANK PASSWORD");
		test.log(LogStatus.INFO, "Expected = Password can't be blank");
		searchPage.clearLoginFields();
		searchPage.setEmail("blabla3@gmail.com");
		searchPage.setPassword("");
		searchPage.slickLoginButton();
		searchPage.passwordError();
	}

	@Test(groups = { "Login" }, priority = 3)
	public void LoginInvalidEmail() throws InterruptedException {
		test.log(LogStatus.INFO, "NOT EXISTING EMAIL");
		test.log(LogStatus.INFO, "Expected = Wrong email or password.");
		searchPage.clearLoginFields();
		searchPage.setEmail("blabla563233@gmail.com");
		searchPage.setPassword("matejsvoboda");
		searchPage.slickLoginButton();
		searchPage.wrongError();
	}

	@Test(groups = { "Login" }, priority = 4)
	public void LoginInvalidPassword() throws InterruptedException {
		test.log(LogStatus.INFO, "INVALID PASSWORD");
		test.log(LogStatus.INFO, "Expected = Wrong email or password.");
		searchPage.clearLoginFields();
		searchPage.setEmail("blabla3@gmail.com");
		searchPage.setPassword("fgsdhfghf");
		searchPage.slickLoginButton();
		searchPage.wrongError();
	}

	@Test(groups = { "Login" }, priority = 5)
	public void LoginInvalidPasswordAndEmail() throws InterruptedException {
		test.log(LogStatus.INFO, "INVALID PASSWORD AND EMAIL");
		test.log(LogStatus.INFO, "Expected = Wrong email or password.");
		searchPage.clearLoginFields();
		searchPage.setEmail("invalid@gmail.com");
		searchPage.setPassword("invalid");
		searchPage.slickLoginButton();
		searchPage.wrongError();
	}

	@Test(groups = { "Login" }, priority = 6)
	public void LoginInvalidPasswordAndBlankEmail() throws InterruptedException {
		test.log(LogStatus.INFO, "INVALID PASSWORD AND BLANK EMAIL");
		test.log(LogStatus.INFO, "Expected = Wrong email or password.");
		searchPage.clearLoginFields();
		searchPage.setEmail("");
		searchPage.setPassword("invalid");
		searchPage.slickLoginButton();
		searchPage.emailError();
	}

	@Test(groups = { "Login" }, priority = 7)
	public void LoginInvalidEmailAndBlankPassword() throws InterruptedException {
		test.log(LogStatus.INFO, "INVALID EMAIL AND BLANK PASSWORD");
		test.log(LogStatus.INFO, "Expected = Wrong email or password.");
		searchPage.clearLoginFields();
		searchPage.setEmail("invalid");
		searchPage.setPassword("");
		searchPage.slickLoginButton();
		searchPage.passwordError();
	}

	@Test(groups = { "Login" }, priority = 8)
	public void LoginValidEmailAndPassword() throws InterruptedException {
		test.log(LogStatus.INFO, "VALID LOGIN");
		test.log(LogStatus.INFO, "Expected = blabla4@gmail.com");
		driver.get(baseUrl + "/login");
		searchPage.clearLoginFields();
		searchPage.setEmail("blabla4@gmail.com");
		searchPage.setPassword("matejsvoboda");
		searchPage.slickLoginButton();
		searchPage.clickLogOut();
		searchPage.clickLogOutButton();
	}

	@Test(groups = { "Edit Profile" }, priority = 9)
	public void EditProfile() throws InterruptedException, AWTException, FindFailed {
		test.log(LogStatus.INFO, "EDIT PROFILE");
		test.log(LogStatus.INFO, "Expected = skype accaunt");
		test.log(LogStatus.INFO, "Expected = 123456");
		driver.get(baseUrl + "/login");
		searchPage.clearLoginFields();
		searchPage.setEmail("abcbbd332@gmail.com");
		searchPage.setPassword("matejsvoboda");
		searchPage.slickLoginButton();
		//searchPage.clickAddProfilePhotoButton();
		//searchPage.selectPhoto();
		
		//searchPage.clickSaveButton();
		searchPage.clickEditButton();// new acc for add!!!!!
		searchPage.clearPhoneField();
		searchPage.addPhone("123456");
		searchPage.clearSkypeField();
		searchPage.addSkype("skype accaunt");
		searchPage.done();
		searchPage.verifyPhoneEdit();
		searchPage.verifySkypeEdit();
		searchPage.clickLogOut();
		searchPage.clickLogOutButton();
	}
/*
	@Test(groups = { "Register Employee" }, priority = 10)
	public void registerEmployeeValid() throws InterruptedException, AWTException, FindFailed {
		test.log(LogStatus.INFO, "------------   REGISTER  TESTS  -------------");
		test.log(LogStatus.INFO, "REGISTER EMPLOYEE VALID");
		test.log(LogStatus.INFO, "Expected = You are waiting for acceptance");
		driver.get(baseUrl + "/register");
		register.setFirstNameR("First Name");
		register.setLastNameR("Last Name");
		register.setEmailR(randomEmail);
		register.setPasswordR("pass123");
		register.confirmPasswordR("pass123");
		register.clickSignUp();
		//Thread.sleep(8000);
		register.selectCompany();
		System.out.println("company selected");
		register.clickJoinButton();
		
		System.out.println("join clicked");
		register.clickOKGreatButton();
		register.registerConfirmation();
		register.clickLogOutButton();
	}*/

	@Test(groups = { "Register Employee" }, priority = 11)
	public void blankFields() {
		test.log(LogStatus.INFO, "BLANK FIELDS");
		test.log(LogStatus.INFO, "Expected = Firstname can't be blank");
		test.log(LogStatus.INFO, "Expected = Lastname can't be blank");
		test.log(LogStatus.INFO, "Expected = Email can't be blank");
		test.log(LogStatus.INFO, "Expected = Password can't be blank");
		driver.get(baseUrl + "/register");
		// searchPage.clickAccLink();
		register.clickSignUp();
		register.firstnameErrorRegistration();
		register.lastnameErrorRegistration();
		register.emailErrorRegistration();
		register.passwordErrorRegistration();
	}

	@Test(groups = { "Register Employee" }, priority = 12)
	public void invalidPasswordConfirmation() {
		test.log(LogStatus.INFO, "INVALID PASSWORD CONFIRMATION");
		test.log(LogStatus.INFO, "Expected = Password confirmation doesn't match password");
		driver.get(baseUrl + "/register");
		register.clearRegistrationFields();
		register.setFirstNameR("First Name");
		register.setLastNameR("Last Name");
		searchPage.setEmail("blabla3@gmail.com");
		register.setPasswordR("pass123");
		register.confirmPasswordR("hgoherh");
		register.clickSignUp();
		register.passwordConfErrorRegistration();
	}

	@Test(groups = { "Register Employee" }, priority = 13)
	public void passConfirmCaseSensitive() {
		test.log(LogStatus.INFO, "PASSWORD CASE SENSITIV");
		test.log(LogStatus.INFO, "Expected = Password confirmation doesn't match password");
		driver.get(baseUrl + "/register");
		register.clearRegistrationFields();
		register.setFirstNameR("First Name");
		register.setLastNameR("Last Name");
		searchPage.setEmail("blabla3@gmail.com");
		register.setPasswordR("pass123");
		register.confirmPasswordR("PASS123");
		register.clickSignUp();
		register.passwordConfErrorRegistration();
	}

	@Test(groups = { "Register Employee" }, priority = 14)
	public void invalidEmailFormat() {
		test.log(LogStatus.INFO, "INVALID EMAIL FORMAT");
		test.log(LogStatus.INFO, "Expected = Email is invalid");
		driver.get(baseUrl);
		register.clickAccLink();
		register.clearRegistrationFields();
		register.setFirstNameR("First Name");
		register.setLastNameR("Last Name");
		searchPage.setEmail("test1cgdctmail.com");
		register.setPasswordR("pass123");
		register.confirmPasswordR("pass123");
		register.clickSignUp();
		register.emailInvalidFormatRegistration();
	}

	@Test(groups = { "Register Employee" }, priority = 15)
	public void takenEmail() {
		test.log(LogStatus.INFO, "TAKEN EMAIL");
		test.log(LogStatus.INFO, "Expected = Email has already been taken");
		driver.get(baseUrl + "/register");
		register.clearRegistrationFields();
		register.setFirstNameR("First Name");
		register.setLastNameR("Last Name");
		searchPage.setEmail("blabla3@gmail.com");
		register.setPasswordR("pass123");
		register.confirmPasswordR("pass123");
		register.clickSignUp();
		register.takenEmailRegistration();
	}

	@Test(groups = { "Register Company" }, priority = 16)
	public void registerCompanyValid() throws AWTException, InterruptedException, FindFailed {
		test.log(LogStatus.INFO, "REGISTER COMPANY VALID");
		test.log(LogStatus.INFO, "Expected = *Match Random Email");
		driver.get(baseUrl + "/register");
		register.clearRegistrationFields();
		register.clickCompanyTab();
		register.setFirstNameR("First");
		register.setLastNameR("Last");
		register.setEmailR2(randomEmail2);
		register.setPasswordR("pass123");
		register.confirmPasswordR("pass123");
		register.clickSignUp();
		register.clickSelectFileButton2();
		register.selectPhoto();
		register.setCompanyName("Company Name");
		register.setEmployees(5);
		register.clickCreateCompanySpaceButton();
		register.setEmailCompany("test1@gmail.com");
		register.clickAddButtonCompany();
		register.clickInviteCreateCompanyButton();
		register.clickPeopleCard();
		register.registerVerification3();
		register.clickLogOut();
		register.clickLogOutButton();
	}

	@Test(groups = { "Register Company" }, priority = 17)
	public void companyBlankFields() {
		test.log(LogStatus.INFO, "BLANK FIELDS");
		test.log(LogStatus.INFO, "Expected = Firstname can't be blank");
		test.log(LogStatus.INFO, "Expected = Lastname can't be blank");
		test.log(LogStatus.INFO, "Expected = Email can't be blank");
		test.log(LogStatus.INFO, "Expected = Password can't be blank");
		driver.get(baseUrl + "/register");
		register.clearRegistrationFields();
		register.clickCompanyTab();
		register.clickSignUp();
		register.firstnameErrorRegistration();
		register.lastnameErrorRegistration();
		register.emailErrorRegistration();
		register.passwordErrorRegistration();
	}

	@Test(groups = { "Search" }, priority = 18)
	public void validSearchResultTest() throws InterruptedException, AWTException {
		test.log(LogStatus.INFO, "-------------   SEARCH  TESTS  --------------");
		test.log(LogStatus.INFO, "CORRECT SEARCH RESULT");
		test.log(LogStatus.INFO, "Expected = 5");
		driver.get(baseUrl + "/login");
		searchPage.clearLoginFields();
		searchPage.setEmail("blabla3@gmail.com");
		searchPage.setPassword("matejsvoboda");
		searchPage.slickLoginButton();
		Thread.sleep(2000);
		search.setSearchItem("funding");
		Thread.sleep(12000);
		search.searchResults();
		searchPage.clickLogOut();
		searchPage.clickLogOutButton();
	}

	@Test(groups = { "Search" }, priority = 19)
	public void removeButtonTest() throws InterruptedException, AWTException {
		test.log(LogStatus.INFO, "SEARCH REMOVE BUTTON TEST");
		test.log(LogStatus.INFO, "Expected = *blank field");
		driver.get(baseUrl + "/login");
		searchPage.clearLoginFields();
		searchPage.setEmail("blabla3@gmail.com");
		searchPage.setPassword("matejsvoboda");
		searchPage.slickLoginButton();
		Thread.sleep(2000);
		search.setSearch("funding");
		search.clickRemoveButton();
		search.removeVerification();
		searchPage.clickLogOut();
		searchPage.clickLogOutButton();
	}

	@Test(groups = { "Search" }, priority = 20)
	public void searchCaseSensitive() throws InterruptedException, AWTException {
		test.log(LogStatus.INFO, "SEARCH CASE SENSITIVE");
		test.log(LogStatus.INFO, "Expected = 5");
		driver.get(baseUrl + "/login");
		searchPage.clearLoginFields();
		searchPage.setEmail("blabla3@gmail.com");
		searchPage.setPassword("matejsvoboda");
		searchPage.slickLoginButton();
		search.setSearchItem("FUNDING");
		Thread.sleep(12000);
		search.searchResults();
		searchPage.clickLogOut();
		searchPage.clickLogOutButton();
	}

	@Test(groups = { "Search" }, priority = 21)
	public void searchResultLinkTest() throws InterruptedException, AWTException {
		test.log(LogStatus.INFO, "SEARCH RESULTS LINK TEST");
		test.log(LogStatus.INFO, "Expected = Funding Project 1");
		driver.get(baseUrl + "/login");
		searchPage.clearLoginFields();
		searchPage.setEmail("blabla3@gmail.com");
		searchPage.setPassword("matejsvoboda");
		searchPage.slickLoginButton();
		search.setSearchItem("funding");
		Thread.sleep(12000);
		search.searchResults();
		search.clickSearchLink();
		register.projectLinkVerification();
		searchPage.clickLogOut();
		searchPage.clickLogOutButton();
	}

	@Test(groups = { "Search" }, priority = 22)
	public void searchTrimTest() throws InterruptedException, AWTException {
		test.log(LogStatus.INFO, "SEARCH RESULTS TRIM TEST");
		test.log(LogStatus.INFO, "Expected = 5");
		driver.get(baseUrl + "/login");
		searchPage.clearLoginFields();
		searchPage.setEmail("blabla3@gmail.com");
		searchPage.setPassword("matejsvoboda");
		searchPage.slickLoginButton();
		Thread.sleep(2000);
		search.setSearchItem("    funding   ");
		Thread.sleep(12000);
		search.searchResults();
		searchPage.clickLogOut();
		searchPage.clickLogOutButton();
	}

	@Test(groups = { "Create Existing Project" }, priority = 23)
	public void createProjectValid() throws AWTException, InterruptedException, FindFailed {
		test.log(LogStatus.INFO, "------------   CREATE  PROJECT  TESTS  ------------");
		test.log(LogStatus.INFO, "CREATE EXISTING PROJECT");
		test.log(LogStatus.INFO, "Expected = Project Test 22");
		driver.get(baseUrl + "/login");
		searchPage.clearLoginFields();
		searchPage.setEmail("abcbbd332@gmail.com");
		searchPage.setPassword("matejsvoboda");
		searchPage.slickLoginButton();
		register.clickProjectsLink();
		register.clickCreateProjectButton();
		create.clickProjectCard();
		create.clickUploadButton();
		searchPage.clickSaveButton();
		create.setProjectName("Project Test 22");
		create.setProjectDescription("Project Description....");
		create.setDate("2017-02-21");
		create.clickNext1();
		System.out.println("buton next clicked");
		create.clickCreateNewResp();
		create.setNewResponsabilityName("New Responsability");
		create.setResponsabilityDesc("Responsability Description....");
		create.clickSaveButton1();
		create.clickAddPeopleResp();
		create.setRespInvite("test123@gmail.com");
		create.clickInviteButton();
		create.setSelectPeopleR();
		create.clickSaveButton2();
		System.out.println("buton save clicked");
		create.clickNext2();
		create.clickUploadFileBtn();
		create.uploadFileBtn();
		create.clickGotToProjectButton();
		create.projectCreateVerification();
		searchPage.clickLogOut();
		searchPage.clickLogOutButton();
	}

	@Test(groups = { "Create Existing Project" }, priority = 24)
	public void createProjectBlankFields() throws AWTException, InterruptedException {
		test.log(LogStatus.INFO, "BLANK FIELDS");
		test.log(LogStatus.INFO, "Expected = Name can't be blank");
		test.log(LogStatus.INFO, "Expected = Name is too short (minimum is 3 characters)");
		test.log(LogStatus.INFO, "Expected = Description can't be blank");
		driver.get(baseUrl + "/login");
		searchPage.clearLoginFields();
		searchPage.setEmail("abcbbd332@gmail.com");
		searchPage.setPassword("matejsvoboda");
		searchPage.slickLoginButton();
		register.clickProjectsLink();
		register.clickCreateProjectButton();
		create.clickProjectCard();
		create.clickNext1();
		create.blankNameError1();
		create.blankNameError2();
		create.blankDescriptionError();
		searchPage.clickLogOut();
		searchPage.clickLogOutButton();
	}

	@Test(groups = { "Create Existing Project" }, priority = 25)
    public void cancelCreateProjectWithNoInputs() throws AWTException, InterruptedException{
		test.log(LogStatus.INFO, "CANCEL PROJECT WITH NO INPUTS");
		test.log(LogStatus.INFO, "Expected = *Create Project Button avaliable");
		driver.get(baseUrl + "/login");
		searchPage.clearLoginFields();
		searchPage.setEmail("abcbbd332@gmail.com");
		searchPage.setPassword("matejsvoboda");
		searchPage.slickLoginButton();
		register.clickProjectsLink();
		register.clickCreateProjectButton();
		create.clickProjectCard();
		create.clickCancelCreateProject();
		create.cancelProjectVerificationWithoutInputs();
		searchPage.clickLogOut();
		searchPage.clickLogOutButton();
	}
	
	@Test(groups = { "Create Funding Project" }, priority = 27)
    public void createFundingProjectValid() throws AWTException, InterruptedException, FindFailed{
		test.log(LogStatus.INFO, "CREATE FUNDING PROJECT VALID");
		test.log(LogStatus.INFO, "Expected = Funding Project");
		driver.get(baseUrl + "/login");
		searchPage.clearLoginFields();
		searchPage.setEmail("abcbbd332@gmail.com");
		searchPage.setPassword("matejsvoboda");
		searchPage.slickLoginButton();
		register.clickProjectsLink();
		register.clickCreateProjectButton();
		register.clickFunding();
		create.setProjectNameFunding("Funding Project");
		create.setProjectWhyFunding("Why text...");
		create.setProjectWhatFunding("What text...");
		create.setProjectHowFunding("How text...");
		create.setStartDate("2017-02-27");
		create.setEndDate("2018-02-27");
		create.clickNextButtonFunding1();
		create.setSelectPeopleProjectFunding();
		create.clickNext2();
		create.clickCreateNewResp();
		create.setNewResponsabilityName("New 22222 Responsability");
		create.setResponsabilityDesc("Responsability Description....");
		create.clickSaveButton2();
        create.clickNext2();
        create.clickUploadFileBtn();
		create.clickUploadFileButton();
		create.clickGotToProjectButtonF();
		create.fundingProjectCreateVerification();
		searchPage.clickLogOut();
		searchPage.clickLogOutButton();
	}
	
	@Test(groups = { "Create Funding Project" }, priority = 28)
    public void VideoUploadTEST() throws AWTException, InterruptedException, FindFailed{
		test.log(LogStatus.INFO, "VIDEO UPLOAD TEST");
		test.log(LogStatus.INFO, "Expected = VLC-record.mp4");
		driver.get(baseUrl + "/login");
		searchPage.clearLoginFields();
		searchPage.setEmail("abcbbd332@gmail.com");
		searchPage.setPassword("matejsvoboda");
		searchPage.slickLoginButton();
		register.clickProjectsLink();
		register.clickCreateProjectButton();
		register.clickFunding();
		create.clickUploadVideoButton();
		create.setVideoUpload();
		create.videoVerification();
		create.setProjectNameFunding("Funding Project");
		create.setProjectWhyFunding("Why text...");
		create.setProjectWhatFunding("What text...");
		create.setProjectHowFunding("How text...");
		create.setStartDate("2017-02-27");
		create.setEndDate("2018-02-27");
		create.clickNextButtonFunding1();
	    create.clickNext2();
	    create.clickNext2();
		searchPage.clickLogOut();
		searchPage.clickLogOutButton();
	}
	@Test(groups = { "Create Responsibility" }, priority = 29)
    public void createResponsibilityValid() throws AWTException, InterruptedException{
		test.log(LogStatus.INFO, "------------   CREATE  RESPONSABILITY  TESTS  ------------");
		test.log(LogStatus.INFO, "CREATE RESPONSABILITY");
		test.log(LogStatus.INFO, "Expected = ABc Responsability");
		driver.get(baseUrl + "/login");
		searchPage.clearLoginFields();
		searchPage.setEmail("abcbbd332@gmail.com");
		searchPage.setPassword("matejsvoboda");
		searchPage.slickLoginButton();
		create.clickResponsibilitiesLink();
		create.clickResponsibilitiesButton();
		create.setResponsibilityName("ABc Responsability");
		create.setResponsibilityDescription("Responsibility Description...");
		create.clickSaveButton2();
		create.responsabilityVerification();
		searchPage.clickLogOut();
		searchPage.clickLogOutButton();
	}
	
	@Test(groups = { "Create Responsibility" }, priority = 30)
    public void createResponsibilityBlankFields() throws AWTException, InterruptedException{
		test.log(LogStatus.INFO, "CREATE RESPONSABILITY BLANK FIELDS");
		test.log(LogStatus.INFO, "Expected = Name can't be blank");
		test.log(LogStatus.INFO, "Expected = Name is too short (minimum is 3 characters)");
		driver.get(baseUrl + "/login");
		searchPage.clearLoginFields();
		searchPage.setEmail("abcbbd332@gmail.com");
		searchPage.setPassword("matejsvoboda");
		searchPage.slickLoginButton();
		create.clickResponsibilitiesLink();
		create.clickResponsibilitiesButton();
		create.setResponsibilityName("");
		create.clickSaveButton2();
		create.blankTitleError1();
		create.blankTitleError2();
		searchPage.clickLogOut();
		searchPage.clickLogOutButton();
	}
	
	@Test(groups = { "Create Responsibility" }, priority = 31)
    public void createResponsibilityLessThanMinCharacters() throws AWTException, InterruptedException{
		test.log(LogStatus.INFO, "CREATE RESPONSABILITY LESS THAN MINIMUM CHARACTERS");
		test.log(LogStatus.INFO, "Expected = Name is too short (minimum is 3 characters)");
		driver.get(baseUrl + "/login");
		searchPage.clearLoginFields();
		searchPage.setEmail("abcbbd332@gmail.com");
		searchPage.setPassword("matejsvoboda");
		searchPage.slickLoginButton();
		create.clickResponsibilitiesLink();
		create.clickResponsibilitiesButton();
		create.setResponsibilityName("Fo");
		create.clickSaveButton2();
		create.blankTitleError2();
		searchPage.clickLogOut();
		searchPage.clickLogOutButton();
	}
	
	@Test(groups = { "Forgot Password Check" }, priority = 32)
    public void forgotPasswordNonExistingUser() {
		test.log(LogStatus.INFO, "------------   FORGOT  PASSWORD  TESTS  -------------");
		test.log(LogStatus.INFO, "FORGOT PASSWORD FOR NON EXISTING USER");
		test.log(LogStatus.INFO, "Couldn't find User.");
		driver.get(baseUrl + "/login");
		forgot.clickForgotPasswordLink();
		forgot.setEmail("gdgdfg@gmail.com");
		forgot.clickSendButton();
		forgot.userError();
	}
	
	@Test(groups = { "Forgot Password Check" }, priority = 33)
    public void forgotPasswordTest() throws AWTException, InterruptedException{
		test.log(LogStatus.INFO, "FORGOT PASSWORD TEST");
		test.log(LogStatus.INFO, "You will receive email with link to reset your password");
		driver.get(baseUrl + "/login");
		forgot.clickForgotPasswordLink();
		forgot.setEmail("testabh1234@gmail.com");
		forgot.clickSendButton();
		forgot.clickOKButton();
	}
		
	@Test(groups = { "Failed Tests" }, priority = 34)
    public void LoginDependentMethod() throws InterruptedException, FindFailed{
		test.log(LogStatus.INFO, "LOGIN METHOD - dependent");
		test.log(LogStatus.INFO, "*Dependent method");	
		searchPage.clearLoginFields();
		searchPage.setEmail("blabla4@gmail.com");
		searchPage.setPassword("matejsvoboda");
		searchPage.slickLoginButton();	
		register.clickProjectsLink();
	}
	
	
	@Test(dependsOnMethods = {"LoginDependentMethod"},groups = { "Failed Tests" }, priority = 35)
    public void CheckLogout2() {
		test.log(LogStatus.INFO, "VERIFY USER IS LOGED OUT WHEN BROWSER IS CLOSED");
		test.log(LogStatus.INFO, "*Login button shoul be avaliable");
		driver.get(baseUrl + "/login");		
		searchPage.checkForLoginButton();
	}
	@Test(groups = { "Logout" }, priority = 36)
    public void LogOut1() {
		test.log(LogStatus.INFO, "*Loginng Out...");
		driver.get(baseUrl + "/login");
		searchPage.clickLogOut();
		searchPage.clickLogOutButton();		
	}
	
	@Test(groups = { "Failed Tests" }, priority = 37)
    public void DateTest() throws AWTException, InterruptedException, ParseException, FindFailed{
    test.log(LogStatus.INFO, "------------   FAILED TESTS  -------------");
		test.log(LogStatus.INFO, "START AND END DATE TEST");
		test.log(LogStatus.INFO, "*Start date should be before End date");
		driver.get(baseUrl + "/login");
		searchPage.clearLoginFields();
		searchPage.setEmail("abcbbd332@gmail.com");
		searchPage.setPassword("matejsvoboda");
		searchPage.slickLoginButton();
		register.clickProjectsLink();
		register.clickCreateProjectButton();
		register.clickFunding();
		create.setProjectNameFunding("Funding Project");
		create.setProjectWhyFunding("Why text...");
		create.setProjectWhatFunding("What text...");
		create.setProjectHowFunding("How text...");
		create.setStartDate("2017-02-27");
		create.setEndDate("2011-02-27");
		test.log(LogStatus.INFO, "Aplication is closing...");
		create.getDateVerification();
        driver.switchTo().alert().accept();
		 		
	}
	

	@AfterMethod
	public void writeResult(ITestResult result) throws IOException
	{	   
	        if(result.getStatus() == ITestResult.SUCCESS)
	        {
	        	test.log(LogStatus.PASS, "PASS");
	        	Reporter.log("PASS");
	        }
	        else if(result.getStatus() == ITestResult.FAILURE)
	        {
	        	test.log(LogStatus.FAIL, "FAIL");
	        	Reporter.log("FAIL");
	        	String path = Screenshots.takeScreenshot(driver, result.getName());
				String imagePath = test.addScreenCapture(path);
				test.log(LogStatus.FAIL, "FAIL", imagePath);
	        }
	        else if(result.getStatus() == ITestResult.SKIP)
	        {
	        	test.log(LogStatus.FAIL, "SKIP");
	        	Reporter.log("SKIP");
	        }	       
	}

	
	
	  @AfterClass
	  public void close(){ 
		 
		  searchPage.after(); 
		  report.endTest(test);
		  report.flush();
		  
	 }
}
//d1e60fd06ac24709ac4d870188e5489f

