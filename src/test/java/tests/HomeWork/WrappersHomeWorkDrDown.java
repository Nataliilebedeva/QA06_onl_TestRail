package tests.HomeWork;

import baseEntities.BaseTest;
import elements.DropDownMenu;
import elements.DropDownMenuByOneButton;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import steps.LoginStep;

public class WrappersHomeWorkDrDown extends BaseTest {

    @Test
    public void DropDownWrapperTest1() {
        LoginStep loginStep = new LoginStep(driver);
        loginStep.loginWithCorrectAttribute();

        driver.get("https://aqa06onl02.testrail.io/index.php?/suites/view/24");

        DropDownMenu dropDownMenu = new DropDownMenu(driver, By.id("reportDropdown"), By.cssSelector(".button-report.dropdownLink"), By.tagName("a"));
        dropDownMenu.selectByText("Activity Summary");
        // dropDownMenu.selectByIndex(9);
    }

    @Test
    public void DropDownWrapperTest2() {
        LoginStep loginStep = new LoginStep(driver);
        loginStep.loginWithCorrectAttribute();

        DropDownMenu dropDownMenu2 = new DropDownMenu(driver, By.id("userDropdown"), By.id("navigation-user"),
                By.tagName("a"));
        //dropDownMenu2.selectByText("My Settings");
        dropDownMenu2.selectByIndex(1);
    }

    @Test
    public void DropDownWrapperTest3() {
        LoginStep loginStep = new LoginStep(driver);
        loginStep.loginWithCorrectAttribute();

        DropDownMenu dropDownMenu3 = new DropDownMenu(driver, By.id("helpDropdown"), By.id("navigation-menu"),
                By.tagName("a"));
        // dropDownMenu3.selectByText("Gurock Blog");
        dropDownMenu3.selectByIndex(10);
    }

    //__________________________________Другая реализация________________________________________

    @Test
    public void DropDownWrapperByOneButtonTest1() {
        LoginStep loginStep = new LoginStep(driver);
        loginStep.loginWithCorrectAttribute();

        DropDownMenuByOneButton dropDownMenu = new DropDownMenuByOneButton(driver, By.id("navigation-menu"));
        dropDownMenu.openDrDown();
        //  dropDownMenu.selectByText("Gurock Blog");
        dropDownMenu.selectByIndex(10);
    }

    @Test
    public void DropDownWrapperByOneButtonTest2() {
        LoginStep loginStep = new LoginStep(driver);
        loginStep.loginWithCorrectAttribute();

        DropDownMenuByOneButton dropDownMenu = new DropDownMenuByOneButton(driver, By.id("navigation-user"));
        dropDownMenu.openDrDown();
        dropDownMenu.selectByText("My Settings");
        //dropDownMenu.selectByIndex(1);
    }

    @Test
    public void DropDownWrapperByOneButtonTest3() {
        LoginStep loginStep = new LoginStep(driver);
        loginStep.loginWithCorrectAttribute();

        driver.get("https://aqa06onl02.testrail.io/index.php?/suites/view/24");

        DropDownMenuByOneButton dropDownMenu = new DropDownMenuByOneButton(driver, By.cssSelector(".button-report.dropdownLink"));
        dropDownMenu.openDrDown();
        dropDownMenu.selectByText("Comparison for Cases");
       // dropDownMenu.selectByIndex(1);
    }

}
