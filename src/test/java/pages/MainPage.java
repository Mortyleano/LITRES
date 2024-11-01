package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    private static final SelenideElement LOGIN_BUTTON = $("[data-testid='header__login-button--desktop']");
    private static final SelenideElement PROFILE_BUTTON = $("[data-testid='user-button']");
    private static final SelenideElement LOGIN_INPUT = $("[data-testid='auth__input--enterEmailOrLogin']");
    private static final SelenideElement PASSWORD_INPUT = $("[data-testid='auth__input--enterPassword']");
    private static final SelenideElement LOGIN_POPUP = $("[data-testid='authorization-popup']");
    private static final SelenideElement SEARCH_INPUT = $("[data-testid='search__input']");
    private static final SelenideElement ERROR_MESSAGE = $("[class*='ControlInput_input__error']");

    @Step("Нажимаем на кнопку 'Войти' в шапке страницы")
    public MainPage clickLogin() {
        LOGIN_BUTTON.shouldBe(visible.because("Не отображается кнопка для входа в аккаунт")).click();
        return this;
    }

    @Step("Получаем текст кнопки профиля в шапке страницы")
    public String getProfileButtonText() {
        return PROFILE_BUTTON.shouldBe(visible.because("Не отображается кнопка для открытия профиля")).getText();
    }

    @Step("Вставляем данные в поля ввода для авторизации и логинимся на сайт")
    public MainPage authorization(String login, String password) {
        LOGIN_INPUT.shouldBe(visible.because("Не отображается поле ввода для логина")).setValue(login).pressEnter();
        PASSWORD_INPUT.shouldBe(visible.because("Не отображается поле ввода для пароля")).setValue(password).pressEnter();
        return this;
    }

    @Step("Вставляем данные для логина в поле ввода")
    public MainPage setOnlyLogin(String login) {
        LOGIN_INPUT.shouldBe(visible.because("Не отображается поле ввода для логина")).setValue(login).pressEnter();
        return this;
    }

    @Step("Проверяем, что не отображается поп-ап для авторизации")
    public boolean isPopupNotPresent() {
        LOGIN_POPUP.shouldNotBe(visible.because("Остался поп-ап после авторизации"));
        return true;
    }

    @Step("Получаем текст ошибки валидации из поп-апа для авторизации")
    public String getErrorMessage() {
        return ERROR_MESSAGE.shouldBe(visible.because("Не отображается ошибка валидации")).getText();
    }

    @Step("Вводим запрос поиска по наименованию книги")
    public void searchBook(String bookTitle) {
        SEARCH_INPUT.shouldBe(visible.because("Не отображается поле ввода для поиска")).setValue(bookTitle).pressEnter();
    }
}