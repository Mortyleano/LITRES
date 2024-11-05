package tests.api;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

import static data.ConfigData.LAUNCH_CONFIG;

public class ApiBase {

    @BeforeAll
    @Step("Устанавливаем конфигурации перед запуском теста")
    public static void settingsTest() {
        RestAssured.baseURI = LAUNCH_CONFIG.getBaseApiUrl();
    }
}