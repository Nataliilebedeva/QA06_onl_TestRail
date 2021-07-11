package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddProjectPage extends BasePage {

    private final static String endpoint = "index.php?/admin/projects/add/1";
    private final static By add_Project_Title_By = By.cssSelector(".content-header-title.page_title");
    private final static By name_Input_By = By.id("name");
    private final static By add_project_button2_By = By.id("accept");


    public AddProjectPage(WebDriver driver, boolean openPageByURL) {
        super(driver, openPageByURL);
    }

    @Override
    protected void openPage() {driver.get(properties.getURL()+ endpoint);}

    @Override
    public boolean isPageOpened() {
        try {
            return getTitleLabel().isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public WebElement getTitleLabel() { return driver.findElement(add_Project_Title_By);}
    public WebElement getNameInput() { return driver.findElement(name_Input_By);}
    public WebElement getProjectButton2() { return driver.findElement(add_project_button2_By );}

    public void setName(String text) {
        getNameInput().sendKeys(text);
    }

    public void clickAddProjectButton2() {
        getProjectButton2().click();
    }
    public void clearName() {
        getNameInput().clear();
    }
}
