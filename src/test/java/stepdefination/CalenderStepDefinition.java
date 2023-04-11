package stepdefination;

import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static com.gemini.generic.ui.utils.DriverAction.*;
import selectors.CalenderXpath;
import utilities.GenericFunctions;
import utilities.CalenderUtils;
import java.time.LocalDate;
import java.util.ArrayList;

public class CalenderStepDefinition {
    final Logger logger = LoggerFactory.getLogger(LoginStepDefinition.class);
    @When("^User navigate to calender button$")
    public void calenderClick(){
        try {
            waitSec(5);
            click(CalenderXpath.calenderImg, "Calender Button");
            waitSec(2);
        }catch(Exception e){
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e.getMessage(), STATUS.FAIL);
        }
    }
    @Then("^User verify default value display$")
    public void verifyDefaultValue(){
        try{
            GenericFunctions genFunc = new GenericFunctions();
            String curDate = genFunc.getCurrentDate();
            // Getting default Selected date
            String date = getElementText(CalenderXpath.calenderDefaultDate);
            GemTestReporter.addTestStep("Default selected date", "Default selected date : " + date, STATUS.PASS, takeSnapShot());
            if(date != null){
                GemTestReporter.addTestStep("Default date present", "Default date present", STATUS.PASS, takeSnapShot());
            }else{
                GemTestReporter.addTestStep("Default date not present", "Default date not present", STATUS.FAIL, takeSnapShot());
            }
        }catch (Exception e){
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e.getMessage(), STATUS.FAIL);
        }
    }

    @Then("^User verify selected default value$")
    public void verifySelectedDefaultValue(){
        try{
            // Get current date
            LocalDate currentDate = LocalDate.now();
            Integer dayOfMonth = currentDate.getDayOfMonth();
            GenericFunctions genFunc = new GenericFunctions();
            String curDate = genFunc.getCurrentDate();
            // Getting Selected date
            String month = genFunc.drpSelectedOptionsValue(CalenderXpath.xpathMonth);
            String year = genFunc.drpSelectedOptionsValue(CalenderXpath.xpathYear);
            String date = getElementText(CalenderXpath.calenderDefaultDate);
            if(Integer.parseInt(date) > 0 && Integer.parseInt(date) < 10){
                date = "0"+date;
            }
            String defSelectedDate = date + "-" + month + "-" + year;
            // Check for expected Default value
            if(defSelectedDate.equalsIgnoreCase(curDate)){
                GemTestReporter.addTestStep("Default value", "Default value Matched", STATUS.PASS);
            }else{
                GemTestReporter.addTestStep("Default value", "Default value Mismatched", STATUS.FAIL);
            }

        }catch (Exception e){
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e.getMessage(), STATUS.FAIL);
        }
    }

    @And("^User select (.+)$")
    public void selectUserInputDate(String str){
        try{
            CalenderUtils calUtil = new CalenderUtils();
            if(str.equalsIgnoreCase("minimum date range")){
                calUtil.verifySelectedMinimumDateRange();
            } else if (str.equalsIgnoreCase("maximum date range")) {
                calUtil.verifySelectedMaximumDateRange();
            }else{
                calUtil.selectSpecifiedDate(str);
            }
        }catch(Exception e){
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e.getMessage(), STATUS.FAIL);
        }
    }

    @Then("^User verify Selected (.+)$")
    public void userVerifySelectedDate(String date){
        try{
            GenericFunctions genFunc = new GenericFunctions();
            ArrayList<String> splitedDateArray = genFunc.splitByCharacter(date, "-");
            // Getting Selected date
            String getMonth = genFunc.drpSelectedOptionsValue(CalenderXpath.xpathMonth);
            String getYear = genFunc.drpSelectedOptionsValue(CalenderXpath.xpathYear);
            String getDate = getElementText(CalenderXpath.calenderDefaultDate);
            String defSelectedDate = getDate + "-" + getMonth + "-" + getYear;
            // Date verification
            if(defSelectedDate.equalsIgnoreCase(date)){
                GemTestReporter.addTestStep("Date Verified", "Got Expected Selected Dates", STATUS.PASS, takeSnapShot());
            }else{
                GemTestReporter.addTestStep("Date Verification Fail", "Selected Date and Expected Date are different", STATUS.FAIL, takeSnapShot());
            }
        }catch (Exception e){
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e.getMessage(), STATUS.FAIL);
        }
    }

    @Then("^User verify \"(.+)\" counts$")
    public void countVerifications(String str){
        try{
            CalenderUtils calUtils = new CalenderUtils();
            calUtils.verifyCounts(str);
        }catch(Exception e){
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e.getMessage(), STATUS.FAIL);
        }
    }

    @Then("^User verify Click on (.+) navigate button$")
    public void previewBtnClick(String btn){
        try{
            GenericFunctions genFunc = new GenericFunctions();
            String prevValue = genFunc.drpSelectedOptionsValue(CalenderXpath.xpathMonth);
            GemTestReporter.addTestStep("Preview button click verification", "Month value before click : " + prevValue, STATUS.PASS, takeSnapShot());
            String afterValue = "";
            if(btn.equalsIgnoreCase("Next")){
                click(CalenderXpath.nextPreviewBtn, "Next preview Button");
                afterValue = genFunc.drpSelectedOptionsValue(CalenderXpath.xpathMonth);
            }else{
                click(CalenderXpath.prevPreviewBtn, "Previous preview Button");
                afterValue = genFunc.drpSelectedOptionsValue(CalenderXpath.xpathMonth);
            }
            GemTestReporter.addTestStep("Preview button click verification", "Month value after click : " + afterValue, STATUS.PASS, takeSnapShot());
            if(afterValue.equalsIgnoreCase(prevValue)){
                GemTestReporter.addTestStep("Preview button click verification", "Button not clicked", STATUS.FAIL);
            }else{
                GemTestReporter.addTestStep("Preview button click verification", "Button clicked", STATUS.PASS);
            }
        }catch (Exception e){
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e.getMessage(), STATUS.FAIL);
        }
    }

    @And("^User clicks on (.+) tab$")
    public void clickBtn(String str){
        try{
            if(str.equalsIgnoreCase("month")){
                click(CalenderXpath.monthBtn, "Calender Month Button");
            }
        }catch (Exception e){
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e.getMessage(), STATUS.FAIL);
        }
    }
    @And("^User clicks on clear data button$")
    public void clearDataBtnClick(){
        try{
            click(CalenderXpath.clrBtn, "Clear Data Button");
        }catch (Exception e){
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e.getMessage(), STATUS.FAIL);
        }
    }

    @And("^User selected date range with (.+) and (.+)$")
    public void dateRangeSelector(String startDate, String endDate){
        try{
            CalenderUtils calUtils = new CalenderUtils();
            calUtils.selectSpecifiedDate(startDate);
            calUtils.selectSpecifiedDate(endDate);
        }catch (Exception e){
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e.getMessage(), STATUS.FAIL);
        }
    }

    @Then("^User verify expected select range between (.+) and (.+)$")
    public void dateRangeVerify(String startDate, String endDate){
        try{
            CalenderUtils calUtils = new CalenderUtils();
            calUtils.verifyDataForRange(startDate, endDate);
        }catch (Exception e){
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e.getMessage(), STATUS.FAIL);
        }
    }
}
