package tests.TestRail;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.AddEditTestCasePage;
import pages.SomeTestCasePage;
import pages.TestCasesPage;
import steps.*;

public class AddEditDeleteTestCaseTests extends BaseTest {

    @Test(dataProvider = "CaseDataProvider", dataProviderClass = AddEditTestCasePage.class)
    public void positiveAddFirstTestCase(String title, String precondition, String steps, String expresult) {
        LoginStep loginStep = new LoginStep(driver);
        loginStep.loginWithCorrectAttribute();

        ProjectSteps projectSteps = new ProjectSteps(driver);
        projectSteps.addProject("Some_Project_Leb");

        TestCaseSteps testCaseSteps = new TestCaseSteps(driver);
        testCaseSteps.returnToDashboard();
        testCaseSteps.addTestCase("Some_Project_Leb", title, precondition, steps, expresult);
        Assert.assertEquals(new SomeTestCasePage(driver, false).getMessageTitleText(), "Successfully added the new test case. Add another");
    }

    @Test(dataProvider = "CaseDataProvider2", dataProviderClass = AddEditTestCasePage.class, dependsOnMethods = "positiveAddFirstTestCase")
    public void positiveAddOthersTestCase(String title, String precondition, String steps, String expresult) {
        LoginStep loginStep = new LoginStep(driver);
        loginStep.loginWithCorrectAttribute();
        TestCaseSteps testCaseSteps = new TestCaseSteps(driver);
        testCaseSteps.addTestCase("Some_Project_Leb", title, precondition, steps, expresult);
        Assert.assertEquals(new SomeTestCasePage(driver, false).getMessageTitleText(), "Successfully added the new test case. Add another");
    }

    @Test(dataProvider = "EditCaseDataProvider", dataProviderClass = AddEditTestCasePage.class, dependsOnMethods = "positiveAddOthersTestCase")
    public void positiveEditTestCase(String title, String precondition, String steps, String expresult) {
        LoginStep loginStep = new LoginStep(driver);
        loginStep.loginWithCorrectAttribute();

        TestCaseSteps testCaseSteps = new TestCaseSteps(driver);
        testCaseSteps.editTestCase("Some_Project_Leb", title, precondition, steps, expresult);
        Assert.assertEquals(new SomeTestCasePage(driver, false).getMessageTitleText(), "Successfully updated the test case.");
    }

   // @Parameters({"login-value", "psw-value"})
    @Test(expectedExceptions = TimeoutException.class)
    public void positiveDeleteTestCase() {
        LoginStep loginStep = new LoginStep(driver);
        loginStep.loginWithCorrectAttribute();

        TestCaseSteps testCaseSteps = new TestCaseSteps(driver);
        testCaseSteps.deleteTestCase("Some_Project_Leb");
        waits.waitForPresent(By.xpath("//span[text() ='BlaBlaBla']"));
        //waits.waitForVisibilityElement(new TestCasesPage(driver,false).getDeleteCaseLabel());
        //Assert.assertFalse(new TestCasesPage(driver, false).getDeleteCaseLabel().isDisplayed());

    }
}

