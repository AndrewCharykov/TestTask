package andrey.test.task;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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
     * Элемент Коммунальные платежи - город.
     */

    @FindBy(css = ".payment-page__title_inner")
    private WebElement communalPaymentsDistrict;

    /**
     * Элемент ЖКУ москва.
     */
    @FindBy (xpath = "//span[text()='ЖКУ-Москва']" )
    public WebElement zkyMoscow;

    /**
     * Элемент Локатор города Москва в выборе городов.
     */
    @FindBy (xpath = "//span[text()='г. Москва']" )
    public WebElement moscowPayments;

    /**
     * Элемент Локатор города СПб в выборе городов.
     */
    @FindBy (xpath = "//span[text()='г. Санкт-Петербург']" )
    public WebElement spbPayments;

    /**
     * Инициализация драйвера.
     * @param driver передаем двайвер.
     */
    public CommunalPaymentsPage(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    /**
     *  Проверяте в каком городе.
     * @param s  стринга город.
     * @param element локатор элемента.
     */
    public void communalPaymentsInCity(final String s, final WebElement element) {
        wait = new WebDriverWait(driver, gettimeWaiting());
        WebElement districtNow =
                wait.until(ExpectedConditions
                        .visibilityOf(communalPaymentsDistrict));

        if (!districtNow.getText().equals(s)) {
            communalPaymentsDistrict.click();
            wait = new WebDriverWait(driver, gettimeWaiting());
            wait.until(ExpectedConditions
                    .visibilityOf(element)).click();
        }
    }

    /**
     * Нажимает на элемент.
     * @param element локатор.
     */
    public void elementClick(final WebElement element) {
        wait = new WebDriverWait(driver, gettimeWaiting());
        wait.until(ExpectedConditions
                .visibilityOf(element)).click();
    }

    /**
     * Ожидание элемента.
     * @param element локатор элемента.
     */
    public void elementWait(final WebElement element) {
        wait = new WebDriverWait(driver, gettimeWaiting());
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
