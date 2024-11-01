package tests.web.authorization;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import tests.web.WebBase;

import static data.ConfigData.AUTH_CONFIG;
import static data.TestsData.BAD_LOGIN;
import static data.TestsData.BAD_PASSWORD;
import static data.TestsData.ERROR_EMPTY_LOGIN_TEXT;
import static data.TestsData.ERROR_EMPTY_PASSWORD_TEXT;
import static data.TestsData.ERROR_LOGIN_TEXT;
import static data.TestsData.ERROR_PASSWORD_TEXT;
import static helpers.Navigation.openMainPage;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Ошибки валидации ввода для авторизации на сайте")
public class UnsuccessfulAuthorizationTests extends WebBase {

    @Tags({
            @Tag("web"),
            @Tag("smoke")
    })
    @Test
    @DisplayName("Проверка ошибки валидации для поля ввода 'Почта или логин'")
    public void unsuccessfulAuthorizationLoginTest() {
        openMainPage();
        MainPage mainPage = new MainPage()
                .clickLogin()
                .setOnlyLogin(BAD_LOGIN);

        step("Проверяем отображение ошибки валидации для логина в поп-апе авторизации", () ->
                assertThat(mainPage.getErrorMessage())
                        .as("Отсутствует вывод ошибки валидации для логина")
                        .contains(ERROR_LOGIN_TEXT)
        );
    }

    @Tags({
            @Tag("web"),
            @Tag("smoke")
    })
    @Test
    @DisplayName("Проверка ошибки валидации для поля ввода 'Пароль'")
    public void unsuccessfulAuthorizationPasswordTest() {
        openMainPage();
        MainPage mainPage = new MainPage()
                .clickLogin()
                .authorization(AUTH_CONFIG.login(), BAD_PASSWORD);

        step("Проверяем отображение ошибки валидации для пароля в поп-апе авторизации", () ->
                assertThat(mainPage.getErrorMessage())
                        .as("Отсутствует вывод ошибки валидации для пароля")
                        .contains(ERROR_PASSWORD_TEXT)
        );
    }

    @Tags({
            @Tag("web"),
            @Tag("smoke")
    })
    @Test
    @DisplayName("Проверка ошибки валидации для пустого ввода в поле 'Почта или логин'")
    public void unsuccessfulAuthorizationEmptyLoginTest() {
        openMainPage();
        MainPage mainPage = new MainPage()
                .clickLogin()
                .setOnlyLogin(null);

        step("Проверяем отображение ошибки валидации при вводе пустого логина", () ->
                assertThat(mainPage.getErrorMessage())
                        .as("Отсутствует вывод ошибки валидации при вводе пустого логина")
                        .contains(ERROR_EMPTY_LOGIN_TEXT)
        );
    }

    @Tags({
            @Tag("web"),
            @Tag("smoke")
    })
    @Test
    @DisplayName("Проверка ошибки валидации для пустого ввода в поле 'Пароль'")
    public void unsuccessfulAuthorizationEmptyPasswordTest() {
        openMainPage();
        MainPage mainPage = new MainPage()
                .clickLogin()
                .authorization(AUTH_CONFIG.login(), null);

        step("Проверяем отображение ошибки валидации при вводе пустого пароля", () ->
                assertThat(mainPage.getErrorMessage())
                        .as("Отсутствует вывод ошибки валидации при вводе пустого пароля")
                        .contains(ERROR_EMPTY_PASSWORD_TEXT)
        );
    }
}