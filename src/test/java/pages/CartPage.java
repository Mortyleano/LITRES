package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CartPage {

    private static final SelenideElement DELETE_BOOK_BUTTON = $("[data-testid='cart__listDeleteButton']");
    private static final SelenideElement DELETE_BOOK_CONFIRM = $("div[class*='Modal_controls'] button[class*='Button_button']");
    private static final SelenideElement BOOK_TITLE = $("[data-testid='cart__bookCardTitle--wrapper']");
    private static final SelenideElement BOOK_COVER = $("[data-testid='cart__bookCardCover--wrapper']");
    private static final SelenideElement BOOK_AUTHOR = $("[data-testid='cart__bookCardAuthor--wrapper']");

    @Step("Удаляем книгу из корзины")
    public CartPage deleteBook() {
        DELETE_BOOK_BUTTON.shouldBe(visible.because("Не отображается кнопка для удаления книги из корзины")).click();
        DELETE_BOOK_CONFIRM.shouldBe(visible.because("Не отображается кнопка для подтверждения удаления книги из корзины")).click();
        return this;
    }

    @Step("Проверяем отображение наименование книги в корзине")
    public boolean isTitleBookInCartPresent() {
        return BOOK_TITLE.is(visible.because("Не отображается наименование книги в корзине"));
    }

    @Step("Проверяем отображение автора книги в корзине")
    public boolean isAuthorBookInCartPresent() {
        return BOOK_AUTHOR.is(visible.because("Не отображается автор книги в корзине"));
    }

    @Step("Проверяем отображение обложки для книги в корзине")
    public boolean isCoverBookInCartPresent() {
        return BOOK_COVER.is(visible.because("Не отображается обложка книги в корзине"));
    }
}