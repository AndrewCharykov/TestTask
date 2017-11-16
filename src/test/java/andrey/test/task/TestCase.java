package andrey.test.task;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


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

        homePage.payments.click();

        PaymentsPage paymentsPage = new PaymentsPage(driver);
        paymentsPage.communalPayments.click();

        CommunalPaymentsPage communalPaymentsPage = new CommunalPaymentsPage(driver);
        communalPaymentsPage.communalPaymentsInCity("Москве",
                communalPaymentsPage.moscowPayments);

        String zkyName = communalPaymentsPage.zkyMoscow.getText();
        communalPaymentsPage.zkyMoscow.click();

        ZkyMoscowPage zkyMoscowPage = new ZkyMoscowPage(driver);
        zkyMoscowPage.payZkyInMoscow.click();

        zkyMoscowPage.buttonPayZkyInMoscow.click();

        Assert.assertEquals("Поле обязательное",
                zkyMoscowPage.errorMessageCodePayment.getText());

        Assert.assertEquals("Поле обязательное",
                zkyMoscowPage.errorMessageDate.getText());

        Assert.assertEquals("Поле обязательное",
                zkyMoscowPage.errorMessageSum.getText());

        zkyMoscowPage.fieldPayerCode.sendKeys( "1");
        zkyMoscowPage.fieldProviderPeriod.sendKeys( "1");
        zkyMoscowPage.fieldSum.sendKeys( "1");
        zkyMoscowPage.fieldSum.sendKeys( Keys.TAB);

        Assert.assertEquals("Поле неправильно заполнено",
                zkyMoscowPage.errorMessageCodePayment.getText());
        Assert.assertEquals("Поле заполнено некорректно",
                zkyMoscowPage.errorMessageDate.getText());
        Assert.assertEquals("Минимальная сумма перевода - 10 \u20BD",
                zkyMoscowPage.errorMessageSum.getText());

        zkyMoscowPage.fieldSum.sendKeys( "15001");

        Assert.assertEquals("Максимальная сумма перевода - 15 000 \u20BD",
               zkyMoscowPage.errorMessageSum.getText());

        zkyMoscowPage.fieldSum.sendKeys( Keys.TAB);

        zkyMoscowPage.payments.click();

        paymentsPage.fieldForInput.sendKeys(zkyName);


        paymentsPage.compareDropdown("ЖКУ-Москва");

        paymentsPage.firstElementInDropdown.click();

        homePage.payments.click();
        paymentsPage.communalPayments.click();

        communalPaymentsPage.communalPaymentsInCity("Санкт-Петербурге", communalPaymentsPage.spbPayments);

        paymentsPage.fieldForInput.sendKeys(zkyName);
        paymentsPage.notIncluderInTheList();
    }

}
