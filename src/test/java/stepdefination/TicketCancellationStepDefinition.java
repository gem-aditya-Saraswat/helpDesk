package stepdefination;

import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.tdd.GemjarTestngBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static com.gemini.generic.ui.utils.DriverAction.*;

import selectors.DashboardEmployeeViewXpath;
import selectors.TicketCreationXpath;
import utilities.GenericFunctions;
import selectors.TicketCancellationXpath;

import java.util.ArrayList;

public class TicketCancellationStepDefinition extends GemjarTestngBase {
    final Logger logger = LoggerFactory.getLogger(LoginStepDefinition.class);
    GenericFunctions gFunc = new GenericFunctions();
    String incidentID = null;
    @Then("^User create ticket (.+) file with details (.+), (.+), (.+)$")
    public void createTicket(String fileInclusion, String subject, String desc, String department){
        try{
            TicketCreationStepDefinition createTicket = new TicketCreationStepDefinition();
            if(fileInclusion.equalsIgnoreCase("without")){
                createTicket.clickOnCreateTicket();
                createTicket.fillDetails(subject, desc);
                createTicket.selectTicketType();
                createTicket.selectDepartment(department);
                createTicket.submitClick();
                gFunc.waitForElement(DashboardEmployeeViewXpath.loaderGet,5);
            }
        }catch (Exception e){
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e.getMessage(), STATUS.FAIL);
        }
    }

    @Then("^User get the Incident ID$")
    public void incidentIdFetch(){
        try{
            String ticketID = getElementText(TicketCreationXpath.ticketID);
            GenericFunctions genFunc = new GenericFunctions();
            ArrayList<String> listTicket = genFunc.splitByCharacter(ticketID, ": ");
            incidentID = listTicket.get(1);
//            listTicket = genFunc.splitByCharacter(incidentID, "-");
//            incidentID = listTicket.get(1);
            GemTestReporter.addTestStep("Fetch ticket ID", "Ticket ID:" + listTicket.get(1), STATUS.PASS, takeSnapShot());
            click(TicketCreationXpath.continueBtn, "Continue Button");
            gFunc.waitForElement(DashboardEmployeeViewXpath.loaderGet,5);
        }catch (Exception e){
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e.getMessage(), STATUS.FAIL);
        }
    }

    @Then("^User search the Ticket ID$")
    public void incidentIdSearch(){
        try{
            SearchStepDefinition search = new SearchStepDefinition();
            search.searchItemValidation("Valid", incidentID);
            gFunc.waitForElement(DashboardEmployeeViewXpath.loaderGet,5);
            search.searchClick();
            gFunc.waitForElement(DashboardEmployeeViewXpath.loaderGet,5);
            GemTestReporter.addTestStep("Search for Incident ID :" + incidentID, "Searched for the incident ID", STATUS.PASS, takeSnapShot());
        }catch (Exception e){
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e.getMessage(), STATUS.FAIL);
        }
    }

    @Then("^User cancel the ticket$")
    public void ticketCancel(){
        try{
            click(TicketCancellationXpath.threeDots, "More Options Button");
            click(TicketCancellationXpath.ticketCancellationBtn, "Cancel Ticket Button");
            typeText(TicketCancellationXpath.reasonTextArea,"Sample ticket cancel.");
            GemTestReporter.addTestStep("Fill reason", "Reason for cancellation filled", STATUS.PASS, takeSnapShot());
            click(TicketCancellationXpath.cancelTicketBtn, "Cancel Ticket Button");
            gFunc.waitForElement(DashboardEmployeeViewXpath.loaderGet,5);
        }catch (Exception e){
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e.getMessage(), STATUS.FAIL);
        }
    }

    @Then("User verify cancel ticket")
    public void verifyTicketCancel(){
        try{
            incidentIdSearch();
            String status = getElementText(TicketCancellationXpath.statusColumn);
            if(status.equalsIgnoreCase("cancelled")){
                GemTestReporter.addTestStep("Ticket cancel Verification", "Ticket is Cancelled", STATUS.PASS, takeSnapShot());
            }else {
                GemTestReporter.addTestStep("Ticket cancel Verification", "Ticket is not Cancelled", STATUS.FAIL, takeSnapShot());
            }
        }catch (Exception e){
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e.getMessage(), STATUS.FAIL);
        }
    }

    @Then("^User create request (.+) file with details (.+), (.+), (.+), (.+), (.+)$")
    public void createWithoutFile(String fileInclusion, String subject, String desc, String department, String category, String subCategory){
        try{
            TicketCreationStepDefinition createTicket = new TicketCreationStepDefinition();
            if(fileInclusion.equalsIgnoreCase("without")){
                createTicket.clickOnCreateTicket();
                createTicket.fillDetails(subject, desc);
                createTicket.selectRequestType();
                createTicket.selectDepartment(department);
                createTicket.fillDetailCategory(category,subCategory);
                createTicket.submitClick();
//                waitSec(5);
                gFunc.waitForElement(DashboardEmployeeViewXpath.loaderGet,5);
            }
        }catch (Exception e){
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e.getMessage(), STATUS.FAIL);
        }
    }

    @And("^User create ticket (.+) file details (.+), (.+), (.+), (.+), (.+) having file on (.+)$")
    public void createWithFile(String fileInclusion, String subject, String desc, String department, String category, String subCategory, String filepath){
        try{
            TicketCreationStepDefinition createTicket = new TicketCreationStepDefinition();
            if(fileInclusion.equalsIgnoreCase("with")){
                createTicket.clickOnCreateTicket();
                createTicket.fillDetails(subject, desc);
                createTicket.selectRequestType();
                createTicket.selectDepartment(department);
                createTicket.fillDetailCategory(category,subCategory);
                createTicket.userFileUpload(filepath);
                createTicket.submitClick();
//                waitSec(5);
                gFunc.waitForElement(DashboardEmployeeViewXpath.loaderGet,5);
            }
        }catch (Exception e){
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e.getMessage(), STATUS.FAIL);
        }
    }

    @And("^User create incident (.+) file details (.+), (.+), (.+) having file on (.+)$")
    public void createWithFile(String fileInclusion, String subject, String desc, String department, String filepath){
        try{
            TicketCreationStepDefinition createTicket = new TicketCreationStepDefinition();
            if(fileInclusion.equalsIgnoreCase("with")){
                createTicket.clickOnCreateTicket();
                createTicket.fillDetails(subject, desc);
                createTicket.selectTicketType();
                createTicket.selectDepartment(department);
                createTicket.userFileUpload(filepath);
                createTicket.submitClick();
//                waitSec(5);
                gFunc.waitForElement(DashboardEmployeeViewXpath.loaderGet,5);
            }
        }catch (Exception e){
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e.getMessage(), STATUS.FAIL);
        }
    }
    @Then("^User fetches the Request ID$")
    public void requestIdFetch(){
        incidentIdFetch();
    }

    @Then("^User Verify if ticket is cancelled$")
    public void ticketCancelVerification(){
        try{
            String ticketStatus = getElementText(TicketCancellationXpath.statusColumn);
            if(ticketStatus.equalsIgnoreCase("Cancelled")){
                GemTestReporter.addTestStep("Ticket cancellation verification","Ticket is alredy cancelled", STATUS.PASS, takeSnapShot());
            }else{
                GemTestReporter.addTestStep("Ticket cancellation verification","Ticket is not cancelled", STATUS.PASS, takeSnapShot());
            }
        }catch (Exception e){
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e.getMessage(), STATUS.FAIL);
        }
    }

    @And("^User cancel the ticket through ticket details page$")
    public void cancelTicketThroughTicketDetailsPage(){
        try{
            click(TicketCancellationXpath.cancelTicketclick, "Cancel Ticket Button");
            GemTestReporter.addTestStep("Click on Cancel Ticket", "Clicked", STATUS.PASS, takeSnapShot());
            typeText(TicketCancellationXpath.reasonTextArea,"Sample ticket cancel.");
            GemTestReporter.addTestStep("Fill reason", "Reason for cancellation filled", STATUS.PASS, takeSnapShot());
            click(TicketCancellationXpath.cancelTicketBtn, "Cancel Ticket Button");
        }catch (Exception e){
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e.getMessage(), STATUS.FAIL);
        }
    }

    @Then("^User verify the ticket cancel without reason not applicable$")
    public void verifyTicketCancelWithoutReason(){
        try{
            click(TicketCancellationXpath.ticketClick, "Ticket");
//            waitSec(3);
            gFunc.waitForElement(TicketCancellationXpath.cancelTicketBtn, 4);
            click(TicketCancellationXpath.cancelTicketclick, "Cancel Ticket");
            GemTestReporter.addTestStep("Click on Cancel Ticket", "Clicked", STATUS.PASS, takeSnapShot());
            click(TicketCancellationXpath.cancelTicketBtn, "Cancel Ticket Button");
            if(isExist(TicketCancellationXpath.inputErrorReason)){
                GemTestReporter.addTestStep("Cancel without Reason", "Reason required to cancel a ticket", STATUS.PASS, takeSnapShot());
            }
            click(TicketCancellationXpath.noBtn, "No Button");

        }catch (Exception e){
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e.getMessage(), STATUS.FAIL);
        }
    }


}
