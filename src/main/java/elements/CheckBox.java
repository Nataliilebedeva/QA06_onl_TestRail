package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckBox {
    private  final UIElement element;

    public CheckBox(WebDriver driver, By by) {
        this.element = new UIElement(driver,by);
    }

    public CheckBox(WebDriver driver, WebElement element) {
        this.element = new UIElement(driver,element);
    }

    public  void  click(){
        this.element.click();
    }

    public boolean isSelected() {
        return this.element.isSelected();
    }

    public void changeState(boolean makeSelected){
        if (this.isSelected() != makeSelected) this.click();
    }

    //_____________Реализация через два метода________________________

    public void clickCheckBox(){
        if (!this.isSelected()) {
            this.click();
        }
    }

    public void unClickCheckBox(){
        if (this.isSelected()){
            this.click();
        }
    }

}
