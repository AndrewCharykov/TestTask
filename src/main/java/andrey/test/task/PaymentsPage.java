package andrey.test.task;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Страница платежей.
 */
public class PaymentsPage  {
    /**
     * Вебдрайвер.
     */
    private WebDriver driver;
    /**
     * Элемент "Коммунальные платежи".
     */
    @FindBy(xpath = "//span[text()='Коммунальные платежи']" )
    public WebElement communalPayments;
    /**
     * Элемент Поле для ввода.
     */
    @FindBy(xpath = "//input[@autocomplete='off'][@autocapitalize='off']" )
    public WebElement fieldForInput;
    /**
     * Элемент Первый элемент из дропдайна.
     */
    @FindBy(css = "._2vlxq" )
    public WebElement firstElementInDropdown;
    /**
     * Инициализация драйвера.
     * @param driver драйвер.
     */
    public PaymentsPage(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
    }
    /**
     *  Сравнивает дропдаун.
     * @param s1 стринга.
     */
    public void compareDropdown(final String s1) {
        List<WebElement> elements =
              driver.findElements(By.xpath("//*[contains(text(),'Что оплатить или куда перевести?')]"));
        String s = elements.get(0).getText();
        String[] parts = (s + " ").split("\\p{P}?[ \\n]+");
        if (!parts[0].equals(s1)) {
            return;
        }
    }
    /**
     * Не входит в список.
     */
    public void notIncluderInTheList() {
        List<WebElement> elements =
              driver.findElements(By.xpath("//*[contains(text(),'Что оплатить или куда перевести?')]"));
        String s = elements.get(0).getText();
        if (!s.equals("Ничего не найдено")) {
            return;
        }
    }
}


