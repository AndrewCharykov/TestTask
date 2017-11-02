package andrey.test.task.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 */
public class ZkyMoscowPage {
    /**
     * Время ожидания.
     */
    final int timeWaiting = 60;
    /**
     * Вебдрайвер.
     */
    private WebDriver driver;
    /**
     * Вейтер.
     */
    private WebDriverWait wait;
    /**
     * Локатор опталить жку в Москве.
     */
    private By payZkyInMoscow = By.xpath("//span[text()='Оплатить ЖКУ в Москве']");

    /**
     * Возвращает локатор"Оплатить ЖКУ Москве".
     * @return локатор.
     */
    public By getPayZkyInMoscow() {
        return payZkyInMoscow;
    }

    /**
     *  Платежи.
     */
    private By payments = By.cssSelector("[data-reactid='97']");

    /**
     * Возвращает локатор платежей.
     * @return локатор.
     */
    public By getPayments() {
        return payments;
    }

    /**
     * локатор кнопки.
     */
    private By buttonPayZkyInMoscow = By.xpath("//h2[text()='Оплатить ЖКУ в Москве']");

    /**
     * Возвращает локатор.
     * @return локатор.
     */
    public By getButtonPayZkyInMoscow() {
        return buttonPayZkyInMoscow;
    }

    /**
     * локатор код плательщика.
     */
    private By fieldPayerCode =
            By.xpath("id('payerCode')");

    /**
     *возвращает локатор.
     * @return локатор.
     */
    public By getFieldPayerCode() {
        return fieldPayerCode;
    }

    /**
     * Локатор период.
     */
    private By fieldProviderPeriod =
            By.xpath("//input[@name='provider-period']");

    /**
     * возвращает локатор.
     * @return локатор.
     */
    public By getFieldProviderPeriod() {
        return fieldProviderPeriod;
    }

    /**
     * локатор суммы.
     */
    private By fieldSum =
            By.xpath("//div[1]/div[1]/div[1]/div[1]/label[1]/div[1]/input[1]");

    /**
     * возвращет локатор суммы.
     * @return локатор.
     */
    public By getFieldSum() {
        return fieldSum;
    }

    /**
     * локатор ошибкт сообщения код плательщика.
     */
    private By errorMessageCodePayment =
            By.xpath("//form[1]/div[1]/div[1]/div[2]");

    /**
     * возвращает локатор.
     * @return локатор ошибкт сообщения код плательщика.
     */
    public By getErrorMessageCodePayment() {
        return errorMessageCodePayment;
    }

    /**
     * Локатор ошибки даты.
     */
    private By errorMessageDate =
            By.xpath("//form[1]/div[2]/div[1]/div[2]");

    /**
     * Возвращает локатор ошибки даты.
     * @return локатор.
     */
    public By getErrorMessageDate() {
        return errorMessageDate;
    }

    /**
     * Ошибка сообщение суммы.
     */
    private By errorMessageSum =
            By.xpath("//div[1]/div[1]/div[1]/div[1]/div[1]/div[2]");

    /**
     * Возвращает локатор.
     * @return локатор.
     */
    public By getErrorMessageSum() {
        return errorMessageSum;
    }

    /**
     * Конструктор.
     * @param driver драйвер.
     */
    public ZkyMoscowPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Нажимает на элемент.
     * @param element локатор элемента.
     */
    public void elementClick(By element) {
        wait = new WebDriverWait(driver, timeWaiting);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element)).click();
    }

    /**
     *  Получаем текст ощибки.
     * @param element локатор элемента.
     * @return текст ошибки.
     */
    public String textError(By element) {
        wait = new WebDriverWait(driver, timeWaiting);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(element)).getText();
    }

    /**
     * Вводит текст.
     * @param element локатор элемента.
     * @param s то, что нужно ввести.
     */
    public void inputText(By element, String s) {
        wait = new WebDriverWait(driver, timeWaiting);
        WebElement thisElement = wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        thisElement.sendKeys(s);
        thisElement.sendKeys(Keys.TAB);
    }
}