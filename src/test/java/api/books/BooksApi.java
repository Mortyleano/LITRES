package api.books;

import io.qameta.allure.Step;
import models.BooksModel;

import static io.restassured.RestAssured.given;
import static specs.BooksSpecification.addBookToCartRequestSpec;
import static specs.BooksSpecification.addBookToCartResponseSpec;
import static specs.BooksSpecification.deleteBookFromCartRequestSpec;
import static specs.BooksSpecification.deleteBookFromCartResponseSpec;
import static specs.BooksSpecification.getAddBookToCartRequestSpec;
import static specs.BooksSpecification.getDeleteBookFromCartRequestSpec;

public class BooksApi {

    @Step("Добавляем книгу в корзину через API метод перед тестом")
    public void addBookToCartBeforeTest() {
        BooksModel booksData = new BooksModel();
        given(getAddBookToCartRequestSpec())
                .body(booksData)
                .when()
                .put()
                .then()
                .spec(addBookToCartResponseSpec)
                .extract()
                .response();
    }

    @Step("Добавляем книгу в корзину через API метод перед тестом")
    public void addBookToCartBeforeApiTest() {
        BooksModel booksData = new BooksModel();
        given(addBookToCartRequestSpec)
                .body(booksData)
                .when()
                .put()
                .then()
                .spec(addBookToCartResponseSpec)
                .extract()
                .response();
    }

    @Step("Удаляем книгу из корзины через API метод после теста")
    public void deleteBookFromCartAfterTest() {
        BooksModel booksData = new BooksModel();
        given(getDeleteBookFromCartRequestSpec())
                .body(booksData)
                .when()
                .put()
                .then()
                .spec(deleteBookFromCartResponseSpec)
                .extract()
                .response();
    }

    @Step("Удаляем книгу из корзины через API метод после теста")
    public void deleteBookFromCartAfterApiTest() {
        BooksModel booksData = new BooksModel();
        given(deleteBookFromCartRequestSpec)
                .body(booksData)
                .when()
                .put()
                .then()
                .spec(deleteBookFromCartResponseSpec)
                .extract()
                .response();
    }
}