package desktop.fragments.popups;

import abstractClasses.page.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToBasketPopUp extends AbstractPage {

    @FindBy(xpath = "//div[@class='basket-info']//a[@href='/basket']")
    private WebElement basketCheckoutButton;

    public void clickBasketCheckoutButton() {
        basketCheckoutButton.click();
    }

    public AddToBasketPopUp(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
