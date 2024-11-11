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
@DisplayName("Поиск несуществующей книги на сайте")
public class SearchNonExistBookTest extends WebBase {

    private static final String EMPTY_STUB_TITLE_SEARCH_TEXT = "ничего не найдено";
    private static final String BOOK_BAD_SEARCH = "абракадабрапоисккниги";

    @Owner("Aleksandr Aleksandrov")
    @Tags({
            @Tag("web"),
            @Tag("smoke")
    })
    @Test
    @DisplayName("Проверка отображения заглушки при поиске несуществующей книги на сайте")
    public void nonExistSearchBookTest() {
        MainPage mainPage = new MainPage().openMainPage();
        mainPage.searchBook(BOOK_BAD_SEARCH);

        step("Проверяем, что отображается заглушка с отсутствием результатов поиска", () ->
                assertThat(new SearchPage().getTextEmptyStub())
                        .as("Не отобразилась заглушка с отсутствием результатов поиска")
                        .contains(EMPTY_STUB_TITLE_SEARCH_TEXT)
        );
    }
}