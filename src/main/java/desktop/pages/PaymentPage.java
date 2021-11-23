package desktop.pages;

import static desktop.pages.HomePage.BASE_URL;

import abstractClasses.page.AbstractPage;
import desktop.fragments.MiniBasketFragment;
import desktop.fragments.NewCustomerFragment;
import driver.SingletonDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage extends AbstractPage {

    public static final String PAGE_URL = BASE_URL + "/payment/guest";
    public static final String TITLE = "Your basket";

    public PaymentPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    MiniBasketFragment miniBasketFragment = new MiniBasketFragment(SingletonDriver.getDriver());
    NewCustomerFragment newCustomerFragment = new NewCustomerFragment(SingletonDriver.getDriver());

    public MiniBasketFragment getMiniBasketFragment() {
        return miniBasketFragment;
    }

    public NewCustomerFragment getNewCustomerFragment() {
        return newCustomerFragment;
    }
}
