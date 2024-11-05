package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class BookPage {

    private static final SelenideElement ADD_BOOK_TO_CART = $("[data-testid='book__addToCartButton']");
    private static final SelenideElement BOOK_MODAL = $("[data-testid='modalWindow--content']");
    private static final SelenideElement CLOSE_BOOK_MODAL_BUTTON = $("[data-testid='modal__close--button']");

    @Step("Добавляем книгу в корзину")
    public void addBookToCart() {
        ADD_BOOK_TO_CART.shouldBe(visible.because("Не отображается кнопка для добавления книги в корзину")).click();
        if (BOOK_MODAL.is(visible)) {
            CLOSE_BOOK_MODAL_BUTTON.click();
        }
    }
}