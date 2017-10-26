package andrey.test.task;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import andrey.test.task.pages.*;



public class test extends BaseTest {

    @Test
    public void TinkoffPage() throws InterruptedException {
        WebDriver driver = getDriver();
        //1.Переходом по адресу https://www.tinkoff.ru/ загрузить стартовую страницу Tinkoff Bank.
        HomePage homePage = new HomePage(driver);
        homePage.HomePageOpen();

        //2.Из верхнего меню, нажатием на пункт меню “Платежи“, перейти на страницу “Платежи“.
        homePage.ElementClick(homePage.Payments);

        //3.В списке категорий платежей, нажатием на пункт “Коммунальные платежи“, перейти на  страницу выбора поставщиков услуг.
        PaymentsPage paymentsPage = new PaymentsPage(driver);
        paymentsPage.ElementClick(paymentsPage.CommunalPayments);

        //4.Убедиться, что текущий регион – “г. Москва” (в противном случае выбрать регион “г. Москва” из списка регионов).
        CommunalPaymentsPage communalPaymentsPage = new CommunalPaymentsPage(driver);
        communalPaymentsPage.CommunalPaymentsInCity("Москве",communalPaymentsPage.MoscowPayments);

        //5.Со страницы выбора поставщиков услуг, выбрать 1-ый из списка (Должен быть “ЖКУ-Москва”).
        // Сохранить его наименование (далее “искомый”) и нажатием на соответствующий элемент перейти на страницу оплаты “ЖКУ-Москва
        communalPaymentsPage.ElementWait(communalPaymentsPage.ZKY_Moscow);
        String ZKY_Name = driver.findElement(communalPaymentsPage.ZKY_Moscow).getText();
        communalPaymentsPage.ElementClick(communalPaymentsPage.ZKY_Moscow);

        //6.На странице оплаты, перейти на вкладку “Оплатить ЖКУ в Москве“.
        ZKY_MoscowPage zky_moscowPage = new ZKY_MoscowPage(driver);
        zky_moscowPage.ElementClick(zky_moscowPage.PayZkyInMoscow);

        //7.Выполнить проверки на невалидные значения для обязательных полей: проверить все текстовые сообщения об ошибке (и их содержимое),
        // которые появляются под соответствующим полем ввода в результате ввода некорректных данных.
        zky_moscowPage.ElementClick(zky_moscowPage.buttonPayZkyInMoscow);
        Assert.assertEquals("Поле обязательное",zky_moscowPage.TextError(zky_moscowPage.ErrorMessageCodePayment));
        Assert.assertEquals("Поле обязательное",zky_moscowPage.TextError(zky_moscowPage.ErrorMessageDate));
        Assert.assertEquals("Поле обязательное",zky_moscowPage.TextError(zky_moscowPage.ErrorMessageSum));
        zky_moscowPage.InputText(zky_moscowPage.FieldPayerCode,"1");
        Assert.assertEquals("Поле неправильно заполнено",zky_moscowPage.TextError(zky_moscowPage.ErrorMessageCodePayment));
        zky_moscowPage.InputText(zky_moscowPage.FieldProviderPeriod,"1");
        Assert.assertEquals("Поле заполнено некорректно",zky_moscowPage.TextError(zky_moscowPage.ErrorMessageDate));
        zky_moscowPage.InputText(zky_moscowPage.FieldSum,"1");
        Assert.assertEquals("Минимальная сумма перевода - 10 \u20BD",zky_moscowPage.TextError(zky_moscowPage.ErrorMessageSum));
        zky_moscowPage.InputText(zky_moscowPage.FieldSum,"15001");
        Assert.assertEquals("Максимальная сумма перевода - 15 000 \u20BD",zky_moscowPage.TextError(zky_moscowPage.ErrorMessageSum));

        //8.Повторить шаг (2).
        zky_moscowPage.ElementClick(zky_moscowPage.Payments);

        //9.В строке быстрого поиска поставщика услуг ввести наименование искомого (ранее сохраненного).
        paymentsPage.InputTextInTheField(paymentsPage.FieldForInput,ZKY_Name);

        //10.Убедиться, что в списке предложенных провайдеров искомый поставщик первый.
        paymentsPage.CompareDropdown("ЖКУ-Москва");

        //11.Нажатием на элемент, соответствующий искомому, перейти на страницу “Оплатить ЖКУ в Москве“. Убедиться, что загруженная страница та же, что и страница, загруженная в результате шага (5).
        paymentsPage.ElementClick(paymentsPage.FirstElementInDropdown);

        //12.Выполнить шаги (2) и (3).
        homePage.ElementClick(homePage.Payments);
        paymentsPage.ElementClick(paymentsPage.CommunalPayments);

        //13.В списке регионов выбрать “г. Санкт-Петербург”.
        communalPaymentsPage.CommunalPaymentsInCity("Санкт-Петербурге",communalPaymentsPage.SpbPayments);

        //14.Убедится, что в списке поставщиков на странице выбора поставщиков услуг отсутствует искомый
        paymentsPage.InputTextInTheField(paymentsPage.FieldForInput,ZKY_Name);
        paymentsPage.NotIncluderInTheList();
    }

}
