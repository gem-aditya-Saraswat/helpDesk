package utilities;

import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import io.cucumber.java.en.Then;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static com.gemini.generic.ui.utils.DriverAction.*;
import stepdefination.LoginStepDefinition;


public class LoginUtils {
    final Logger logger = LoggerFactory.getLogger(LoginStepDefinition.class);
    public void verifyLogin(){
        try {
            waitSec(5);
            String curURL = getCurrentURL();
            GemTestReporter.addTestStep("Current URL", "Current URL : "+ curURL, STATUS.INFO, takeSnapShot());
            String expURL = "https://helpdeskui-np.geminisolutions.com/#/dashboard/0";
            if (curURL.equalsIgnoreCase(expURL)) {
                GemTestReporter.addTestStep("Pass", "Correct Credentials", STATUS.PASS);
            } else{
                GemTestReporter.addTestStep("Wrong Credentials", "Wrong Credenials", STATUS.PASS);
            }
        }catch (Exception e){
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e.getMessage(), STATUS.FAIL);
        }
    }
}
