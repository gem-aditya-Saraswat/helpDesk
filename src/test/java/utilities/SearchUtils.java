package utilities;

import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import selectors.SearchXpath;

import java.util.List;

import static com.gemini.generic.ui.utils.DriverAction.*;

public class SearchUtils {
    public String searchVerifyResults(String searchItem) throws InterruptedException {
        String status = "Matched";
        WebElement table = getElement(SearchXpath.table);
        List<WebElement> rows = table.findElements(By.xpath("//tr"));
        // Loop through each row and verify that the "Department Type" column contains "IT"
        for (int i = 1; i < rows.size(); i++) {  // skip the header row
            WebElement departmentType = rows.get(i).findElement(By.xpath("//td[2]"));
            String value = departmentType.getText();
            if (!value.equalsIgnoreCase(searchItem)) {
                status = "Unmatched";
//                throw new AssertionError("Expected 'IT', but found " + value);
                GemTestReporter.addTestStep("Value verification", "Search value found : "+value, STATUS.PASS, takeSnapShot());
            }
        }
        return status;
    }
}
