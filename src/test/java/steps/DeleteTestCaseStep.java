package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import pages.SomeProjectPage;
import pages.TestCasesPage;

public class DeleteTestCaseStep extends BaseStep {

    public DeleteTestCaseStep(WebDriver driver) {
        super(driver);
    }

    public void deleteTestCase(String projectRename) {
        DashboardPage dashboardPage = new DashboardPage(driver, true);
        dashboardPage.clickSomeProjectButton(projectRename);

        SomeProjectPage someProjectPage = new SomeProjectPage(driver, false);
        someProjectPage.clickTestCaseButton();

        TestCasesPage testCasesPage = new TestCasesPage(driver, false);
        testCasesPage.clickDeleteSomeTestCaseButton();
        testCasesPage.clickDeletePermanentlySomeTestCaseButton();
        testCasesPage.clickDeletePermanentlySomeTestCaseButton2();
        testCasesPage.clickTestCasesButton();

    }
}
