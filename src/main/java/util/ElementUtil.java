package util;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {
	
	private static WebDriverWait wait;
	private static WebDriver driver;
	
	public static void waitUntilElemDisplayed(By locator, Duration timeOutInSec) {
		wait = new WebDriverWait(driver, timeOutInSec);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public static void clickOnElement(By locator) {
		driver.findElement(locator).click();
	}
	
	public static WebElement findWebElement(WebDriver driver, By locator) {
		return driver.findElement(locator);
	}
	
	public static List<WebElement> findListOfWebElements(WebDriver driver, By locator) {
		return driver.findElements(locator);
	}
	
	public static void mouseHoverOnElemenet(WebDriver driver, By locator) {
		WebElement ele = findWebElement(driver, locator);
		//Creating object of an Actions class
		Actions action = new Actions(driver);
		//Performing the mouse hover action on the target element.
		action.moveToElement(ele).build().perform();
	}
	
	public static void scrollToFooter(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//Scroll down till the bottom of the page
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	
	public static String getWebElementText(WebElement element) {
		return element.getText().trim();
	}
	
	public static String getElementAttributeVal(WebElement element, String attrName) {
		return element.getAttribute(attrName).trim();
	}
	
	

}
