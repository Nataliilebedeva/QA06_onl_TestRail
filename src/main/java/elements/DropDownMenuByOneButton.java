package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class DropDownMenuByOneButton {
    private WebDriver driver;
    private UIElement buttonDD;
    private List<UIElement> options = new ArrayList<>();
    private String attributeNameForOptions;

    /***
     *
     * @param driver
     * @param by селектор кнопки, которая открывает список
     */

    public DropDownMenuByOneButton(WebDriver driver, By by) {
        this.driver = driver;
        this.buttonDD = new UIElement(driver, by);
    }

    private By createOptionsNameBy() {
        String nameParentOptions = buttonDD.getAttribute("href");
        String[] str = nameParentOptions.split("#");
        attributeNameForOptions = str[1];
        By options = By.xpath(String.format("//*[@id = '%s']//a", attributeNameForOptions));
        return options;
    }

    public void createOptionsCollection() {
        for (WebElement element : driver.findElements(createOptionsNameBy())) {
            options.add(new UIElement(driver, element));
        }
    }

    public void openDrDown() {
        this.buttonDD.click();
        createOptionsCollection();
    }

    //для проверки
    public void selectSize() {
        int size = options.size();
        System.out.println(size);
        for (UIElement element : options) {
            System.out.println(element.getText());
        }
    }

    public void selectByText(String optionName) {
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
        options.get(index - 1).click();
    }
}