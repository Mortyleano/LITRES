package tests.api.books;

import api.books.BooksApi;
import data.BooksData;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import tests.api.ApiBase;

import static data.TestsData.STATUS_CODE_204;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static specs.BooksSpecification.deleteBookFromCartRequestSpec;
import static specs.BooksSpecification.deleteBookFromCartResponseSpec;

@DisplayName("Удаление книги из корзины")
public class DeleteBookFromCartApiTest extends ApiBase {

    @BeforeEach
    public void addBookToCartBeforeTest() {
        new BooksApi().addBookToCartBeforeApiTest();
    }

    @Tags({
            @Tag("api"),
            @Tag("smoke")
    })
    @Test
    @DisplayName("Проверка удаления книги из корзины")
    public void successfulDeleteBookFromCartApiTest() {
        BooksData booksData = new BooksData();

        Response response = given(deleteBookFromCartRequestSpec)
                .body(booksData)
                .when()
                .put()
                .then()
                .spec(deleteBookFromCartResponseSpec)
                .extract().response();

        step("Проверяем получение статус-кода '204' в теле ответа после удаления книги из корзины", () ->
                assertThat(response.getStatusCode())
                        .as("Не получили ожидаемый статус-код в теле ответа")
                        .isEqualTo(STATUS_CODE_204)
        );
    }
}