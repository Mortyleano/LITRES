package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:properties/auth.properties"
})
public interface AuthConfig extends Config {

    @Key("login")
    @DefaultValue("${login}")
    String login();

    @Key("password")
    @DefaultValue("${password}")
    String password();
}