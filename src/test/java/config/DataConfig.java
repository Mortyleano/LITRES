package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:properties/data.properties"
})
public interface DataConfig extends Config {

    @Key("bookId")
    int getBookId();

    @Key("bookTitle")
    String getBookTitle();

    @Key("errorLoginText")
    String getErrorLoginText();

    @Key("errorPasswordText")
    String getErrorPasswordText();

    @Key("errorEmptyLoginText")
    String getErrorEmptyLoginText();

    @Key("errorEmptyPasswordText")
    String getErrorEmptyPasswordText();

    @Key("badLogin")
    String getBadLogin();

    @Key("badPassword")
    String getBadPassword();
}