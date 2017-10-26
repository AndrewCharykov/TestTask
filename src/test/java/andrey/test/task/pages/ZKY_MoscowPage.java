package andrey.test.task.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ZKY_MoscowPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public By PayZkyInMoscow = By.xpath("//span[text()='Оплатить ЖКУ в Москве']");
    public By Payments = By.cssSelector("[data-reactid='97']");
    public By buttonPayZkyInMoscow =By.xpath("//h2[text()='Оплатить ЖКУ в Москве']");
    public By FieldPayerCode = By.xpath("id('payerCode')");
    public By FieldProviderPeriod = By.xpath("//input[@name='provider-period']");
    public By FieldSum = By.xpath("//div[1]/div[1]/div[1]/div[1]/label[1]/div[1]/input[1]");
    public By ErrorMessageCodePayment = By.xpath("//form[1]/div[1]/div[1]/div[2]");
    public By ErrorMessageDate = By.xpath("//form[1]/div[2]/div[1]/div[2]");
    public By ErrorMessageSum = By.xpath("//div[1]/div[1]/div[1]/div[1]/div[1]/div[2]");

    public ZKY_MoscowPage(WebDriver driver) {
        this.driver = driver;
    }

    public void ElementClick(By element){
        wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element)).click();
    }

    public String TextError (By element){
        wait = new WebDriverWait(driver, 60);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(element)).getText();
    }
    public void InputText(By element, String s){
        wait = new WebDriverWait(driver, 60);
        WebElement Element = wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        Element.sendKeys(s);
        Element.sendKeys(Keys.TAB);
    }
}
