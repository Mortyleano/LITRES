package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class SearchPage {

    private final SelenideElement searchWrapper = $("[data-testid='search__content--wrapper']");
    private final SelenideElement searchEmptyTitleStub = $("[class*='SearchTitle_empty__title']");
    private final String bookTitle = "[data-testid='art__title']";

    @Step("Получаем название книги из списка в результатах поиска")
    public String getFirstBookTitle() {
        return searchWrapper.$$(bookTitle).asFixedIterable()
                .stream()
                .findFirst()
                .map(SelenideElement::getText)
                .orElseThrow(() -> new AssertionError("Книга не найдена в списке"));
    }

    @Step("Открываем книгу из результатов поиска")
    public void clickOnBookFromSearch() {
        searchWrapper.$$(bookTitle).asFixedIterable()
                .stream()
                .findFirst()
                .ifPresentOrElse(
                        SelenideElement::click,
                        () -> {
                            throw new AssertionError("Книга не найдена в списке");
                        }
                );
    }

    @Step("Получаем текст в заглушке поиска")
    public String getTextEmptyStub() {
        return searchEmptyTitleStub.getText();
    }
}