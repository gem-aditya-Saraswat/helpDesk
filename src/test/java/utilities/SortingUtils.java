package utilities;

import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import selectors.SortingXpath;
import stepdefination.LoginStepDefinition;

import java.util.List;

import static com.gemini.generic.ui.utils.DriverAction.*;
import static com.gemini.generic.ui.utils.DriverAction.takeSnapShot;

public class SortingUtils {
    final Logger logger = LoggerFactory.getLogger(LoginStepDefinition.class);

    public String sortingVerify(String columnName) {
        List<WebElement> colItems = null;
        List<WebElement> colItems2 = null;
        String status = "";
        try {
            switch (columnName) {
                case ("ID"):
                    colItems = getElements(SortingXpath.columnID);
                    click(SortingXpath.getHeading(columnName), columnName);
                    colItems2 = getElements(SortingXpath.columnID);
                    break;
                case ("Subject"):
                    colItems = getElements(SortingXpath.columnSubject);
                    click(SortingXpath.getHeading(columnName), columnName);
                    colItems2 = getElements(SortingXpath.columnSubject);
                    break;
                case ("Department"):
                    colItems = getElements(SortingXpath.columnDepartment);
                    click(SortingXpath.getHeading(columnName), columnName);
                    colItems2 = getElements(SortingXpath.columnDepartment);
                    break;
                case ("Created on"):
                    colItems = getElements(SortingXpath.colCreatedOn);
                    click(SortingXpath.getHeading(columnName), columnName);
                    colItems2 = getElements(SortingXpath.colCreatedOn);
                    break;
                case ("Assigned to"):
                    colItems = getElements(SortingXpath.columnAssignedTo);
                    click(SortingXpath.getHeading(columnName), columnName);
                    colItems2 = getElements(SortingXpath.columnAssignedTo);
                    break;
                case ("Status"):
                    colItems = getElements(SortingXpath.columnStatus);
                    click(SortingXpath.getHeading(columnName), columnName);
                    colItems2 = getElements(SortingXpath.columnStatus);
                    break;
            }
            if (!colItems.equals(colItems2)) {
                status = "sorted";
                GemTestReporter.addTestStep("Column Sorted", columnName +" column is Sorted", STATUS.PASS, takeSnapShot());
            } else {
                status = "Not sorted";
                GemTestReporter.addTestStep("Column NOT Sorted", columnName +" column is NOT Sorted", STATUS.FAIL, takeSnapShot());

            }

        } catch (Exception e) {
            logger.info("Exception Occured!", e);
            GemTestReporter.addTestStep("ERROR", "Exception Occured :" + e.getMessage(), STATUS.FAIL, takeSnapShot());
        }

        return status;
    }
}