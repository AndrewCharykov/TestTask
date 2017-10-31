package andrey.test.task.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Домашняя страница.
 */
public class HomePage {
    /**
     * Время ожидания.
     */
    final int Time = 60;

    /**
     * Вебдрайвер.
     */
    private WebDriver driver;
    /**
     * Вейтер.
     */
    private WebDriverWait wait;
    /**
     * Локатор платежей.
     */
    private By payments = By.xpath("//span[text()='Платежи'][@class='_3Qu__']");

    /**
     * Возвращает локатор.
     * @return локатор.
     */
    public By getPayments() {
        return payments;
    }

    /**
     * URL домашней страницы.
     */
    private String homePageURL = "https://www.tinkoff.ru/";

    /**
     * Инициализация  драйвера.
     * @param driver драйвер.
     */
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Открывает домашнюю страницу.
     */
    public void homePageOpen() {
        driver.get(homePageURL);
    }

    /**
     * нажимаем на элемент.
     * @param element локатор.
     */
    public void elementClick(By element) {
        wait = new WebDriverWait(driver, Time);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element)).click();
    }
}
