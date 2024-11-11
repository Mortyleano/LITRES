package utils;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;

import java.util.ArrayList;

public class BrowserWindowSwitcher {

    @Step("Переключаемся на новую открытую вкладку в браузере")
    public static void switchToNewTab() {
        ArrayList<String> tabs = new ArrayList<>(WebDriverRunner.getWebDriver().getWindowHandles());
        WebDriverRunner.getWebDriver().switchTo().window(tabs.get(1));
    }
}