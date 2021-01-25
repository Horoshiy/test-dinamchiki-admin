package tests;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import config.ConfigHelper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class DinamchikiAdminSignInForm extends TestBase {

    @Test
    @DisplayName("sign in")
    void fillSignInForm() {
        String url = ConfigHelper.getSiteHomePage();
        String name = ConfigHelper.getSiteUser();
        String password = ConfigHelper.getSitePassword();

        step("Open site", () -> {
            open(url);
            $(".q-toolbar__title").shouldHave(text("ДФК Динамчики"));
        });

        step("Fill signing Form", () -> {
            $("form input").val(name);
            $$("form input").get(1).val(password);
            $("form button").click();
        });

        step("Verify redirect to main page", () -> {
            $("main.q-page img").shouldBe(exist);
        });
    }
}
