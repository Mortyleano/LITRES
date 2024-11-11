package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:properties/api.properties"
})
public interface ApiConfig extends Config {

    @Key("apiPathLogin")
    String getApiPathLogin();

    @Key("apiPathSid")
    String getApiPathSid();

    @Key("apiPathAddBook")
    String getApiPathAddBook();

    @Key("apiPathDeleteBook")
    String getApiPathDeleteBook();

    @Key("apiPathAddedArts")
    String getApiPathAddedArts();
}