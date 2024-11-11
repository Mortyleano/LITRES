package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.not;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static data.ConfigData.BASE_CONFIG;

public class MainPage {

    private final SelenideElement loginButton = $("[data-testid='header__login-button--desktop']");
    private final SelenideElement profileButton = $("[data-testid='user-button']");
    private final SelenideElement loginInput = $("[data-testid='auth__input--enterEmailOrLogin']");
    private final SelenideElement passwordInput = $("[data-testid='auth__input--enterPassword']");
    private final SelenideElement loginPopUp = $("[data-testid='authorization-popup']");
    private final SelenideElement searchInput = $("[data-testid='search__input']");
    private final SelenideElement errorMessage = $("[class*='ControlInput_input__error']");

    @Step("Открываем главную страницу сайта")
    public MainPage openMainPage() {
        open(BASE_CONFIG.getBaseUrl());
        return this;
    }

    @Step("Нажимаем на кнопку 'Войти' в шапке страницы")
    public MainPage clickLogin() {
        loginButton.click();
        return this;
    }

    @Step("Получаем текст кнопки профиля в шапке страницы")
    public String getProfileButtonText() {
        return profileButton.getText();
    }

    @Step("Вставляем данные в поля ввода для авторизации и логинимся на сайт")
    public MainPage authorization(String login, String password) {
        loginInput.setValue(login).pressEnter();
        passwordInput.setValue(password).pressEnter();
        return this;
    }

    @Step("Вставляем данные для логина в поле ввода")
    public MainPage setOnlyLogin(String login) {
        loginInput.setValue(login).pressEnter();
        return this;
    }

    @Step("Проверяем, что не отображается поп-ап для авторизации")
    public boolean isPopupNotPresent() {
        return loginPopUp.is(not(visible), Duration.ofSeconds(5));
    }

    @Step("Получаем текст ошибки валидации из поп-апа для авторизации")
    public String getErrorMessage() {
        return errorMessage.getText();
    }

    @Step("Вводим запрос поиска по наименованию книги")
    public void searchBook(String bookTitle) {
        searchInput.setValue(bookTitle).pressEnter();
    }
}