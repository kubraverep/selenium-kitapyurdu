import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class KitapyurduTest extends BaseTest {
    //page classlarından kullanmak üzere nesneler tanımladım.
    //kitabı anasayfadaki search alanında aratacağımız için anasayfa isminde bir nesne tanımladım
    HomePage homePage;
    BooksPage booksPage;
    BooksDetailPage booksDetailPage;
    CartPage cartPage;

    /*Bir sayfayı bir çok elemente ayırmak yerine page objesi içerisinde farklı farklı classlara ayırmak,
     farklı page objeleri yapmak daha iyi olacaktır.*/

    //Kitap arama testi
    @Test//test metodu olduğunu belirten anotasyon
    @Order(1)//testlerin sırayla çalışması için sayı veriyoruz
    public void search_book() {
        homePage = new HomePage(driver);
        //homePage’deki searchbox’ta search yap.
        homePage.searchBox().search("Roman");
        booksPage = new BooksPage(driver);
        //kitaplar sayfasına gidildiğini kontrol et.
        Assertions.assertTrue(booksPage.isOnBookPage(),
                "Not on books page!");

    }
    //bir kitap seçme testi
    @Test
    @Order(2)
    public void select_a_book() {
        booksDetailPage = new BooksDetailPage(driver);
        booksPage.selectBook(1);
        // Kitap detay sayfasına gidildi mi?
        Assertions.assertTrue(booksDetailPage.isOnBookDetailPage(),
                "Not on book detail page!");
    }

    //kitabı sepete ekleme testi
    @Test
    @Order(3)
    public void add_book_to_cart() {
        booksDetailPage.addToCart();
        //sepet ikonundaki değer değişti mi?
        Assertions.assertTrue(homePage.isChangeCartIcon(),
              "book did not add to cart! ");
    }

    //sepete gitme testi
    @Test
    @Order(4)
    public void click_to_cart() {
        cartPage = new CartPage(driver);
        homePage.clickToCart();
        //Sepete kitap eklenmiş mi?
       Assertions.assertTrue(cartPage.checkIfBookAdded(),
              "book was not added to cart!");
        homePage.goToCart();


    }



    //ürün miktarını bir adet arttır
    @Test
    @Order(5)
    public void ıncrease_the_quantity_of_book() {
        cartPage.productCountUp("2");
    }

    //yenileme butonuna bas
    @Test
    @Order(6)
    public void click_the_refresh_button() {
        cartPage.refreshToCount();

        //sepet güncelleniyor yazısı geldi mi
        Assertions.assertTrue(cartPage.isItRefresh(),
                "Count did not chaange!");

    }

    //çarpı butonuna bas
    @Test
    @Order(7)
    public void click_the_cross_button() {
        cartPage.removeProduct();
        //Sepet boş mu?
        Assertions.assertTrue(cartPage.isCartEmpty(),
                "Cart did not empty!");
    }

}
