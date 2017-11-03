package andrey.test.task.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Страница коммунальных платежей.
 */
public class CommunalPaymentsPage {
    /**
     * Время ожидания.
     *
     */
    private final int timeWaiting = 60;
    /**
     * getter for timeWaiting.
     *  @return time.
     */
    public int gettimeWaiting() {
        return timeWaiting;
    }

    /**
     * Вебдрайвер.
     */
    private WebDriver driver;
    /**
     * Вейтер.
     */
    private WebDriverWait wait;
    /**
     * Коммунальные платежи - город.
     */
    private By communalPaymentsDistrict =
            By.cssSelector(".payment-page__title_inner");
    /**
     * ЖКУ москва.
     */
    private By zkyMoscow = By.xpath("//span[text()='ЖКУ-Москва']");

    /**
     *  Возвращает локатор на ЖКУ Москва.
     * @return локатор.
     */
    public By getZkyMoscow() {
        return zkyMoscow;
    }
    /**
     * Локатор города Москва в выборе городов.
     */
    private By moscowPayments = By.xpath("//span[text()='г. Москва']");

    /**
     * Возвращает локатор г Москва.
     * @return локатор.
     */
    public By getMoscowPayments() {
        return moscowPayments;
    }
    /**
     * Локатор города СПб в выборе городов.
     */
    private By spbPayments = By.xpath("//span[text()='г. Санкт-Петербург']");

    /**
     * Возвращает локатор гСпб.
     * @return локатор.
     */
    public By getSpbPayments() {
        return spbPayments;
    }

    /**
     * Инициализация драйвера.
     * @param driver передаем двайвер.
     */
    public CommunalPaymentsPage(final WebDriver driver) {
        this.driver = driver;
    }

    /**
     *  Проверяте в каком городе.
     * @param s  стринга город.
     * @param element локатор элемента.
     */
    public void communalPaymentsInCity(final String s, final By element) {
        wait = new WebDriverWait(driver, gettimeWaiting());
        WebElement districtNow =
                wait.until(ExpectedConditions
                        .visibilityOfElementLocated(communalPaymentsDistrict));

        if (!districtNow.getText().equals(s)) {
            elementClick(communalPaymentsDistrict);
            wait = new WebDriverWait(driver, gettimeWaiting());
            wait.until(ExpectedConditions
                    .visibilityOfElementLocated(element)).click();
        }
    }

    /**
     * Нажимает на элемент.
     * @param element локатор.
     */
    public void elementClick(final By element) {
        wait = new WebDriverWait(driver, gettimeWaiting());
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(element)).click();
    }

    /**
     * Ожидание элемента.
     * @param element локатор элемента.
     */
    public void elementWait(final By element) {
        wait = new WebDriverWait(driver, gettimeWaiting());
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }
}
