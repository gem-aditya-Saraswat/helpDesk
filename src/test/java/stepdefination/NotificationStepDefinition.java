package stepdefination;

import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.tdd.GemjarTestngBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static com.gemini.generic.ui.utils.DriverAction.*;
import selectors.NotificationXpath;
import utilities.NotificationsUtils;

import java.util.List;

public class NotificationStepDefinition extends GemjarTestngBase {
    final Logger logger = LoggerFactory.getLogger(LoginStepDefinition.class);
    int headerCount;
    @Then("^User verify notification button exist$")
    public void notificationBtnVerfication(){
        try{
            if(isExist(NotificationXpath.notificationBtn)){
                GemTestReporter.addTestStep("Notification Button Check", "Notification Button exist", STATUS.PASS, takeSnapShot());
            }else {
                GemTestReporter.addTestStep("Notification Button Check", "Notification Button not exist", STATUS.FAIL, takeSnapShot());
            }
        }catch(Exception e){
            logger.info("Exception Occured!", e);
            GemTestReporter.addTestStep("ERROR", "Exception Occured :" + e.getMessage(), STATUS.FAIL, takeSnapShot());
        }
    }

    @And("^User clicks on notification button$")
    public void notificationBtnClick(){
        try{
            click(NotificationXpath.notificationBtn, "Notification Button");
            GemTestReporter.addTestStep("Click on Notification Button", "Notification Button Clicked", STATUS.PASS, takeSnapShot());
        }catch(Exception e){
            logger.info("Exception Occured!", e);
            GemTestReporter.addTestStep("ERROR", "Exception Occured :" + e.getMessage(), STATUS.FAIL, takeSnapShot());
        }
    }

    @When("^User check for notification header count$")
    public void headerCount(){
        try{
            headerCount = Integer.parseInt(getElementText(NotificationXpath.notificationCount));
            GemTestReporter.addTestStep("Notification header Count", "Notification header count is " + headerCount, STATUS.INFO, takeSnapShot());
        }catch(Exception e){
            logger.info("Exception Occured!", e);
            GemTestReporter.addTestStep("ERROR", "Exception Occured :" + e.getMessage(), STATUS.FAIL, takeSnapShot());
        }
    }

    @Then("^User verify the Notification check button$")
    public void notificationCheckBtn(){
        try{
            if(isExist(NotificationXpath.activeCheckNotificationBtn)){
                GemTestReporter.addTestStep("Unread Notification Status", "No Unread notifications", STATUS.PASS, takeSnapShot());
            }else if(isExist(NotificationXpath.checkNotificationBtn)){
                GemTestReporter.addTestStep("Unread Notification Status", "Total Unread Notifications are " + headerCount, STATUS.PASS, takeSnapShot());
            }
        }catch(Exception e){
            logger.info("Exception Occured!", e);
            GemTestReporter.addTestStep("ERROR", "Exception Occured :" + e.getMessage(), STATUS.FAIL, takeSnapShot());
        }
    }

    @And("^User clicks on \"(.+)\"$")
    public void readUnreadTabClick(String readUnread){
        try{
            if(readUnread.equalsIgnoreCase("unread")){
                click(NotificationXpath.unreadTab, "Unread Tab");
                GemTestReporter.addTestStep("Unread Tab click", "Unread Tab clicked", STATUS.PASS, takeSnapShot());
            }else if(readUnread.equalsIgnoreCase("all")){
                click(NotificationXpath.allTab, "All Tab");
                GemTestReporter.addTestStep("All Tab click", "All Tab clicked", STATUS.PASS, takeSnapShot());
            }
        }catch(Exception e){
            logger.info("Exception Occured!", e);
            GemTestReporter.addTestStep("ERROR", "Exception Occured :" + e.getMessage(), STATUS.FAIL, takeSnapShot());
        }
    }

