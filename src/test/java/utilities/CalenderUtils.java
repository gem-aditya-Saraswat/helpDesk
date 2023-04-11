package utilities;

import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.tdd.GemjarTestngBase;
import org.codehaus.groovy.ast.tools.GeneralUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import stepdefination.LoginStepDefinition;
import selectors.CalenderXpath;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.gemini.generic.ui.utils.DriverAction.*;

public class CalenderUtils extends GemjarTestngBase {
    final Logger logger = LoggerFactory.getLogger(LoginStepDefinition.class);
    public void verifySelectedMinimumDateRange(){
        try{
            if(isExist(CalenderXpath.calenderDefaultDate)){
                GemTestReporter.addTestStep("Minimum Date Range", "Verified minimum date range", STATUS.PASS);
            }else{
                GemTestReporter.addTestStep("Minimum Date Range", "Minimum date range not selected", STATUS.FAIL);
            }
        }catch (Exception e){
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e.getMessage(), STATUS.FAIL);
        }
    }
    public void verifySelectedMaximumDateRange(){
        try{
            List<WebElement> inrangeDates = getElements(CalenderXpath.calenderInRangeDates);
            int monthSizeOne = 29;
            int monthSizeTwo = 28;
            int monthSizeThree = 26;
            int monthSizeFour = 25;
            if(isExist(CalenderXpath.calenderStartRangeDate) && isExist(CalenderXpath.calenderEndRangeDate)){
                if (inrangeDates.size() == monthSizeOne || inrangeDates.size() == monthSizeTwo || inrangeDates.size() == monthSizeThree || inrangeDates.size() == monthSizeFour){
                    GemTestReporter.addTestStep("Maximum Date Range", "Valid maximum date Range", STATUS.PASS);
                }
            }else {
                GemTestReporter.addTestStep("Maximum Date Range", "Invalid maximum date Range", STATUS.FAIL);
            }
        }catch (Exception e){
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e.getMessage(), STATUS.FAIL);
        }
    }

    public void selectSpecifiedDate(String str){
        try{
            GenericFunctions genFunc = new GenericFunctions();
            ArrayList<String> splitedDate = genFunc.splitByCharacter(str, "-");
            String dayOfMonth = splitedDate.get(0);
            String month = splitedDate.get(1);
            String year = splitedDate.get(2);
            if(isExist(CalenderXpath.calenderPicker)){
                // Select month
                genFunc.drpSelectValue(CalenderXpath.calenderMonth, month);
                // Select Year
                genFunc.drpSelectValue(CalenderXpath.calenderYear, year);
                // Select date
                WebElement gg = getElement(By.xpath(String.format(CalenderXpath.xpathDate, dayOfMonth)));
                waitUntilElementAppear(By.xpath(String.format(CalenderXpath.xpathDate, dayOfMonth)),5);
                click(gg, "Specified Date");
                GemTestReporter.addTestStep("Specified Date", "Specified Date Selected", STATUS.PASS, takeSnapShot());
            }
        }catch (Exception e){
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e.getMessage(), STATUS.FAIL);
        }
    }

    public void verifyCounts(String str){
        try{
            if(str.equalsIgnoreCase("Maximum Selected Days")){

            } else if (str == "Minimum Selected Days") {
                if(isExist(CalenderXpath.calenderDefaultDate)){
                    GemTestReporter.addTestStep("Minimum Date Range", "Verified minimum date range", STATUS.PASS);
                }else{
                    GemTestReporter.addTestStep("Minimum Date Range", "Minimum date range not selected", STATUS.FAIL);
                }
            } else if (str.equalsIgnoreCase( "Month")) {
                List<WebElement> optionMonth = getElements(CalenderXpath.calenderMonthOption);
                int monthCount = optionMonth.size();
                if(monthCount == 12){
                    GemTestReporter.addTestStep("Month count verification", "Verified successfully total month count", STATUS.PASS);
                }else{
                    GemTestReporter.addTestStep("Month count verification", "Verification failed for total month count", STATUS.FAIL);
                }
            } else if (str.equalsIgnoreCase( "Weekday")) {
                List<WebElement> optionWeekday = getElements(CalenderXpath.calenderWeekdayOption);
                int weekDayCount = optionWeekday.size();
                if(weekDayCount == 7){
                    GemTestReporter.addTestStep("Weekday count verification", "Verified successfully total weekday count", STATUS.PASS);
                }else{
                    GemTestReporter.addTestStep("Weekday count verification", "Verification failed for total weekday count", STATUS.FAIL);
                }
            }
        }catch(Exception e){
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e.getMessage(), STATUS.FAIL);
        }
    }


    public void verifyDataForRange(String startDate, String endDate){
        try {

            System.out.println(startDate+"---yo--- "+ endDate);
            GenericFunctions gutils = new GenericFunctions();
            ArrayList<String> startDateList= gutils.splitByCharacter(startDate, "-");
            ArrayList<String> endDateList = gutils.splitByCharacter(endDate,"-");
            String updatedStartDate = gutils.dateConvert(startDateList);
            String updatedEndDate = gutils.dateConvert(endDateList);
            Date updEndDate = gutils.stringToDate(updatedEndDate);
            Date updStartDate = gutils.stringToDate(updatedStartDate);
            String flag = "Green";
            List<String> dateCreateOn = new ArrayList<>();
//            System.out.println(getElementsText(CalenderXpath.createdOnDate));
            dateCreateOn = getElementsText(CalenderXpath.createdOnDate);
            for (String s : dateCreateOn) {
                String[] sSub = s.split(" ");
                List<String> subListDate= List.of(sSub).subList(0,3);
                String tempDate = subListDate.get(0)+"-"+subListDate.get(1)+"-"+subListDate.get(2);
                Date temperoryDate = gutils.stringToDate(tempDate);
                if(!((temperoryDate.after(updStartDate) && temperoryDate.before(updEndDate)) || (temperoryDate.equals(updStartDate) || temperoryDate.equals(updEndDate)))){
                    flag = "red";
                    GemTestReporter.addTestStep("Date Range","Date out of Range : " + temperoryDate, STATUS.INFO);
                }
            }
            if(flag.equalsIgnoreCase("green")){
                GemTestReporter.addTestStep("Verify date Range","Date is in Range", STATUS.PASS);
            }else{
                GemTestReporter.addTestStep("Verify date Range","Date is not in Range", STATUS.FAIL);
            }
       }catch (Exception e){
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e.getMessage(), STATUS.FAIL);
        }
    }
}
