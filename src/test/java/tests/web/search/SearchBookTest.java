package tests.web.search;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.SearchPage;
import tests.web.WebBase;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

@Feature("Поиск")
@DisplayName("Поиск книги на сайте")
public class SearchBookTest extends WebBase {

    private static final String BOOK_TITLE = "Мастер и Маргарита";

    @Owner("Aleksandr Aleksandrov")
    @Tags({
            @Tag("web"),
            @Tag("smoke")
    })
    @Test
    @DisplayName("Проверка поиска книги на сайте")
    public void searchBookTest() {
        MainPage mainPage = new MainPage().openMainPage();
        mainPage.searchBook(BOOK_TITLE);

        step("Проверяем, что в результатах поиска отображается книга, которую мы искали", () ->
                assertThat(new SearchPage().getFirstBookTitle())
                        .as("Не нашлась книга в результатах поиска")
                        .contains(BOOK_TITLE)
        );
    }
}