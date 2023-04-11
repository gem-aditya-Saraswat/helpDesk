package utilities;

import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import stepdefination.LoginStepDefinition;
import static com.gemini.generic.ui.utils.DriverAction.*;
import selectors.NotificationXpath;

import java.util.List;

public class NotificationsUtils {
    final Logger logger = LoggerFactory.getLogger(LoginStepDefinition.class);
    public String unreadNotificationCount(int headercount){
        String matchUnmatch = null;
        try{
            List<WebElement> notifyList= getElements(NotificationXpath.notificationList);
            if(notifyList.size() == headercount){
                matchUnmatch = "matched";
            }else{
                matchUnmatch = "not matched";
            }
        }catch (Exception e){
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e.getMessage(), STATUS.FAIL);
        }
        return matchUnmatch;
    }
}
