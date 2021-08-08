package baseEntities;

import core.ReadProperties;
import org.openqa.selenium.WebDriver;

public class BaseStep {
    protected WebDriver driver;
    protected ReadProperties properties = new ReadProperties();

    public BaseStep(WebDriver driver) {
        this.driver = driver;

    }
}
