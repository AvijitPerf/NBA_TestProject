package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingPage{
	
	private WebDriver driver;

	public ShoppingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By shopMenuItems = By.xpath("//li[@role='menuitem']/a[text()='men']");
	
	private By shopSubMenuItems = By.xpath("//li[./a[text()='men']]//a[@class='dropdown-link']//div[text()='Jackets']");
	
	private By productTitles = By.cssSelector("div[class='product-card row'] div[class='product-card-title'] a");
	
	private By productPrices = By.cssSelector("div[class='price-card'] span[class='lowest'] span[class='sr-only']");
	
	

}
