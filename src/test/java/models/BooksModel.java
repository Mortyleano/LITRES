package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Collections;
import java.util.List;

import static data.ConfigData.DATA_CONFIG;

@AllArgsConstructor
@Data
@Builder
public class BooksModel {

    private List<Integer> art_ids;

    public BooksModel() {
        this.art_ids = getBookModel().getArt_ids();
    }

    private BooksModel getBookModel() {
        return BooksModel.builder().art_ids(Collections.singletonList(DATA_CONFIG.getBookId())).build();
    }
}