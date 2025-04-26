package manager;

import org.openqa.selenium.*;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class ApplicationManager {
    protected WebDriver driver;
    private LoginHelper session;
    private GroupHelper groups;
    private  ContactHelper contacts;


    public void init(String browser) {
        if (driver == null) {
            if ("firefox".equals(browser)) {
                var options = new FirefoxOptions();
                options.setBinary("/home/kristina/firefox");
                driver = new FirefoxDriver(options);
            } else if ("chrome".equals(browser)) {
                //var options = new ChromeOptions();
                //options.setBinary("/opt/google/chrome");
                //driver = new ChromeDriver(options);
                ChromeOptions options = new ChromeOptions();

                System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

                //options.addArguments("--headless");
                //options.addArguments("--no-sandbox");
                //options.addArguments("start-maximized");
                //options.addArguments("disable-infobars");
                //options.addArguments("--disable-extensions");

                driver = new ChromeDriver(options);
                //driver.implicitly_wait(10);

            } else {
                throw new IllegalArgumentException(String.format("Unknown browser %s", browser));
            }

            //testBase.js = (JavascriptExecutor) driver;
            //testBase.vars = new HashMap<String, Object>();
            Runtime.getRuntime().addShutdownHook(new Thread(driver::quit));
            driver.get("http://localhost/addressbook/index.php");
            driver.manage().window().setSize(new Dimension(1850, 1053));
            session().login("admin", "secret");
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

}
