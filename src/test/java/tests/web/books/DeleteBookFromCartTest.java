package tests.web.books;

import api.books.BooksApi;
import helpers.WithLogin;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import pages.CartPage;
import tests.web.WebBase;

import static helpers.Navigation.openCartPage;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.junit.jupiter.api.Assertions.assertFalse;

@DisplayName("Удаление книги из корзины")
public class DeleteBookFromCartTest extends WebBase {

    @Tags({
            @Tag("web"),
            @Tag("smoke")
    })
    @Test
    @WithLogin
    @DisplayName("Проверка удаления книги из корзины")
    public void deleteBookFromCartTest() {
        new BooksApi().addBookToCartBeforeTest();

        openCartPage();

        CartPage cartPage = new CartPage().deleteBook();
        step("Проверяем, что книга отсутствует в корзине после удаления", () -> {
            assertSoftly(softly -> {
                assertFalse(cartPage.isTitleBookInCartPresent(), "Книга не удалилась из корзины");
                assertFalse(cartPage.isAuthorBookInCartPresent(), "Книга не удалилась из корзины");
                assertFalse(cartPage.isCoverBookInCartPresent(), "Книга не удалилась из корзины");
            });
        });
    }
}