package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class AlertsIFrameJavaScriptExecutorTestsHomeWork extends BaseTest {

    @Test
    public void simpleAlertTest() {
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");

        WebElement simpleAlertButton = waits.waitForVisibility(By.xpath("//button[.='Click for JS Alert']"));
        simpleAlertButton.click();

        Alert alert = driver.switchTo().alert();
        alert.accept();
        WebElement textResult = waits.waitForVisibility(By.id("result"));

        Assert.assertEquals(textResult.getText(), "You successfully clicked an alert");
    }

    @Test
    public void mediumAlertTest() {
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");

        WebElement mediumAlertButton = waits.waitForVisibility(By.xpath("//button[.='Click for JS Confirm']"));
        mediumAlertButton.click();

        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        WebElement textResult = waits.waitForVisibility(By.id("result"));

        Assert.assertEquals(textResult.getText(), "You clicked: Cancel");
    }

    @Test
    public void hurdAlertTest() {
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");

        WebElement hurdAlertButton = waits.waitForVisibility(By.xpath("//button[.='Click for JS Prompt']"));
        hurdAlertButton.click();

        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Привет");
        alert.accept();
        WebElement textResult = waits.waitForVisibility(By.id("result"));

        Assert.assertEquals(textResult.getText(), "You entered: Привет");
    }

    @Test
    public void alertTest() {
        driver.get("http://the-internet.herokuapp.com/iframe");

        driver.switchTo().frame("mce_0_ifr");

        WebElement inputTextMessage = waits.waitForVisibility(By.tagName("p"));
        inputTextMessage.clear();
        inputTextMessage.sendKeys("Привет");

        driver.switchTo().defaultContent();

        WebElement centerButton = waits.waitForVisibility(By.xpath("//button[@title = 'Align center']"));
        centerButton.click();
    }

    @Test
    public void alertOnlinerTest() {
        driver.get("https://www.onliner.by/");

        WebElement searchInput = waits.waitForVisibility(By.className("fast-search__input"));
        searchInput.sendKeys("Палатка", Keys.ENTER);

        WebElement iframe = waits.waitForVisibility(By.xpath("//iframe[@class= 'modal-iframe']"));

        driver.switchTo().frame(iframe);

        List<WebElement> titleProduct = waits.waitForPresentElements(By.xpath("//div[@class='product__title']/a"));
        String textFirstProduct = titleProduct.get(0).getText();
        System.out.println(textFirstProduct);

        WebElement searchInputIFrame = waits.waitForVisibility(By.xpath("//input[@class='search__input']"));
        searchInputIFrame.clear();
        searchInputIFrame.sendKeys(textFirstProduct);

        String product_Name_Button = "//a[.='replace']";
        WebElement productNameButton = driver.findElement(By.xpath(product_Name_Button.replace("replace", textFirstProduct)));
        waits.waitForVisibilityElement(productNameButton);
        productNameButton.click();

        driver.switchTo().defaultContent();

        String title_product = "//h1[contains(text(), 'replace')]";
        WebElement titleSomeProduct = waits.waitForVisibility(By.xpath(title_product.replace("replace", textFirstProduct)));

        Assert.assertEquals(titleSomeProduct.getText(), textFirstProduct);
    }

    @Test
    public void jsScrollOnlinerTest() {
        driver.get("https://www.onliner.by/");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
}
