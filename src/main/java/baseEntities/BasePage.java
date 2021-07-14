package baseEntities;

import core.ReadProperties;
import core.Waits;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    protected static final int WAIT_FOR_PAGE_LOADING_SEC = 5;

    protected WebDriver driver;
    protected ReadProperties properties = new ReadProperties();
    protected Waits waits;

    protected abstract void openPage();

    public abstract boolean isPageOpened();

    public BasePage(WebDriver driver, boolean openPageByURL) {
        this.driver = driver;
        waits = new Waits(driver, properties.getTimeOut());
       // properties = new ReadProperties();

        if (openPageByURL) {
            openPage();
        }

        waitForOpen();
    }

    protected void waitForOpen() {
        int secondsCount = 0;
        boolean isPageOpenedIndicator = isPageOpened();

        while (!isPageOpenedIndicator && secondsCount < WAIT_FOR_PAGE_LOADING_SEC) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            secondsCount++;
            isPageOpenedIndicator = isPageOpened();
        }

        if (!isPageOpenedIndicator) {
            throw new AssertionError("Page was not opened");
        }
    }
}
