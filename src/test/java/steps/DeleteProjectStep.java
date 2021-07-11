package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import pages.OverviewPage;
import pages.ProjectsPage;

public class DeleteProjectStep extends BaseStep {

    public DeleteProjectStep(WebDriver driver) {
        super(driver);
    }

    public void deleteProject(String projectRename) {
        DashboardPage dashboardPage = new DashboardPage(driver, true);
        dashboardPage.clickAdministrationButton();
        OverviewPage overviewPage = new OverviewPage(driver, true);
        overviewPage.clickProjectsButton();
        ProjectsPage projectsPage = new ProjectsPage(driver, true);
        projectsPage.deleteProject(projectRename);
        projectsPage.clickYesToDeleteLabel();
        projectsPage.clickOkToDeleteButton();
    }
}
