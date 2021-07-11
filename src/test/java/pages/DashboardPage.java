package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage extends BasePage {

    private final static String endpoint = "index.php?/dashboard";
    private final static By dashboard_label_By = By.id("navigation-dashboard");
    private final static By add_project_button_By = By.id("sidebar-projects-add");
    private final static By administration_button_By = By.id("navigation-admin");
    private final static String some_project_button = "//*[text() = 'replace']";

    public DashboardPage(WebDriver driver, boolean openPageByURL) {
        super(driver, openPageByURL);
    }

    @Override
    protected void openPage() {
        driver.get(properties.getURL()+ endpoint);
    }

    @Override
    public boolean isPageOpened() {
        try {
            return getTitleLabel().isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public WebElement getTitleLabel() { return driver.findElement(dashboard_label_By);}
    public String getTitleText() { return getTitleLabel().getText();}
    public WebElement getProjectButton() { return driver.findElement(add_project_button_By);}
    public WebElement getAdministrationButton() { return driver.findElement(administration_button_By);}
    public WebElement getSomeProjectButton(String projectRename) {
        return driver.findElement(By.xpath(some_project_button.replace("replace", projectRename)));
    }

    public void clickAddProjectButton() {
        getProjectButton().click();
    }
    public void clickAdministrationButton()  {
        getAdministrationButton().click();
    }
    public void clickSomeProjectButton(String projectRename)  {
        getSomeProjectButton(projectRename).click();
    }
}
