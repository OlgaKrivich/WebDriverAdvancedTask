package desktop.pages;

import static desktop.pages.HomePage.BASE_URL;

import abstractClasses.page.AbstractPage;
import desktop.fragments.popups.AddToBasketPopUp;
import driver.SingletonDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasketPage extends AbstractPage {

    public static final String PAGE_URL = BASE_URL + "/basket";
    public static final String TITLE = "Your basket";
    AddToBasketPopUp addToBasketPopUp = new AddToBasketPopUp(SingletonDriver.getDriver());

    @FindBy(xpath = "//title")
    private WebElement pageTitle;

    @FindBy(xpath = "//div[@class='checkout-btns-wrap']/a[@href='/payment/guest']")
    private WebElement checkoutButton;

    @FindBy(xpath = "//dl[@class='delivery-text']/dt")
    private WebElement deliveryCost;

    @FindBy(xpath = "//dl[@class='total']/dt")
    private WebElement totalCost;

    public AddToBasketPopUp getAddToBasketPopUp() {
        return addToBasketPopUp;
    }

    public BasketPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String getPageTitle() {
        return SingletonDriver.getDriver().getTitle();
    }

    public void clickCheckoutButton() {
        waitUntilElementToBeClickable(checkoutButton);
        checkoutButton.click();
    }

    public String verifyBasketOrder(String fieldName) {
        return SingletonDriver.getDriver()
                .findElement(By.xpath(
                        ".//dt[contains(text(),'" + fieldName + "')]/following-sibling::dd"))
                .getText();
    }

}



