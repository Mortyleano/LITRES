package tests.web.books;

import api.books.BooksApi;
import helpers.WithLogin;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import pages.BookPage;
import pages.CartPage;
import pages.MainPage;
import pages.SearchPage;
import tests.web.WebBase;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static utils.BrowserWindowSwitcher.switchToNewTab;

@Feature("Корзина")
@DisplayName("Добавление книги в корзину")
public class AddBookToCartTest extends WebBase {

    private static final String BOOK_TITLE = "Мастер и Маргарита";

    @Owner("Aleksandr Aleksandrov")
    @Tags({
            @Tag("web"),
            @Tag("smoke")
    })
    @Test
    @WithLogin
    @DisplayName("Проверка добавления книги в корзину")
    public void addBookToCart() {
        MainPage mainPage = new MainPage().openMainPage();
        mainPage.searchBook(BOOK_TITLE);

        new SearchPage().clickOnBookFromSearch();
        switchToNewTab();

        new BookPage().addBookToCart();

        CartPage cartPage = new CartPage().openCartPage();
        step("Проверяем, что книга находится в корзине после добавления", () -> {
            assertSoftly(softly -> {
                assertTrue(cartPage.isTitleBookInCartPresent(), "Книга не добавилась в корзину");
                assertTrue(cartPage.isAuthorBookInCartPresent(), "Книга не добавилась в корзину");
                assertTrue(cartPage.isCoverBookInCartPresent(), "Книга не добавилась в корзину");
            });
        });
    }

    @AfterEach
    public void deleteBookFromCartAfterTest() {
        new BooksApi().deleteBookFromCartAfterTest();
    }
}