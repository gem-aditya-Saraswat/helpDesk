package selectors;

import org.openqa.selenium.By;

public class CalenderXpath {
    public static By calenderImg = By.xpath("//img[@alt='calender']");
    public static String xpathMonth = "//span[@class = 'rdrMonthPicker']/child::select";
    public static By calenderMonth = By.xpath(xpathMonth);
    public static String xpathYear = "//span[@class = 'rdrYearPicker']/child::select";
    public static By calenderYear = By.xpath(xpathYear);
    public static String xpathDate = "(//button[not(contains(@class,'rdrDayPassive'))]/span[@class='rdrDayNumber']/span//text()[ . = %s])//ancestor::button";
    public static String xpathDefaultDate = "//span[@class='rdrStartEdge rdrEndEdge']/following-sibling::span/child::span";
    public static By calenderDefaultDate = By.xpath(xpathDefaultDate);
    public static String xpathInRangeDates = "//span[@class='rdrInRange']";
    public static By calenderInRangeDates = By.xpath(xpathInRangeDates);
    public static String xpathStartEdge = "//span[@class='rdrStartEdge']";
    public static By calenderStartRangeDate = By.xpath(xpathStartEdge);
    public static String xpathEndEdge = "//span[contains(@class,'rdrEndEdge')]";
    public static By calenderEndRangeDate = By.xpath(xpathEndEdge);
    public static String xpathMonthOption = "//span[@class='rdrMonthPicker']/select/option";
    public static By calenderMonthOption = By.xpath(xpathMonthOption);
    public static String xpathWeekdayOption = "//span[@class='rdrWeekDay']";
    public static String prevPrevious = "//div[@class='rdrMonthAndYearWrapper']//button[1]";
    public static By prevPreviewBtn = By.xpath(prevPrevious);
    public static String prevNext = "//div[@class='rdrMonthAndYearWrapper']//button[2]";
    public static By nextPreviewBtn = By.xpath(prevNext);
    public static By monthBtn = By.xpath("//span[@class='rdrMonthPicker']/select");
    public static By clrBtn = By.xpath("//button[text()='Clear Data']");
    public static By calenderWeekdayOption = By.xpath(xpathWeekdayOption);
    public static By createdOnDate = By.xpath("//table/tbody/tr/td[5]");
    public static By calenderPicker = By.xpath("//div[contains(@class,'datePicker')]");
}
