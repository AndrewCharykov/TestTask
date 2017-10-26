package andrey.test.task.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class PaymentsPage  {

    private WebDriver driver;
    private WebDriverWait wait;

    public By CommunalPayments = By.xpath("//span[text()='Коммунальные платежи']");
    public By FieldForInput = By.xpath("//input[@autocomplete='off']");
    public By FirstElementInDropdown = By.cssSelector("._2vlxq");

    public PaymentsPage(WebDriver driver){
        this.driver = driver;
    }

    public void InputTextInTheField(By element, String s){
        wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element)).click();
        driver.findElement(element).sendKeys(s);
    }

    public void CompareDropdown (String s1){
        wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='_2vlxq']")));
        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='_2vlxq']"));
        String s = elements.get(0).getText();
        String[] parts = (s + " ").split("\\p{P}?[ \\n]+");

        if(!parts[0].equals(s1)) {
            return;
        }
    }

    public void ElementClick(By Element){
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(Element)).click();
    }

    public void NotIncluderInTheList(){
        wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='_200uJ']")));
        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='_200uJ']"));
        String s = elements.get(0).getText();
        if(!s.equals("Ничего не найдено")) {
            return;
        }
    }
}


