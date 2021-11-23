package desktop.fragments;

import abstractClasses.fragment.AbstractFragment;
import java.util.List;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookItemFragment extends AbstractFragment {

    @FindBy(xpath = "//div[@class='book-item']")
    private WebElement fragmentRootElement;

    public BookItemFragment(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickAddToBasketButton(String productTitle) {
        List<WebElement> booksList = findElements(By.xpath("//div[@class='book-item']"));
        booksList.stream()
                .filter(book -> book.findElement(By.xpath("//h3[@class='title']/a")).getText()
                        .equals(productTitle)).findFirst()
                .orElseThrow(() -> new NoSuchElementException("No book found"))
                .findElement(By.xpath("//div[@class='item-actions']//a")).click();
    }

}
