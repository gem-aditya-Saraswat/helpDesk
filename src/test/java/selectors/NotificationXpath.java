package selectors;

import org.openqa.selenium.By;

public class NotificationXpath {
    public static By headerCountNotification = By.xpath("//div[contains(@class, 'header_count')]");
    public static By unreadTab = By.xpath("//div[contains(text(), 'Unread')]");
    public static By notificationList = By.xpath("//li[contains(@class, 'notification_list')]");
    public static By allTab = By.xpath("//div[contains(text(), 'All')]");
    public static By notificationCount = By.xpath("//div[contains(@class, 'header_count')]/span");
    public static By notificationBtn = By.xpath("//button[contains(@class, 'MuiButtonBase')]");
    public static By activeCheckNotificationBtn = By.xpath("//img[contains(@src, 'Check_Active')]");
    public static By checkNotificationBtn = By.xpath("//img[contains(@src, 'Check')]");
    public static By showMore = By.xpath("//u[text()='Show More']");
    public static By notificationsList = By.xpath("//div[contains(@class,'notification_mainBody')]//li");
    public static By firstNotif = By.xpath("(//div[contains(@class,'notification_mainBody')]//li)[1]");
}
