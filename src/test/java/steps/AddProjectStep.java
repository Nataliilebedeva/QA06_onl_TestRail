package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.AddProjectPage;
import pages.DashboardPage;

public class AddProjectStep extends BaseStep {

    public AddProjectStep(WebDriver driver) {
        super(driver);
    }

    public void addProject(String projectName) {
        DashboardPage dashboardPage = new DashboardPage(driver, true);
        dashboardPage.clickAddProjectButton();
        AddProjectPage addProjectPage = new AddProjectPage(driver, true);
        addProjectPage.setName(projectName);
        addProjectPage.clickAddProjectButton2();

    }
}
