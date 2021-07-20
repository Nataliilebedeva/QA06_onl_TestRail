package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.*;

public class AddTestCaseStep extends BaseStep {

    public AddTestCaseStep(WebDriver driver) {
        super(driver);
    }

    public void returnToDashboard (){
        ProjectsPage projectsPage = new ProjectsPage(driver, true);
        projectsPage.clickDashboardButton();
    }

    public void addTestCase(String projectRename, String title, String precondition, String steps, String expresult) {

        DashboardPage dashboardPage = new DashboardPage(driver, true);
        dashboardPage.clickSomeProjectButton(projectRename);

        SomeProjectPage someProjectPage = new SomeProjectPage(driver, false);
        someProjectPage.clickTestCaseButton();

        TestCasesPage testCasesPage = new TestCasesPage(driver, false);
        testCasesPage.clickAddTestCaseButton();

        AddEditTestCasePage addEditTestCasePage = new AddEditTestCasePage(driver, false);
        addEditTestCasePage.setCaseTitleInput(title);
        addEditTestCasePage.setCasePreconditionInput(precondition);
        addEditTestCasePage.setCaseStepsInput(steps);
        addEditTestCasePage.setCaseExpectedResultInput(expresult);
        addEditTestCasePage.clickAddCaseButton();
    }


    }
