package andrey.test.task;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Страница платежей.
 */
public class PaymentsPage  {
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
    }

    /**
     * Ввод текста в поле.
     * @param element локатор поля.
     * @param s текст.
     */
    public void inputTextInTheField(final WebElement element, final String s) {
        wait = new WebDriverWait(driver, gettimeWaiting());
        wait.until(ExpectedConditions
                .visibilityOf(element)).click();
        element.sendKeys(s);
    }

    /**
     *  Сравнивает дропдаун.
     * @param s1 стринга.
     */
    public void compareDropdown(final String s1) {
        wait = new WebDriverWait(driver, gettimeWaiting());
        wait.until(ExpectedConditions
              .visibilityOfElementLocated(By.xpath("//div[@class='U_INn _3F9eq _1E2xX']")));
        List<WebElement> elements =
              driver.findElements(By.xpath("//div[@class='U_INn _3F9eq _1E2xX']"));
        String s = elements.get(0).getText();
        String[] parts = (s + " ").split("\\p{P}?[ \\n]+");
        if (!parts[0].equals(s1)) {
            return;
        }
    }

    /**
     * Нажатие на элемент.
     * @param element локатор элемента.
     */
    public void elementClick(final WebElement element) {
        wait = new WebDriverWait(driver, gettimeWaiting());
        wait.until(ExpectedConditions
                .visibilityOf(element)).click();
    }

    /**
     * Не входит в список.
     */
    public void notIncluderInTheList() {
        wait = new WebDriverWait(driver, gettimeWaiting());
        wait.until(ExpectedConditions
              .visibilityOfElementLocated(By.xpath("//div[@class='U_INn _3F9eq _1E2xX']")));
        List<WebElement> elements =
              driver.findElements(By.xpath("//div[@class='U_INn _3F9eq _1E2xX']"));
        String s = elements.get(0).getText();
        if (!s.equals("Ничего не найдено")) {
            return;
        }
    }
}


