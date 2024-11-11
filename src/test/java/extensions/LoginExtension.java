package extensions;

import api.authtorization.AuthorizationApi;
import io.qameta.allure.Step;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import static com.codeborne.selenide.Selenide.open;
import static data.UserSessionData.addCookies;

public class LoginExtension implements BeforeEachCallback {

    @Override
    @Step("Авторизуемся через API и устанавливаем cookies")
    public void beforeEach(ExtensionContext context) {
        String sessionId = new AuthorizationApi().getAuthorizationResponse();
        open("https://www.litres.ru/favicon.ico");
        addCookies("SID", sessionId);
        addCookies("cookie-agreement", "1");
    }
}