package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class SearchPage {

    private static final SelenideElement SEARCH_WRAPPER = $("[data-testid='search__content--wrapper']");
    private static final SelenideElement SEARCH_EMPTY_TITLE_STUB = $("[class*='SearchTitle_empty__title']");
    private static final String BOOK_TITLE = "[data-testid='art__title']";

    @Step("Получаем название книги из списка в результатах поиска")
    public String getFirstBookTitle() {
        SEARCH_WRAPPER.shouldBe(visible.because("Не отображается список книг в результатах поиска"));
        ElementsCollection bookTitles = SEARCH_WRAPPER.$$(BOOK_TITLE);
        if (!bookTitles.isEmpty()) {
            return bookTitles.get(0).getText();
        } else {
            throw new AssertionError("Книга не найдена в списке");
        }
    }

    @Step("Открываем книгу из результатов поиска")
    public void clickOnBookFromSearch() {
        SEARCH_WRAPPER.shouldBe(visible.because("Не отображается список книг в результатах поиска"));
        ElementsCollection bookTitles = SEARCH_WRAPPER.$$(BOOK_TITLE);
        if (!bookTitles.isEmpty()) {
            bookTitles.get(0).click();
        } else {
            throw new AssertionError("Книга не найдена в списке");
        }
    }

    @Step("Получаем текст в заглушке поиска")
    public String getTextEmptyStub() {
        return SEARCH_EMPTY_TITLE_STUB.shouldBe(visible.because("Не отображается заглушка")).getText();
    }
}