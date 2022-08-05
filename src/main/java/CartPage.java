import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends BasePage {

    //By bookNameLocator =  By.xpath("//img[@style='max-height:80px;']");
    By quantityBoxLocator= By.xpath("//input[@name='quantity']");
    By refreshButtonLocator=  By.className("fa fa-refresh green-icon");
    By refreshingCartLocator= By.className("swal2-title ky-swal-title-single");
    By crossButtonLocator= By.className("fa fa-times red-icon");
    By emptyCartLocator= By.id("emptyCartLocator");

    public CartPage(WebDriver driver) {
        super(driver);
    }
    //sepetteki ürün elementi 0dan büyükse sepete ürün eklenmiş demektir.

    //public boolean checkIfBookAdded() {return getProducts().size() > 0 ;}

    //sepetteki tüm ürünleri döner
   // private List<WebElement> getProducts(){return findAll(bookNameLocator);}

    public void productCountUp(String text) {
        //quantity box'ı bul ve oraya istenilen adeti yaz.
        type(quantityBoxLocator, text);
    }

    public void refreshToCount() {
        click(refreshButtonLocator);
    }

    public boolean isItRefresh() {
        //sepet güncellendiğinde çıkan elementleri görüyorsak kontrol sağlanır.
        return isDisplayed(refreshingCartLocator);
    }

    public boolean isCartEmpty() {
        //sepetin boş olduğunu gösteren element varsa kontrol sağlanmış olur
        return isDisplayed(emptyCartLocator);
    }

    public void removeProduct() {
        click(crossButtonLocator);

    }
}
