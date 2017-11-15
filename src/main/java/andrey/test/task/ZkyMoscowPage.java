package andrey.test.task;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Страница платежей в Москве.
 */
public class ZkyMoscowPage {
    /**
     * Вебдрайвер.
     */
    private WebDriver driver;
    /**
     * Элемент опталить жку в Москве.
     */
    @FindBy(xpath = "//span[text()='Оплатить ЖКУ в Москве']" )
    public WebElement payZkyInMoscow;
    /**
     *  Элемент Платежи.
     */
    @FindBy(css = "//span[@data-reactid='97']" )
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
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
    }

    /**
     * Вводит текст.
     * @param element локатор элемента.
     * @param s то, что нужно ввести.
     */
    public void inputText(final WebElement element, final String s) {
        element.sendKeys(s);
        element.sendKeys(Keys.TAB);
    }
}
