package tests;

import com.codeborne.selenide.Configuration;
import config.ConfigHelper;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static config.AttachmentsHelper.*;

public class TestBase {
    @BeforeAll
    static void setup() {
        addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));

//        Configuration.remote = ConfigHelper.getWebdriverRemote();
        Configuration.startMaximized = true;
    }

    @AfterEach
    @Step("Attachments")
    public void afterEach() {
        attachScreenshot("Last screenshot");
        attachPageSource();
        attachAsText("Browser console logs", getConsoleLogs());

        closeWebDriver();
    }
}
