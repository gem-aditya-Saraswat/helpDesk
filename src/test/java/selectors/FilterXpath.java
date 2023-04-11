package selectors;

import org.openqa.selenium.By;

public class FilterXpath {
    public static By filterBtn = By.xpath("//button[contains(text(),'Filter')]");
    public static By crossIconFilter = By.xpath("//img[@alt='cross icon']");
    public static By departmentList = By.xpath("//tbody/tr/td[3]");
    public static By statusList = By.xpath("//tbody/tr/td[7]");
    public static By clearAllBtn = By.xpath("//button[text()='Clear all']");
    public static By filterToggleBtn = By.xpath("//input[@type='checkbox']");
    public static By xpathDepartmentStatus(String departmentStatus){
        return By.xpath(String.format("//button[text()='%s']",departmentStatus));
    }
    public static By department(String name) {
        return By.xpath("//button[contains(text(),'" + name + "')]");
    }

    public static By unassignedFilter = By.xpath("");
    public static By status(String name) {
        return By.xpath("//button[contains(text(),'" + name + "')]");
    }
}
