package tests.TestRail;

import baseEntities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.ProjectsPage;
import steps.AddProjectStep;
import steps.DeleteProjectStep;
import steps.EditProjectStep;
import steps.LoginStep;

//запускать через param.xml с добавлением корректного логина и пароля
public class AddEditDeleteProjectTests extends BaseTest {

    @Parameters({"login-value", "psw-value"})
    @Test(invocationCount = 2)
    public void positiveAddProjectTest(String login, String psw) {
        LoginStep loginStep = new LoginStep(driver);
        loginStep.login(login, psw);
        AddProjectStep addProjectStep = new AddProjectStep(driver);
        addProjectStep.addProject(properties.getProjectName());
        Assert.assertEquals(new ProjectsPage(driver, false).getSuccessfullyAddedText(), "Successfully added the new project.");
    }

    @Parameters({"login-value", "psw-value"})
    @Test(dependsOnMethods = "positiveAddProjectTest", invocationCount = 2)
    public void positiveEditProjectTest(String login, String psw) {
        LoginStep loginStep = new LoginStep(driver);
        loginStep.login(login, psw);
        EditProjectStep editProjectStep = new EditProjectStep(driver);
        editProjectStep.editProject(properties.getProjectName(), properties.getReProjectName());
        Assert.assertEquals(new ProjectsPage(driver, false).getSuccessfullyAddedText(), "Successfully updated the project.");
    }

    @Parameters({"login-value", "psw-value"})
    @Test(dependsOnMethods = "positiveEditProjectTest", invocationCount = 2)
    public void positiveDeleteProjectTest(String login, String psw) {
        LoginStep loginStep = new LoginStep(driver);
        loginStep.login(login, psw);
        DeleteProjectStep deleteProjectStep = new DeleteProjectStep(driver);
        deleteProjectStep.deleteProject(properties.getReProjectName());
        Assert.assertEquals(new ProjectsPage(driver, false).getSuccessfullyAddedText(), "Successfully deleted the project.");
    }
}
