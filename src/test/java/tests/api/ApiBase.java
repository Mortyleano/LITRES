package tests.api;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

import static data.ConfigData.BASE_CONFIG;

public class ApiBase {

    @BeforeAll
    @Step("Устанавливаем конфигурации перед запуском теста")
    public static void setUp() {
        RestAssured.baseURI = BASE_CONFIG.getBaseApiUrl();
    }
}