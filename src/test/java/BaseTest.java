import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)//metodların sırayla çalışması için
@ExtendWith(TestResultLogger.class)
public class BaseTest {
    WebDriver driver;
    //web driver oluşturup başlatılacak ve istenen sayfaya gidilcek.
    @Test
    @BeforeAll//her şeyden önce
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();//driver null olmaktan çıkıyor
        driver.get("https://www.kitapyurdu.com/");
        driver.manage().window().maximize();//ekran açıldıktan sonra büyüt
    }
    @AfterAll//her şeyden sonra
    public void tearDown(){
        driver.quit();
    }//driverı kapat

}
