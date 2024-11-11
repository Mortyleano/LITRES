package tests.web.authorization;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import tests.web.WebBase;

import static data.ConfigData.AUTH_CONFIG;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

@Feature("Авторизация")
@DisplayName("Ошибки валидации ввода для авторизации на сайте")
public class UnsuccessfulAuthorizationTests extends WebBase {

    private static final String ERROR_EMPTY_LOGIN_TEXT = "Поле не может быть пустым";
    private static final String ERROR_EMPTY_PASSWORD_TEXT = "Введите пароль";
    private static final String ERROR_LOGIN_TEXT = "Пользователь не найден, чтобы зарегистрироваться укажите почту";
    private static final String ERROR_PASSWORD_TEXT = "Неверное сочетание логина и пароля";
    private static final String BAD_LOGIN = "@Логин";
    private static final String BAD_PASSWORD = "qwerty";

    @Owner("Aleksandr Aleksandrov")
    @Tags({
            @Tag("web"),
            @Tag("smoke")
    })
    @Test
    @DisplayName("Проверка ошибки валидации для поля ввода 'Почта или логин'")
    public void unsuccessfulAuthorizationLoginTest() {
        MainPage mainPage = new MainPage()
                .openMainPage()
                .clickLogin()
                .setOnlyLogin(BAD_LOGIN);

        step("Проверяем отображение ошибки валидации для логина в поп-апе авторизации", () ->
                assertThat(mainPage.getErrorMessage())
                        .as("Отсутствует вывод ошибки валидации для логина")
                        .contains(ERROR_LOGIN_TEXT)
        );
    }

    @Owner("Aleksandr Aleksandrov")
    @Tags({
            @Tag("web"),
            @Tag("smoke")
    })
    @Test
    @DisplayName("Проверка ошибки валидации для поля ввода 'Пароль'")
    public void unsuccessfulAuthorizationPasswordTest() {
        MainPage mainPage = new MainPage()
                .openMainPage()
                .clickLogin()
                .authorization(AUTH_CONFIG.login(), BAD_PASSWORD);

        step("Проверяем отображение ошибки валидации для пароля в поп-апе авторизации", () ->
                assertThat(mainPage.getErrorMessage())
                        .as("Отсутствует вывод ошибки валидации для пароля")
                        .contains(ERROR_PASSWORD_TEXT)
        );
    }

    @Owner("Aleksandr Aleksandrov")
    @Tags({
            @Tag("web"),
            @Tag("smoke")
    })
    @Test
    @DisplayName("Проверка ошибки валидации для пустого ввода в поле 'Почта или логин'")
    public void unsuccessfulAuthorizationEmptyLoginTest() {
        MainPage mainPage = new MainPage()
                .openMainPage()
                .clickLogin()
                .setOnlyLogin(null);

        step("Проверяем отображение ошибки валидации при вводе пустого логина", () ->
                assertThat(mainPage.getErrorMessage())
                        .as("Отсутствует вывод ошибки валидации при вводе пустого логина")
                        .contains(ERROR_EMPTY_LOGIN_TEXT)
        );
    }

    @Owner("Aleksandr Aleksandrov")
    @Tags({
            @Tag("web"),
            @Tag("smoke")
    })
    @Test
    @DisplayName("Проверка ошибки валидации для пустого ввода в поле 'Пароль'")
    public void unsuccessfulAuthorizationEmptyPasswordTest() {
        MainPage mainPage = new MainPage()
                .openMainPage()
                .clickLogin()
                .authorization(AUTH_CONFIG.login(), null);

        step("Проверяем отображение ошибки валидации при вводе пустого пароля", () ->
                assertThat(mainPage.getErrorMessage())
                        .as("Отсутствует вывод ошибки валидации при вводе пустого пароля")
                        .contains(ERROR_EMPTY_PASSWORD_TEXT)
        );
    }
}