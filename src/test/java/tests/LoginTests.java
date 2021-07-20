package tests;

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

    @Parameters({"login-value", "psw-value"})
    @Test
    public void positiveLoginTestFirstUser(String login, String psw) {
        LoginStep loginStep = new LoginStep(driver);
        loginStep.login(login, psw);
        Assert.assertEquals(new DashboardPage(driver, true).getTitleText(), "DASHBOARD", "Страница Dashboard не открылась");
    }

    @Test
    public void negativeLoginTest1(@Optional("11111") String login, @Optional("22222222") String psw) {
        LoginStep loginStep = new LoginStep(driver);
        loginStep.login(login, psw);
        Assert.assertEquals(new LoginPage(driver, false).getErrorLabel().getText(), "Email/Login or Password is incorrect. Please try again.");
    }

    @Parameters("login-value")
    @Test
    public void negativeLoginTest2(String login) {
        LoginStep loginStep = new LoginStep(driver);
        loginStep.login(login, "");
        Assert.assertEquals(new LoginPage(driver, false).getNoPasswordLabel().getText(), "Password is required.");
    }

    @Parameters("psw-value")
    @Test
    public void negativeLoginTest3(String psw) {
        LoginStep loginStep = new LoginStep(driver);
        loginStep.login("", psw);
        Assert.assertEquals(new LoginPage(driver, false).getNoLoginLabel().getText(), "Email/Login is required.");
    }

    @Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = "Page was not opened")
    public void negativeLoginTest4(@Optional("") String login, @Optional("") String psw) {
        LoginStep loginStep = new LoginStep(driver);
        loginStep.login(login, psw);
        Assert.assertTrue(new DashboardPage(driver, false).getTitleLabel().isDisplayed());
    }
}







