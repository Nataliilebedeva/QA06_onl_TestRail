package steps;

import baseEntities.BasePage;
import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.AddProjectPage;
import pages.DashboardPage;
import pages.OverviewPage;
import pages.ProjectsPage;

public class EditProjectStep extends BaseStep {

    public EditProjectStep(WebDriver driver) {
        super(driver);
    }

    public void editProject(String projectName, String projectRename) {
        DashboardPage dashboardPage = new DashboardPage(driver, true);
        dashboardPage.clickAdministrationButton();
        OverviewPage overviewPage = new OverviewPage(driver, true);
        overviewPage.clickProjectsButton();
        ProjectsPage projectsPage = new ProjectsPage(driver, true);
        projectsPage.selectProject(projectName);
        AddProjectPage addProjectPage = new AddProjectPage(driver, false);
        addProjectPage.clearName();
        addProjectPage.setName(projectRename);
        addProjectPage.clickAddProjectButton2();

    }
}
