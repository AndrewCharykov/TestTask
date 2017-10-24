package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private WebDriver driver;
    private WebDriverWait wait;

    public By Payments =By.xpath("//span[text()='Платежи'][@class='_3Qu__']");

    private String HomePageURL ="https://www.tinkoff.ru/";

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void HomePageOpen() {
        driver.get(HomePageURL);
    }

    public void ElementClick(By Element){
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(Element)).click();
    }


}
