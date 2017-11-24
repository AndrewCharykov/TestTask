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

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Страница платежей в Москве.
 */
public class ZkyMoscowPage {
    /**
     * Вебдрайвер.
     */
    private WebDriver driver;

    @FindBy(xpath = "//span[@data-qa-file='HeaderMenuItem']")
    private List<WebElement> productMenuItem;

    /**
     * Метод для выбора продукта в головном меню
     * @param menuName Передаем название вкладки
     */
    public void chooseProductMenuItem(final String menuName){
        Optional<WebElement> first = productMenuItem.stream()
                .filter(WebElement -> WebElement.getText().trim().equalsIgnoreCase(menuName)).findFirst();
        first.ifPresent(WebElement::click);
        first.orElseThrow(() -> new NoSuchElementException("Не могу найти данный пункт меню"));
    }
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
    @FindBy(xpath = "(//div[@data-qa-file='UIFormRowError'])[1]" )
    public WebElement errorMessageCodePayment;
    /**
     * Элемент ошибки даты.
     */
    @FindBy(xpath = "(//div[@data-qa-file='UIFormRowError'])[2]" )
    public WebElement errorMessageDate;
    /**
     * Элемент Ошибка сообщение суммы.
     */
    @FindBy(xpath = "(//div[@data-qa-file='UIFormRowError'])[3]" )
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
     * таб
     */
    @FindBy(xpath = "//span[@data-qa-file='Tab']")
    private List<WebElement> tabs;
    /**
     * Выбор нужного таба
     */
    public void chooseTab(String tabName) {
        Optional<WebElement> first = tabs.stream()
                .filter(WebElement -> WebElement.getText().trim().equalsIgnoreCase(tabName)).findFirst();
        first.ifPresent(WebElement::click);
        first.orElseThrow(() -> new NoSuchElementException("Не могу найти данный услугу"));
    }
    /**
     * Кнопки
     */
    @FindBy(xpath = "//button[@data-qa-file='UIButton']")
    private List<WebElement> buttonList;
    /**
     * Кликнуть по кнопке
     */
    public void clickButton(String buttonName){
        Optional<WebElement> first = buttonList.stream()
                .filter(WebElement -> WebElement.getText().trim().equalsIgnoreCase(buttonName)).findFirst();
        first.ifPresent(WebElement::click);
        first.orElseThrow(() -> new NoSuchElementException("Не могу найти данный кнопку"));
    }

    /**
     *
     */
    @FindBy(xpath = "//label[@data-qa-file='UIInput']")
    private List<WebElement> textField;

    public void writeTextInField(String field ,CharSequence... text ){
        Optional<WebElement> first = textField.stream()
                .filter(webElement -> webElement.getText().trim().equalsIgnoreCase(field)).findFirst();
        first.ifPresent(edit -> edit.sendKeys(text));
        first.orElseThrow(() -> new NoSuchElementException("Не могу найти данное поле"));
    }

}
