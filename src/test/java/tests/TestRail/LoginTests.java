package tests.TestRail;

import baseEntities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import steps.LoginStep;

//запускать через param.xml с добавлением корректного логина и пароля
public class LoginTests extends BaseTest {

    //@Parameters({"login-value", "psw-value"})
    @Test
    public void positiveLoginTestFirstUser() {
        LoginStep loginStep = new LoginStep(driver);
        loginStep.loginWithCorrectAttribute();
        Assert.assertEquals(new DashboardPage(driver, true).getTitleText(), "DASHBOARD", "Страница Dashboard не открылась");
    }

    @Test
    public void negativeLoginTest1() {
        LoginStep loginStep = new LoginStep(driver);
        loginStep.loginWithCorrectAttribute();
        Assert.assertEquals(new LoginPage(driver, false).getErrorLabel().getText(), "Email/Login or Password is incorrect. Please try again.");
    }

   //@Parameters("login-value")
    @Test
    public void negativeLoginTest2() {
        LoginStep loginStep = new LoginStep(driver);
        loginStep.loginWithCorrectAttribute();
        Assert.assertEquals(new LoginPage(driver, false).getNoPasswordLabel().getText(), "Password is required.");
    }

  //@Parameters("psw-value")
    @Test
    public void negativeLoginTest3(String psw) {
        LoginStep loginStep = new LoginStep(driver);
        loginStep.loginWithCorrectAttribute();
        Assert.assertEquals(new LoginPage(driver, false).getNoLoginLabel().getText(), "Email/Login is required.");
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = "Page was not opened")
    public void negativeLoginTest4() {
        LoginStep loginStep = new LoginStep(driver);
        loginStep.login("", "");
        Assert.assertTrue(new DashboardPage(driver, false).getTitleLabel().isDisplayed());
    }
}







