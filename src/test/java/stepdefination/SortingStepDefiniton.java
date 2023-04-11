package stepdefination;

import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.tdd.GemjarTestngBase;
import io.cucumber.java.en.And;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static com.gemini.generic.ui.utils.DriverAction.*;
import utilities.SortingUtils;

public class SortingStepDefiniton extends GemjarTestngBase {
    final Logger logger = LoggerFactory.getLogger(LoginStepDefinition.class);
    @And("^User sorts \"(.+)\" column$")
    public void columnSorting(String columnName){
        try{
            SortingUtils sortUtil = new SortingUtils();
            String status = sortUtil.sortingVerify(columnName);
            if (status.equalsIgnoreCase("sorted")) {
                GemTestReporter.addTestStep("Column Sorted Result", "Result after Column is Sorted", STATUS.INFO, takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Column NOT Sorted Result", "Result after Column not Sorted", STATUS.INFO, takeSnapShot());
            }
        } catch (Exception e) {
            logger.info("Exception Occured!", e);
            GemTestReporter.addTestStep("ERROR", "Exception Occured :" + e.getMessage(), STATUS.FAIL, takeSnapShot());
        }
    }
}
