package pages;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.ElementUtil;
import util.WriteDataOnCSVFile;

public class DP2HomePage {
	
	private WebDriver driver;

	public DP2HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By categories = By.xpath("//nav[contains(@class,'footerlist')]//h2");
	
	private By footerHyperLinks = By.xpath("//ul[@data-testid='footer-list']//li//a");
	
	
	public void scrollToFooterOfDP2HomePage() {
		ElementUtil.scrollToFooter(driver);
	}
	
	public List<String> getCategoryListAtFooter(){
		List<WebElement> categoryElements = ElementUtil.findListOfWebElements(driver, categories);
		List<String> categoryList = new ArrayList<String>();
		for(WebElement ele : categoryElements) {
			categoryList.add(ElementUtil.getWebElementText(ele));
		}
		return categoryList;
	}
	
	public List<String> getAllLinksAtFooter(){
		List<WebElement> hyperLinkElements = ElementUtil.findListOfWebElements(driver, footerHyperLinks);
		List<String> hyperLinkList = new ArrayList<String>();
		for(WebElement ele : hyperLinkElements) {
			hyperLinkList.add(ElementUtil.getElementAttributeVal(ele, "href"));
		}
		return hyperLinkList;
	}
	
	public List<String> duplicateHyperLinks(){
		List<String> duplicateHyperLinks = new ArrayList<String>();
		Set<String> linkSet = new HashSet<String>();
		List<String> allAvailableHyperLinks = getAllLinksAtFooter();
		for(String link : allAvailableHyperLinks) {
			if(!linkSet.add(link)) {
				duplicateHyperLinks.add(link);
			}else {
				linkSet.add(link);
			}
		}
		return duplicateHyperLinks;
	}
	
	public void writeAllHyperlinksToCSVFile(String fileName){
		List<String[]> data = new ArrayList<String[]>();
		List<String> allAvailableHyperLinks = getAllLinksAtFooter();
		data.add(new String[] {"HyperLinkAddress"});
		for(String link : allAvailableHyperLinks) {
			data.add(new String[] {link});
		}
		WriteDataOnCSVFile.writeDataToCSV(fileName, data);		
	}

}
