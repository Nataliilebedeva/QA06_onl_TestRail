package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;

public class AddEditTestCasePage extends BasePage {

    private final static String endpoint = "index.php?/cases/add/287"; //287 ??????
    //private final static String endpoint = "index.php?/cases/edit/196&group_by=cases:section_id&group_order=asc&display_deleted_cases=0&group_id=60"; //эндпоинт при переходе на эту страницу при попытке изменить тест кейс
    private final static By add_test_case_title_By = By.cssSelector(".content-header-title.page_title");
    private final static By case_title_input_By = By.id("title");
    private final static By case_precondition_input_By = By.id("custom_preconds_display");
    private final static By case_steps_input_By = By.id("custom_steps_display");
    private final static By case_expected_result_input_By = By.id("custom_expected_display");
    private final static By add_case_button_By = By.id("accept");

    public AddEditTestCasePage(WebDriver driver, boolean openPageByURL) {
        super(driver, openPageByURL);
    }

    @Override
    protected void openPage() { driver.get(properties.getURL()+ endpoint); }

    @Override
    public boolean isPageOpened() {
        try {
            return getAddTestCaseTitle().isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public WebElement getAddTestCaseTitle() { return driver.findElement(add_test_case_title_By);}
    public WebElement getCaseTitleInput() { return driver.findElement(case_title_input_By);}
    public WebElement getCasePreconditionInput() { return driver.findElement(case_precondition_input_By);}
    public WebElement getCaseStepsInput() { return driver.findElement(case_steps_input_By);}
    public WebElement getCaseExpectedResultInput() { return driver.findElement(case_expected_result_input_By);}
    public WebElement getAddCaseButton() { return driver.findElement(add_case_button_By);}

    public void setCaseTitleInput(String text) {
        getCaseTitleInput().sendKeys(text);
    }
    public void setCasePreconditionInput(String text) {
        getCasePreconditionInput().sendKeys(text);
    }
    public void setCaseStepsInput(String text) { getCaseStepsInput().sendKeys(text);}
    public void setCaseExpectedResultInput(String text){ getCaseExpectedResultInput().sendKeys(text); }
    public void clickAddCaseButton() {
        getAddCaseButton().click();
    }

    @DataProvider(name = "CaseDataProvider")
    public static Object[][] dataForCase () {
        return new Object[][]{{"BlaBlaBla","Precondition","Steps","Expected Result"}};
        }

    @DataProvider(name = "CaseDataProvider2")
    public static Object[][] dataForCase2 () {
        return new Object[][]{{"TestCaseLeb_2","Precondition_2","Steps_2","Expected Result_2"}};
    }

    @DataProvider(name = "EditCaseDataProvider")
    public static Object[][] editDataForCase () {
        return new Object[][]{{"(update)",":)))",":(((((","^____^"}};
    }

        }

