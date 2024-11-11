package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:properties/browser.properties"
})
public interface BrowserConfig extends Config {

    @Key("browserSize")
    String getBrowserSize();

    @Key("browser")
    String getBrowser();

    @Key("browserVersion")
    String getBrowserVersion();

    @Key("pageLoadStrategy")
    String pageLoadStrategy();
}