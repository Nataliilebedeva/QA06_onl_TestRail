package tests.ClassWork;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

public class AdvancedElementsTest extends BaseTest {

    @Test
    public void hoverTest(){
        driver.get("http://the-internet.herokuapp.com/hovers");

        List <WebElement> list = driver.findElements(By.className("figure"));
        Actions actions = new Actions(driver);
        actions
                .moveToElement(list.get(0))
                .pause(1000)
                .build().perform();//собирают элемент ation'a и выполняют его
        waits.waitForPresent(By.xpath("//h5[text()='name: user1']"));
        actions
                .moveToElement(list.get(1))
                .pause(1000)
                .build().perform();//собирают элемент ation'a и выполняют его
        waits.waitForPresent(By.xpath("//h5[text()='name: user2']"));

        actions
        .moveToElement(list.get(2))
                .pause(1000)
                .build().perform();//собирают элемент ation'a и выполняют его
        waits.waitForPresent(By.xpath("//h5[text()='name: user3']"));
    }

    @Test
    public void contextTest() {
        driver.get("http://the-internet.herokuapp.com/context_menu");
        WebElement hotSpot = driver.findElement(By.id("hot-spot"));
        Actions actions = new Actions(driver);
        actions
                .moveToElement(hotSpot)
                .contextClick()
                .pause(1000)
                .build().perform();
    }

    @Test
    public void dragAndDropTest(){
        driver.get("http://the-internet.herokuapp.com/drag_and_drop");
        WebElement a = driver.findElement(By.id("column-a"));
        WebElement b = driver.findElement(By.id("column-b"));

        Actions actions = new Actions(driver);
        actions
                .dragAndDrop(a,b)
                .build().perform();

        actions
                .moveToElement(a)
                .clickAndHold()
                .moveToElement(b)
                .release()
                .build().perform();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void uploadFileTest(){
        driver.get("http://the-internet.herokuapp.com/upload");
        WebElement uploadFile = driver.findElement(By.xpath("//input[@type = 'file' and @name = 'file']"));
        uploadFile.sendKeys("C:/Users/ntshs/Downloads/thumb.jpg");

        driver.findElement(By.id("file-submit")).submit();

        waits.waitForVisibility(By.xpath("//h3[text() = 'File Uploaded!']"));

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
