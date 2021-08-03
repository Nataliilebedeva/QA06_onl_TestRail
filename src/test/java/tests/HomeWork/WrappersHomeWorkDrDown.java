package tests.HomeWork;

import baseEntities.BaseTest;
import elements.DropDownMenuByOneButton;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import steps.LoginStep;

public class WrappersHomeWorkDrDown extends BaseTest {

    @Test
    public void DropDownWrapperByOneButtonTest1() throws InterruptedException {
        LoginStep loginStep = new LoginStep(driver);
        loginStep.loginWithCorrectAttribute();

        DropDownMenuByOneButton dropDownMenu = new DropDownMenuByOneButton(driver, By.id("navigation-menu"));
        dropDownMenu.openDrDown();
        //  dropDownMenu.selectByText("Gurock Blog");
        dropDownMenu.selectByIndex(10);
        Thread.sleep(3000);
    }

    @Test
    public void DropDownWrapperByOneButtonTest2() throws InterruptedException {
        LoginStep loginStep = new LoginStep(driver);
        loginStep.loginWithCorrectAttribute();

        DropDownMenuByOneButton dropDownMenu = new DropDownMenuByOneButton(driver, By.id("navigation-user"));
        dropDownMenu.openDrDown();
        dropDownMenu.selectByText("My Settings");
        //dropDownMenu.selectByIndex(1);
        Thread.sleep(3000);
    }

    @Test
    public void DropDownWrapperByOneButtonTest3() throws InterruptedException {
        LoginStep loginStep = new LoginStep(driver);
        loginStep.loginWithCorrectAttribute();

        driver.get("https://aqa06onl03.testrail.io/index.php?/suites/view/3");

        DropDownMenuByOneButton dropDownMenu = new DropDownMenuByOneButton(driver, By.cssSelector(".button-report.dropdownLink"));
        dropDownMenu.openDrDown();
       // dropDownMenu.selectByText("Activity Summary");
        dropDownMenu.selectByIndex(9);
        Thread.sleep(3000);
    }

}
