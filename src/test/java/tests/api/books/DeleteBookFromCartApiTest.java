package tests.api.books;

import api.books.BooksApi;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.restassured.response.Response;
import models.BooksModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import tests.api.ApiBase;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static specs.BooksSpecification.deleteBookFromCartRequestSpec;
import static specs.BooksSpecification.deleteBookFromCartResponseSpec;

@Feature("Корзина")
@DisplayName("Удаление книги из корзины через API")
public class DeleteBookFromCartApiTest extends ApiBase {

    @BeforeEach
    public void addBookToCartBeforeTest() {
        new BooksApi().addBookToCartBeforeApiTest();
    }

    @Owner("Aleksandr Aleksandrov")
    @Tags({
            @Tag("api"),
            @Tag("smoke")
    })
    @Test
    @DisplayName("Проверка удаления книги из корзины через API")
    public void successfulDeleteBookFromCartApiTest() {
        BooksModel booksData = new BooksModel();

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
                        .isEqualTo(204)
        );
    }
}