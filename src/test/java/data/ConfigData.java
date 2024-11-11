package data;

import config.ApiConfig;
import config.AuthConfig;
import config.BaseConfig;
import config.BrowserConfig;
import config.DataConfig;
import org.aeonbits.owner.ConfigFactory;

public class ConfigData {

    public static final ApiConfig API_CONFIG = ConfigFactory.create(ApiConfig.class, System.getProperties());
    public static final AuthConfig AUTH_CONFIG = ConfigFactory.create(AuthConfig.class, System.getProperties());
    public static final BaseConfig BASE_CONFIG = ConfigFactory.create(BaseConfig.class, System.getProperties());
    public static final BrowserConfig BROWSER_CONFIG = ConfigFactory.create(BrowserConfig.class, System.getProperties());
    public static final DataConfig DATA_CONFIG = ConfigFactory.create(DataConfig.class, System.getProperties());
}