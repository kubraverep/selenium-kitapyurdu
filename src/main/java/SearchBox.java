import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchBox extends BasePage{
    By searchBoxLocator = By.id("search-input");
    By submitButtonLocator = By.xpath("//span[@class='common-sprite button-search']");

    public SearchBox(WebDriver driver) {
        super(driver);
    }

    public void search(String text) {
        //searchBox'ı bul ve oraya istenilen texti yaz.
        type(searchBoxLocator, text);
        click(submitButtonLocator);

    }
}
