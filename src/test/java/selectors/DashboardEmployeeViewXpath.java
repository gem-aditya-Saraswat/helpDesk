package selectors;

import org.openqa.selenium.By;

public class DashboardEmployeeViewXpath {
    public static By userGuideBtn = By.xpath("//img[@alt='userGuide']//parent::section");
    public static By userGuideTxt = By.xpath("//span[text()='Helpdesk User Guide.pdf']");
    public static By empName = By.xpath("//div[contains(@class,'leftmenu_empName')]");
    public static By empRole = By.xpath("//div[contains(@class,'leftmenu_empRole')]");
    public static By sideButton = By.xpath("//div[contains(@class,'leftmenu_toggleBtn')]");
    public static By leftMenuInactive = By.xpath("//div[contains(@class,'leftmenu_leftmenuInactive')]");
    public static By contactUsButton = By.xpath("//img[@alt='Support']");
    public static By supportEmail = By.xpath("//p[contains(@class,'modal_text')]");
    public static By closeSupportPanelBtn = By.xpath("//button[@class='btn-close']");
    public static By logoutButton = By.xpath("//img[@alt='logout']");
    public static By rowsPerPageDrpDwn = By.xpath("//select[@aria-label='rows per page']");
    public static By nextBtn = By.xpath("//button[@title='Go to next page']");
    public static By numberOfRows = By.xpath("//tbody/tr");
    public static By previousBtn = By.xpath("//button[@title='Go to previous page']");
    public static By loaderGet = By.xpath("//div[contains(@class,'ldsDualRing')]");
}
