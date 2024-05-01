package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import util.ElementUtil;

public class CPHomePage{
	
	private WebDriver driver;

	public CPHomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By closePopupBtn = By.xpath("//div[text()='x']");
	
	private By acceptCoockiesBtn = By.cssSelector("button#onetrust-accept-btn-handler");
	
	private By shopMenu = By.xpath("//li[@class='menu-item']//span[text()='Shop']");
	
	private By menSubMenu = By.xpath("//nav[@aria-label='header-primary-menu']//li//a[contains(text(),'Men')]");
	
	public void closePopupIfPresent() {
		try {
			ElementUtil.waitUntilElemDisplayed(closePopupBtn, Duration.ofSeconds(5));
			ElementUtil.clickOnElement(closePopupBtn);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void acceptCoockies() {
		try {
			ElementUtil.waitUntilElemDisplayed(acceptCoockiesBtn, Duration.ofSeconds(5));
			ElementUtil.clickOnElement(acceptCoockiesBtn);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void navigateToMensShopping() {
		ElementUtil.mouseHoverOnElemenet(driver, shopMenu);
		ElementUtil.clickOnElement(menSubMenu);
	}

}
