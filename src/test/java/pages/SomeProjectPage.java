package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SomeProjectPage extends BasePage {

    private final static String endpoint = "index.php?/projects/overview/315"; //315 ??????
    private final static By test_project_title_By = By.cssSelector(".content-header-title.page_title");
    private final static By test_case_button_By = By.id("navigation-suites");

    public SomeProjectPage(WebDriver driver, boolean openPageByURL) {
        super(driver, openPageByURL);
    }

    @Override
    protected void openPage() { driver.get(properties.getURL()+ endpoint); }

    @Override
    public boolean isPageOpened() {
        try {
            return getProjectTitle().isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public WebElement getProjectTitle() { return driver.findElement(test_project_title_By);}
    public WebElement getTestCaseButton() { return driver.findElement(test_case_button_By);}

    public void clickTestCaseButton()  {
        getTestCaseButton().click();
    }
}
