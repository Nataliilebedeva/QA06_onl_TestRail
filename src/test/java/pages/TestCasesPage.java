package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestCasesPage extends BasePage {

    private final static String endpoint = "index.php?/suites/view/287"; //287 ??????
    private final static By test_case_title_By = By.cssSelector(".content-header-title.page_title");
    private final static By add_test_case_button_By = By.id("sidebar-cases-add");
    private final static By edit_some_test_case_button_By = By.xpath("//span[text() ='TestCaseLeb_2']/ancestor::tr[contains(@id,'row')]/td[5]");
    private final static By delete_some_test_case_button_By = By.xpath("//span[text() ='BlaBlaBla']/ancestor::tr[contains(@id,'row')]/td[6]");
    private final static By delete_permanently_some_test_case_button_By = By.xpath("//div[@class = 'button-group dialog-buttons-highlighted']/a[contains(@class, 'dialog-action-secondary button-black')]");
    private final static By delete_permanently2_some_test_case_button_By = By.xpath("//div[@class = 'button-group dialog-buttons-highlighted']/a[contains(@class, 'button button-left button-black dialog-action-default')]");
    private final static By delete_case_label_By = By.xpath("//span[text() ='BlaBlaBla']");
    private final static By test_cases_button_By = By.id("navigation-suites");


    public TestCasesPage(WebDriver driver, boolean openPageByURL) {
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

    public WebElement getAddTestCaseButton() {
        return driver.findElement(add_test_case_button_By);
    }

    public WebElement getEditSomeTestCaseButton() {
        return driver.findElement(edit_some_test_case_button_By);
    }

    public WebElement getDeleteSomeTestCaseButton() {
        return driver.findElement(delete_some_test_case_button_By);
    }

    public WebElement getDeletePermanentlySomeTestCaseButton() {
        return driver.findElement(delete_permanently_some_test_case_button_By);
    }

    public WebElement getDeletePermanentlySomeTestCaseButton2() {
        return driver.findElement(delete_permanently2_some_test_case_button_By);
    }

    public WebElement getDeleteCaseLabel() {
        return driver.findElement(delete_case_label_By);
    }

    public WebElement getTestCasesButton() {
        return driver.findElement(test_cases_button_By);
    }

    public void clickAddTestCaseButton() {
        getAddTestCaseButton().click();
    }

    public void clickEditSomeTestCaseButton() {
        getEditSomeTestCaseButton().click();
    }

    public void clickDeleteSomeTestCaseButton() {
        getDeleteSomeTestCaseButton().click();
    }

    public void clickDeletePermanentlySomeTestCaseButton() {
        getDeletePermanentlySomeTestCaseButton().click();
    }

    public void clickDeletePermanentlySomeTestCaseButton2() {
        getDeletePermanentlySomeTestCaseButton2().click();
    }

    public void clickTestCasesButton() {
        getTestCasesButton().click();
    }


}
