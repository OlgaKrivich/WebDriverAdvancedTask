package desktop.fragments;

import abstractClasses.fragment.AbstractFragment;
import driver.SingletonDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MiniBasketFragment extends AbstractFragment {

    @FindBy(xpath = "//div[@class='mini-basket']")
    private WebElement fragmentRootElement;

    public MiniBasketFragment(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String verifyCheckoutOrderSummary(String fieldName) {
        return SingletonDriver.getDriver()
                .findElement(By.xpath(
                        "//dt/strong[contains(text(),'" + fieldName
                                + "')]/ancestor::dt/following-sibling::dd"))
                .getText();
    }

}
