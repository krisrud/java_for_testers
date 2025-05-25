package manager;

import org.openqa.selenium.*;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class ApplicationManager {
    protected WebDriver driver;
    private LoginHelper session;
    private GroupHelper groups;
    private  ContactHelper contacts;
    private  JdbcHelper jdbc;
    private  HibernateHelper hbm;
    private Properties properties;


    public void init(String browser, Properties properties) throws MalformedURLException {
        this.properties = properties;
        if (driver == null) {
            var seleniumServer = properties.getProperty("seleniumServer");
            if ("firefox".equals(browser)) {
                if (seleniumServer != null) {
                    driver = new RemoteWebDriver(new URL(seleniumServer), new FirefoxOptions());
                } else {
                    var options = new FirefoxOptions();
                    options.setBinary(properties.getProperty("local.firefox"));
                    driver = new FirefoxDriver(options);
                }

            } else if ("chrome".equals(browser)) {
                if (seleniumServer != null) {
                    driver = new RemoteWebDriver(new URL(seleniumServer), new ChromeOptions());
                } else {
                    ChromeOptions options = new ChromeOptions();
                    System.setProperty(properties.getProperty("local.chrome"), properties.getProperty("local.chromedriver"));
                    driver = new ChromeDriver(options);
                }
                    //var options = new ChromeOptions();
                //options.setBinary("/opt/google/chrome");
                //driver = new ChromeDriver(options);


                //options.addArguments("--headless");
                //options.addArguments("--no-sandbox");
                //options.addArguments("start-maximized");
                //options.addArguments("disable-infobars");
                //options.addArguments("--disable-extensions");


                //driver.implicitly_wait(10);

            } else {
                throw new IllegalArgumentException(String.format("Unknown browser %s", browser));
            }

            //testBase.js = (JavascriptExecutor) driver;
            //testBase.vars = new HashMap<String, Object>();
            Runtime.getRuntime().addShutdownHook(new Thread(driver::quit));
            driver.get(properties.getProperty("web.baseUrl"));
            driver.manage().window().setSize(new Dimension(1850, 1053));
            session().login(properties.getProperty("web.username"), properties.getProperty("web.password"));
        }
    }

    public LoginHelper session() {
        if (session == null) {
            session = new LoginHelper(this);
        }
        return  session;
    }

    public  GroupHelper groups() {
        if (groups == null) {
            groups = new GroupHelper(this);
        }
        return  groups;
    }

    public boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

    public  ContactHelper contacts() {
        if (contacts == null) {
            contacts = new ContactHelper(this);
        }
        return  contacts;
    }

    public  JdbcHelper jdbc () {
        if (jdbc == null) {
            jdbc = new JdbcHelper(this);
        }
        return  jdbc;
    }

    public  HibernateHelper hbm () {
        if (hbm == null) {
            hbm = new HibernateHelper(this);
        }
        return  hbm;
    }

}
