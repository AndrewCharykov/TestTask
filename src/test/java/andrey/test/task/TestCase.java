package andrey.test.task;

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

        homePage.elementClick(homePage.payments);

        PaymentsPage paymentsPage = new PaymentsPage(driver);
        paymentsPage.elementClick(paymentsPage.communalPayments);

        CommunalPaymentsPage communalPaymentsPage = new CommunalPaymentsPage(driver);
        communalPaymentsPage.communalPaymentsInCity("Москве",
                communalPaymentsPage.moscowPayments);

        communalPaymentsPage.elementWait(communalPaymentsPage.zkyMoscow);
        String zkyName = communalPaymentsPage.zkyMoscow.getText();
        communalPaymentsPage.elementClick(communalPaymentsPage.zkyMoscow);

        ZkyMoscowPage zkyMoscowPage = new ZkyMoscowPage(driver);
        zkyMoscowPage.elementClick(zkyMoscowPage.payZkyInMoscow);

        zkyMoscowPage.elementClick(zkyMoscowPage.buttonPayZkyInMoscow);
        Assert.assertEquals("Поле обязательное",
                zkyMoscowPage.textError(zkyMoscowPage.errorMessageCodePayment));

        Assert.assertEquals("Поле обязательное",
                zkyMoscowPage.textError(zkyMoscowPage.errorMessageDate));

        Assert.assertEquals("Поле обязательное",
                zkyMoscowPage.textError(zkyMoscowPage.errorMessageSum));

        zkyMoscowPage.inputText(zkyMoscowPage.fieldPayerCode, "1");

        Assert.assertEquals("Поле неправильно заполнено",
                zkyMoscowPage.textError(zkyMoscowPage.errorMessageCodePayment));

        zkyMoscowPage.inputText(zkyMoscowPage.fieldProviderPeriod, "1");

        Assert.assertEquals("Поле заполнено некорректно",
                zkyMoscowPage.textError(zkyMoscowPage.errorMessageDate));

        zkyMoscowPage.inputText(zkyMoscowPage.fieldSum, "1");

        Assert.assertEquals("Минимальная сумма перевода - 10 \u20BD",
                zkyMoscowPage.textError(zkyMoscowPage.errorMessageSum));

        zkyMoscowPage.inputText(zkyMoscowPage.fieldSum, "15001");

        Assert.assertEquals("Максимальная сумма перевода - 15 000 \u20BD",
                zkyMoscowPage.textError(zkyMoscowPage.errorMessageSum));

        zkyMoscowPage.elementClick(zkyMoscowPage.payments);

        paymentsPage.inputTextInTheField(paymentsPage.fieldForInput, zkyName);

        paymentsPage.compareDropdown("ЖКУ-Москва");

        paymentsPage.elementClick(paymentsPage.firstElementInDropdown);

        homePage.elementClick(homePage.payments);
        paymentsPage.elementClick(paymentsPage.communalPayments);

        communalPaymentsPage.communalPaymentsInCity("Санкт-Петербурге", communalPaymentsPage.spbPayments);

        paymentsPage.inputTextInTheField(paymentsPage.fieldForInput, zkyName);
        paymentsPage.notIncluderInTheList();
    }

}
