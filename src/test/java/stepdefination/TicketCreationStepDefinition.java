package stepdefination;

import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.tdd.GemjarTestngBase;
import com.gemini.generic.ui.utils.DriverAction;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import static com.gemini.generic.ui.utils.DriverAction.*;

import io.cucumber.java.en.When;
import org.openqa.selenium.devtools.v85.network.model.DataReceived;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import selectors.DashboardEmployeeViewXpath;
import selectors.TicketCancellationXpath;
import selectors.TicketCreationXpath;
import utilities.GenericFunctions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.gemini.generic.ui.utils.DriverAction.waitSec;


public class TicketCreationStepDefinition extends GemjarTestngBase {
    final Logger logger = LoggerFactory.getLogger(LoginStepDefinition.class);
    GenericFunctions gFunc = new GenericFunctions();
    String ticketID = "";

    @When("^click on create ticket$")
    public void clickOnCreateTicket() {
        try {
            click(TicketCreationXpath.createticket, "Create Ticket");
//            waitSec(5);
            gFunc.waitForElement(TicketCreationXpath.enterSubject, 5);
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e.getMessage(), STATUS.FAIL);
        }
    }

    @And("^Fill Details (.+), (.+)$")
    public void fillDetails(String subject, String description) {
        try {
            click(TicketCreationXpath.enterSubject, "Subject Text Box");
            typeText(TicketCreationXpath.enterSubject, subject);
            click(TicketCreationXpath.enterDesc, "Description Text Box");
            typeText(TicketCreationXpath.enterDesc, description);
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e.getMessage(), STATUS.FAIL);
        }
    }

    @And("^Select ticket type as Incident$")
    public void selectTicketType() {
        try {
            click(TicketCreationXpath.typeticketDropdown("Type"), "Type Dropdown");
            gFunc.waitForElement(TicketCreationXpath.incidentSelect, 3);
            click(TicketCreationXpath.incidentSelect, "Incident");
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e.getMessage(), STATUS.FAIL);
        }
    }

    @And("^Select ticket type as Request$")
    public void selectRequestType() {
        try {
            click(TicketCreationXpath.typeticketDropdown("Type"), "Ticket Type Dropdown");
            gFunc.waitForElement(TicketCreationXpath.requestSelect, 3);
            click(TicketCreationXpath.requestSelect, "Request");
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e.getMessage(), STATUS.FAIL);
        }
    }

    @And("^Select Department as (.+)$")
    public void selectDepartment(String dept) {
        try {
            gFunc.presenceOfElement(TicketCreationXpath.ticketDropdown("Department"), 10);
            click(TicketCreationXpath.ticketDropdown("Department"), "Department Dropdown");
            gFunc.presenceOfElement(TicketCreationXpath.getDepartment(dept),3);
            click(TicketCreationXpath.getDepartment(dept), dept);
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e.getMessage(), STATUS.FAIL);
        }
    }

    @And("^User Fill Details (.+), (.+) details$")
    public void fillDetailCategory(String category, String subCategory) {
        try {
            gFunc.presenceOfElement(TicketCreationXpath.ticketDropdown("Category"),3);
            click(TicketCreationXpath.ticketDropdown("Category"), "Category Dropdown");
            click(TicketCreationXpath.getDepartment(category), category);
            gFunc.presenceOfElement(TicketCreationXpath.ticketDropdown("Sub-category"),2);
            click(TicketCreationXpath.ticketDropdown("Sub-category"), "Sub-Category Dropdown");
            click(TicketCreationXpath.getDepartment(subCategory), subCategory);
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e.getMessage(), STATUS.FAIL);
        }
    }

    @And("^User Clicks on Submit Button$")
    public void submitClick() {
        try {
            click(TicketCreationXpath.btnSubmit);
            gFunc.waitUntilElemDisappear(DashboardEmployeeViewXpath.loaderGet,10);
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e.getMessage(), STATUS.FAIL);
        }
    }

    @And("^User uploads file from (.+)$")
    public void userFileUpload(String filepath) {
        try {
            scrollIntoView(TicketCreationXpath.fileUploadBtn);
            waitSec(1);
            String directory = System.getProperty("user.dir") + "\\src\\test\\resources\\sampleFiles\\sample_PNG.png";
            fileUpload(TicketCreationXpath.fileUploadBtn, directory);
//            waitSec(3);
            gFunc.waitUntilElemDisappear(DashboardEmployeeViewXpath.loaderGet,10);
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e.getMessage(), STATUS.FAIL);
        }
    }

    @Then("^User verify the incident with details (.+), (.+)$")
    public void verifyDetails(String subject, String description) {
        try {
            click(TicketCreationXpath.previewBtn);
            String previewSubject = getElementText(TicketCreationXpath.previewSubject);
            String previewDescription = getElementText(TicketCreationXpath.previewDescription);
            if (previewSubject.equalsIgnoreCase(subject) && previewDescription.equalsIgnoreCase(description)) {
                GemTestReporter.addTestStep("Ticket Details Verification", "Details verified Successfully", STATUS.PASS);
            } else {
                GemTestReporter.addTestStep("Ticket Details Verification Fail", "Details verification fail ", STATUS.PASS);
            }
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e.getMessage(), STATUS.FAIL);
        }
    }

    @Then("^User clicks on close button$")
    public void closeBtnClick() {
        try {
            click(TicketCreationXpath.closeBtn);
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e.getMessage(), STATUS.FAIL);
        }
    }

    @And("^User fetch the Incident ID$")
    public void incidentIdFetch() {
        try {
            ticketID = getElementText(TicketCreationXpath.ticketID);
            GenericFunctions genFunc = new GenericFunctions();
            ArrayList<String> listTicket = genFunc.splitByCharacter(ticketID, ": ");
            ticketID = listTicket.get(1);
            GemTestReporter.addTestStep("Fetch ticket ID", "Ticket ID: " + ticketID, STATUS.PASS, takeSnapShot());
            click(TicketCreationXpath.continueBtn);
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e.getMessage(), STATUS.FAIL);
        }
    }

    @Then("^User fetch the Request ID$")
    public void requestIdFetch() {
        incidentIdFetch();
    }

    @Then("^Verify (.+) with (.+), (.+) (.+) file$")
    public void verifyTicketDetails(String incReq, String subject, String desc, String withWithoutFile) {
        try {
            SearchStepDefinition searchStep = new SearchStepDefinition();
            searchStep.searchItemValidation("Valid", ticketID);
            searchStep.searchClick();
            click(TicketCreationXpath.ticketClickForDetails(ticketID));
            gFunc.waitUntilElemDisappear(DashboardEmployeeViewXpath.loaderGet,10);
            GemTestReporter.addTestStep("Click on ticket Id for verification", "Clicked on ticket Id for verification", STATUS.PASS, takeSnapShot());
            String subj = getElementText(TicketCreationXpath.subjectAfterClick);
            String description = getElementText(TicketCreationXpath.descAfterClick);
            String type = getElementText(TicketCreationXpath.typeAfterClick);
            if (withWithoutFile.equalsIgnoreCase("without")) {
                if (subj.equalsIgnoreCase(ticketID + " | " + subject) && description.equalsIgnoreCase(desc) && incReq.equalsIgnoreCase(type)) {
                    GemTestReporter.addTestStep("Ticket Details Verification", "Details verified Successfully", STATUS.PASS, takeSnapShot());
                } else {
                    GemTestReporter.addTestStep("Ticket Details Verification Fail", "Details verification fail ", STATUS.FAIL, takeSnapShot());
                }
            } else if (withWithoutFile.equalsIgnoreCase("with")) {
                if (subj.equalsIgnoreCase(ticketID + " | " + subject) && description.equalsIgnoreCase(desc) && incReq.equalsIgnoreCase(type) && isExist(TicketCreationXpath.attachedFile)) {
                    GemTestReporter.addTestStep("Ticket Details Verification", "Details verified Successfully", STATUS.PASS, takeSnapShot());
                } else {
                    GemTestReporter.addTestStep("Ticket Details Verification Fail", "Details verification fail ", STATUS.FAIL, takeSnapShot());
                }
            }
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e.getMessage(), STATUS.FAIL);
        }
    }

    @Then("^Verify ticket not created and remaining mandatory fields$")
    public void remainingMandatoryFields() {
        try {
            submitClick();
            waitSec(1);
            List<String> errorFields = getElementsText(TicketCreationXpath.inputError);
            if (errorFields.size() > 0) {
                for (String message : errorFields) {
                    GemTestReporter.addTestStep("Required Fields", message, STATUS.INFO);
                }
            } else {
                GemTestReporter.addTestStep("Required Fields", "All fields are filled", STATUS.INFO);
            }
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e.getMessage(), STATUS.FAIL);
        }
    }

    @And("^User fill (.+) \"(.+)\" as (.+)$")
    public void dataFill(String incidentRequest, String field, String fieldValue) {
        try {
            if (field.equalsIgnoreCase("subject")) {
                click(TicketCreationXpath.enterSubject);
                typeText(TicketCreationXpath.enterSubject, fieldValue);
                waitSec(1);
            }
            if (field.equalsIgnoreCase("description")) {
                click(TicketCreationXpath.enterDesc);
                typeText(TicketCreationXpath.enterDesc, fieldValue);
                waitSec(1);
            }
            if (incidentRequest.equalsIgnoreCase("request")) {
                selectRequestType();
            } else {
                selectTicketType();
            }
            if (field.equalsIgnoreCase("department")) {
                selectDepartment(fieldValue);
            }
            if (field.equalsIgnoreCase("category")) {
                gFunc.presenceOfElement(TicketCreationXpath.ticketDropdown("Category"),3);
                click(TicketCreationXpath.ticketDropdown("Category"));
                click(TicketCreationXpath.getDepartment(fieldValue));
            }
            if (field.equalsIgnoreCase("sub-category")) {
                gFunc.presenceOfElement(TicketCreationXpath.ticketDropdown("Sub-Category"),3);
                click(TicketCreationXpath.ticketDropdown("Sub-Category"));
                click(TicketCreationXpath.getDepartment(fieldValue));
            }
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e.getMessage(), STATUS.FAIL);
        }
    }

    @And("^User upload \"(.+)\" (.+) file$")
    public void fileUploadValidInvalid(String validInvalid, String sizeExtensions) {
        try {
            if (validInvalid.equalsIgnoreCase("valid")) {
                if (sizeExtensions.equalsIgnoreCase("size")) {
                    List<String> validSize = new ArrayList<>();
                    Collections.addAll(validSize, "inRange");
                    String directory = System.getProperty("user.dir") + "\\src\\test\\resources\\sampleFiles\\sample_inRange.doc";
                    fileUpload(TicketCreationXpath.fileUploadBtn, directory);
                    gFunc.waitUntilElemDisappear(DashboardEmployeeViewXpath.loaderGet,10);
//                    fileUploadVerification(validInvalid);
                } else if (sizeExtensions.equalsIgnoreCase("extensions")) {
                    List<String> validExtensions = new ArrayList<>();
                    Collections.addAll(validExtensions, "PNG", "GIF", "PDF", "CSV", "XLSX", "PPT");
                    for (String validExtension : validExtensions) {
                        String directory = System.getProperty("user.dir") + "\\src\\test\\resources\\sampleFiles\\sample_" + validExtension + "." + validExtension.toLowerCase();
                        fileUpload(TicketCreationXpath.fileUploadBtn, directory);
                        GemTestReporter.addTestStep("File Upload", "File Upload for : " +validExtension,STATUS.INFO);
                        gFunc.waitUntilElemDisappear(DashboardEmployeeViewXpath.loaderGet,10);
//                        fileUploadVerification(validInvalid);
                    }
                }
            } else if (validInvalid.equalsIgnoreCase("invalid")) {
                if (sizeExtensions.equalsIgnoreCase("size")) {
                    List<String> inValidSizes = new ArrayList<>();
                    Collections.addAll(inValidSizes, "MorethantwoMB");
                    for (String inValidSize : inValidSizes) {
                        String directory = System.getProperty("user.dir") + "\\src\\test\\resources\\sampleFiles\\sample_" + inValidSize + ".docx";
                        try {
                            fileUpload(TicketCreationXpath.fileUploadBtn, directory);
                        } catch (Exception e) {
                            GemTestReporter.addTestStep("Invalid File Upload", "File not uploaded, File have more than 2mb size", STATUS.PASS, takeSnapShot());
                        }
//                        fileUploadVerification(validInvalid);
                    }
                } else if (sizeExtensions.equalsIgnoreCase("extensions")) {
                    List<String> inValidExtensions = new ArrayList<>();
                    Collections.addAll(inValidExtensions, "HTML", "ODP", "ODS", "ODT", "PPTX", "RTF", "SVG", "XLS");
                    for (String inValidExtension : inValidExtensions) {
                        String directory = System.getProperty("user.dir") + "\\src\\test\\resources\\sampleFiles\\sample_" + inValidExtension + "." + inValidExtension.toLowerCase();
                        try {
                            fileUpload(TicketCreationXpath.fileUploadBtn, directory);
                        } catch (Exception e) {
                            GemTestReporter.addTestStep("Invalid File Upload with Extension" + inValidExtension, "File not uploaded", STATUS.PASS, takeSnapShot());
                        }
                    }
                }
            }
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e.getMessage(), STATUS.FAIL);
        }
    }

    @Then("^Verify file upload for the \"(.+)\" scenario$")
    public void fileUploadVerification(String validInvalid) {
        try {
            if (validInvalid.equalsIgnoreCase("valid")) {
                if (isExist(TicketCreationXpath.fileUpload)) {
                    GemTestReporter.addTestStep("Valid file upload status", "File successfully uploaded", STATUS.PASS, takeSnapShot());
                    click(TicketCreationXpath.fileUploadCrossIcon);
                } else {
                    GemTestReporter.addTestStep("Valid file upload status", "File upload failed", STATUS.FAIL, takeSnapShot());
                }
            } else if (validInvalid.equalsIgnoreCase("invalid")) {
                if (isExist(TicketCreationXpath.fileUpload)) {
                    GemTestReporter.addTestStep("Invalid file upload status", "File successfully uploaded", STATUS.FAIL, takeSnapShot());
                    click(TicketCreationXpath.fileUploadCrossIcon);
                } else {
                    GemTestReporter.addTestStep("Invalid file upload status", "File upload failed", STATUS.PASS, takeSnapShot());
                }
            }
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e.getMessage(), STATUS.FAIL);
        }
    }

    @And("^User click on the ticket$")
    public void ticketClick() {
        try {
            click(TicketCreationXpath.ticketClickForDetails(ticketID));
            gFunc.waitUntilElemDisappear(DashboardEmployeeViewXpath.loaderGet,3);
            GemTestReporter.addTestStep("Click on ticket Id for verification", "Clicked on ticket Id for verification", STATUS.PASS, takeSnapShot());
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e.getMessage(), STATUS.FAIL);
        }
    }

    @And("^User comment on the ticket$")
    public void commentOnTicket() {
        try {
            typeText(TicketCreationXpath.commentArea, "Sample ticket cancel.");
            GemTestReporter.addTestStep("Do Comment!", "Sample comment", STATUS.PASS, takeSnapShot());
            click(TicketCreationXpath.submitComment);
            GemTestReporter.addTestStep("Submit Comment", "Comment Updated!", STATUS.PASS, takeSnapShot());
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e.getMessage(), STATUS.FAIL);
        }
    }
}