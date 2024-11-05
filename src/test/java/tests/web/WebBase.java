package tests.web;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.Attachments;

import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static data.ConfigData.LAUNCH_CONFIG;

public class WebBase {

    @BeforeAll
    @Step("Устанавливаем конфигурации перед запуском теста")
    public static void settingsTest() {
        RestAssured.baseURI = LAUNCH_CONFIG.getBaseApiUrl();
        Configuration.baseUrl = LAUNCH_CONFIG.getBaseUrl();
        Configuration.browser = LAUNCH_CONFIG.getBrowser();
        Configuration.browserVersion = LAUNCH_CONFIG.getBrowserVersion();
        Configuration.browserSize = LAUNCH_CONFIG.getBrowserSize();
        Configuration.pageLoadStrategy = LAUNCH_CONFIG.pageLoadStrategy();

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
    }

    @BeforeEach
    @Step("Добавляем конфигурации для запускаемого теста")
    public void setUpBeforeEach() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
    @Step("Выполняем конфигурации после окончания теста")
    public void settingsAfterTest() {
        Attachments.screenshotAs("Изображение последнего события из теста");
        Attachments.pageSource();
        Attachments.browserConsoleLogs();
        Attachments.addVideo();
        closeWebDriver();
    }
}