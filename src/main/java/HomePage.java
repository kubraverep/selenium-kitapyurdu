import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
    //HomePage objesi içerisinde searchbox için ayrı bir page objesi oluşturdum.
    SearchBox searchBox;
    By cartCountLocator = By.id("cart-items");
    By cartCountainerLocator = By.id("sprite-cart-icon");

    By  goToCartLocator =By.id("js-cart");
    public HomePage(WebDriver driver) {
        super(driver);
        searchBox = new SearchBox(driver);
    }

    public SearchBox searchBox() {
        return this.searchBox;
    }

    //kitabı sepete ekledikten sonra sepet ikonunda değişiklik. eğer sepet ikonundaki değer sıfırdan büyükse doğrulanır.
    public boolean isChangeCartIcon() {
        return getCartCount()>0;
    }
    //sepetteki sayıyı verir
    private int getCartCount(){
        String count = find(cartCountLocator).getText();
        return Integer.parseInt(count);
    }
    public void clickToCart() {
        click(cartCountainerLocator);
    }


    public void goToCart() {
        click(goToCartLocator);
    }

}
