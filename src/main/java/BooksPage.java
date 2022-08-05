import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BooksPage extends BasePage {
    //kitaplar sayfasında olduğumuzu kontrol etmek için
    By productListLocator = By.id("faceted-search-list-total");
    By productNameLocator= By.className("pr-img-link");

    public BooksPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnBookPage() {
        //istediğimiz element sayfada görünüyormu diye basePagede oluşturduğumuz metodu kullandık.
        return isDisplayed(productListLocator);
    }

    public void selectBook(int i) {
        getAllBooks().get(i).click();
    }
    //kitaplar sayfasında birden fazla element olduğu için bir metod yazıyorum.
    private List<WebElement> getAllBooks(){
        return findAll(productNameLocator);
    }
}
