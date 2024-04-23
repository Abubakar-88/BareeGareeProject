package pages;

import base.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchPageOfCar extends Base {

    @FindBy(xpath = "//h6[text()='Toyota Axio']")
    private WebElement toyotaAxioCarName;

    public SearchPageOfCar(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickToyotaAxioCarName() {
        fluentWaitClick(toyotaAxioCarName);
    }
public boolean isOnSearchResultsPage() {
    String expectedUrl = "https://initial.bareegaree.com/Ads/Bangladesh/All";
    String searchText = "searchText=car";

    // Wait for the URL to contain the expected URL
    fluentWaitForUrl(expectedUrl);

    String currentUrl = driver.getCurrentUrl().toLowerCase();

    // Check if the current URL contains the expected URL and search text
    boolean isUrlCorrect = currentUrl.startsWith(expectedUrl.toLowerCase());
    boolean isSearchTextPresent = currentUrl.contains(searchText.toLowerCase());

    // Return true only if both conditions are met
    return isUrlCorrect && isSearchTextPresent;
}
}
