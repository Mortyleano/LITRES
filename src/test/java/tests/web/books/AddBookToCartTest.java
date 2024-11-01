package tests.web.books;

import api.books.BooksApi;
import helpers.WithLogin;
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

import static data.TestsData.BOOK_TITLE;
import static helpers.Navigation.openCartPage;
import static helpers.Navigation.openMainPage;
import static helpers.Navigation.switchToNewTab;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Добавление книги в корзину")
public class AddBookToCartTest extends WebBase {

    @Tags({
            @Tag("web"),
            @Tag("smoke")
    })
    @Test
    @WithLogin
    @DisplayName("Проверка добавления книги в корзину")
    public void addBookToCart() {
        openMainPage();
        MainPage mainPage = new MainPage();
        mainPage.searchBook(BOOK_TITLE);

        new SearchPage().clickOnBookFromSearch();
        switchToNewTab();

        new BookPage().addBookToCart();

        openCartPage();

        CartPage cartPage = new CartPage();
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