package andrey.test.task;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Домашняя страница.
 */
public class HomePage {
    /**
     * Вебдрайвер.
     */
    private WebDriver driver;

    /**
     * Лист, в котором будут все продукты головного меню
     */
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
     * URL домашней страницы.
     */
    private String homePageURL = "https://www.tinkoff.ru/";
    /**
     * Инициализация  драйвера.
     * @param driver драйвер.
     */
    public HomePage(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
    }
    /**
     * Открывает домашнюю страницу.
     */
    public void homePageOpen() {
        driver.get(homePageURL);
    }
}
