package elements;

import net.bytebuddy.implementation.bytecode.Throw;
import org.openqa.selenium.*;

import java.util.ArrayList;
import java.util.List;

public class RadioButton {
    private UIElement uiElement;
    private List<UIElement> options = new ArrayList<>();
    private WebDriver driver;

    /***
     * RadioButton ui element для улучшения работы
     * @param driver
     * @param by необходимо передать значение аттрибута name
     *
     */
    public RadioButton(WebDriver driver, By by) {
        this.driver = driver;

        for (WebElement element: driver.findElements(by)) {
            options.add(new UIElement(driver, element));
        }
    }

    //для проверки
    public void sizeCollection(){
       System.out.println(options.size());
    }

    public void selectByIndex(int index) {
        for (UIElement element : options) {
            if (Integer.parseInt(element.getAttribute("value")) == index) {
                element.click();
                break;
            }
        }
    }

    public void selectByText(String optionName) {
        for (UIElement element : options) {
            String textValue;
           try {
           textValue = element.getParent().findElement(By.xpath(String.format("./*[text() = '%s']", optionName))).getText();}
           catch (NoSuchElementException ex) {continue;}
            System.out.println(textValue);
            if (textValue.equalsIgnoreCase(optionName)) {
                element.click();
                break;
            }
        }
    }
}
