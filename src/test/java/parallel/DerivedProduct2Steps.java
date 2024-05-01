package parallel;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DP2HomePage;

import java.util.List;

import org.testng.Assert;
import util.CucumberLogs;

public class DerivedProduct2Steps {
	
	private DP2HomePage dp2HomePage = new DP2HomePage(DriverFactory.getDriver());

   	
	@Given("I am on the DP2 Home Page")
	public void i_am_on_the_dp2_home_page() {
		DriverFactory.getDriver()
		.get("https://www.nba.com/bulls/");
	}
	
	@When("I scroll down to the footer of the page")
	public void i_scroll_down_to_the_footer_of_the_page() {
		dp2HomePage.scrollToFooterOfDP2HomePage();
	}
	
	@Then("I can see the following categories")
	public void i_can_see_the_following_categories(DataTable dataTable) {
	    List<String> expCategories = dataTable.asList();
	    List<String> actCategories = dp2HomePage.getCategoryListAtFooter();
	    Assert.assertEquals(actCategories, expCategories);	    
	}
	
	@Given("I can write all hyperlinks in {string} file")
	public void i_can_write_all_hyperlinks_in_file(String fileName) {
	    dp2HomePage.writeAllHyperlinksToCSVFile(fileName);
	}
	
	@Then("I validate if any duplicate hyperlinks present at footer")
	public void i_validate_if_any_duplicate_hyperlinks_present_at_footer() {
		if(dp2HomePage.duplicateHyperLinks().size() > 0) {
	    	CucumberLogs.printLog("Duplicate HyperLinks are : "+dp2HomePage.duplicateHyperLinks());
	    }else {
	    	CucumberLogs.printLog("There is no duplicate hyperlink present.");
	    }
	}


}
