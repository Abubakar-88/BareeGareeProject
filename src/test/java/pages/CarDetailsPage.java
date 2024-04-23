package pages;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarDetailsPage extends Base {

    public CarDetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public List<Map<String, String>> getAllCarDetailsList() {
        List<Map<String, String>> carDetailsList = new ArrayList<>();

        WebElement detailsSection = fluentWait(driver.findElement(By.className("details_des_left_body_desc")));
        List<WebElement> detailElements = detailsSection.findElements(By.tagName("p"));

        Map<String, String> carDetails = new HashMap<>();

        for (WebElement detailElement : detailElements) {
            String labelText = detailElement.findElement(By.tagName("span")).getText().trim();
            String detailValue = detailElement.findElement(By.className("body_desc_bold")).getText().trim();

            String key = labelText.replaceAll("[^a-zA-Z0-9]", "");
            carDetails.put(key, detailValue);
        }

        carDetailsList.add(carDetails);

        return carDetailsList;
    }
}
