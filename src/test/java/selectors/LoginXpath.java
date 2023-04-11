package selectors;

import org.openqa.selenium.By;

public class LoginXpath {
    public static By ssoLoginBtn = By.xpath("//button[text()='Login with SSO']");

    public static By msSigninText = By.xpath("//input[@type='email']");

    public static By msSignInPass = By.xpath("//input[@type='password']");
    public static By signInBtn = By.xpath("//input[@type='submit' and @value='Sign in']");

    public static By nextLogInBtn = By.xpath("//input[@type='submit']");

    public static By skip = By.xpath("//input[@type='button']");
    public static By view = By.xpath("//div[contains(@class, 'control')]");
    public static By employeeView = By.xpath("//div[text()='Employee View']");
    public static By supportView = By.xpath("//div[text()='Support View' and @aria-disabled='false']");
}