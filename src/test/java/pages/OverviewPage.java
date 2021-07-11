package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OverviewPage extends BasePage {

    private final static String endpoint = "index.php?/admin/overview";
    private final static By overview_label_By = By.cssSelector(".content-header-title.page_title");
    private final static By projects_button_By = By.id("navigation-sub-projects");

    public OverviewPage(WebDriver driver, boolean openPageByURL) {
        super(driver, openPageByURL);
    }

    @Override
    protected void openPage() {
        driver.get(properties.getURL() + endpoint);
    }

    @Override
    public boolean isPageOpened() {
        try {
            return getOverviewLabel().isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public WebElement getOverviewLabel() {
        return driver.findElement(overview_label_By);
    }

    public WebElement getProjectsButton() {
        return driver.findElement(projects_button_By);
    }

    public void clickProjectsButton() {
        getProjectsButton().click();
    }

}
