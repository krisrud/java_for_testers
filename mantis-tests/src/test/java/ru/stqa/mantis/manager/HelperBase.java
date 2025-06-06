package ru.stqa.mantis.manager;

import org.openqa.selenium.By;

import java.nio.file.Paths;

public class HelperBase {
    protected final ApplicationManager manager;

    public HelperBase(ApplicationManager manager) {
        this.manager = manager;
    }

    protected void type(By locator, String text) {
        click(locator);
        manager.driver().findElement(locator).clear();
        manager.driver().findElement(locator).sendKeys(text);
    }

    protected void attach(By locator, String file) {
        manager.driver().findElement(locator).sendKeys(Paths.get(file).toAbsolutePath().toString());
    }

    public void click(By locator) {
        manager.driver().findElement(locator).click();
    }

    public  boolean isElementPresent(By locator) {
        return manager.driver().findElements(locator).size() > 0;
    }
}
