package tests.TestRail;

import baseEntities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.ProjectsPage;
import steps.*;

public class AddEditDeleteProjectTests extends BaseTest {

    //@Parameters({"login-value", "psw-value"})
    @Test(invocationCount = 1)
    public void positiveAddProjectTest() {
        LoginStep loginStep = new LoginStep(driver);
        loginStep.loginWithCorrectAttribute();
        ProjectSteps projectSteps = new ProjectSteps(driver);
        projectSteps.addProject(properties.getProjectName());
        Assert.assertEquals(new ProjectsPage(driver, false).getSuccessfullyAddedText(), "Successfully added the new project.");
    }

  //@Parameters({"login-value", "psw-value"})
    @Test(dependsOnMethods = "positiveAddProjectTest", invocationCount = 1)
    public void positiveEditProjectTest() {
        LoginStep loginStep = new LoginStep(driver);
        loginStep.loginWithCorrectAttribute();
        ProjectSteps projectSteps = new ProjectSteps(driver);
        projectSteps.editProject(properties.getProjectName(), properties.getReProjectName());
        Assert.assertEquals(new ProjectsPage(driver, false).getSuccessfullyAddedText(), "Successfully updated the project.");
    }

   // @Parameters({"login-value", "psw-value"})
    @Test(dependsOnMethods = "positiveEditProjectTest", invocationCount = 1)
    public void positiveDeleteProjectTest() {
        LoginStep loginStep = new LoginStep(driver);
        loginStep.loginWithCorrectAttribute();
        ProjectSteps projectSteps = new ProjectSteps(driver);
        projectSteps.deleteProject(properties.getReProjectName());
        Assert.assertEquals(new ProjectsPage(driver, false).getSuccessfullyAddedText(), "Successfully deleted the project.");
    }
}
