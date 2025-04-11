package manager;

import org.openqa.selenium.By;

public class LoginHelper {

    private final ApplicationManager manager;

    public LoginHelper(ApplicationManager manager) {
        this.manager = manager;
    }

    void login(String user, String password) {
        //driver.findElement(By.name("user")).click();
        manager.driver.findElement(By.name("user")).sendKeys(user);
        //driver.findElement(By.name("pass")).click();
        manager.driver.findElement(By.name("pass")).sendKeys(password);
        manager.driver.findElement(By.xpath("//input[@value=\'Login\']")).click();
    }
}
