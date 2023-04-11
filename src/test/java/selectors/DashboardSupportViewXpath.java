package selectors;

import org.openqa.selenium.By;

public class DashboardSupportViewXpath {
    public static By iconGemini = By.xpath("//div[contains(@class, 'gemlogo')]");
    public static By toggleBtn = By.xpath("//div[contains(@class, 'toggleBtn')]");
    public static By dashboardMenuItem = By.xpath("//div/child::a[contains(@class, 'menuitem_navItem')]");
    public By tabXpath(String tabName){
        return By.xpath("//li/div/div[text()='"+ tabName +"']");
    }
}
