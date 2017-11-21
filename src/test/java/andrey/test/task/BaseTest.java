package andrey.test.task;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static java.lang.System.setProperty;

/**
 * Базовый тест.
 */
public class BaseTest {
    /**
     * Вебдрайвер.
     */
    private WebDriver driver;

    /**
     * Инициализацуия драйвера.
     */
    @BeforeTest
    public void init() {
        setProperty("webdriver.chrome.driver",
                "C:\\Users\\a.charykov\\Desktop\\chromedriver_win32\\"
                        + "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    /**
     * Возвращает драйвер.
     * @return инициализированный webdriver.
     */
    protected  WebDriver getDriver() {
        return driver;
    }

    /**
     * Закрывает браузер.
     */
    @AfterTest
    public void dispose() {
        driver.quit();
    }
}