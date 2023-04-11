package stepdefination;

import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.tdd.GemjarTestngBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static com.gemini.generic.ui.utils.DriverAction.*;

import selectors.DashboardEmployeeViewXpath;
import selectors.SearchXpath;
import utilities.GenericFunctions;
import utilities.SearchUtils;


public class SearchStepDefinition extends GemjarTestngBase {
    final Logger logger = LoggerFactory.getLogger(LoginStepDefinition.class);
    GenericFunctions gutil = new GenericFunctions();
    String validity = "";
    @When("^User enter (.+) search item as \"(.+)\"$")
    public void searchItemValidation(String valid, String searchItem){
        try{
            validity = valid;
            if(validity.equalsIgnoreCase( "valid")){
                click(SearchXpath.searchField, "Search Field");
                typeText(SearchXpath.searchField, searchItem);
            } else if (validity.equalsIgnoreCase( "Invalid")) {
                click(SearchXpath.searchField, "Search Field");
                typeText(SearchXpath.searchField, searchItem);
            }
        }catch (Exception e){
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e.getMessage(), STATUS.FAIL);
        }
    }

    @And("^User click on Search button$")
    public void searchClick(){
        try{
            click(SearchXpath.searchBtn, "Search Button");
            gutil.waitForElement(DashboardEmployeeViewXpath.loaderGet, 10);
        }catch(Exception e){
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e.getMessage(), STATUS.FAIL);
        }
    }

    @Then("^User verify the search results for \"(.+)\"$")
    public void verifySearch(String searchItem){
        try{
            SearchUtils searchUtil = new SearchUtils();
            if(validity.equalsIgnoreCase("Valid")){
                String  status = searchUtil.searchVerifyResults(searchItem);
                if(status.equalsIgnoreCase("matched")) {
                    GemTestReporter.addTestStep("Verify search results", "Search results " + status, STATUS.PASS, takeSnapShot());
                }else{
                    GemTestReporter.addTestStep("Verify search results", "Search results " + status, STATUS.FAIL, takeSnapShot());
                }
            }else if(validity.equalsIgnoreCase("Invalid") && isExist(SearchXpath.tableViewNoData)){
                GemTestReporter.addTestStep("Verify search results for Invalid Scenerio", "Search results not Found", STATUS.PASS, takeSnapShot());
            }else {
                GemTestReporter.addTestStep("Verify search results", "Search results not matched", STATUS.FAIL, takeSnapShot());
            }
        }catch(Exception e){
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e.getMessage(), STATUS.FAIL);
        }
    }

    @And("^User clear the search box$")
    public void clearSearchTab(){
      try {
          if(isExist(SearchXpath.crossToClearSearch)) {
              click(SearchXpath.crossToClearSearch, "Clear Search");
              GemTestReporter.addTestStep("Clear search tab", "Clicked on clear search button", STATUS.PASS, takeSnapShot());
          }
      }catch (Exception e){
          logger.info("An exception occurred!", e);
          GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e.getMessage(), STATUS.FAIL);
      }
    }

    @Then("^User verify the search box is empty$")
    public void verifySearchEmpty(){
        try {
            String searchText = getElementText(SearchXpath.searchField);
            if(searchText.equalsIgnoreCase("")){
                GemTestReporter.addTestStep("Search field status", "Search field is empty", STATUS.PASS, takeSnapShot());
            }
        }catch (Exception e){
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e.getMessage(), STATUS.FAIL);
        }
    }
}
