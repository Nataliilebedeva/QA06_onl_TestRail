package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.AddProjectPage;
import pages.DashboardPage;
import pages.OverviewPage;
import pages.ProjectsPage;

public class ProjectSteps extends BaseStep {
    public ProjectSteps(WebDriver driver) {
        super(driver);
    }

    public void addProject(String projectName) {
        DashboardPage dashboardPage = new DashboardPage(driver, true);
        dashboardPage.clickAddProjectButton();
        AddProjectPage addProjectPage = new AddProjectPage(driver, true);
        addProjectPage.setName(projectName);
        addProjectPage.clickAddProjectButton2();
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
