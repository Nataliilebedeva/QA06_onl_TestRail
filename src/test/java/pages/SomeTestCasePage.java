package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SomeTestCasePage extends BasePage {

    private final static String endpoint = "index.php?/cases/view/126"; //126 ??????
    private final static By test_case_title_By = By.className("content-breadcrumb");
    private final static By message_title_By = By.cssSelector(".message.message-success");

    public SomeTestCasePage(WebDriver driver, boolean openPageByURL) {
        super(driver, openPageByURL);
    }

    @Override
    protected void openPage() {
        driver.get(properties.getURL() + endpoint);
    }

    @Override
    public boolean isPageOpened() {
        try {
            return getTestCaseTitle().isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public WebElement getTestCaseTitle() {
        return driver.findElement(test_case_title_By);
    }

    public WebElement getMessageTitle() {
        return driver.findElement(message_title_By);
    }

    public String getMessageTitleText() {
        return getMessageTitle().getText();
    }
}
