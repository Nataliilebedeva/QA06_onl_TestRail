package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class BrowserService {
    private ReadProperties properties = new ReadProperties();
    private WebDriver driver;
    private Waits wait;

    public BrowserService() {
        switch (properties.getBrowser().toLowerCase()) {
            case "chrome":
                WebDriverManager.getInstance(DriverManagerType.CHROME).setup();

                HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
                chromePrefs.put("profile.default_content_settings.popups", 0);
                chromePrefs.put("download.default_directory", System.getProperty("user.dir"));
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setExperimentalOption("prefs", chromePrefs);
                chromeOptions.addArguments("start-maximized", "disable-gpu");
                chromeOptions.setHeadless(properties.getHeadless());

                driver = new ChromeDriver(chromeOptions);
                break;

            case "firefox":
                WebDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setHeadless(properties.getHeadless());
                driver = new FirefoxDriver(firefoxOptions);
                break;
            case "ie":
                WebDriverManager.getInstance(DriverManagerType.IEXPLORER).setup();
                driver = new InternetExplorerDriver();
                break;
            default:
                throw new AssertionError("Данный браузер не поддерживается.");
        }
                driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
                wait = new Waits(driver, properties.getTimeOut());
        }


    public WebDriver getDriver() {
        return driver;
    }

    public Waits getWait(){
        return  wait;
    }
}
