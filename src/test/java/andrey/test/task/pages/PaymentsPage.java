package andrey.test.task.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
     * Вейтер.
     */
    private WebDriverWait wait;
    /**
     * Локтор "Коммунальные платежи".
     */
    private By communalPayments =
            By.xpath("//span[text()='Коммунальные платежи']");

    /**
     * Возвращает локатор.
     * @return локатор.
     */
    public By getCommunalPayments() {
        return communalPayments;
    }

    /**
     * Поле для ввода.
     */
    private By fieldForInput = By.xpath("//input[@autocomplete='off']");

    /**
     * Возвращает локатор.
     * @return локатор.
     */
    public By getFieldForInput() {
        return fieldForInput;
    }

    /**
     * Первый элемент из дропдайна.
     */
    private By firstElementInDropdown = By.cssSelector("._2vlxq");

    /**
     * Возвращает локатор первого элемента из дропдауна.
     * @return локатор.
     */
    public By getFirstElementInDropdown() {
        return firstElementInDropdown;
    }

    /**
     * Инициализация драйвера.
     * @param driver драйвер.
     */
    public PaymentsPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Ввод текста в поле.
     * @param element локатор поля.
     * @param s текст.
     */
    public void inputTextInTheField(By element, String s) {
        wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element)).click();
        driver.findElement(element).sendKeys(s);
    }

    /**
     *  Сравнивает дропдаун.
     * @param s1 стринга.
     */
    public void compareDropdown(String s1) {
        wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='_2vlxq']")));
        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='_2vlxq']"));
        String s = elements.get(0).getText();
        String[] parts = (s + " ").split("\\p{P}?[ \\n]+");
        if(!parts[0].equals(s1)) {
            return;
        }
    }

    /**
     * Нажатие на элемент.
     * @param element локатор элемента.
     */
    public void elementClick(By element) {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element)).click();
    }

    /**
     * Не входит в список.
     */
    public void notIncluderInTheList() {
        wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='_200uJ']")));
        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='_200uJ']"));
        String s = elements.get(0).getText();
        if(!s.equals("Ничего не найдено")) {
            return;
        }
    }
}


