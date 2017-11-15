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
 * Страница коммунальных платежей.
 */
public class CommunalPaymentsPage {
     /**
     * Вебдрайвер.
     */
    private WebDriver driver;
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
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
    }

    /**
     *  Проверяте в каком городе.
     * @param s  стринга город.
     * @param element локатор элемента.
     */
    public void communalPaymentsInCity(final String s, final WebElement element) {
        WebElement districtNow = communalPaymentsDistrict;
        if (!districtNow.getText().equals(s)) {
            communalPaymentsDistrict.click();
            element.click();
        }
    }


}
