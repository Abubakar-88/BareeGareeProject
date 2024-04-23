package pages;

import base.Base;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class SignupPage extends Base {
    @FindBy(xpath = "*//div[@id='navbarSupportedContent']/ul/li[3]/a")
    private WebElement signUpMenu;

    @FindBy(xpath = "//a[contains(@href, '/general-user/registration-from/')]")
    private WebElement generalUserLink;

    @FindBy(id = "login_image")
    private WebElement signUpTitleElement;

    @FindBy(id = "firstName")
    private WebElement firstNameInput;

    @FindBy(id = "lastName")
    private WebElement lastNameInput;

    @FindBy(id = "userName")
    private WebElement userNameInput;

    @FindBy(id = "emailId")
    private WebElement emailInput;

    @FindBy(id = "phone")
    private WebElement phoneInput;

    @FindBy(id = "whatsappNumber")
    private WebElement whatsappNumberInput;

    @FindBy(id = "district")
    private WebElement districtDropdown;


@FindBy(id = "thana")
private WebElement thanaDropdown;
    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "confirmPassword")
    private WebElement confirmPasswordInput;

    @FindBy(id = "isAgreeWithTermsAndConditions")
    private WebElement agreeWithTermsCheckbox;

    @FindBy(id = "btnSignUp")
    private WebElement signUpButton;
    public SignupPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickSignUpDropdown() {
        try {
            if (signUpMenu.isDisplayed()) {
                signUpMenu.click();
            }
        } catch (NoSuchElementException e) {
            System.out.println("Element not found: " + e.getMessage());
        }
    }

    public void clickGeneralUserLink() {
        waitForWebdriver(driver, generalUserLink, Duration.ofSeconds(7));
    }
    public WebElement getSignUpTitleElement() {
        return signUpTitleElement;
    }
    public void enterFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
    }

    public void enterUserName(String userName) {
        userNameInput.sendKeys(userName);
    }

    public void enterEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void enterPhone(String phone) {
        phoneInput.sendKeys(phone);
    }

    public void enterWhatsappNumber(String whatsappNumber) {
        whatsappNumberInput.sendKeys(whatsappNumber);
    }

    public void selectDistrict(String district) {
        WebElement districtElement = fluentWait(districtDropdown);
        dropDownvalue(districtElement, district);
    }

    public void selectThana(String thana) {
        WebElement thanaElement = fluentWait(thanaDropdown);
        dropDownvalue(thanaElement, thana);
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        confirmPasswordInput.sendKeys(confirmPassword);
    }


    public void checkAgreeWithTerms() {
        agreeWithTermsCheckbox.click();
    }


    public void agreeWithTermsAndConditions() {
        agreeWithTermsCheckbox.click();
    }

    public void clickSignUpButton() {
        fluentWaitClick(signUpButton);
    }
}
