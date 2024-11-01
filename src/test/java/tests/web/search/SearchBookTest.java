package tests.web.search;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.SearchPage;
import tests.web.WebBase;

import static data.TestsData.BOOK_TITLE;
import static helpers.Navigation.openMainPage;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Поиск книги на сайте")
public class SearchBookTest extends WebBase {

    @Tags({
            @Tag("web"),
            @Tag("smoke")
    })
    @Test
    @DisplayName("Проверка поиска книги на сайте")
    public void searchBookTest() {
        openMainPage();
        new MainPage().searchBook(BOOK_TITLE);

        step("Проверяем, что в результатах поиска отображается книга, которую мы искали", () ->
                assertThat(new SearchPage().getFirstBookTitle())
                        .as("Не нашлась книга в результатах поиска")
                        .contains(BOOK_TITLE)
        );
    }
}