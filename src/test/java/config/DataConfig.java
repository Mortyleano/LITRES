package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:properties/data.properties"
})
public interface DataConfig extends Config {

    @Key("bookId")
    int getBookId();
}