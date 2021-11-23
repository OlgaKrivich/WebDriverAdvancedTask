package abstractClasses.fragment;

import static driver.SingletonDriver.getDriver;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.WebDriverWaiter;

public abstract class AbstractFragment extends WebDriverWaiter {

    private WebElement rootElement;

    public AbstractFragment() {
        PageFactory.initElements(getDriver(), this);
    }

    public void setRootElement(WebElement element) {
        this.rootElement = element;
    }

    public WebElement getRootElement() {
        return rootElement;
    }

    public WebElement findElement(By by) {
        return getDriver().findElement(by);
    }

    public List<WebElement> findElements(By by) {
        return getDriver().findElements(by);
    }

    public boolean isElementDisplayed(By by) {
        return !findElements(by).isEmpty();
    }
}
