package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:properties/launch.properties"
})
public interface LaunchConfig extends Config {

    @Key("baseApiUrl")
    String getBaseApiUrl();

    @Key("baseUrl")
    String getBaseUrl();

    @Key("browserSize")
    String getBrowserSize();

    @Key("browser")
    String getBrowser();

    @Key("browserVersion")
    String getBrowserVersion();

    @Key("pageLoadStrategy")
    String pageLoadStrategy();
}