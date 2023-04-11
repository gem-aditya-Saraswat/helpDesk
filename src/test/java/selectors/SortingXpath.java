package selectors;

import org.openqa.selenium.By;

public class SortingXpath {
    public static By columnID = By.xpath("//tr/td/a");
    public static By columnSubject = By.xpath("//tr/td[2]");
    public static By columnDepartment = By.xpath("//tbody/tr/td[3]");
    public static By colCreatedOn = By.xpath("//tbody/tr/td[5]");
    public static By columnAssignedTo = By.xpath("//tbody/tr/td[6]");
    public static By columnStatus = By.xpath("//tbody/tr/td[7]");
    public static By getHeading(String headingName) {
        return By.xpath("//*[text()= '" + headingName + "']");
    }
}
