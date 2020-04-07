package ru.netology;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class LoginMainPageTestClass {
    @Test
    @DisplayName("Main test login")
    public void loginPage() {

        MysqlConn mysql = new MysqlConn();

        open("http://127.0.0.1:9999");

        $("[name='login']").setValue(mysql.login);
        $("[name='password']").setValue(mysql.pass);
        $("[data-test-id='action-login']").click();
        // ждем пока сгенерируется проверочный код
        sleep(1000);
        // получаем код из БД
        mysql.getCodeSec();

        $("[name='code']").setValue(mysql.code);
        $("[data-test-id='action-verify']").click();

        $("[data-test-id='dashboard']").shouldHave(text("Личный кабинет"));
    }
}
