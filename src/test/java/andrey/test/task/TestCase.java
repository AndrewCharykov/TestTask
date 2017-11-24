package andrey.test.task;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.openqa.selenium.Keys.ENTER;
import static org.openqa.selenium.Keys.TAB;


/**
 * Первый тест.
 */
public class TestCase extends BaseTest {
    /**
     * Погнали.
     * @throws InterruptedException  погнали.
     */
    @Test
    public void tinkoffPage() throws InterruptedException {
        WebDriver driver = getDriver();

        HomePage homePage = new HomePage(driver);
        homePage.homePageOpen();
        homePage.chooseProductMenuItem("Платежи");

        PaymentsPage paymentsPage = new PaymentsPage(driver);
        paymentsPage.chooseMenuItemProvider("Коммунальные платежи");

        CommunalPaymentsPage communalPaymentsPage = new CommunalPaymentsPage(driver);
        if(!communalPaymentsPage.isCurrentRegion("Москве")){
            communalPaymentsPage.openRegionList();
            communalPaymentsPage.chooseRegion("г. Москва");
        }

        String firstService = communalPaymentsPage.firstServiceName();
        communalPaymentsPage.chooseServiceProvider("ЖКУ-Москва");

        ZkyMoscowPage zkyMoscowPage = new ZkyMoscowPage(driver);
        zkyMoscowPage.chooseTab("ОПЛАТИТЬ ЖКУ В МОСКВЕ");

        zkyMoscowPage.clickButton("Оплатить ЖКУ в Москве");

        Assert.assertEquals("Поле обязательное",
                zkyMoscowPage.errorMessageCodePayment.getText());

        Assert.assertEquals("Поле обязательное",
                zkyMoscowPage.errorMessageDate.getText());

        Assert.assertEquals("Поле обязательное",
                zkyMoscowPage.errorMessageSum.getText());

        zkyMoscowPage.writeTextInField("Код плательщика за ЖКУ в Москве", "1");
        zkyMoscowPage.writeTextInField("За какой период оплачиваете коммунальные услуги","1");
        zkyMoscowPage.writeTextInField("Сумма платежа, от 10 до 15 000 \u20BD", "1", TAB);


        Assert.assertEquals("Поле неправильно заполнено",
                zkyMoscowPage.errorMessageCodePayment.getText());
        Assert.assertEquals("Поле заполнено некорректно",
                zkyMoscowPage.errorMessageDate.getText());
        Assert.assertEquals("Минимальная сумма перевода - 10 \u20BD",
                zkyMoscowPage.errorMessageSum.getText());

        zkyMoscowPage.fieldSum.sendKeys( "15001");

        Assert.assertEquals("Максимальная сумма перевода - 15 000 \u20BD",
               zkyMoscowPage.errorMessageSum.getText());

        zkyMoscowPage.fieldSum.sendKeys( TAB);

        zkyMoscowPage.payments.click();

       // paymentsPage.fieldForInput.sendKeys(zkyName);


        paymentsPage.compareDropdown("ЖКУ-Москва");

        paymentsPage.firstElementInDropdown.click();

        homePage.chooseProductMenuItem("Платежи");
        paymentsPage.chooseMenuItemProvider("Коммунальные платежи");

        communalPaymentsPage.openRegionList();
        communalPaymentsPage.chooseRegion("г. Санкт-Петербург");

     //   paymentsPage.fieldForInput.sendKeys(zkyName);
        paymentsPage.notIncluderInTheList();
    }

}
