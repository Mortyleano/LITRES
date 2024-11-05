package tests.api.authorization;

import data.AuthorizationData;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import tests.api.ApiBase;

import static data.TestsData.STATUS_CODE_200;
import static data.TestsData.STATUS_CODE_422;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static specs.AuthorizationSpecification.authorizationRequestSpec;
import static specs.AuthorizationSpecification.authorizationResponseSpec;
import static specs.AuthorizationSpecification.unsuccessfulAuthorizationRequestSpec;
import static specs.AuthorizationSpecification.unsuccessfulAuthorizationResponseSpec;

@DisplayName("Авторизация на сайте через API")
public class AuthorizationTests extends ApiBase {

    @Tags({
            @Tag("api"),
            @Tag("smoke")
    })
    @Test
    @DisplayName("Проверка успешной авторизации на сайте через API со статус-кодом '200'")
    public void successfulAuthorizationTest() {
        AuthorizationData authData = new AuthorizationData();

        Response response = given(authorizationRequestSpec)
                .body(authData)
                .when()
                .post()
                .then()
                .spec(authorizationResponseSpec)
                .extract().response();

        step("Проверяем получение статус-кода '200' в теле ответа после успешной авторизации", () ->
                assertThat(response.getStatusCode())
                        .as("Не получили ожидаемый статус-код в теле ответа")
                        .isEqualTo(STATUS_CODE_200)
        );
    }

    @Tags({
            @Tag("api"),
            @Tag("smoke")
    })
    @Test
    @DisplayName("Проверка ошибки авторизации на сайте через API со статус-кодом '422'")
    public void unsuccessfulAuthorizationTest() {
        AuthorizationData authData = new AuthorizationData();

        Response response = given(unsuccessfulAuthorizationRequestSpec)
                .body(authData)
                .when()
                .post()
                .then()
                .spec(unsuccessfulAuthorizationResponseSpec)
                .extract().response();

        step("Проверяем получение статус-кода '422' в теле ответа после получения ошибки авторизации", () ->
                assertThat(response.getStatusCode())
                        .as("Не получили ожидаемый статус-код в теле ответа")
                        .isEqualTo(STATUS_CODE_422)
        );
    }
}