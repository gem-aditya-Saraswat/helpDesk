package selectors;

import org.openqa.selenium.By;


public class SearchXpath {
    public static By  searchBtn = By.xpath("//button[@type='submit' and text() = 'Search']");
    public static By  searchField = By.xpath("//input[@id='search']");
    public static By table = By.xpath("//table");
    public static By tableViewNoData = By.xpath("//img[@alt='No Data !']");
    public static By crossToClearSearch = By.xpath("//img[@alt='cross']");
}
