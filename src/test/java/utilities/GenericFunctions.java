package utilities;

import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.tdd.GemjarTestngBase;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import com.gemini.generic.ui.utils.DriverAction;
import com.gemini.generic.ui.utils.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import stepdefination.LoginStepDefinition;

public class GenericFunctions extends GemjarTestngBase {
    final Logger logger = LoggerFactory.getLogger(LoginStepDefinition.class);
    WebDriver Driver = DriverManager.getWebDriver();

    public void presenceOfElement(By elementXpath, int time) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(),Duration.ofSeconds(time));
            wait.until(ExpectedConditions.presenceOfElementLocated(elementXpath));
        } catch (Exception e) {
            GemTestReporter.addTestStep("Presence of Element ", "Element is not present", STATUS.INFO);
        }
    }

    public void waitForElement(By locator, int duration) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(), Duration.ofSeconds((long) duration));
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        }catch (Exception e){
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e.getMessage(), STATUS.INFO);
        }
    }

    public void waitUntilElemDisappear(By locator, int duration) {
        try {
            WebElement webElement = DriverAction.getElement(locator);
            WebDriverWait webDriverWait = new WebDriverWait(DriverManager.getWebDriver(), Duration.ofSeconds((long) duration));
            webDriverWait.until(ExpectedConditions.invisibilityOf(webElement));
        }catch (Exception e){
            GemTestReporter.addTestStep("Presence of Element ", "Element is present" + e.getMessage(), STATUS.INFO);
        }
    }

    public String drpSelectedOptionsValue(String xpath) {
        Select select = new Select(Driver.findElement(By.xpath(xpath)));
        WebElement option = select.getFirstSelectedOption();
        String defaultVal = option.getText();
//        select.deselectByValue("March");
        return defaultVal;
    }

    public void drpSelectValue(By xpath, String value) {
        Select select = new Select(Driver.findElement(xpath));
        select.selectByVisibleText(value);
    }

    public String getCurrentDate() {
        String currentDate = "";
        try {
            LocalDate currDate = LocalDate.now();
            // create formatter for desired format
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy");
            // format the current date using the formatter
            currentDate = currDate.format(formatter);
            // print the formatted date
            logger.info("Formatted current date", currentDate);
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e.getMessage(), STATUS.FAIL);
        }
        return currentDate;
    }

    public ArrayList<String> splitByCharacter(String str, String symbol) {
        ArrayList<String> splitedArray = new ArrayList<>();
        try {
            for (String part : str.split(symbol)) {
                splitedArray.add(part);
            }
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e.getMessage(), STATUS.FAIL);
        }
        return splitedArray;
    }

    public String dateConvert(ArrayList<String> dateList) {
        String updatedDate = "";
        try {
            String month = dateList.get(1);
            String updatedMonth = month.substring(0, 3);
            updatedDate = dateList.get(0) + "-" + updatedMonth + "-" + dateList.get(2);
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e.getMessage(), STATUS.FAIL);
        }
        return updatedDate;
    }

    public Date stringToDate(String dateString) {
        SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy");
        Date date = null;
        try {
            date = format.parse(dateString);
            System.out.println(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }
}
