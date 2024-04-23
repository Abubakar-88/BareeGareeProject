package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Base;

public class HomePage extends Base{
	 @FindBy(id = "searchText")
	 private WebElement searchBox;
	 
	 @FindBy(xpath = "//i[@class='fa-solid fa-magnifying-glass']")
	 private WebElement searchButton;

	@FindBy(xpath = "//button[@type='button']")
	 private WebElement microphoneButton;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	public void navigateUrl(String url) {
		navigateURL(url);
	}

    public String getPageTitle() {
    	return driver.getTitle();
    }

    
    public void enterSearchKeyword(String keyword) {
        searchBox.sendKeys(keyword);
    }
    
    public void clickSearchButton() {
        searchButton.click();
    }

    public void clickMicrophoneButton() {
        microphoneButton.click();
    }
    
    
}
