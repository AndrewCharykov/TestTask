package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommunalPaymentsPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public By CommunalPaymentsDistrict = By.cssSelector(".payment-page__title_inner");
    public By ZKY_Moscow = By.xpath("//span[text()='ЖКУ-Москва']");
    public By MoscowPayments =By.xpath("//span[text()='г. Москва']");
    public By SpbPayments =By.xpath("//span[text()='г. Санкт-Петербург']");
    public CommunalPaymentsPage(WebDriver driver) {
        this.driver = driver;
    }


    public void CommunalPaymentsInCity (String s,By Element){
        wait = new WebDriverWait(driver, 60);
        WebElement DistrictNow = wait.until(ExpectedConditions.visibilityOfElementLocated(CommunalPaymentsDistrict));

        if(!DistrictNow.getText().equals(s)){
            ElementClick(CommunalPaymentsDistrict);
            wait = new WebDriverWait(driver, 60);
            wait.until(ExpectedConditions.visibilityOfElementLocated(Element)).click();
        }
    }

    public void ElementClick(By element){
        wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element)).click();
    }

    public void ElementWait(By Element){
        wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(Element));
    }
}
