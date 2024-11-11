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
@DisplayName("Авторизация на сайте")
public class SuccessfulAuthorizationTest extends WebBase {

    @Owner("Aleksandr Aleksandrov")
    @Tags({
            @Tag("web"),
            @Tag("smoke")
    })
    @Test
    @DisplayName("Проверка авторизации на сайте")
    public void authorizationTest() {
        MainPage mainPage = new MainPage()
                .openMainPage()
                .clickLogin()
                .authorization(AUTH_CONFIG.login(), AUTH_CONFIG.password());

        step("Проверяем, что после успешной авторизации поп-ап закрылся", () ->
                assertThat(mainPage.isPopupNotPresent())
                        .as("Поп-ап для авторизации остался открытым")
                        .isTrue()
        );

        step("Проверяем, что кнопка 'Войти' изменилась на 'Профиль'", () ->
                assertThat(mainPage.getProfileButtonText())
                        .as("Кнопка не изменила свой текст")
                        .contains("Профиль")
        );
    }
}