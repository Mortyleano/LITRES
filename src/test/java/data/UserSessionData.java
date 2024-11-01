package data;

import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class UserSessionData {

    public static void addCookies(String cookieName, String cookieValue) {
        Cookie sidCookie = new Cookie(cookieName, cookieValue, ".litres.ru", "/", null);
        getWebDriver().manage().addCookie(sidCookie);
    }

    public static String getCookieValue(String cookieName) {
        Cookie cookie = getWebDriver().manage().getCookieNamed(cookieName);
        return cookie != null ? cookie.getValue() : null;
    }

    public static String getSessionId() {
        return getCookieValue("SID");
    }
}