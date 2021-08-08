package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class DropDownMenu {
    private WebDriver driver;
    private UIElement uiElement;
    private Button uiElementButton;
    private List<UIElement> options = new ArrayList<>();


    /***
     *
     * @param driver
     * @param by
     * @param byButton - кнопка, которую нужно нажать для того, чтобы открыть выпадающий список
     * @param byOptions - селектор для формирования коллекции из options для выпадающего списка
     */

    public DropDownMenu(WebDriver driver, By by, By byButton, By byOptions) {
        this.driver = driver;
        this.uiElement = new UIElement(driver, by);
        this.uiElementButton = new Button(driver, byButton);
        for (WebElement element : this.uiElement.findElements(byOptions)) {
            options.add(new UIElement(driver, element));
        }
    }

    //для проверки
    public void selectSize() {
      this.uiElementButton.click();
       int size = options.size();
        System.out.println(size);
        for (UIElement element: options) {
            System.out.println(element.getText());
        }
    }

    public void selectByText(String optionName) {
        this.uiElementButton.click();
        for (UIElement element : options) {
            String textValue = element.getText();
            if (textValue.equalsIgnoreCase(optionName)) {
                element.click();
                break;
            }
        }
    }

    /***
     *
     * @param index индекс от 1
     */

    public void selectByIndex(int index) {
        this.uiElementButton.click();
        options.get(index-1).click();
    }
}