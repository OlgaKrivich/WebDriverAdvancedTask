package desktop.fragments.popups;

import abstractClasses.page.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChristmasPopUp extends AbstractPage {

    @FindBy(xpath = "//div[@class='corner-content']//i[@class='icon-close']")
    private WebElement closeIcon;

    public ChristmasPopUp(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickCloseIcon() {
        closeIcon.click();
    }

}
