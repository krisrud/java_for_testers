package manager;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class ApplicationManager {
    protected WebDriver driver;
    private LoginHelper session;
    private GroupHelper groups;

    public void init() {
        if (driver == null) {
            var options = new FirefoxOptions();
            options.setBinary("/home/kristina/firefox");
            driver = new FirefoxDriver(options);
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

}
