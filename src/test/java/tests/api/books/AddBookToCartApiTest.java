package tests.api.books;

import api.books.BooksApi;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.restassured.response.Response;
import models.BooksModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import tests.api.ApiBase;

import java.util.List;

import static data.ConfigData.API_CONFIG;
import static data.ConfigData.DATA_CONFIG;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static specs.BooksSpecification.addBookToCartRequestSpec;
import static specs.BooksSpecification.addBookToCartResponseSpec;

@Feature("Корзина")
@DisplayName("Добавление книги в корзину через API")
public class AddBookToCartApiTest extends ApiBase {

    @Owner("Aleksandr Aleksandrov")
    @Tags({
            @Tag("api"),
            @Tag("smoke")
    })
    @Test
    @DisplayName("Проверка добавления книги в корзину через API")
    public void successfulAddBookToCartApiTest() {
        BooksModel booksData = new BooksModel();

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
                        .isEqualTo(200)
        );

        step("Проверяем, что ID добавленной книги содержится в ответе", () -> {
            List<Integer> addedArtIds = response.jsonPath().getList(API_CONFIG.getApiPathAddedArts(), Integer.class);
            assertThat(addedArtIds)
                    .as("Добавленная книга не найдена в корзине")
                    .contains(DATA_CONFIG.getBookId());
        });
    }

    @AfterEach
    public void deleteBookFromCartAfterTest() {
        new BooksApi().deleteBookFromCartAfterApiTest();
    }
}