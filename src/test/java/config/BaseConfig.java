package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:properties/base.properties"
})
public interface BaseConfig extends Config {

    @Key("baseApiUrl")
    String getBaseApiUrl();

    @Key("baseUrl")
    String getBaseUrl();
}