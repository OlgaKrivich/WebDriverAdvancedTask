package abstractClasses.page;

import static driver.SingletonDriver.getDriver;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.WebDriverWaiter;

public abstract class AbstractPage extends WebDriverWaiter {

    private String pageUrl;
    private String pageUrlPattern;

    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public String setPageUrlPattern(String pageUrlPattern) {
        return this.pageUrlPattern = pageUrlPattern;
    }

    public String getPageUrlPattern() {
        return pageUrlPattern;
    }

    public boolean checkUrl() {
        boolean result = pageUrl.equals(getDriver().getCurrentUrl());
        if (!result && isNotEmpty(pageUrlPattern)) {
            return getDriver().getCurrentUrl().matches(pageUrlPattern);
        }
        return result;
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
