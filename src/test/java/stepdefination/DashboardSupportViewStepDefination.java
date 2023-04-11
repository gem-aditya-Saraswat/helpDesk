package stepdefination;

import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.tdd.GemjarTestngBase;
import io.cucumber.java.en.Then;
import utilities.DashboardSupportViewUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static com.gemini.generic.ui.utils.DriverAction.*;

public class DashboardSupportViewStepDefination extends GemjarTestngBase {
    final Logger logger = LoggerFactory.getLogger(LoginStepDefinition.class);
    @Then("^Verify click on \"(.+)\"$")
    public void clickVerifyTab(String tabToClick){
        try {
            DashboardSupportViewUtils dasUtil = new DashboardSupportViewUtils();
            String status = dasUtil.tabClick(tabToClick);
            if (status.equalsIgnoreCase("clicked")) {
                GemTestReporter.addTestStep("Tab click status", tabToClick + " is clicked", STATUS.PASS, takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Tab click status", tabToClick + " is not clicked", STATUS.FAIL, takeSnapShot());
            }
        }catch (Exception e){
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e.getMessage(), STATUS.FAIL);
        }
    }
}
