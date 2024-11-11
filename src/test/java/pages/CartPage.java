package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CartPage {

    private final SelenideElement deleteBookButton = $("[data-testid='cart__listDeleteButton']");
    private final SelenideElement deleteBookConfirm = $("div[class*='Modal_controls'] button[class*='Button_button']");
    private final SelenideElement bookTitle = $("[data-testid='cart__bookCardTitle--wrapper']");
    private final SelenideElement bookCover = $("[data-testid='cart__bookCardCover--wrapper']");
    private final SelenideElement bookAuthor = $("[data-testid='cart__bookCardAuthor--wrapper']");

    @Step("Открываем страницу с корзиной")
    public CartPage openCartPage() {
        open("/my-books/cart/");
        return this;
    }

    @Step("Удаляем книгу из корзины")
    public CartPage deleteBook() {
        deleteBookButton.click();
        deleteBookConfirm.click();
        return this;
    }

    @Step("Проверяем отображение наименование книги в корзине")
    public boolean isTitleBookInCartPresent() {
        return bookTitle.is(visible);
    }

    @Step("Проверяем отображение автора книги в корзине")
    public boolean isAuthorBookInCartPresent() {
        return bookAuthor.is(visible);
    }

    @Step("Проверяем отображение обложки для книги в корзине")
    public boolean isCoverBookInCartPresent() {
        return bookCover.is(visible);
    }
}