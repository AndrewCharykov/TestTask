package andrey.test.task;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Домашняя страница.
 */
public class HomePage {
    /**
     * Вебдрайвер.
     */
    private WebDriver driver;

    /**
     * Элемент платежей.
     */
    @FindBy(xpath = "//span[text()='Платежи'][@class='_3Qu__']")
    public WebElement payments;

    /**
     * URL домашней страницы.
     */
    private String homePageURL = "https://www.tinkoff.ru/";
    /**
     * Инициализация  драйвера.
     * @param driver драйвер.
     */
    public HomePage(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
    }

    /**
     * Открывает домашнюю страницу.
     */
    public void homePageOpen() {
        driver.get(homePageURL);
    }
}
