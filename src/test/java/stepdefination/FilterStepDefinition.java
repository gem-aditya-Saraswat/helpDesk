package stepdefination;

import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.tdd.GemjarTestngBase;
import com.gemini.generic.ui.utils.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.sl.In;
import org.codehaus.groovy.ast.tools.GeneralUtils;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.gemini.generic.ui.utils.DriverAction.*;

import selectors.DashboardEmployeeViewXpath;
import selectors.FilterXpath;
import utilities.FilterUtils;
import utilities.GenericFunctions;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilterStepDefinition extends GemjarTestngBase {
    final Logger logger = LoggerFactory.getLogger(LoginStepDefinition.class);
    GenericFunctions gUtil = new GenericFunctions();
    @When("^User click on filter button$")
    public void filterBtnClick() {
        try {
            click(FilterXpath.filterBtn, "Filter Button");
            GemTestReporter.addTestStep("Filter button click", "Filter Button clicked", STATUS.PASS, takeSnapShot());
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e.getMessage(), STATUS.FAIL);
        }
    }

    @And("^User click filter with (.+)$")
    public void filterClick(String criteria) {
        try {
            click(FilterXpath.xpathDepartmentStatus(criteria), "Filter " + criteria);
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e.getMessage(), STATUS.FAIL);
        }
    }

    @And("^User close the filter$")
    public void closeFilter() {
        try {
            click(FilterXpath.crossIconFilter, "Close Filter Button");
            GemTestReporter.addTestStep("Filter closed", "Filter Closed", STATUS.PASS, takeSnapShot());
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e.getMessage(), STATUS.FAIL);
        }
    }

    @Then("^User Verify the filtered rows on (.+) with (.+)$")
    public void verifyFilteredRow(String departmentStatus, String criteria) {
        try {
            FilterUtils filUtil = new FilterUtils();
            filUtil.verifyValuesList(departmentStatus, criteria);
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e.getMessage(), STATUS.FAIL);
        }
    }

    @And("^User click on clear all filters$")
    public void clearAllClick() {
        try {
            gUtil.waitForElement(FilterXpath.clearAllBtn,3);
            click(FilterXpath.clearAllBtn, "Clear All Button");
            GemTestReporter.addTestStep("Clear all button click", "Clicked on clear all button", STATUS.PASS, takeSnapShot());
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e.getMessage(), STATUS.FAIL);
        }
    }

    @And("^User switches on the toggle for 'Hide cancelled, closed and resolved tickets'$")
    public void toggleClick() {
        try {
            if (isExist(FilterXpath.filterToggleBtn)) {
                click(FilterXpath.filterToggleBtn, "Toggle Button");
            } else {
                GemTestReporter.addTestStep("Toggle Button", "Toggle Button does not Exist!", STATUS.FAIL, takeSnapShot());
            }
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e.getMessage(), STATUS.FAIL);
        }
    }

    @And("^User verify that ticket displayed should not be 'Cancelled, closed or resolved'$")
    public void verifyToggleClick() {
        try {
            FilterUtils futil = new FilterUtils();
            futil.toggleVerify();
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e.getMessage(), STATUS.FAIL);
        }
    }

    @And("^User picks the (.+) and (.+)$")
    public void selectDepartmentStatus(String departmentTypes, String statusTypes) {
        try {
            String[] departmentValues = departmentTypes.split(" & ");
            int departmentValuesSize = departmentValues.length;
            int departmentCount = 0;
            for (String department : departmentValues) {
                click(FilterXpath.department(department), department + " Button");
                gUtil.waitForElement(DashboardEmployeeViewXpath.loaderGet,5);
                departmentCount++;
            }
            if (departmentCount == departmentValuesSize) {
                GemTestReporter.addTestStep("Filter Selection", "Successfully selected the : " + departmentValuesSize + ", Department Filters", STATUS.PASS, takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Filter Selection", "Unable to select the Department Filters", STATUS.FAIL, takeSnapShot());
            }

            String[] statusValues = statusTypes.split(" & ");
            int statusValuesSize = statusValues.length;
            int statusCount = 0;
            for (String statusValue : statusValues) {
                click(FilterXpath.status(statusValue), statusValue + "Button");
                gUtil.waitForElement(DashboardEmployeeViewXpath.loaderGet, 10);
                statusCount++;
            }
            if (statusCount == statusValuesSize) {
                GemTestReporter.addTestStep("Filter Selection", "Successfully selected the : " + statusValuesSize + ", Status Filters", STATUS.PASS, takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Filter Selection", "Unable to select the Status Filters", STATUS.FAIL, takeSnapShot());
            }
            click(FilterXpath.crossIconFilter, "cross icon");
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e.getMessage(), STATUS.FAIL);
        }
    }

    @Then("^User Verify the (.+) and (.+)$")
    public void verifyDepartmentAndStatus(String departmentTypes, String statusTypes) {
        try {
            String[] departmentValues = departmentTypes.split(" & ");
            String[] statusValues = statusTypes.split(" & ");
            DashboardEmployeeViewStepDefinition.selectRowPerPage("25");
            int count = 1;
            do {
                List<String> dItems = new ArrayList<>();
                List<String> sItems = new ArrayList<>();
                String departmentFlag = "Green";
                String statusFlag = "Green";
                List<WebElement> departmentItems = getElements(FilterXpath.departmentList);
                List<WebElement> statusItems = getElements(FilterXpath.statusList);
                for (WebElement departmentItem : departmentItems) {
                    String deptStr = getElementText(departmentItem);
                    if (!(dItems.contains(deptStr))) {
                        dItems.add(deptStr);
                    }
                }
                for (WebElement statusItem : statusItems) {
                    String statusStr = getElementText(statusItem);
                    if (!(sItems.contains(statusStr))) {
                        sItems.add(statusStr);
                    } else if (statusStr.equalsIgnoreCase("Unassigned ")) {
                        sItems.add("Unassigned");
                    }
                }
                for (String dItem : dItems) {
                    if (!List.of(departmentValues).contains(dItem)) {
                        GemTestReporter.addTestStep("Not Expected Department", dItem, STATUS.INFO);
                        departmentFlag = "Red";
                    }
                }

                for (String sItem : sItems) {
                    if (!List.of(statusValues).contains(sItem)) {
                        GemTestReporter.addTestStep("Not Expected Status", sItem, STATUS.INFO);
                        statusFlag = "Red";
                    }
                }
                if (departmentFlag.equalsIgnoreCase("green") && statusFlag.equalsIgnoreCase("green")) {
                    GemTestReporter.addTestStep("Filter Verification in Result", "Successful", STATUS.PASS, takeSnapShot());
                } else {
                    GemTestReporter.addTestStep("Filter Verification in Result", "Not Successful", STATUS.FAIL, takeSnapShot());
                }
                count += 1;
            } while ((DriverManager.getWebDriver().findElement(DashboardEmployeeViewXpath.nextBtn).isEnabled()) && count < 3);

        } catch (Exception e) {
            logger.info("Exception Occurred!", e);
            GemTestReporter.addTestStep("ERROR", "Exception Occurred :" + e.getMessage(), STATUS.FAIL, takeSnapShot());
        }
    }
}
