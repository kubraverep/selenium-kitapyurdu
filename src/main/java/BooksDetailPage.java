import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BooksDetailPage extends BasePage {

    By addToCartButtonLocator =  By.xpath("//a[@id='button-cart']");
    public BooksDetailPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnBookDetailPage() {
        //belirttiğimiz elementi görüyorsak detay sayfasındayız demektir.
        return isDisplayed(addToCartButtonLocator);
    }

    public void addToCart() {
        click(addToCartButtonLocator);
    }
}