    @Then("^User verify the notification count$")
    public void notificationCountVerification(){
        try{
            if(headerCount > 0){
                NotificationsUtils notifyUtil = new NotificationsUtils();
                String matchUnmatch = notifyUtil.unreadNotificationCount(headerCount);
                GemTestReporter.addTestStep("Unread notification count status", "Unread notification count" + matchUnmatch, STATUS.PASS, takeSnapShot());
            }else{
                GemTestReporter.addTestStep("Unread notification count status", "All notifications are read", STATUS.PASS, takeSnapShot());
            }
        }catch(Exception e){
            logger.info("Exception Occured!", e);
            GemTestReporter.addTestStep("ERROR", "Exception Occured :" + e.getMessage(), STATUS.FAIL, takeSnapShot());
        }
    }

    @When("^User check for unread notifications$")
    public void checkUnreadNotification(){
        headerCount();
    }

    @And("^User mark all notification as read$")
    public void markAllRead(){
        try{
            click(NotificationXpath.checkNotificationBtn, "Check Notification Button");
            GemTestReporter.addTestStep("Notification Mark as read", "All notifications marked as read", STATUS.PASS, takeSnapShot());
        }catch(Exception e){
            logger.info("Exception Occured!", e);
            GemTestReporter.addTestStep("ERROR", "Exception Occured :" + e.getMessage(), STATUS.FAIL, takeSnapShot());
        }
    }

    @Then("^User verify the Show More working$")
    public void verifyShowMoreWorking() {
        try {
            if (isExist(NotificationXpath.showMore)) {
                List<WebElement> notificationsList = getElements(NotificationXpath.notificationsList);
                if (notificationsList.size() > 0) {
                    while (isExist(NotificationXpath.showMore)) {
                        waitUntilElementAppear(NotificationXpath.showMore, 3);
                        click(NotificationXpath.showMore, "Show More");
                        waitSec(2);
                    }
                    List<WebElement> showMoreNotificationsList = getElements(NotificationXpath.notificationsList);
                    if (showMoreNotificationsList.size() > notificationsList.size()) {
                        GemTestReporter.addTestStep("Notification", "Show More Option is Verified", STATUS.PASS, takeSnapShot());
                    } else {
                        GemTestReporter.addTestStep("Notification", "Show More Option is not Working", STATUS.FAIL, takeSnapShot());
                    }
                } else {
                    GemTestReporter.addTestStep("Notification", "No Notifications are there", STATUS.PASS, takeSnapShot());
                }
            } else {
                GemTestReporter.addTestStep("Notification", "Show More Option does not Exist", STATUS.FAIL, takeSnapShot());
            }
        } catch (Exception e) {
            logger.info("Exception occurred!", e);
            GemTestReporter.addTestStep("Not Verified", "Exception arises" + e.getMessage(), STATUS.FAIL, takeSnapShot());
        }
    }
    @And("^User clicks on a Ticket from Notifications$")
    public void clickTicketFromNotifications() {
        try {
            List<WebElement> notificationsList = getElements(NotificationXpath.notificationsList);
            if (notificationsList.size() > 0) {
                click(NotificationXpath.firstNotif, "Ticket from Notification");
            } else {
                GemTestReporter.addTestStep("Notification", "No Notifications are there", STATUS.PASS, takeSnapShot());
            }
        } catch (Exception e) {
            logger.info("Exception Occurred!", e);
            GemTestReporter.addTestStep("ERROR", "Exception occurred :" + e.getMessage(), STATUS.FAIL, takeSnapShot());
            throw e;
        }
    }

    @Then("^User verify the ticket details page$")
    public void verifyTicketDetailsPage() {
        try {
            String ticketDetailsPage = getCurrentURL();
            if (ticketDetailsPage.contains("ticket-details")) {
                GemTestReporter.addTestStep("Ticket Details Page Verification", "Ticket Details Page is Successfully Opened", STATUS.PASS, takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Ticket Details Page Verification", "Ticket Details Page is not Opened", STATUS.FAIL, takeSnapShot());
            }
        } catch (Exception e) {
            logger.info("Exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "Exception occurred :" + e.getMessage(), STATUS.FAIL, takeSnapShot());
            throw e;
        }
    }
}
