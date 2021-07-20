package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdvansedElementsTest2 extends BaseTest {

    @Test
    public void simpleAlertTest(){
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        WebElement simpleAlertButton = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        simpleAlertButton.click();

        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();

        WebDriverWait wait = new WebDriverWait(driver,5);
       WebElement resultLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result")));
        Assert.assertEquals(resultLabel.getText(), "You successfully clicked an alert");
    }

    @Test
    public void mediumAlertTest(){
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");

        WebElement simpleAlertButton = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        simpleAlertButton.click();

        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();

        WebDriverWait wait = new WebDriverWait(driver,5);
        WebElement resultLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result")));
        Assert.assertEquals(resultLabel.getText(), "You clicked: Cancel");
    }

    @Test
    public void promptAlertTest(){
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");

        WebElement simpleAlertButton = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        simpleAlertButton.click();

        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.sendKeys("Тестовое сообщение");
        alert.accept();

        WebDriverWait wait = new WebDriverWait(driver,5);
        WebElement resultLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result")));
        Assert.assertEquals(resultLabel.getText(), "You entered: Тестовое сообщение");
    }


}
