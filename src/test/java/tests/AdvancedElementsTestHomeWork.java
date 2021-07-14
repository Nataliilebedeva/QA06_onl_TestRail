package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class AdvancedElementsTestHomeWork extends BaseTest {

    @Test
    public void contextTest() {
        driver.get("http://the-internet.herokuapp.com/context_menu");
        WebElement hotSpot = driver.findElement(By.id("hot-spot"));
        Actions actions = new Actions(driver);
        actions
                .moveToElement(hotSpot)
                .contextClick()
                .build().perform();
    }

    //Найти чекбокс
    //Нажать на кнопку
    //Дождаться надписи “It’s gone”
    //Проверить, что чекбокса нет
    //Найти инпут
    //Проверить, что он disabled
    //Нажать на кнопку
    //Дождаться надписи “It's enabled!”
    //Проверить, что инпут enabled

    @Test
    public void dynamicControl(){
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");

        //Найти чекбокс
        WebElement checkBox = driver.findElement(By.xpath("//*[text() = ' A checkbox']"));

        //Нажать на кнопку
        WebElement removeButton = driver.findElement(By.xpath("//form[@id ='checkbox-example']/button[@type]"));
        removeButton.click();

        //Дождаться надписи “It’s gone”
        waits.waitForVisibility(By.id("message"));

        //Проверить, что чекбокса нет
        waits.waitForInvisibilityElement(checkBox);

        //Найти инпут
        WebElement input = driver.findElement(By.xpath("//input[@type ='text']"));

        //Проверить, что он disabled
        input.click();
        waits.waitForNotClickElement(input);

        //Нажать на кнопку
        WebElement buttonEnable = driver.findElement(By.xpath("//button[@onclick ='swapInput()']"));
        buttonEnable.click();

        //Дождаться надписи “It's enabled!”
        waits.waitForVisibility(By.id("message"));

        //Проверить, что инпут enabled
        waits.waitForClickElement(input);

    }





}
