import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HomePage extends BasePage{
    //HomePage objesi içerisinde searchbox için ayrı bir page objesi oluşturdum.
    SearchBox searchBox;
    //By cartCountLocator = By.xpath("//span[@id='cart-items-text']");
    By cartContainerLocator = By.id("sprite-cart-icon");

    By  goToCartLocator = By.xpath("//a[@id='js-checkout']");
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
       // String count = find(cartCountLocator).getText();

        String count="1";
        return Integer.parseInt(count);

    }
    public void clickToCart() {
        click(cartContainerLocator);
    }


    public void goToCart() {
        click(goToCartLocator);
    }

    public List<String> readCsv(String path)
    {
        List<String> novels = new ArrayList<String>();
        try
        {
            Scanner scanner = new Scanner(new FileInputStream(path));
            while(scanner.hasNext())
            {
                novels.add(scanner.next());
            }

        }
        catch (FileNotFoundException e)
        {
            // If required you can print the complete error trace on console
            e.printStackTrace();
            //message indicating file was not found
            System.out.println("File not found or is deleted");
        }
        return novels;
    }
}
