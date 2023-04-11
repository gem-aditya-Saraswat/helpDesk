package selectors;

import org.openqa.selenium.By;

public class TicketCreationXpath {
    public static By createticket = By.xpath("//button[text()='Create New Ticket']");

    public static By enterSubject = By.xpath("//input[@placeholder = 'Enter Subject']");

    public static By enterDesc = By.xpath("//textarea[@placeholder='Write the details here...']");

    public static By ticketDropdown(String options) {
        return By.xpath("//label[contains(text(),'"+options+"')]/following-sibling::div");
    }
    public static By typeticketDropdown(String options) {
        return By.xpath("//label[contains(text(),'"+options+"')]/parent::div/following-sibling::div");
    }
    public static By incidentSelect = By.xpath("//div[text() = 'Incident']");
    public static By requestSelect = By.xpath("//div[text() = 'Request']");
    public static By btnSubmit = By.xpath("//button[text()='Submit']");
    public static By fileUploadBtn = By.xpath("//input[@type='file']");
    public static By previewSubject = By.xpath("//label[text()='Subject']/following-sibling::p");
    public static By previewType = By.xpath("//label[text()='Type']/parent::div/following-sibling::p");
    public static By previewDescription = By.xpath("//label[text()='Description']/following-sibling::p");
    public static By previewBtn = By.xpath("//button[text()='Preview']");
    public static By closeBtn = By.xpath("//button[@aria-label='Close']");
    public static By ticketID = By.xpath("//span[text()='Ticket ID:']//ancestor::p");
    public static By continueBtn = By.xpath("//button[text()='Continue']");
    public static By descAfterClick = By.xpath("//div[contains(text(), 'Description')]//following-sibling::div");
    public static By subjectAfterClick = By.xpath("//span[contains(@class,'header_title')]");
    public static By typeAfterClick = By.xpath("//div[contains(text(), 'Type')]//following-sibling::div");
    public static By attachedFile = By.xpath("//div[contains(text(), 'Attached files')]//following-sibling::div");
    public static By inputError = By.xpath("//span[contains(@class, 'inputError')]");
    public static By fileUploadCrossIcon = By.xpath("//img[contains(@class, 'modal_icons')and contains(@alt, 'folder icon')]");
    public static By getDepartment(String deptName) {
        return By.xpath("//div[text()= '" + deptName + "']");
    }
    public static By ticketClickForDetails(String ticketID){return By.xpath("//u[contains(text(), '"+ticketID+"')]/parent::a");}
    public static By fileUpload = By.xpath("//div[contains(@class, 'modal_uploadedFile')]");
    public static By commentArea = By.xpath("//textArea[contains(@class, 'comments')]");
    public static By submitComment = By.xpath("//button[contains(@class, 'comments')]");
}