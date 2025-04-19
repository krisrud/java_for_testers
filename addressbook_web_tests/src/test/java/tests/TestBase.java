package tests;

import manager.ApplicationManager;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.JavascriptExecutor;

import java.util.Map;

public class TestBase {

    protected static ApplicationManager app;

    JavascriptExecutor js;
    Map<String, Object> vars;

    @BeforeEach
    public void setUp() {
        if (app == null) {
            app = new ApplicationManager();
        }
        app.init(System.getProperty("browser", "firefox"));
    }

}
