package tests;

import manager.ApplicationManager;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.JavascriptExecutor;

import java.io.File;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Random;

public class TestBase {

    protected static ApplicationManager app;

    JavascriptExecutor js;
    Map<String, Object> vars;

    @BeforeEach
    public void setUp() {
        if (app == null) {
            app = new ApplicationManager();
        }
        app.init(System.getProperty("browser", "chrome"));
    }

    public static String randomFile(String dir) {
        var fileNames = new File(dir).list();
        var rnd = new Random();
        var index = rnd.nextInt(fileNames.length);
        return Paths.get(dir, fileNames[index]).toString();
    }

}
