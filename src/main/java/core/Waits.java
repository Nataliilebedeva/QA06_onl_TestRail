package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Waits {
    private WebDriverWait wait;

    public Waits(WebDriver driver, int timeOut) {
        wait = new WebDriverWait(driver, timeOut);
    }

    //не только наличие в дом-модели, но и его отображение на экране: присутствует и отображается
    public WebElement waitForVisibility(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    //только наличие в дом-модели вообще
    public WebElement waitForPresent(By by) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }


    public WebElement waitForVisibilityElement(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public List<WebElement> waitForVisibilityAllElements(By by) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    public Boolean waitForInvisibility(By by) {
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public Boolean waitForAttribute(By by, String attributeName, String attributeValue) {
        return wait.until(ExpectedConditions.attributeToBe(by, attributeName, attributeValue));
    }

    public Boolean waitForWindows(int windowsCount) {
        return wait.until(ExpectedConditions.numberOfWindowsToBe(windowsCount));
    }
}

