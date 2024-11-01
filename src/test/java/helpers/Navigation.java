package helpers;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.open;
import static data.ConfigData.LAUNCH_CONFIG;

public class Navigation {

    @Step("Открываем главную страницу сайта")
    public static void openMainPage() {
        open(LAUNCH_CONFIG.getBaseUrl());
    }

    @Step("Открываем страницу с корзиной")
    public static void openCartPage() {
        open("/my-books/cart/");
    }

    @Step("Переключаемся на новую открытую вкладку в браузере")
    public static void switchToNewTab() {
        ArrayList<String> tabs = new ArrayList<>(WebDriverRunner.getWebDriver().getWindowHandles());
        WebDriverRunner.getWebDriver().switchTo().window(tabs.get(1));
    }
}