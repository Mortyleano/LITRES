package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:properties/path.properties"
})
public interface PathConfig extends Config {

    @Key("apiPathLogin")
    String getApiPathLogin();

    @Key("apiPathSid")
    String getApiPathSid();

    @Key("apiPathAddBook")
    String getApiPathAddBook();

    @Key("apiPathDeleteBook")
    String getApiPathDeleteBook();
}