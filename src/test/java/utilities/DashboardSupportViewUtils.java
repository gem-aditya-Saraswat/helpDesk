package utilities;

import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import stepdefination.LoginStepDefinition;
import static com.gemini.generic.ui.utils.DriverAction.*;
import selectors.DashboardSupportViewXpath;

public class DashboardSupportViewUtils {
    final Logger logger = LoggerFactory.getLogger(LoginStepDefinition.class);
    public String tabClick(String tabToClick){
        DashboardSupportViewXpath viewXpath = new DashboardSupportViewXpath();
        String url = getCurrentURL();
        String status = "";
        try{
            switch (tabToClick){
                case "Icon":
                    waitUntilElementAppear(viewXpath.iconGemini,5);
                    click(viewXpath.iconGemini);
                    status = "Clicked";
                    break;
                case "toggle button":
                    waitUntilElementAppear(viewXpath.toggleBtn,5);
                    click(viewXpath.toggleBtn);
                    status = "Clicked";
                    break;
                case "dashboard menuitem":
                    waitUntilElementAppear(viewXpath.dashboardMenuItem,5);
                    click(viewXpath.dashboardMenuItem);
                    status = "Clicked";
                    break;
                case "Assigned":
                case "Unassigned":
                case "My Department":
                case "Others" :
                    waitUntilElementAppear(viewXpath.tabXpath(tabToClick),5);
                    click(viewXpath.tabXpath(tabToClick));
                    status = "Clicked";
                    break;
            }
        }catch (Exception e){
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e.getMessage(), STATUS.FAIL);
        }
        return status;
    }
}
