package tests.api.books;

import api.books.BooksApi;
import data.BooksData;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import tests.api.ApiBase;

import static data.TestsData.STATUS_CODE_200;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static specs.BooksSpecification.addBookToCartRequestSpec;
import static specs.BooksSpecification.addBookToCartResponseSpec;

@DisplayName("Добавление книги в корзину через API")
public class AddBookToCartApiTest extends ApiBase {

    @Tags({
            @Tag("api"),
            @Tag("smoke")
    })
    @Test
    @DisplayName("Проверка добавления книги в корзину через API")
    public void successfulAddBookToCartApiTest() {
        BooksData booksData = new BooksData();

        Response response = given(addBookToCartRequestSpec)
                .body(booksData)
                .when()
                .put()
                .then()
                .spec(addBookToCartResponseSpec)
                .extract().response();

        step("Проверяем получение статус-кода '200' в теле ответа после добавления книги в корзину", () ->
                assertThat(response.getStatusCode())
                        .as("Не получили ожидаемый статус-код в теле ответа")
                        .isEqualTo(STATUS_CODE_200)
        );
    }

    @AfterEach
    public void deleteBookFromCartAfterTest() {
        new BooksApi().deleteBookFromCartAfterApiTest();
    }
}