package stepDefinitions;

import java.io.IOException;
import java.util.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebElement;
import base.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.CarDetailsPage;
import pages.HomePage;
import pages.SearchPageOfCar;
import pages.SignupPage;
import utilities.ExcelReader;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class looking_car_wth_successfully extends Base{

	  HomePage homePge = new HomePage(driver);
	  SearchPageOfCar searchPage = new SearchPageOfCar(driver);
      CarDetailsPage carDetailsPage = new CarDetailsPage(driver);
      SignupPage signUpPage = new SignupPage(driver);
	String email;
	String password;
	String confirmPassword;
	String userName;
	String firstName;
	String lastName;
	String mobileNumber;
	String whatsappNumber;
	String district;
	String thana;

	   @Given("I am on the homepage")
	    public void i_am_on_the_homepage() {
		   homePge.navigateUrl(host);
	    }

	    @When("Satisfy that homepage is visible")
	    public void verify_that_homepage_is_visible() {
	        String expectedTitle = "Partners - Connecting Buyers and Sellers for Properties, Vehicles, Electronics, Lifestyle and Jobs";
	        String actualTitle = homePge.getPageTitle();
	        assertEquals("Homepage title doesn't match", expectedTitle, actualTitle);
	    }
	
	    @Then("I enter {string} in the search bar")
	    public void i_add_products_to_the_cart(String keyword) {
	    	homePge.enterSearchKeyword(keyword);
	    }

	    @And("I click the search button")
	    public void i_click_the_Cart_button() {
		    
		    homePge.clickSearchButton();
	       
	    }

    @Then("I should see search results related of car")
    public void iShouldSeeSearchResultsRelatedTo() {
		assertTrue(searchPage.isOnSearchResultsPage());
    }


	@When("I click on Toyota Axio car name")
	public void iClickOnToyotaAxioCarName() {
		searchPage.clickToyotaAxioCarName();
	}

	@Then("I should see the following information in the car details")
	public void iShouldSeeTheFollowingInformationInTheCarDetails(DataTable dataTable) {
		List<Map<String, String>> expectedCarDetailsList = dataTable.asMaps(String.class, String.class);

		List<Map<String, String>> actualCarDetailsList = carDetailsPage.getAllCarDetailsList();
		Map<String, String> actualCarDetails = actualCarDetailsList.get(0);

		for (Map<String, String> expectedDetails : expectedCarDetailsList) {
			String name = expectedDetails.get("name");
			String expectedValue = expectedDetails.get("value");
			if (actualCarDetails.containsKey(name)) {
				String actualValue = actualCarDetails.get(name);
				assertEquals(expectedValue, actualValue);
			} else {
				System.out.println("Expected key '" + name + "' not found in actualCarDetails.");
		}



		}
	}
 //Signup page
	@And("I click on the Signup Menu")
	public void clickOnTheSignupMenu()  {
		signUpPage.clickSignUpDropdown();
	}

	@Then("I click on the General User of dropdown menu")
	public void clickOnTheGeneralUserOfDropdownMenu()  {

		signUpPage.clickGeneralUserLink();
	}

	@Then("I should see the {string} title on the signup page")
	public void shouldSeeTheTitleOnTheSignupPage(String expectedTitle) {
		WebElement titleElement = signUpPage.getSignUpTitleElement();
		String actualTitle = titleElement.getText();
		assertEquals(expectedTitle, actualTitle);
	}


	@And("I fill out the signup form with data from {string} and {int}")
	public void iFillOutTheSignupFormWithDataFromAndRowNumber(String sheetName, int rowNumber) throws IOException, InvalidFormatException {
		reader = new ExcelReader();
		List<Map<String,String>> readData =
				reader.getData(System.getProperty("user.dir") + "\\src\\test\\resources\\data\\AutoData.xlsx", sheetName);
		firstName = readData.get(rowNumber).get("First name");
		lastName = readData.get(rowNumber).get("Last name");
		email = readData.get(rowNumber).get("Email");
		userName = readData.get(rowNumber).get("UserName");
		district = readData.get(rowNumber).get("District");
		thana = readData.get(rowNumber).get("Thana");
		password = readData.get(rowNumber).get("Password");
		confirmPassword = readData.get(rowNumber).get("Confirm Password");
		mobileNumber = readData.get(rowNumber).get("Mobile Number");
		whatsappNumber = readData.get(rowNumber).get("Whatsapp Number");

	}

	@And("I fill first name")
	public void iFillFirstName() {
		  signUpPage.enterFirstName(firstName);
	}
	@And("I fill last name")
	public void iFillLastName() {
		  signUpPage.enterLastName(lastName);

	}

	@Then("I fill userName")
	public void iFillUserName() {
    signUpPage.enterUserName(userName);
	}

	@And("I fill email")
	public void iFillEmail() {
     signUpPage.enterEmail(email);
	}

	@And("I fill password")
	public void iFillPassword() {
    signUpPage.enterPassword(password);
	}

	@And("I fill confirm password")
	public void iFillConfirmPassword() {
		  signUpPage.enterConfirmPassword(confirmPassword);
	}
	@And("I select district name")
	public void iSelectDistrictName()  {
    signUpPage.selectDistrict(district);
	}

	@And("I select thana name")
	public void iSelectThanaName() {
     signUpPage.selectThana(thana);
	}

	@And("I fill mobile number")
	public void iFillMobileNumber() {
     signUpPage.enterPhone(mobileNumber);
	}

	@And("I fill whatsapp number")
	public void iFillWhatsappNumber() {
    signUpPage.enterWhatsappNumber(whatsappNumber);
	}

	@Then("And I click on the Sign Up button")
	public void andIClickOnTheSignUpButton() {
	}

	@And("I agree with the terms and conditions")
	public void iAgreeWithTheTermsAndConditions() {
		signUpPage.agreeWithTermsAndConditions();
	}

	@Then("I click on the Sign Up button")
	public void iClickOnTheSignUpButton()  {
		signUpPage.clickSignUpButton();
	}



}
