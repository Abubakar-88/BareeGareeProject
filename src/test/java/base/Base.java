package base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;


public class Base {
	protected static WebDriver driver;
	public static Properties property = new Properties();
	public static String host;
	public static FileInputStream fis;
	public static utilities.ExcelReader reader;
	
	public static void click(By by) {
		driver.findElement( by ).click();
	}
	
	public static boolean isDisplayed(By by){
		return driver.findElement( by ).isDisplayed();
	}

	public static String getText(By by){
		return driver.findElement(by).getText();
	}

	public static void navigateURL(String url) {
		driver.get( url );
	}
	public static void dropDownvalue(WebElement webElement, String name) {
		Select select = new Select(webElement);
		select.selectByVisibleText(name);
	}
	
	   public void fluentWaitClick(WebElement element) {
	        Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(40))
	                .pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
	        WebElement clickableElement = wait.until(ExpectedConditions.elementToBeClickable(element));
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].click();", clickableElement);
	    }

	public void fluentWaitForUrl(String expectedUrl) {
		Wait<WebDriver> wait = new FluentWait<>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(1))
				.ignoring(NoSuchElementException.class);

		wait.until(ExpectedConditions.urlContains(expectedUrl));
	}
	public WebElement fluentWait(WebElement by) {
		Wait<WebDriver> wait = new FluentWait<>(driver)
				.withTimeout(Duration.ofSeconds(40))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);


		WebElement element = wait.until(ExpectedConditions.visibilityOf(by));
		return element;
	}
	public static void waitForWebdriver(WebDriver driver, WebElement element, Duration waitDuration) {
		WebDriverWait wait = new WebDriverWait(driver, waitDuration);
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	}

}
