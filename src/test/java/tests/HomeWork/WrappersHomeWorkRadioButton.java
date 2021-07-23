package tests.HomeWork;

import baseEntities.BaseTest;
import elements.Button;
import elements.RadioButton;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import steps.LoginStep;

public class WrappersHomeWorkRadioButton extends BaseTest {

    @Test
    public void radioButtonWrapperTest() throws InterruptedException {
        LoginStep loginStep = new LoginStep(driver);
        loginStep.loginWithCorrectAttribute();

        driver.get("https://aqa06onl02.testrail.io/index.php?/admin/projects/add");

        RadioButton radioButton = new RadioButton(driver, By.name("suite_mode"));
        radioButton.selectByIndex(3);
        radioButton.selectByText("Use a single repository with baseline support", "strong");
        Thread.sleep(2000);
    }

    @Test
    public void radioButtonWrapperTest2() throws InterruptedException {
        LoginStep loginStep = new LoginStep(driver);
        loginStep.loginWithCorrectAttribute();

        driver.get("https://aqa06onl02.testrail.io/index.php?/admin/subscription#");

        Button button1 = new Button(driver, By.xpath("//*[.='Exports']"));
        button1.click();

        RadioButton radioButton = new RadioButton(driver, By.name("db_type"));
        radioButton.selectByIndex(0);
        Thread.sleep(2000);
        radioButton.selectByText("MS SQL Export", "p");
        Thread.sleep(2000);
    }

}
