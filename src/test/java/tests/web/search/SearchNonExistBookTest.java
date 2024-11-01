package tests.web.search;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.SearchPage;
import tests.web.WebBase;

import static data.TestsData.BOOK_BAD_SEARCH;
import static data.TestsData.EMPTY_STUB_TITLE_SEARCH_TEXT;
import static helpers.Navigation.openMainPage;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Поиск несуществующей книги на сайте")
public class SearchNonExistBookTest extends WebBase {

    @Tags({
            @Tag("web"),
            @Tag("smoke")
    })
    @Test
    @DisplayName("Проверка отображения заглушки при поиске несуществующей книги на сайте")
    public void nonExistSearchBookTest() {
        openMainPage();
        new MainPage().searchBook(BOOK_BAD_SEARCH);

        step("Проверяем, что отображается заглушка с отсутствием результатов поиска", () ->
                assertThat(new SearchPage().getTextEmptyStub())
                        .as("Не отобразилась заглушка с отсутствием результатов поиска")
                        .contains(EMPTY_STUB_TITLE_SEARCH_TEXT)
        );
    }
}