package ru.stqa.mantis.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.stqa.mantis.common.CommonFunctions;

import java.time.Duration;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class UserRegistrationTests extends TestBase {


    //@ParameterizedTest
    //@MethodSource("randomName")
    @Test
    void canRegisterUser() {
        String username = CommonFunctions.randomString(10);
        var email = String.format("%s@localhost", username);
        var password = "password";
        // создать пользователя (адрес) на почтовом сервере (JamesHelper)
        app.jamesCli().addUser(email, password);
        // заполняем форму создания и отправляем (браузер)
        if (app.session().isLoggedIn()) {
            app.session().logout();
        }
        app.session().addNewAccount(username, email);
        // ждём почту (MailHelper)
        var messages = app.mail().receive(email, password, Duration.ofSeconds(60));
        // извлекаем ссылку из письма & проходим по ссылке и завершаем регистрацию (браузер)
        var text = messages.get(0).content();
        var pattern = Pattern.compile("http://\\S*");
        var matcher = pattern.matcher(text);
        if (matcher.find()) {
            var url = text.substring(matcher.start(), matcher.end());
            System.out.println(url);
            app.driver().get(url);
            app.session().fillingFormAfterUserCreate(username, password);
        }
        // проверяем, что пользователь может залогиниться (HttpSessionHelper)
        app.http().login(username, password);
        Assertions.assertTrue(app.http().isLoggedIn());

    }

    public  static Stream<String> randomName() {
        Supplier<String> randomName = () -> CommonFunctions.randomString(10);
        return Stream.generate(randomName).limit(2);
    }
}
