package elements;

import core.Waits;
import org.openqa.selenium.*;

import java.util.List;

public class UIElement implements WebElement {
    private By by;
    private final WebDriver driver;
    private final WebElement webElement;
    private JavascriptExecutor jsExecutor;
    private Waits waits;

    public UIElement(WebDriver driver, By by) {
        this.by = by;
        this.driver = driver;
        this.jsExecutor = (JavascriptExecutor) driver;
        this.waits = new Waits(driver);
        this.webElement = driver.findElement(by);
    }

    public UIElement(WebDriver driver, WebElement webElement) {
        this.driver = driver;
        this.jsExecutor = (JavascriptExecutor) driver;
        this.waits = new Waits(driver);
        this.webElement = webElement;
    }

    @Override
    public void click() {
        try {
            webElement.click();
        } catch (ElementNotVisibleException notVisibleException) {
            try {
                scrollIntoView();
                waits.waitForClickElement(webElement);
                webElement.click();
            } catch (Exception ex) {
                jsExecutor.executeScript("arguments[0].click();", webElement);
            }
        }
    }

    @Override
    public void submit() {
        scrollIntoView();
        webElement.submit();
    }

    @Override
    public void sendKeys(CharSequence... charSequences) {
        scrollIntoView();
        webElement.sendKeys(charSequences);
    }

    @Override
    public void clear() {
        webElement.clear();
    }

    @Override
    public String getTagName() {
        return webElement.getTagName();
    }

    @Override
    public String getAttribute(String s) {
        return webElement.getAttribute(s);
    }

    @Override
    public boolean isSelected() {
        return webElement.isSelected();
    }

    @Override
    public boolean isEnabled() {
        return webElement.isEnabled();
    }

    @Override
    public String getText() {
        return webElement.getText();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return webElement.findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        return webElement.findElement(by);
    }

    @Override
    public boolean isDisplayed() {
        return webElement.isDisplayed();
    }

    @Override
    public Point getLocation() {
        return webElement.getLocation();
    }

    @Override
    public Dimension getSize() {
        return webElement.getSize();
    }

    @Override
    public Rectangle getRect() {
        return webElement.getRect();
    }

    @Override
    public String getCssValue(String s) {
        return webElement.getCssValue(s);
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        return webElement.getScreenshotAs(outputType);
    }

    public void scrollIntoView() {
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", webElement);
    }

    public WebElement getParent() {
        return (WebElement) ((JavascriptExecutor) driver).executeScript("return arguments[0].parentNode;", webElement);
    }

}

