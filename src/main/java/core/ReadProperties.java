package core;

import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
    protected Properties properties;

    public ReadProperties() {
        properties = new Properties();

        try {
            properties.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getURL() {
        return properties.getProperty("url");
    }

    public String getBrowser() {
        return properties.getProperty("browser");
    }

    public String getUserName() {
        return properties.getProperty("username");
    }

    public String getPassword() {
        return properties.getProperty("password");
    }


    public boolean getHeadless() {
        return Boolean.parseBoolean(properties.getProperty("headless"));
    }

    public int getTimeOut() {
        return Integer.parseInt(properties.getProperty("timeout"));
    }


    public String getProjectName() {
        return properties.getProperty("nameProject");
    }

    public String getReProjectName() {
        return properties.getProperty("renameProject");
    }
}

