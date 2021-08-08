package tests.ClassWork;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class iFrameTest extends BaseTest {

    @Test
    public void frameTest() {
        driver.get("http://the-internet.herokuapp.com/iframe");

        driver.switchTo().frame(0);
        WebElement element = driver.findElement(By.xpath("//p[.='Your content goes here.']"));
        Assert.assertTrue(element.isDisplayed());

        driver.switchTo().parentFrame();//можно так, но вернет на один уровен выше
        driver.switchTo().defaultContent();//можно так, но вернет на основной первоначальный сайт
        WebElement menu = driver.findElement(By.xpath("//*[@role = 'menubar']"));
        Assert.assertTrue(menu.isDisplayed());
    }

    @Test
    public void frameTest1() {
        driver.get("http://the-internet.herokuapp.com/iframe");

        driver.switchTo().frame("mce_0_ifr"); //передаем айди, без указания селектора, локатора

        WebElement element = driver.findElement(By.xpath("//p[.='Your content goes here.']"));
        Assert.assertTrue(element.isDisplayed());

        driver.switchTo().parentFrame();//можно так, но вернет на один уровен выше
        driver.switchTo().defaultContent();//можно так, но вернет на основной первоначальный сайт
        WebElement menu = driver.findElement(By.xpath("//*[@role = 'menubar']"));
        Assert.assertTrue(menu.isDisplayed());
    }

    @Test
    public void frameTest2() {
        driver.get("http://the-internet.herokuapp.com/iframe");

        driver.switchTo().frame(driver.findElement(By.tagName("iframe")));//ищем именно по тегу iframe, потому что он виден селениуму

        WebElement element = driver.findElement(By.xpath("//p[.='Your content goes here.']"));
        Assert.assertTrue(element.isDisplayed());

        driver.switchTo().parentFrame();//можно так, но вернет на один уровен выше
        driver.switchTo().defaultContent();//можно так, но вернет на основной первоначальный сайт
        WebElement menu = driver.findElement(By.xpath("//*[@role = 'menubar']"));
        Assert.assertTrue(menu.isDisplayed());
    }

}
