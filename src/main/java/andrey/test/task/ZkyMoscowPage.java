package andrey.test.task;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Страница платежей в Москве.
 */
public class ZkyMoscowPage {
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
     * Элемент опталить жку в Москве.
     */
    @FindBy(xpath = "//span[text()='Оплатить ЖКУ в Москве']" )
    public WebElement payZkyInMoscow;

    /**
     *  Элемент Платежи.
     */
    @FindBy(css = "[data-reactid='97']" )
    public WebElement payments;

    /**
     * Элемент кнопки.
     */
    @FindBy(xpath = "//h2[text()='Оплатить ЖКУ в Москве']" )
    public WebElement buttonPayZkyInMoscow;

    /**
     * Элемент код плательщика.
     */
    @FindBy(xpath = "id('payerCode')" )
    public WebElement fieldPayerCode;

    /**
     * Элемент период.
     */
    @FindBy(xpath = "//input[@name='provider-period']" )
    public WebElement fieldProviderPeriod;

    /**
     * Элемент суммы.
     */
    @FindBy(xpath = "//div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/label[1]/div[1]/input[1]" )
    public WebElement fieldSum;

    /**
     * Элемент ошибкт сообщения код плательщика.
     */
    @FindBy(xpath = "//form[1]/div[1]/div[1]/div[2]" )
    public WebElement errorMessageCodePayment;

    /**
     * Элемент ошибки даты.
     */
    @FindBy(xpath = "//form[1]/div[2]/div[1]/div[2]" )
    public WebElement errorMessageDate;

    /**
     * Элемент Ошибка сообщение суммы.
     */
    @FindBy(xpath = "//div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]" )
    public WebElement errorMessageSum;

    /**
     * Конструктор.
     * @param driver драйвер.
     */
    public ZkyMoscowPage(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver,this);
    }

    /**
     * Нажимает на элемент.
     * @param element локатор элемента.
     */
    public void elementClick(final WebElement element) {
        wait = new WebDriverWait(driver, gettimeWaiting());
        wait.until(ExpectedConditions
                .visibilityOf(element)).click();
    }

    /**
     *  Получаем текст ощибки.
     * @param element локатор элемента.
     * @return текст ошибки.
     */
    public String textError(final WebElement element) {
        wait = new WebDriverWait(driver, gettimeWaiting());
        return wait.until(ExpectedConditions
                .visibilityOf(element)).getText();
    }

    /**
     * Вводит текст.
     * @param element локатор элемента.
     * @param s то, что нужно ввести.
     */
    public void inputText(final WebElement element, final String s) {
        wait = new WebDriverWait(driver, gettimeWaiting());
        WebElement thisElement = wait.until(ExpectedConditions
                .visibilityOf(element));
        thisElement.sendKeys(s);
        thisElement.sendKeys(Keys.TAB);
    }
}
