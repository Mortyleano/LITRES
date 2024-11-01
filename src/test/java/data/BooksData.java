package data;

import lombok.Data;
import models.BooksModel;

import java.util.Collections;
import java.util.List;

import static data.TestsData.BOOK_ID_TEST_1;

@Data
public class BooksData {

    private List<Integer> art_ids;

    public BooksData() {
        this.art_ids = getBookModel().getArt_ids();
    }

    private BooksModel getBookModel() {
        return BooksModel.builder().art_ids(Collections.singletonList(BOOK_ID_TEST_1)).build();
    }
}