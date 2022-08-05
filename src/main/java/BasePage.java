import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.util.List;

// Diğer sayfaların ortak olarak metodlarını kullanabildiği BasePage sınıfını oluşturdum.
// Böylece kod tekrarının önüne geçmiş olacağım.
public class BasePage {
    WebDriver driver;
    public BasePage(WebDriver driver){
        this.driver=driver;
    }
    //web elementi bulan metod
    public WebElement find(By Locator){
        return driver.findElement(Locator);
    }

    //web elementi listesi döndüren metod
    public List<WebElement> findAll(By locator){
        return driver.findElements(locator);
    }
    //web elementini bul ve tıklama metodu
    public void click(By locator){
        find(locator).click();
    }

    //web elementini bul ve bir şey yazdırma metodu
    public void type(By locator , String text){
        find(locator).sendKeys(text);
    }

    //görünüp görünmediğini bulan metod
    public Boolean isDisplayed(By locator){
        return find(locator).isDisplayed();
    }
    public void enter(){
        driver.findElement(By.id("Value")).sendKeys(Keys.ENTER);
    }
}
