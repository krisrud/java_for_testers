package ru.stqa.mantis.manager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Properties;

public class ApplicationManager {
    protected WebDriver driver;
    private String string;
    private Properties properties;
    private SessionHelper sessionHelper;

    public void init(String browser, Properties properties) {
        this.string = browser;
        this.properties = properties;

    }

    public WebDriver driver() {
        if (driver == null) {
            if ("firefox".equals(string)) {
                //var options = new FirefoxOptions();
                //options.setBinary(properties.getProperty("local.firefox"));
                driver = new FirefoxDriver();
            } else if ("chrome".equals(string)) {
                //var options = new ChromeOptions();
                //options.setBinary("/opt/google/chrome");
                //driver = new ChromeDriver(options);
                //ChromeOptions options = new ChromeOptions();

                //System.setProperty(properties.getProperty("local.chrome"), properties.getProperty("local.chromedriver"));
                driver = new ChromeDriver();
                //options.addArguments("--headless");
                //options.addArguments("--no-sandbox");
                //options.addArguments("start-maximized");
                //options.addArguments("disable-infobars");
                //options.addArguments("--disable-extensions");

                //driver = new ChromeDriver(options);
                //driver.implicitly_wait(10);

            } else {
                throw new IllegalArgumentException(String.format("Unknown browser %s", string));
            }

            //testBase.js = (JavascriptExecutor) driver;
            //testBase.vars = new HashMap<String, Object>();
            Runtime.getRuntime().addShutdownHook(new Thread(driver::quit));
            driver.get(properties.getProperty("web.baseUrl"));
            driver.manage().window().setSize(new Dimension(1850, 1053));
        }
        return driver;
    }

    public SessionHelper session() {
        if (sessionHelper == null) {
            sessionHelper = new SessionHelper(this);
        }
        return sessionHelper;
    }
}
