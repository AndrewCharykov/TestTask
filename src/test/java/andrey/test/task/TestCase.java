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
        //1.Переходом по адресу https://www.tinkoff.ru/
        // загрузить стартовую страницу Tinkoff Bank.
        HomePage homePage = new HomePage(driver);
        homePage.homePageOpen();

        //2.Из верхнего меню, нажатием на пункт меню “Платежи“,
        // перейти на страницу “Платежи“.
        homePage.elementClick(homePage.getPayments());

        //3.В списке категорий платежей,
        // нажатием на пункт “Коммунальные платежи“,
        // перейти на  страницу выбора поставщиков услуг.
        PaymentsPage paymentsPage = new PaymentsPage(driver);
        paymentsPage.elementClick(paymentsPage.getCommunalPayments());

        //4.Убедиться, что текущий регион – “г. Москва”
        // (в противном случае выбрать регион “г. Москва” из списка регионов).
        CommunalPaymentsPage communalPaymentsPage = new CommunalPaymentsPage(driver);
        communalPaymentsPage.communalPaymentsInCity("Москве",
                communalPaymentsPage.getMoscowPayments());

        //5.Со страницы выбора поставщиков услуг,
        // выбрать 1-ый из списка (Должен быть “ЖКУ-Москва”).
        // Сохранить его наименование (далее “искомый”)
        // и нажатием на соответствующий элемент перейти на страницу оплаты “ЖКУ-Москва
        communalPaymentsPage.elementWait(communalPaymentsPage.getZkyMoscow());
        String zkyName = driver.findElement(communalPaymentsPage.getZkyMoscow()).getText();
        communalPaymentsPage.elementClick(communalPaymentsPage.getZkyMoscow());

        //6.На странице оплаты, перейти на вкладку “Оплатить ЖКУ в Москве“.
        ZkyMoscowPage zkyMoscowPage = new ZkyMoscowPage(driver);
        zkyMoscowPage.elementClick(zkyMoscowPage.getPayZkyInMoscow());

        //7.Выполнить проверки на невалидные значения для обязательных полей:
        // проверить все текстовые сообщения об ошибке (и их содержимое),
        // которые появляются под соответствующим полем ввода
        // в результате ввода некорректных данных.
        zkyMoscowPage.elementClick(zkyMoscowPage.getButtonPayZkyInMoscow());
        Assert.assertEquals("Поле обязательное",
                zkyMoscowPage.textError(zkyMoscowPage.getErrorMessageCodePayment()));

        Assert.assertEquals("Поле обязательное",
                zkyMoscowPage.textError(zkyMoscowPage.getErrorMessageDate()));

        Assert.assertEquals("Поле обязательное",
                zkyMoscowPage.textError(zkyMoscowPage.getErrorMessageSum()));

        zkyMoscowPage.inputText(zkyMoscowPage.getFieldPayerCode(), "1");

        Assert.assertEquals("Поле неправильно заполнено",
                zkyMoscowPage.textError(zkyMoscowPage.getErrorMessageCodePayment()));

        zkyMoscowPage.inputText(zkyMoscowPage.getFieldProviderPeriod(), "1");

        Assert.assertEquals("Поле заполнено некорректно",
                zkyMoscowPage.textError(zkyMoscowPage.getErrorMessageDate()));

        zkyMoscowPage.inputText(zkyMoscowPage.getFieldSum(), "1");

        Assert.assertEquals("Минимальная сумма перевода - 10 \u20BD",
                zkyMoscowPage.textError(zkyMoscowPage.getErrorMessageSum()));

        zkyMoscowPage.inputText(zkyMoscowPage.getFieldSum(), "15001");

        Assert.assertEquals("Максимальная сумма перевода - 15 000 \u20BD",
                zkyMoscowPage.textError(zkyMoscowPage.getErrorMessageSum()));

        //8.Повторить шаг (2).
        zkyMoscowPage.elementClick(zkyMoscowPage.getPayments());

        //9.В строке быстрого поиска поставщика услуг
        // ввести наименование искомого (ранее сохраненного).
        paymentsPage.inputTextInTheField(paymentsPage.getFieldForInput(), zkyName);

        //10.Убедиться, что в списке предложенных провайдеров
        // искомый поставщик первый.
        paymentsPage.compareDropdown("ЖКУ-Москва");

        //11.Нажатием на элемент, соответствующий искомому,
        // перейти на страницу “Оплатить ЖКУ в Москве“.
        // Убедиться, что загруженная страница та же,
        // что и страница, загруженная в результате шага (5).
        paymentsPage.elementClick(paymentsPage.getFirstElementInDropdown());

        //12.Выполнить шаги (2) и (3).
        homePage.elementClick(homePage.getPayments());
        paymentsPage.elementClick(paymentsPage.getCommunalPayments());

        //13.В списке регионов выбрать “г. Санкт-Петербург”.
        communalPaymentsPage.communalPaymentsInCity("Санкт-Петербурге", communalPaymentsPage.getSpbPayments());

        //14.Убедится, что в списке поставщиков на странице выбора поставщиков
        // услуг отсутствует искомый
        paymentsPage.inputTextInTheField(paymentsPage.getFieldForInput(), zkyName);
        paymentsPage.notIncluderInTheList();
    }

}
