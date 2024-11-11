package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class BookPage {

    private final SelenideElement addBookToCart = $("[data-testid='book__addToCartButton']");
    private final SelenideElement bookModal = $("[data-testid='modalWindow--content']");
    private final SelenideElement closeBookModalButton = $("[data-testid='modal__close--button']");

    @Step("Добавляем книгу в корзину")
    public void addBookToCart() {
        addBookToCart.click();
        if (bookModal.is(visible)) {
            closeBookModalButton.click();
        }
    }
}