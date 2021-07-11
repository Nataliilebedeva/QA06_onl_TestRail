package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProjectsPage extends BasePage {

    private final static String endpoint = "index.php?/admin/projects/overview";
    private final static By project_Title_By = By.cssSelector(".content-header-title.page_title");
    private final static By successfully_Title_By = By.cssSelector(".message.message-success");
    private final static String project_edit_button = "//*[text() = 'replace']";
    private final static String project_delete_button = "//*[text() = 'replace']/ancestor::tr[@class = 'even hoverSensitive']//div[@class = 'icon-small-delete']";
    private final static By yes_to_delete_label_By = By.xpath("//*[text() = 'Yes, delete this project (cannot be undone)']/ancestor::div[@class = 'checkbox']//input[@name = 'deleteCheckbox']");
    private final static By ok_to_delete_button_By = By.xpath("//*[@id = 'deleteDialog']//a[contains(text(), 'OK')]");
    private final static By dashboard_button_By = By.id("navigation-dashboard");

    public ProjectsPage(WebDriver driver, boolean openPageByURL) {
        super(driver, openPageByURL);
    }

    @Override
    protected void openPage() {
        driver.get(properties.getURL() + endpoint);
    }


    @Override
    public boolean isPageOpened() {
        try {
            return getProjectTitleLabel().isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public WebElement getProjectTitleLabel() {
        return driver.findElement(project_Title_By);
    }

    public WebElement getSuccessfullyAddedTitle() {
        return driver.findElement(successfully_Title_By);
    }

    public String getSuccessfullyAddedText() {
        return getSuccessfullyAddedTitle().getText();
    }

    public WebElement getProjectEditButton(String projectName) {
        return driver.findElement(By.xpath(project_edit_button.replace("replace", projectName)));
    }

    public WebElement getProjectDeleteButton(String projectRename) {
        return driver.findElement(By.xpath(project_delete_button.replace("replace", projectRename)));
    }

    public WebElement getYesToDeleteLabel() {
        return driver.findElement(yes_to_delete_label_By);
    }

    public WebElement getOkToDeleteButton() {
        return driver.findElement(ok_to_delete_button_By);
    }

    public WebElement getDashboardButton() {
        return driver.findElement(dashboard_button_By);
    }


    public void selectProject(String projectName) {
        getProjectEditButton(projectName).click();
    }

    public void deleteProject(String projectRename) {
        getProjectDeleteButton(projectRename).click();
    }

    public void clickYesToDeleteLabel() {
        getYesToDeleteLabel().click();
    }

    public void clickOkToDeleteButton() {
        getOkToDeleteButton().click();
    }

    public void clickDashboardButton() {
        getDashboardButton().click();
    }
}
