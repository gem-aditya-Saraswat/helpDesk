package selectors;

import org.openqa.selenium.By;

public class TicketCancellationXpath {
    public static By threeDots =  By.xpath("//td//button[@tabindex=0]");
    public static By ticketCancellationBtn = By.xpath("//span[text()='Cancel Ticket']");
    public static By cancelTicketBtn = By.xpath("//button[text()='Cancel Ticket']");
    public static By reasonTextArea = By.xpath("//textArea[@placeholder='If yes, please specify the reason...']");
    public static By statusColumn = By.xpath("//tbody/tr/td[7][1]");
    public static By ticketClick = By.xpath("//td[1]//child::a");
    public static By cancelTicketclick = By.xpath("//span[contains(@class,'cancelTicket')]");
    public static By inputErrorReason = By.xpath("//span[contains(@class,'inputErrorText')]");
    public static By noBtn = By.xpath("//button[text()='No']");
}
