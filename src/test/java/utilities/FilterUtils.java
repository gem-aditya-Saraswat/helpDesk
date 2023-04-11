package utilities;

import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.tdd.GemjarTestngBase;
import com.gemini.generic.ui.utils.DriverManager;
import org.codehaus.groovy.ast.tools.GeneralUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import selectors.DashboardEmployeeViewXpath;
import stepdefination.DashboardEmployeeViewStepDefinition;
import stepdefination.LoginStepDefinition;
import selectors.FilterXpath;
import static com.gemini.generic.ui.utils.DriverAction.*;

import java.util.ArrayList;
import java.util.List;

public class FilterUtils extends GemjarTestngBase {
    final Logger logger = LoggerFactory.getLogger(LoginStepDefinition.class);
    GenericFunctions gUtil = new GenericFunctions();
    public List<String> getValueList(String departmentStatus){
        List<String> valueList = new ArrayList<>();
        try {
            if (departmentStatus.equalsIgnoreCase("department")) {
                valueList = getElementsText(FilterXpath.departmentList);
            }
            if (departmentStatus.equalsIgnoreCase("status")) {
                valueList = getElementsText(FilterXpath.statusList);
            }
        }catch (Exception e){
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e.getMessage(), STATUS.FAIL);
        }
        return valueList;
    }

    public void verifyValuesList(String departmentStatus, String criteria){
        try{
            List<String> listValues = getValueList(departmentStatus);
            String flag = "green";
            for (String value:listValues) {
                if(value.equalsIgnoreCase(criteria)){
                    continue;
                }else {
                    GemTestReporter.addTestStep("Expected filter value", "Expected filter value not matched", STATUS.FAIL, takeSnapShot());
                    flag = "Red";
                    break;
                }
            }
            if(flag.equalsIgnoreCase("green")){
                GemTestReporter.addTestStep("Expected filter value", "Expected filter value matched", STATUS.PASS, takeSnapShot());
            }
        }catch (Exception e){
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e.getMessage(), STATUS.FAIL);
        }
    }

    public void toggleVerify(){
        try{
            boolean flag = false;
            scrollIntoView(DashboardEmployeeViewXpath.nextBtn);
            DashboardEmployeeViewStepDefinition.selectRowPerPage("25");
            while ((DriverManager.getWebDriver().findElement(DashboardEmployeeViewXpath.nextBtn).isEnabled())) {
                List<String> statusListAfterToggleClick = getElementsText(FilterXpath.statusList);
                for (String s : statusListAfterToggleClick) {
                    if (!(s.equalsIgnoreCase("Cancelled") || s.equalsIgnoreCase("Closed") || s.equalsIgnoreCase("Resolved"))) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    GemTestReporter.addTestStep("Filter Toggle Switch", "Filter Toggle Switch is Working", STATUS.PASS, takeSnapShot());
                } else {
                    GemTestReporter.addTestStep("Filter Toggle Switch", "Filter Toggle Switch is Not Working", STATUS.FAIL, takeSnapShot());
                }
                click(DashboardEmployeeViewXpath.nextBtn, "Next Side Button");
//                waitSec(3);
                gUtil.waitForElement(DashboardEmployeeViewXpath.loaderGet, 10);
                if (!(DriverManager.getWebDriver().findElement(DashboardEmployeeViewXpath.nextBtn).isEnabled())) {
                    for (String s : statusListAfterToggleClick) {
                        if (!(s.equalsIgnoreCase("Cancelled") || s.equalsIgnoreCase("Closed") || s.equalsIgnoreCase("Resolved"))) {
                            flag = true;
                            break;
                        }
                    }
                    if (flag) {
                        GemTestReporter.addTestStep("Filter Toggle Switch click", "Filter Toggle Switch is Working", STATUS.PASS, takeSnapShot());
                    } else {
                        GemTestReporter.addTestStep("Filter Toggle Switch click", "Filter Toggle Switch is Not Working", STATUS.FAIL, takeSnapShot());
                    }
                }
            }
        }catch (Exception e){
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e.getMessage(), STATUS.FAIL);
        }
    }
}
