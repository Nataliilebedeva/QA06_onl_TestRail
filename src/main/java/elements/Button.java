package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Button {
    private final UIElement element;

    public Button(WebDriver driver, By by) {
        this.element = new UIElement(driver, by);
    }

    public void click() { this.element.click();}

    public void submit() {
        this.element.submit();
    }

    public boolean isDisplayed(){
       return this.element.isDisplayed();
    }
}
