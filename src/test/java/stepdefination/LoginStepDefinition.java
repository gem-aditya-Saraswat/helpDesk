package stepdefination;

import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.tdd.GemjarTestngBase;
import com.gemini.generic.ui.utils.DriverAction;
import com.gemini.generic.utils.ProjectConfigData;
import io.cucumber.java.en.When;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.cucumber.java.en.Given;

import static com.gemini.generic.ui.utils.DriverAction.*;

import io.cucumber.java.en.Then;
import selectors.LoginXpath;
import utilities.LoginUtils;
import utilities.ReadProperties;
import utilities.GenericFunctions;
import selectors.DashboardEmployeeViewXpath;

public class LoginStepDefinition extends GemjarTestngBase {
    final Logger logger = LoggerFactory.getLogger(LoginStepDefinition.class);
    GenericFunctions gutil = new GenericFunctions();

    @Given("^Launch Helpdesk Portal$")
    public void login() {
        gutil.presenceOfElement(LoginXpath.ssoLoginBtn, 10);
    }

    @When("^User Clicks on Login with SSO button$")
    public void ssoButtonClick() {
        try {
            click(LoginXpath.ssoLoginBtn, "SSO Button");
            gutil.presenceOfElement(LoginXpath.msSigninText, 10);
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e.getMessage(), STATUS.FAIL);
        }
    }

    @Then("^User Login with (.+) and (.+)$")
    public void loginCredential(String userid, String pass) {
        try {
            String credentialUserid = ProjectConfigData.getProperty("email");
            // input the fetched userid
            gutil.waitForElement(LoginXpath.msSigninText, 10);

            typeText(LoginXpath.msSigninText, credentialUserid);
            click(LoginXpath.nextLogInBtn, "Login Button");
            // Get password
            gutil.waitForElement(LoginXpath.msSignInPass, 10);
            String credentialPass = ProjectConfigData.getProperty("pswd");
            typeText(LoginXpath.msSignInPass, credentialPass, "Password");
            click(LoginXpath.nextLogInBtn, " Submit Button");

            click(LoginXpath.skip, "No Button");
            LoginUtils verifyLogin = new LoginUtils();
            verifyLogin.verifyLogin();
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e.getMessage(), STATUS.FAIL);
        }
    }

    @Then("^User Login wrong \"(.+)\" and \"(.+)\"$")
    public void loginWithWrongCredential(String userid, String pass) {
        try {
            // Get userid
            ReadProperties readCredentials = new ReadProperties();
            String credentialUserid = readCredentials.readProperties(userid);
            // input the fetched userid
            gutil.presenceOfElement(LoginXpath.msSigninText, 10);
            click(LoginXpath.msSigninText, "Sign in Text Box");
            typeText(LoginXpath.msSigninText, credentialUserid);
            click(LoginXpath.nextLogInBtn, "Submit Button");
            waitSec(1);
            // check if input of userid credential successful
            if (isExist(LoginXpath.signInBtn)) {
                // Get password
                String credentialPass = readCredentials.readProperties(pass);
                click(LoginXpath.msSignInPass, "Password Text Box");
                typeText(LoginXpath.msSignInPass, credentialPass);
                click(LoginXpath.nextLogInBtn, "Submit Button");
                click(LoginXpath.skip, "No Button");
            } else {
                GemTestReporter.addTestStep("Wrong credentials", "User enters wrong credentials", STATUS.PASS);
            }
            LoginUtils verifyLogin = new LoginUtils();
            verifyLogin.verifyLogin();
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e.getMessage(), STATUS.FAIL);
        }
    }

    @Given("^User Do Login with \"(.+)\" and \"(.+)\" on \"(.+)\" view$")
    public void userDoLoginWithAnd(String userid, String pass, String view) {
        try {
            ssoButtonClick();
            loginCredential(userid, pass);
            changeView(view);
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e.getMessage(), STATUS.FAIL);
        }
    }

    @Given("^User click on (.+) view$")
    public void changeView(String view) {
        try {
            gutil.waitForElement(LoginXpath.view, 10);
            click(LoginXpath.view, "View Button");
            GemTestReporter.addTestStep("View Click", "Clicked on view", STATUS.INFO, takeSnapShot());
            if (view.equalsIgnoreCase("employee")) {
                click(LoginXpath.employeeView, "Employee View");
                GemTestReporter.addTestStep("Employee View Click", "Clicked on Employee view", STATUS.INFO, takeSnapShot());
            } else if (view.equalsIgnoreCase("support")) {
                click(LoginXpath.supportView, "Support View");
                GemTestReporter.addTestStep("Support View Click", "Clicked on Support view", STATUS.INFO, takeSnapShot());
            }
        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e.getMessage(), STATUS.FAIL);
        }
    }
}