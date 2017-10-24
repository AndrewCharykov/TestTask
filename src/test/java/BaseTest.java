import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    protected WebDriver driver;

    public void Init(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\a.charykov\\Desktop\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void Dispose(){
        driver.quit();
    }
}