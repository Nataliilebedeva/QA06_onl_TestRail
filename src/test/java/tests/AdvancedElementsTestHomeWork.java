package tests;


import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class AdvancedElementsTestHomeWork extends BaseTest {

    //Реализовать Правый клик по элементу
    @Test
    public void contextTest() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/context_menu");
        WebElement hotSpot = driver.findElement(By.id("hot-spot"));
        Actions actions = new Actions(driver);
        actions
                .moveToElement(hotSpot)
                .contextClick()
                .build().perform();

        Thread.sleep(2000);
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
    public void dynamicControl() {
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

    @Test
    public void uploadFileTest() {
        String nameImage = "thumb.jpg";
        driver.get("http://the-internet.herokuapp.com/upload");

        WebElement uploadFile = driver.findElement(By.xpath("//input[@type = 'file' and @name = 'file']"));

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(nameImage).getFile());
        String absolutePath = file.getAbsolutePath();

        uploadFile.sendKeys(absolutePath);

        driver.findElement(By.id("file-submit")).submit();

        waits.waitForVisibility(By.xpath("//h3[text() = 'File Uploaded!']"));

        WebElement textMessage = driver.findElement(By.id("uploaded-files"));
        Assert.assertEquals(nameImage, textMessage.getText());

    }

    @Test
    public void downloadFileTest() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/download");
        WebElement downloadFile = driver.findElement(By.xpath("//a[. = 'upload.png']"));
        downloadFile.click();
        Thread.sleep(3000);

        File folder = new File(System.getProperty("user.dir"));
        File[] listOfFiles = folder.listFiles();
        boolean found = false;
        File f = null;
        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {
                String fileName = listOfFile.getName();
                System.out.println("File " + listOfFile.getName());
                if (fileName.matches("upload.png")) {
                    f = new File(fileName);
                    found = true;
                }
            }
        }
        Assert.assertTrue(found, "Downloaded document is not found");
        f.deleteOnExit();
    }
}

