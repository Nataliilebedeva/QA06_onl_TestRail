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

//запускать через param.xml с добавлением корректного логина и пароля
public class AddEditDeleteTestCaseTests extends BaseTest {

    @Test(dataProvider = "CaseDataProvider", dataProviderClass = AddEditTestCasePage.class)
    public void positiveAddFirstTestCase(String title, String precondition, String steps, String expresult) {
        LoginStep loginStep = new LoginStep(driver);
        loginStep.login("atrostyanko+0601@gmail.com", "hYE/RiquvQVIzXfiBwm3"); //пришлось засветить логин и пароль, потому что с передачей параметров логина и пароля из xml не проходил дата провайдер

        AddProjectStep addProjectStep = new AddProjectStep(driver);
        addProjectStep.addProject("Some_Project_Leb");

        AddTestCaseStep addTestCaseStep = new AddTestCaseStep(driver);
        addTestCaseStep.returnToDashboard();
        addTestCaseStep.addTestCase("Some_Project_Leb", title, precondition, steps, expresult);
        Assert.assertEquals(new SomeTestCasePage(driver, false).getMessageTitleText(), "Successfully added the new test case. Add another");
    }

    @Test(dataProvider = "CaseDataProvider2", dataProviderClass = AddEditTestCasePage.class, dependsOnMethods = "positiveAddFirstTestCase")
    public void positiveAddOthersTestCase(String title, String precondition, String steps, String expresult) {
        LoginStep loginStep = new LoginStep(driver);
        loginStep.login("atrostyanko+0601@gmail.com", "hYE/RiquvQVIzXfiBwm3"); //пришлось засветить логин и пароль, потому что с передачей параметров не проходил дата провайдер

        AddTestCaseStep addTestCaseStep = new AddTestCaseStep(driver);
        addTestCaseStep.addTestCase("Some_Project_Leb", title, precondition, steps, expresult);
        Assert.assertEquals(new SomeTestCasePage(driver, false).getMessageTitleText(), "Successfully added the new test case. Add another");
    }

    @Test(dataProvider = "EditCaseDataProvider", dataProviderClass = AddEditTestCasePage.class, dependsOnMethods = "positiveAddOthersTestCase")
    public void positiveEditTestCase(String title, String precondition, String steps, String expresult) {
        LoginStep loginStep = new LoginStep(driver);
        loginStep.login("atrostyanko+0601@gmail.com", "hYE/RiquvQVIzXfiBwm3"); //пришлось засветить логин и пароль, потому что с передачей параметров не проходил дата провайдер

        EditTestCaseStep editTestCaseStep = new EditTestCaseStep(driver);
        editTestCaseStep.editTestCase("Some_Project_Leb", title, precondition, steps, expresult);

        Assert.assertEquals(new SomeTestCasePage(driver, false).getMessageTitleText(), "Successfully updated the test case.");
    }

    @Parameters({"login-value", "psw-value"})
    @Test(dependsOnMethods = "positiveAddFirstTestCase", expectedExceptions = TimeoutException.class)
    public void positiveDeleteTestCase(String login, String psw) {
        LoginStep loginStep = new LoginStep(driver);
        loginStep.login(login, psw);

        DeleteTestCaseStep deleteTestCaseStep = new DeleteTestCaseStep(driver);
        deleteTestCaseStep.deleteTestCase("Some_Project_Leb");
        waits.waitForPresent(By.xpath("//span[text() ='BlaBlaBla']"));
        //waits.waitForVisibilityElement(new TestCasesPage(driver,false).getDeleteCaseLabel());
        //Assert.assertFalse(new TestCasesPage(driver, false).getDeleteCaseLabel().isDisplayed());

    }
}

