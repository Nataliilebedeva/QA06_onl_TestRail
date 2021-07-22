package baseEntities;

import core.BrowserService;
import core.ReadProperties;
import core.Waits;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import utils.Listener;

@Listeners(Listener.class)
public class BaseTest {
    public WebDriver driver;
    protected ReadProperties properties = new ReadProperties();
    protected Waits waits;

    @BeforeTest
    public void setupTest() {

        //properties = new ReadProperties();
    }

    @BeforeMethod
    public void setupMethod() {
        driver = new BrowserService().getDriver();
        waits= new Waits(driver, properties.getTimeOut());
    }

    @AfterMethod
    public void tearDownMethod() {
        driver.quit();
    }
}
