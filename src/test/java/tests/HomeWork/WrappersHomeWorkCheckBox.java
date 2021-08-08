package tests.HomeWork;

import baseEntities.BaseTest;
import core.Waits;
import elements.CheckBox;
import elements.RadioButton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import steps.LoginStep;

import java.util.ArrayList;
import java.util.List;

public class WrappersHomeWorkCheckBox extends BaseTest {

    @Test
    public void checkBoxWrapperTest1() {
        LoginStep loginStep = new LoginStep(driver);
        loginStep.loginWithCorrectAttribute();

        driver.get("https://aqa06onl03.testrail.io/index.php?/admin/projects/add");

        CheckBox checkBox = new CheckBox(driver, By.id("show_announcement"));
        checkBox.changeState(true);

    }

    @Test
    public void checkBoxWrapperTest2() throws InterruptedException {
        Waits waits = new Waits(driver);

        LoginStep loginStep = new LoginStep(driver);
        loginStep.loginWithCorrectAttribute();

        driver.get("https://aqa06onl03.testrail.io/index.php?/todos/overview/3");

        List <CheckBox> checkBoxList = new ArrayList<>();
        for (WebElement element : waits.waitForVisibilityAllElements(By.name("statusSelection[]"))){
            checkBoxList.add(new CheckBox(driver,element));
        }

        for (CheckBox element: checkBoxList) {
            element.changeState(true);
        }

        Thread.sleep(2000);

        for (CheckBox element: checkBoxList) {
            element.changeState(false);
        }

        Thread.sleep(2000);
    }

    //_____________________Реализация через два метода________________________________

    @Test
    public void checkBoxWrapperTest3() throws InterruptedException {
        Waits waits = new Waits(driver);

        LoginStep loginStep = new LoginStep(driver);
        loginStep.loginWithCorrectAttribute();

        driver.get("https://aqa06onl03.testrail.io/index.php?/todos/overview/3");

        List<CheckBox> checkBoxList = new ArrayList<>();
        for (WebElement element : waits.waitForVisibilityAllElements(By.name("statusSelection[]"))) {
            checkBoxList.add(new CheckBox(driver, element));
        }

        for (CheckBox element : checkBoxList) {
            element.unClickCheckBox();
        }
        Thread.sleep(2000);
    }
}
