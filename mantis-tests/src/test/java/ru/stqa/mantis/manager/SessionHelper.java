package ru.stqa.mantis.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class SessionHelper extends HelperBase {

    public SessionHelper (ApplicationManager manager) {
        super(manager);
    }

    public void login(String user, String password) {
        type(By.name("username"), user);
        click(By.cssSelector("input[type = 'submit']"));
        type(By.name("password"), password);
        click(By.cssSelector("input[type = 'submit']"));
    }

    public boolean isLoggedIn() {
        return isElementPresent(By.cssSelector("span.user-info"));
    }

    public void addNewAccount (String user, String email) {
        click(By.cssSelector("a[href = 'signup_page.php']"));
        type(By.name("username"), user);
       click(By.cssSelector("input[name = 'username']"));
        type(By.name("email"), email);
       click(By.cssSelector("input[name = 'email']"));
        click(By.cssSelector("input[type = 'submit']"));
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        var wait = new WebDriverWait(manager.driver, Duration.ofSeconds(20));
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.linkText("Proceed")));
//        click(By.linkText("Proceed"));
        click(By.cssSelector("a[href = 'login_page.php']"));
    }

    public void logout() {
        manager.driver().get(String.format("%s/logout_page.php", manager.property("web.baseUrl")));
    }

    public void fillingFormAfterUserCreate(String username, String password) {
        type(By.name("realname"), username);
        type(By.name("password"), password);
        type(By.name("password_confirm"), password);
        click(By.cssSelector("button[type = 'submit']"));
    }
}
