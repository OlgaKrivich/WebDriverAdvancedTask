package desktop.pages;

import static desktop.pages.HomePage.BASE_URL;

import abstractClasses.page.AbstractPage;
import desktop.fragments.BookItemFragment;
import desktop.fragments.SearchFilterFragment;
import desktop.fragments.SearchResultsFragment;
import desktop.fragments.popups.ChristmasPopUp;
import driver.SingletonDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends AbstractPage {

    public static final String PAGE_URL = BASE_URL + "/search";
    public static final String TITLE = "Results for Thinking in Java | Book Depository";

    BookItemFragment bookItemFragment = new BookItemFragment(SingletonDriver.getDriver());
    SearchResultsFragment searchResultsFragment = new SearchResultsFragment(
            SingletonDriver.getDriver());
    SearchFilterFragment searchFilterFragment = new SearchFilterFragment(
            SingletonDriver.getDriver());
    ChristmasPopUp christmasPopUp = new ChristmasPopUp(SingletonDriver.getDriver());

    @FindBy(xpath = "//title")
    private WebElement pageTitle;

    public String getPageTitle() {
        return SingletonDriver.getDriver().getTitle();
    }

    public BookItemFragment getBookItemFragment() {
        return bookItemFragment;
    }

    public SearchResultsFragment getSearchResultsFragment() {
        return searchResultsFragment;
    }

    public SearchFilterFragment getSearchFilterFragment() {
        return searchFilterFragment;
    }

    public ChristmasPopUp getChristmasPopUp() {
        return christmasPopUp;
    }

    public SearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
