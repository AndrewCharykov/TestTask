package andrey.test.task;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
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

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

/**
 * Страница коммунальных платежей.
 */
public class CommunalPaymentsPage {
     /**
     * Вебдрайвер.
     */
    private WebDriver driver;
    /**
     * Текущее имя города.
     */
    @FindBy(css = ".payment-page__title_inner")
    private WebElement currentRegion;
    /**
     *
     * @param region
     * @return
     */
    public boolean isCurrentRegion(String region){
        return currentRegion.getText().equals(region);
    }
    /**
     * Открытие списка с регионами
     */
    public void openRegionList(){
        currentRegion.click();
    }
    /**
     *
     */
    @FindBy(xpath = "//span[@data-qa-file='UIRegions']")
    private List<WebElement> region;
    /**
     * Выбор ргеиона.
     */
    public void chooseRegion(String nameRegion){
        Optional<WebElement> first = region.stream()
                .filter(WebElement -> WebElement.getText().trim().equalsIgnoreCase(nameRegion)).findFirst();
        first.ifPresent(WebElement::click);
        first.orElseThrow(() -> new NoSuchElementException("Не могу найти данный регион"));
    }
    /**
     * Лист с услугами провайдера.
     */
    @FindBy(xpath = "//li[@data-qa-file='UIMenuItemProvider']")
    private List<WebElement> serviceProvider;

    /**
     *  Выбрать услугу
     * @param nameService
     */
    public void chooseServiceProvider(String nameService){
        Optional<WebElement> first = serviceProvider.stream()
                .filter(WebElement -> WebElement.getText().trim().equalsIgnoreCase(nameService)).findFirst();
        first.ifPresent(WebElement::click);
        first.orElseThrow(() -> new NoSuchElementException("Не могу найти данный услугу"));
    }
    /**
     *
     */
    @FindBy(xpath ="(//li[@data-qa-file='UIMenuItemProvider'])[1]")
    private WebElement firstService;
    /**
     * Имя первой услуги
     */
    public String firstServiceName(){
        return firstService.getText();
    }
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

}
