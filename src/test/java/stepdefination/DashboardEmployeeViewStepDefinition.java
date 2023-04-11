package stepdefination;

import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.tdd.GemjarTestngBase;
import com.gemini.generic.ui.utils.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static com.gemini.generic.ui.utils.DriverAction.*;
import selectors.DashboardEmployeeViewXpath;

import javax.swing.plaf.PanelUI;
import java.util.ArrayList;
import java.util.List;

public class DashboardEmployeeViewStepDefinition extends GemjarTestngBase {
    final Logger logger = LoggerFactory.getLogger(LoginStepDefinition.class);
    String prevURL = null;
    @When("^Click on User Guide Button$")
    public void userGuideBtnClick(){
        try {
            click(DashboardEmployeeViewXpath.userGuideBtn, "User Guide Button");
            waitSec(3);
        }catch (Exception e){
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e.getMessage(), STATUS.FAIL);
        }
    }

    @Then("^Verify New tab open$")
    public void newTabVerify(){
        try {
            prevURL = getCurrentURL();
            List<String> windowList = new ArrayList<>(getWindowHandles());
            switchToWindow(windowList.get(1)); // Switch focus to 2nd window
            windowList.get(1);
            waitSec(5);
        }catch (Exception e){
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e.getMessage(), STATUS.FAIL);
        }
    }

    @Then("^Verify user Guide$")
    public void verifyUserGuide(){
        try {
            String currentURL = getCurrentURL();
            if(prevURL.equalsIgnoreCase(currentURL)){
                GemTestReporter.addTestStep("User Gude click verify", "User guide not clicked", STATUS.FAIL, takeSnapShot());
            }else if(isExist(DashboardEmployeeViewXpath.userGuideTxt)){
                GemTestReporter.addTestStep("User Gude click verify", "User guide clicked", STATUS.PASS, takeSnapShot());
            }
        }catch (Exception e){
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e.getMessage(), STATUS.FAIL);
        }
    }

    @Then("^Verify loggedIn user details as (.+) and (.+)$")
    public void verifyLoggedInDetails(String userID, String designation){
        try{
            String uID = getElementText(DashboardEmployeeViewXpath.empName);
            String uRole = getElementText(DashboardEmployeeViewXpath.empRole);
            if(uID.equalsIgnoreCase(userID)){
                GemTestReporter.addTestStep("Employee Name Verification", "Employee Name Verified", STATUS.PASS, takeSnapShot());
            }else {
                GemTestReporter.addTestStep("Employee Name Verification", "Employee Name Verification failed", STATUS.FAIL, takeSnapShot());
            }
            if(uRole.equalsIgnoreCase(designation)){
                GemTestReporter.addTestStep("Employee Designation Verification", "Employee Designation Verified", STATUS.PASS, takeSnapShot());
            }else {
                GemTestReporter.addTestStep("Employee Designation Verification", "Employee Designation Verification failed", STATUS.FAIL, takeSnapShot());
            }
        }catch (Exception e){
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e.getMessage(), STATUS.FAIL);
        }
    }

    @When("^User clicks on Side Menu button$")
    public void sideMenuButtonClick(){
        try{
            click(DashboardEmployeeViewXpath.sideButton, "Side Menu Button");
            GemTestReporter.addTestStep("Side menu button click", "Side menu button clicked", STATUS.PASS, takeSnapShot());
        }catch (Exception e){
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e.getMessage(), STATUS.FAIL);
        }
    }

    @Then("^Verify (.+) of side menu$")
    public void sideMenuState(String collapseExpansion){
        try{
            if(collapseExpansion.equalsIgnoreCase("collapse") && isExist(DashboardEmployeeViewXpath.leftMenuInactive)){
                GemTestReporter.addTestStep("Side menu status", "Side Menu status : " + collapseExpansion, STATUS.PASS, takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Side menu status", "Side Menu status : " + collapseExpansion, STATUS.PASS, takeSnapShot());
            }
        }catch (Exception e){
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e.getMessage(), STATUS.FAIL);
        }
    }

    @When("^User clicks on contact us button$")
    public void contactUsClick(){
        try{
            click(DashboardEmployeeViewXpath.contactUsButton, "Contact Us button");
            GemTestReporter.addTestStep("Contact Us button click", "Contact us button clicked", STATUS.PASS, takeSnapShot());
        }catch (Exception e){
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e.getMessage(), STATUS.FAIL);
        }
    }

    @Then("^User Verify contact email presence$")
    public void verifyContactEmail(){
        try{
            if(isExist(DashboardEmployeeViewXpath.supportEmail)) {
                GemTestReporter.addTestStep("Support email Verification", " Support Email present", STATUS.PASS, takeSnapShot());
            }else{
                GemTestReporter.addTestStep("Support email Verification", " Support Email not present", STATUS.FAIL, takeSnapShot());
            }
        }catch (Exception e){
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e.getMessage(), STATUS.FAIL);
        }
    }

    @And("^User closes the contact us panel$")
    public void contactUsPanelClose(){
        try{
            click(DashboardEmployeeViewXpath.closeSupportPanelBtn);
            GemTestReporter.addTestStep("Support panel close", "Clicked on close panel button", STATUS.PASS, takeSnapShot());
        }catch (Exception e){
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e.getMessage(), STATUS.FAIL);
        }
    }

    @When("^User clicks on logout button$")
    public void logoutButtonClick(){
        try{
            click(DashboardEmployeeViewXpath.logoutButton);
            GemTestReporter.addTestStep("logout button click", "Clicked on log out button", STATUS.PASS, takeSnapShot());
        }catch (Exception e){
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e.getMessage(), STATUS.FAIL);
        }
    }

    @Then("^Verify user logged out successfully$")
    public void logoutVerification(){
        try{
            waitSec(3);
            String expectedUrl = "https://helpdeskui-np.geminisolutions.com/#/";
            if(getCurrentURL().equalsIgnoreCase(expectedUrl)) {
                GemTestReporter.addTestStep("Log out verification", "Successfully Logged out", STATUS.PASS, takeSnapShot());
            }
        }catch (Exception e){
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e.getMessage(), STATUS.FAIL);
        }
    }

    @And("^User selects \"(.+)\" Rows per page from dropdown$")
    public static void selectRowPerPage(String rowPerPage){
        try{
            if (isExist(DashboardEmployeeViewXpath.rowsPerPageDrpDwn)) {
                scrollIntoView(DashboardEmployeeViewXpath.nextBtn);
                Select rowsPerPage = new Select(DriverManager.getWebDriver().findElement(DashboardEmployeeViewXpath.rowsPerPageDrpDwn));
                waitSec(1);
                rowsPerPage.selectByValue(rowPerPage);
                waitSec(1);
                scrollIntoView(DashboardEmployeeViewXpath.rowsPerPageDrpDwn);
                GemTestReporter.addTestStep("Rows Per Page DropDown", rowPerPage + " selected from Rows Per Page DropDown", STATUS.PASS, takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Rows Per Page DropDown", "Rows Per Page DropDown does not Exist", STATUS.FAIL, takeSnapShot());
            }
        }catch (Exception e){
            final Logger logger = LoggerFactory.getLogger(LoginStepDefinition.class);
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e.getMessage(), STATUS.FAIL);
        }
    }

    @Then("^User verifies that the number of rows per page equal to the \"(.+)\"$")
    public void verifyPagePerCount(int rowsPerPage){
        try{
            int rowsCount = getElements(DashboardEmployeeViewXpath.numberOfRows).size();
            if (rowsPerPage == rowsCount) {
                GemTestReporter.addTestStep("Rows Per Page Value", "Number of Rows Per Page : " + rowsCount + ", is Equal to the Selected DropDown Value : " + rowsPerPage, STATUS.PASS, takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Rows Per Page Value", "Number of Rows Per Page : " + rowsCount + ", is Not Equal to the Selected DropDown Value : " + rowsPerPage, STATUS.FAIL, takeSnapShot());
            }
        }catch (Exception e){
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e.getMessage(), STATUS.FAIL);
        }
    }

    @Then("^User verify Next button should be enabled on first page$")
    public void nextButtonClickVerify(){
        try{
            scrollIntoView(DashboardEmployeeViewXpath.rowsPerPageDrpDwn);
            waitSec(1);
            if (DriverManager.getWebDriver().findElement(DashboardEmployeeViewXpath.nextBtn).isEnabled()) {
                GemTestReporter.addTestStep("Next Button", "Next Button is Enabled on First Page!", STATUS.PASS, takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Next Button", "Next Button is Not Enabled on First Page!", STATUS.FAIL, takeSnapShot());
            }
        }catch (Exception e){
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e.getMessage(), STATUS.FAIL);
        }
    }

    @Then("^User verify Previous button should be disabled on first page$")
    public void prvButtonClickVerify(){
        try{
            scrollIntoView(DashboardEmployeeViewXpath.rowsPerPageDrpDwn);
            waitSec(1);
            if (!(DriverManager.getWebDriver().findElement(DashboardEmployeeViewXpath.previousBtn).isEnabled())) {
                GemTestReporter.addTestStep("Previous Button", "Previous Button is not Enabled!", STATUS.PASS, takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Previous Button", "Previous Button is Enabled on First Page!", STATUS.FAIL, takeSnapShot());
            }
        }catch (Exception e){
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e.getMessage(), STATUS.FAIL);
        }
    }

    @And("^User clicks on Next button and verify that the previous button is enabled$")
    public void nxtButtonClickVerifyPrvButton(){
        try{
            scrollIntoView(DashboardEmployeeViewXpath.rowsPerPageDrpDwn);
            waitSec(2);
            if (isExist(DashboardEmployeeViewXpath.nextBtn)) {
                click(DashboardEmployeeViewXpath.nextBtn, "Next Button");
            } else {
                GemTestReporter.addTestStep("Next Button", "Next Button does not Exist!", STATUS.FAIL, takeSnapShot());
            }
            waitSec(3);
            if (DriverManager.getWebDriver().findElement(DashboardEmployeeViewXpath.previousBtn).isEnabled()) {
                GemTestReporter.addTestStep("Previous Button", "Previous Button is Enabled!", STATUS.PASS, takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Previous Button", "Previous Button is Not Enabled!", STATUS.FAIL, takeSnapShot());
            }
        }catch (Exception e){
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e.getMessage(), STATUS.FAIL);
        }
    }

    @And("^User clicks on Previous button and verify that it is disabled now$")
    public void prvButtonClickVerifyPrvButton(){
        try{
            scrollIntoView(DashboardEmployeeViewXpath.rowsPerPageDrpDwn);
            waitSec(2);
            if (isExist(DashboardEmployeeViewXpath.previousBtn)) {
                click(DashboardEmployeeViewXpath.previousBtn, "Previous Button");
            } else {
                GemTestReporter.addTestStep("Previous Button", "Previous Button does not Exist!", STATUS.FAIL, takeSnapShot());
            }
            if (!(DriverManager.getWebDriver().findElement(DashboardEmployeeViewXpath.previousBtn).isEnabled())) {
                GemTestReporter.addTestStep("Previous Button", "Previous Button is Disabled now!", STATUS.PASS, takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Previous Button", "Previous Button is still Enabled!", STATUS.FAIL, takeSnapShot());
            }
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e.getMessage(), STATUS.FAIL);
        }
    }
}
